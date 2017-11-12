package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Users;
import com.service.SpCarService;
import com.service.UserService;
import com.util.DbConn;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		DbConn.closeBds();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String flag = request.getParameter("flag");
		if(flag!=null&&flag.equalsIgnoreCase("flush")){
			int uid = (int) request.getSession().getAttribute("uid");
			int num = SpCarService.getCarNum(uid);
			request.getSession().setAttribute("carnum",num);
			out.write("{\"message\":\"刷新成功！\",\"cnum\":"+num+"}");
			out.flush();
			out.close();
			return;
		}
		if(name.equalsIgnoreCase("@quit")){
			request.getSession().invalidate();
			out.write("注销成功！");
			out.flush();
			out.close();
			return;
		}
		String pwd = request.getParameter("pwd");
		Users users = new Users(name,pwd);
		users = UserService.findUser(users);
		if(users == null){
			response.sendRedirect("index.jsp");
		}else{
			Integer uid = users.getUid();
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("avatar",users.getAvatar());
			request.getSession().setAttribute("city",users.getCity());
			int num = SpCarService.getCarNum(uid);
			request.getSession().setAttribute("carnum",num);
			
			ObjectMapper mapper=new ObjectMapper();
			//借密码变量 存储 购物车数量
			users.setUpwd(num+"");
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
			out.write(json);
			out.flush();
			if(out != null){
				out.close();
			}
		}
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		String message = String.format("用户：%s存在!%d:%6.2f",
//				name,user.getCardNum(),user.getMoney());
//		out.println(message);
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
		DbConn.getFactory();
	}

}
