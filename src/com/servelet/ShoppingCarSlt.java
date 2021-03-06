package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Address;
import com.mod.bean.ShoppingCar;
import com.service.SpCarService;
import com.service.UserService;

public class ShoppingCarSlt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2979228988959015623L;

	/**
	 * Constructor of the object.
	 */
	public ShoppingCarSlt() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String flag = request.getParameter("flag");
		PrintWriter out = response.getWriter();
		int uid = (int) request.getSession().getAttribute("uid");
		if (flag.equalsIgnoreCase("add")) {
			addGoods(request, response);
		} else if (flag.equalsIgnoreCase("dele")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			if (SpCarService.deleGoods(cid)) {
				out.write("{\"message\":\"删除成功！\",\"num\":" + 0 + "}");
				int num = SpCarService.getCarNum(uid);
				request.getSession().setAttribute("carnum", num);
			} else {
				out.write("{\"message\":\"删除失败！\"}");
			}
			out.flush();
			out.close();
		} else if (flag.equalsIgnoreCase("view")) {
			// LinkedList<ShoppingCar> list = SpCarService.getCarListByUid(uid);
			// request.getSession().setAttribute("carlist", list);

			ObjectMapper mapper = new ObjectMapper();
			LinkedList<Address> adresList = UserService.getAdress(uid);
			String adresJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(adresList);
			LinkedList<HashMap<String, Object>> view = SpCarService.getCarView(uid);
			request.getSession().setAttribute("view", view);
			request.getSession().setAttribute("adresJson", adresJson);
			request.getRequestDispatcher("jsp/shoppingcar.jsp").forward(request, response);
		}

		// request.setAttribute("list", ProductService.getList());
		// request.getRequestDispatcher("/jsp/shopping.jsp").forward(request,
		// response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			int uid = (int) request.getSession().getAttribute("uid");
			int gid = Integer.parseInt(request.getParameter("gid"));
			int gnum = Integer.parseInt(request.getParameter("gnum"));
			String desc = request.getParameter("desc");
			Timestamp tm = new Timestamp(new Date().getTime());
			ShoppingCar sc = new ShoppingCar(tm, uid, gid, gnum, desc);
			// ObjectMapper mapper = new ObjectMapper();
			// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sc));
			if (SpCarService.addGoods(sc)) {
				request.getSession().removeAttribute("carnum");
				int num = SpCarService.getCarNum(uid);
				request.getSession().setAttribute("carnum", num);

				out.write("{\"message\":\"添加成功！\",\"num\":" + num + "}");

			} else {
				out.write("{\"message\":\"添加失败！\"}");
			}

		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			out.write("{\"message\":\"添加失败！\"}");
		} finally {
			out.flush();
			out.close();
		}
	}

	Logger log = Logger.getLogger(ShoppingCarSlt.class.getName());

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
