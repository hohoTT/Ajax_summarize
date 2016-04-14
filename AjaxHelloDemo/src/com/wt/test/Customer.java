package com.wt.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {

	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	private String name;
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCity() {
		return "QingDao";
	}
	
	@JsonIgnore
	public String getBirth(){
		return "1995-06-06";
	}
	
	// 测试 jackson 主方法
	
	public static void main(String[] args) throws JsonProcessingException {
		
		// 1. 导入 jar 包
		
		// 2. 创建 ObjectMapper 对象
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. 调用 mapper 的 writeValueAsString 方法，把一个对象转为一个 JSON 字符串
		Customer customer = new Customer("hohoTT", "007");
		String jsonStr = mapper.writeValueAsString(customer);
		
		System.out.println("jsonStr ----- " + jsonStr);
		
		// 4. 注意 JackSon 使用 getter 方法来定位 JSON 对象的属性
		// 除了可以添加注解 com.fasterxml.jackson.annotation.JsonIgnore, 
		// 来忽略某一个 getter 定义的属性
		
		// JackSon 还可以转为一个 JSON 的 list 集合对象
		List<Customer> customers = Arrays.asList(customer, new Customer("ABC", "008"));
		jsonStr = mapper.writeValueAsString(customers);
		
		System.out.println("jsonStr ----- " + jsonStr);
				
	}

}
