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
	
	// ���� jackson ������
	
	public static void main(String[] args) throws JsonProcessingException {
		
		// 1. ���� jar ��
		
		// 2. ���� ObjectMapper ����
		ObjectMapper mapper = new ObjectMapper();
		
		// 3. ���� mapper �� writeValueAsString ��������һ������תΪһ�� JSON �ַ���
		Customer customer = new Customer("hohoTT", "007");
		String jsonStr = mapper.writeValueAsString(customer);
		
		System.out.println("jsonStr ----- " + jsonStr);
		
		// 4. ע�� JackSon ʹ�� getter ��������λ JSON ���������
		// ���˿������ע�� com.fasterxml.jackson.annotation.JsonIgnore, 
		// ������ĳһ�� getter ���������
		
		// JackSon ������תΪһ�� JSON �� list ���϶���
		List<Customer> customers = Arrays.asList(customer, new Customer("ABC", "008"));
		jsonStr = mapper.writeValueAsString(customers);
		
		System.out.println("jsonStr ----- " + jsonStr);
				
	}

}
