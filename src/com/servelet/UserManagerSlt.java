package com.servelet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.mod.bean.Users;
import com.service.UserService;
import com.tests.log4jExample;

/**
 * Servlet implementation class UserManagerSlt
 */
public class UserManagerSlt extends HttpServlet {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagerSlt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	static Logger log = Logger.getLogger(log4jExample.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		Users user=null;
		if(flag!=null){
			switch(flag){
			case "regist":
				json = mapper.writeValueAsString(request.getParameterMap());
				//ajaxSubmit 提交时每个参数以数组传递，需要删除[]
				json = json.replace("[", "");
				json = json.replace("]", "");
				System.out.println(json);
				try{
					user = mapper.readValue(json, Users.class);
					String message = UserService.addUser(user);
					if(message.contains("成功")){
						request.getSession().setAttribute("name", user.getUname());
						request.getSession().setAttribute("uid", user.getUid());
						request.getSession().setAttribute("avatar",user.getAvatar());
						request.getSession().setAttribute("city",user.getCity());
						out.write("注册成功！");
					}else if(message.contains("Duplicate")){
						out.write("用户名已存在！注册失败！");
						log.warn(message);
					}else{
						log.warn(message);
						out.write("注册失败！");
					}
				}catch(Exception e){
					e.printStackTrace();
					out.write("请输入正确的注册信息！");
					out.flush();
					out.close();
					return;
				}
				out.flush();
				out.close();
				return;
				}
			}
		
		
		// 上传请求
		SmartUpload su = new SmartUpload();
		su.initialize(this, request, response);
		su.setAllowedFilesList("jpg,png,JPG,PNG");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

		log.info(sdf.format(new Date()));
		try {
			su.setDeniedFilesList("exe");
			su.upload();
			Files files = su.getFiles();
			com.jspsmart.upload.File file;
			String name1, name2, type;
			int index;
			
			file = files.getFile(0);
			// 判断是否为空上传项
			if (file.isMissing()){
				log.info(sdf.format(new Date())+":file missing!!!");
				out.write("#");
				out.flush();
				out.close();
				return;
			}
			name1 = file.getFileName();
			index = name1.lastIndexOf('.');
			type = name1.substring(index);// 获得文件类型
			name1 = name1.substring(0, index);// 获得文件名不包括后缀
			name2 = name1 + "_date_" + sdf.format(new Date()) + type;
			char sp = File.separatorChar;
			file.saveAs("jsp" + sp + "img" + sp + name2, com.jspsmart.upload.File.SAVEAS_VIRTUAL);
			file.saveAs("D:" + sp + "MyEclipse" + sp + "Workspaces" + sp + "onlineShopping2" + sp + "WebRoot" + sp
					+ "jsp" + sp + "img" + sp + name2, com.jspsmart.upload.File.SAVEAS_PHYSICAL);
			log.info("接收：" + name1 + "\r\n保存为：---->" + name2);
			out.write("img/" + name2);
			out.flush();
			out.close();
			// com.jspsmart.upload.File.SAVEAS_VIRTUAL 下载到tomcat部署文件夹
			// auto 部署文件优先
			// PHYSICAL 硬盘指定目录
			// su.save("down");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
