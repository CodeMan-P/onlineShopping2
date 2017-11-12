package com.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String flag = request.getParameter("flag");
		Map<String,String[]> m = request.getParameterMap();
		ObjectMapper mapper = new ObjectMapper();
		LinkedList<Integer> buyCids=new LinkedList<Integer>();
		for(String temp:m.get("buyCids")){
			buyCids.add(Integer.parseInt(temp));
		}
		Integer adresId=Integer.parseInt(m.get("adresId")[0]);
		
		if(flag!= null &&flag.equalsIgnoreCase("multi")){
			//下单购买一堆
			
			//删除购物车下单物品
		}else{
			//商品界面直接购买
		}
	}

}
