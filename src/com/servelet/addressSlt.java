package com.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mod.bean.Address;

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
		if (flag == null) {
			response.sendRedirect("jsp/address.jsp");
		} else if (flag.equalsIgnoreCase("addAdres")) {

			// 新建地址完成返回首页
			response.sendRedirect("/index.jsp");
		} else if (flag.equalsIgnoreCase("editAdres")) {
			String addr = request.getParameter("addr");
			String aname = request.getParameter("aname");
			String aphone = request.getParameter("aphone");
			Boolean def = false;
			String temp = request.getParameter("def");
			if (temp != null && temp.equals("1")) {
				def = true;
			}
			int uid = (int) request.getSession().getAttribute("uid");

			Address newAdd = new Address(uid, def, aphone, aname, addr);

		} else if (flag.equalsIgnoreCase("deleAdres")) {

		}

	}

}
