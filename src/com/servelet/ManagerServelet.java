package com.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServelet
 */

public class ManagerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		//request.getSession().setAttribute("list", ProductService.getList());
		//request.getRequestDispatcher("/jsp/manager.jsp").forward(request, response);
//		String flag = request.getParameter("flag");
//		PrintWriter out = response.getWriter();
//		ObjectMapper mapper = new ObjectMapper();
//		String json="";
//		Goods p=null;
//		if(flag!=null){
//			switch(flag){
//			case "show":
//				request.getSession().setAttribute("list", ProductService.getList());
//				request.getRequestDispatcher("/jsp/proShow.jsp").forward(request, response);
//				return;
//			case "dele":
//				int deleId = Integer.parseInt(request.getParameter("id"));
//				if(ProductService.delePro(deleId)){
//					out.write("删除成功！");
//				}else{
//					out.write("删除失败！");
//				}
//				out.flush();
//				out.close();
//				return;
//			case "edit":
//
//				json = mapper.writeValueAsString(request.getParameterMap());
//				//ajaxSubmit 提交时每个参数以数组传递，需要删除[]
//				json = json.replace("[", "");
//				json = json.replace("]", "");
//				//System.out.println(json);
//				try{
//					p = mapper.readValue(json, Products.class);					
//				}catch(Exception e){
//					out.write("请输入正确的商品信息！");
//					out.flush();
//					out.close();
//					return;
//				}
//				if(ProductService.editPro(p)){
//					out.write("修改成功");
//					request.getSession().setAttribute("list", ProductService.getList());
//				}else{
//					out.write("修改失败");
//				}
//				out.flush();
//				out.close();
//				return;
//			case "add":
//				json = mapper.writeValueAsString(request.getParameterMap());
//				//ajaxSubmit 提交时每个参数以数组传递，需要删除[]
//				json = json.replace("[", "");
//				json = json.replace("]", "");
//				//System.out.println(json);
//				
//				try{
//					p = mapper.readValue(json, Products.class);					
//				}catch(Exception e){
//					out.write("请输入正确的商品信息！");
//					out.flush();
//					out.close();
//					return;
//				}
//				if(ProductService.addPro(p)){
//					out.write("添加成功");
//					request.getSession().setAttribute("list", ProductService.getList());
//				}else{
//					out.write("添加失败");
//				}
//				out.flush();
//				out.close();
//				return;
//			default:;
//			}
		}
		
		// 上传请求
//		SmartUpload su = new SmartUpload();
//		su.initialize(this, request, response);
//		su.setAllowedFilesList("jpg,png,JPG,PNG");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
//
//		System.out.println(sdf.format(new Date()));
//		try {
//			su.setDeniedFilesList("exe");
//			su.upload();
//			Files files = su.getFiles();
//			int sum = files.getCount();
//			com.jspsmart.upload.File file;
//			String name1,name2,type;
//			int index;
//			System.out.println("文件总数："+sum);
//				file = files.getFile(0);
//			    if(file.isMissing()) //判断是否为空上传项
//			    	System.out.println("");
//				name1 = file.getFileName();
//				index= name1.lastIndexOf('.');
//				type = name1.substring(index);//获得文件类型
//				
//				name1 = name1.substring(0, index);//获得文件名不包括后缀
//				name2 = name1+"_date_"+sdf.format(new Date())+type;
//				
//				file.saveAs("jpg"+File.separatorChar+name2,com.jspsmart.upload.File.SAVEAS_VIRTUAL);
//				System.out.println("接收："+name1+"\r\n保存为：---->"+name2);
//				out.write("../jpg/"+name2);
//				out.flush();
//				out.close();
				//com.jspsmart.upload.File.SAVEAS_VIRTUAL  下载到tomcat部署文件夹
				//auto 部署文件优先
				//PHYSICAL  硬盘指定目录
			//su.save("down");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}
