package com.wt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wt.beans.ShoppingCart;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCartServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 获取请求参数： id、price
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// 2. 获取购物车对象
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		
		if(shoppingCart == null){
			shoppingCart = new ShoppingCart(); 
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 3. 把点击的对象加入到购物车中
		shoppingCart.addToCart(bookName, price);
		
		// 4. 准备响应的 JSON 对象: {"bookName" : "",　"totalBookNumber" : 1, "totalMoney" : 1}
		// 若从服务器端返回 JSON 字符串，则属性名必须使用双引号，单引号需要转义后使用
		// 以下为之前复杂的拼接字符串的形式，这种使用方法复杂繁琐
//		StringBuilder result = new StringBuilder();
//		result.append("{")
//			  .append("\"bookName\" : \"" + bookName + "\"")
//			  .append(",")
//			  .append("\"totalBookNumber\" : " + shoppingCart.getTotalBookNumber())
//			  .append(",")
//			  .append("\"totalMoney\" : " + shoppingCart.getTotalMoney())
//			  .append("}");
		
		// 以下为是使用 JackSon 来自动创建 JSON 字符串的方法
		ObjectMapper objectMapper = new ObjectMapper();
		
		String result = objectMapper.writeValueAsString(shoppingCart);
		
		System.out.println("result ----- " + result);
		
		// 5. 响应 JSON 对象
		response.setContentType("text/javascript");
//		response.getWriter().print(result.toString());
		
		response.getWriter().print(result);
	}

}
