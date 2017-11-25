package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mod.bean.Goods;
import com.service.GoodsService;

public class searchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public searchServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String word = request.getParameter("word");
		if(word == null){
			word = (String) request.getSession().getAttribute("word");
			if(word == null){
				return;
			}
		}
		String sort = null;
		sort = (String) request.getSession().getAttribute("sort");
		if(sort!=null&&!sort.equals("")&&sort.equalsIgnoreCase("asc")){
			sort = "desc";
		}else{
			sort = "asc";
		}
		 
		ArrayList<Goods> productList = null;
		 productList = GoodsService.productList(word, sort);
		
		request.getSession().setAttribute("productList", productList);
		request.getSession().setAttribute("word", word);
		request.getSession().setAttribute("sort", sort);
		response.sendRedirect("jsp/list.jsp");

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
