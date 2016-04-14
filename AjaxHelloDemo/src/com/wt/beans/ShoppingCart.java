package com.wt.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
	
	// 存放 ShoppingCartItem 的 map : 键 : 书名； 值 : ShoppingCartItem 对象
	private Map<String, ShoppingCartItem> items = new HashMap<String, ShoppingCartItem>();
	
	private String bookName;
	
	// 添加商品
	public void addToCart(String bookName, int price){
		
		this.bookName = bookName;
		
		if(items.containsKey(bookName)){
			ShoppingCartItem item = items.get(bookName);
			item.setNumber(item.getNumber() + 1);
		}
		else{
			ShoppingCartItem item = new ShoppingCartItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
			
			items.put(bookName, item);
		}
		
	}
	
	// 获取总的书的书目
	public int getTotalBookNumber(){
		int total = 0;
		
		for (ShoppingCartItem item : items.values()) {
			total += item.getNumber();
		}
		
		return total;
	}
	
	// 获取书的总价格
	public int getTotalMoney(){
		int money = 0;
		
		for (ShoppingCartItem item : items.values()) {
			money += item.getNumber() * item.getPrice();
		}
		
		return money;
	}
	
	public String getBookName() {
		return bookName;
	}

}









