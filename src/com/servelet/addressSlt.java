package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UsersDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Address;
import com.service.UserService;

/**
 * Servlet implementation class addressSlt
 */
@WebServlet("/ast")
public class addressSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addressSlt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");
		int uid = (int) request.getSession().getAttribute("uid");
		if (flag == null) {
			return;
			
		} else if (flag.equalsIgnoreCase("dele")) {
			int aid = Integer.parseInt(request.getParameter("aid"));
			
			boolean b = UserService.deleAddress(aid);
			PrintWriter out = response.getWriter();
			if(b){
				out.write("{\"message\":\"删除成功！\"}");
			}else{
				out.write("{\"message\":\"删除失败！\"}");
			}
			out.flush();
			out.close();
			return;
		} else if (flag.equalsIgnoreCase("changeAdd")) {
			String json;
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request.getParameterMap());
			json = json.replaceAll("\\[|\\]", "");
			Address adr = mapper.readValue(json, Address.class);
			
			@SuppressWarnings("unchecked")
			HashMap<String,String> hm = mapper.readValue(json, HashMap.class);
			adr.setProvince(hm.get("province"));
			adr.setCity(hm.get("city"));
			adr.setUid(uid);
			boolean b = UserService.addAddress(adr);
			PrintWriter out = response.getWriter();
			if(b){
				out.write("{\"message\":\"添加成功！\"}");
			}else{
				out.write("{\"message\":\"添加失败！\"}");
			}
			out.flush();
			out.close();
			// 新建地址完成后刷新
			//response.sendRedirect("/Spcar?flag=view");
			return;
		} else if (flag.equalsIgnoreCase("editAdres")) {
			String addr = request.getParameter("addr");
			String aname = request.getParameter("aname");
			String aphone = request.getParameter("aphone");
			Boolean def = false;
			String temp = request.getParameter("def");
			if (temp != null && temp.equals("1")) {
				def = true;
			}
			Address newAdd = new Address(uid, def, aphone, aname, addr);

		} else if (flag.equalsIgnoreCase("deleAdres")) {

		}

	}

}
