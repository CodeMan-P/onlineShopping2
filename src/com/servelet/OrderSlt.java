package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.OrderForm;
import com.mod.bean.Orders;
import com.mod.bean.ShoppingCar;
import com.service.OrdersService;
import com.service.SpCarService;

/**
 * Servlet implementation class OrderSlt
 */
@WebServlet("/Order")
public class OrderSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSlt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String flag = request.getParameter("flag");
		PrintWriter out = response.getWriter();
		int uid = (int) request.getSession().getAttribute("uid");
		if (flag != null && flag.equalsIgnoreCase("multi")) {
			// 下单购买一堆
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
			String oid = sf.format(new Date());
			if (addOrders(request, response,oid)) {
				//获取当前订单视图
				LinkedList<HashMap<String, Object>> orderslist = OrdersService.getOrderList(oid, uid);
				HashMap<String, Object> hm = jsonFactory(orderslist);
				request.getSession().setAttribute("hm", hm);
				out.write("{\"message\":\"添加成功！\",\"oid\":"+oid+"}");
			}else{
				out.write("{\"message\":\"添加失败！\"}");
			}
			out.flush();
		} else {
			// 商品界面直接购买
		}
		out.close();
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> jsonFactory(LinkedList<HashMap<String, Object>> orderslist){
		//提取公共字段
		HashMap<String, Object> m = new HashMap<String, Object>();
		LinkedList<String> fileds = new LinkedList<String>();
		fileds.add("address");
		fileds.add("sum");
		fileds.add("oid");
		fileds.add("uid");
		fileds.add("state");
		
		HashMap<String, Object> hm=null;
		HashMap<String, Object> tempm=null;
		//移除公共字段存入 m
		for(int i=0;i<orderslist.size();i++){
			hm=orderslist.get(i);
			tempm=(HashMap<String, Object>) orderslist.get(i).clone();
			if(i==0){
				for(String s:tempm.keySet()){
					if(fileds.contains(s)){
						m.put(s,hm.remove(s));
					}
				}
			}else{
				for(String s:tempm.keySet()){
					if(fileds.contains(s)){
						hm.remove(s);
					}
				}
			}
		m.put((i+1)+"_goods", hm);
		};
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//商品依次加入m
		return m;
	}
	private Boolean addOrders(HttpServletRequest request, HttpServletResponse response,String oid ) {
		LinkedList<OrderForm> orderlist = null;
		Orders orders = null;
		LinkedList<Integer> buyCids = null;
		try {
			int uid = (int) request.getSession().getAttribute("uid");
			Map<String, String[]> m = request.getParameterMap();

			buyCids = new LinkedList<Integer>();
			for (String temp : m.get("buyCids")) {
				buyCids.add(Integer.parseInt(temp));
			}
			String address = m.get("adresId")[0];
			LinkedList<Integer> tempcids = new LinkedList<Integer>();
			tempcids.addAll(buyCids);
			
			// orderfor表添加
			// LinkedList<ShoppingCar> list = SpCarService.getCarListByUid(uid);
			LinkedList<HashMap<String, Object>> view = SpCarService.getCarView(uid);
			orderlist = new LinkedList<OrderForm>();

			OrderForm tempOrder = null;
			double sum = 0;
			for (HashMap<String, Object> temp : view) {
				// int cid = (int)temp.get("cid");
				if (tempcids.contains(temp.get("cid"))) {
					tempcids.remove(temp.get("cid"));
				} else {
					continue;
				}
				tempOrder = new OrderForm();
				tempOrder.setOid(oid);
				tempOrder.setGid((Integer) temp.get("gid"));
				int gnum = (int) temp.get("gnum");
				double price = (double) temp.get("price");
				tempOrder.setGnum(gnum);
				double subtotal = gnum * price;
				tempOrder.setSubtotal(subtotal);
				orderlist.add(tempOrder);
				sum += subtotal;
			}
			orders = new Orders(oid, uid, sum, address);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		if(orders == null||orderlist==null||buyCids==null){
			return false;
		}
		return OrdersService.addOrders(orders, orderlist,buyCids);
	}

}
