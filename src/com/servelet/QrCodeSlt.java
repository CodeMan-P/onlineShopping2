package com.servelet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.mod.bean.Qrcheck;
import com.mod.bean.Users;
import com.service.QrcheckService;
import com.service.SpCarService;
import com.service.UserService;

/**
 * Servlet implementation class QrCodeSlt
 */
@WebServlet("/QrCode")
public class QrCodeSlt extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QrCodeSlt() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		if (flag == null || flag.equals("")) {
			creatQRQode(request, response);
			return;
			}
		PrintWriter out = response.getWriter();
		if (flag.equals("check")) {
			String uuid = (String) request.getSession().getAttribute("uuid");
			
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			Users users = new Users(name, pwd);
			users = UserService.findUser(users);

			if (users == null) {
				out.write("<script type='text/javascript'>alert('登录失败，账户不存在！');</script>");
				
			} else {
				Qrcheck qr = new Qrcheck(uuid, 1, name, pwd);
				QrcheckService.update(qr);
				out.write("<script type='text/javascript'>alert('登录成功');</script>");
			}
		}else if (flag.equals("scan")){
			//获得二维码链接里的UUID
			String uuid = request.getParameter("UUID");
			
			QrcheckService.changeStatus(uuid,2);
			request.getSession().setAttribute("uuid", uuid);
			response.sendRedirect("qrcheck.jsp");
		}else if (flag.equals("verify")){
			String uuid = request.getParameter("uuid");
			Qrcheck qr = QrcheckService.getQrcheck(uuid);
			if(qr==null){
				out.close();
				return;
			}
			
			if (qr.getStatus() == 0) {
				out.write("{\"message\":\"验证失败！\"}");
			} else if (qr.getStatus() == 2) {
				out.write("{\"message\":\"已扫描\"}");
				
			}else if (qr.getStatus() == 1) {
				Users users = new Users(qr.getName(), qr.getPwd());
				users = UserService.findUser(users);
				if (users == null) {
					out.write("{\"message\":\"验证失败！\"}");
				} else {
					Integer uid = users.getUid();
					request.getSession().setAttribute("name", qr.getName());
					request.getSession().setAttribute("uid", uid);
					request.getSession().setAttribute("avatar", users.getAvatar());
					request.getSession().setAttribute("city", users.getCity());
					int num = SpCarService.getCarNum(uid);
					request.getSession().setAttribute("carnum", num);

					ObjectMapper mapper = new ObjectMapper();
					// 借密码变量 存储 购物车数量
					users.setUpwd(num + "");
					String json = mapper.writeValueAsString(users);
					
					out.write(json);
					out.flush();
					QrcheckService.deleQrcheck(uuid);
				}

			}

		}
		if (out != null) {
			out.close();
		}

	}

	static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public static String getUUID() {
		String time = sf.format(new Date());
		// Long timeM = System.currentTimeMillis();
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return time + "-" + uuidStr;
	}

	static int WIDTH = 200;
	static int HEIGHT = 200;

	public void creatQRQode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		OutputStream ou = response.getOutputStream();
		String st = null;
		//String uuid = getUUID();
		String uuid = request.getParameter("UUID");
		String Addr = request.getLocalAddr();
		int port = request.getLocalPort();
		st = "http://" + Addr + ":" + port + "/onlineShopping/QrCode?flag=scan&&UUID=" + uuid;
		Qrcheck q = new Qrcheck(uuid, 0);
		boolean b = QrcheckService.insertQrcheck(q);
		if (!b) {
			// 二维码生成失败返回
			return;
		}
		String format = "png";// 图像类型
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 控制边宽
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(st, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
		} catch (WriterException e) {
			e.printStackTrace();
			
		}
		// 生成矩阵
		MatrixToImageWriter.writeToStream(bitMatrix, format, ou);
		ou.flush();
		ou.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
