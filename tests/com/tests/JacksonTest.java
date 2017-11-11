package com.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	// 子类多态
	// @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS,
	// include=JsonTypeInfo.As.PROPERTY, property="@class")
	// @JsonSubTypes({@Type(value=Lion.class,name="lion"),@Type(value=Elephant.class,name="elephant")})

	@Test
	public void testMethod() {
//		TreeMap tm = new TreeMap<>(new Comparator<Goods>() {
//
//			@Override
//			public int compare(Goods o1, Goods o2) {
//				return o1.name.compareTo(o2.name);
//			}
//		});
//		tm.keySet().iterator();
//		TreeSet tss = new TreeSet<Goods>(new Comparator<Goods>() {
//
//			@Override
//			public int compare(Goods o1, Goods o2) {
//				return o1.name.compareTo(o2.name);
//			}
//		});
		ObjectMapper mapper = new ObjectMapper();
		String path = System.getProperty("user.dir") + File.separatorChar + "test" + File.separatorChar
				+ "sort_content_data.json";
		// sort_content_data scd = new sort_content_data();
		File file = new File(path);

		Class<?> c = null;
		sort_content_data temp = new sort_content_data();
		try {
			c = Class.forName(temp.getClass().getName());

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} // 获取Class对象，注意这里必须是包名+类名
		HashSet<Object> ts = new HashSet<Object>();
		HashMap<String,Object> hm = new HashMap<String,Object>();
		String s = "sort_content_data";
		LinkedList<sort_content_data> scd = new LinkedList<>();

		// scd.getFirst();
		try {
			// scd = mapper.readValue(file, sort_content_data.class);
			scd = mapper.readValue(file, new TypeReference<LinkedList<sort_content_data>>() {
			});
			System.out.println(scd.getClass().getCanonicalName());
			System.out.println(scd.getFirst().data.getFirst().section);
			Goods g1 =null;
			Data d = null;
			d=scd.getFirst().data.getFirst();
			 g1 = d.getGoods().getFirst();
			 hm.put("data", d);
			 hm.put("goods", g1);
			 //ts.add(d);
			 //ts.add(g1);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hm));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		String path = System.getProperty("user.dir") + File.separatorChar + "WebRoot\\json\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String fileName = "pro_date_" + sdf.format(new Date()) + ".json";
		String fileName2 = "proView_date_20171106162557681.json";

		// File file = new File(path+fileName);
		File file2 = new File(path + fileName2);
		try {
			// if(!file.exists()){
			// file.createNewFile();
			// }
			if (!file2.exists()) {
				file2.createNewFile();
			}
			// mapper.writeValue(file, list);//单行文本输出
			System.out.println("down!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JsonFactory jsf = mapper.getFactory();

			JsonGenerator jsong = jsf.createGenerator(file2, JsonEncoding.UTF8);
			System.out.println(json);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 1.注解使用在 类名,接口头上
	 * 
	 * @JsonIgnoreProperties(value={"comid"}) //希望动态过滤掉的属性 2。该注解使用在get方法头上
	 * 
	 * @JsonIgnore
	 */
}
