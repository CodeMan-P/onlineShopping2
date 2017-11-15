package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Users;

/**
 * Servlet implementation class RegistServelet
 */
@WebServlet("/Regist")
public class RegistServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String flag = request.getParameter("flag");
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		Users user = null;
		if (flag != null) {
			switch (flag) {
			case "regist":
				json = mapper.writeValueAsString(request.getParameterMap());
				// ajaxSubmit 提交时每个参数以数组传递，需要删除[]
				json = json.replace("[", "");
				json = json.replace("]", "");
				// System.out.println(json);
				try {
					user = mapper.readValue(json, Users.class);
				} catch (Exception e) {
					e.printStackTrace();
					out.write("请输入正确的注册信息！");
					out.flush();
					out.close();
					return;
				}
				// if(UserDao.addUser(user)){
				//
				// request.getSession().setAttribute("name",user.getName());
				// request.getSession().setAttribute("list",
				// ProductService.getList());
				// out.write("注册成功");
				//// request.getRequestDispatcher("Shop").forward(request,
				// response);
				// }else{
				// out.write("注册失败");
				// }
				out.flush();
				out.close();
				return;
			}
		}
	}

}
