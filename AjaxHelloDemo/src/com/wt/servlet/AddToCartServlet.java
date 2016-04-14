package com.wt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// 1. ��ȡ��������� id��price
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// 2. ��ȡ���ﳵ����
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		
		if(shoppingCart == null){
			shoppingCart = new ShoppingCart(); 
			session.setAttribute("shoppingCart", shoppingCart);
		}
		
		// 3. �ѵ���Ķ�����뵽���ﳵ��
		shoppingCart.addToCart(bookName, price);
		
		// 4. ׼����Ӧ�� JSON ����: {"bookName" : "",��"totalBookNumber" : 1, "totalMoney" : 1}
		// ���ӷ������˷��� JSON �ַ�����������������ʹ��˫���ţ���������Ҫת���ʹ��
		StringBuilder result = new StringBuilder();
		result.append("{")
			  .append("\"bookName\" : \"" + bookName + "\"")
			  .append(",")
			  .append("\"totalBookNumber\" : " + shoppingCart.getTotalBookNumber())
			  .append(",")
			  .append("\"totalMoney\" : " + shoppingCart.getTotalMoney())
			  .append("}");
		
		// 5. ��Ӧ JSON ����
		response.setContentType("text/javascript");
		response.getWriter().print(result.toString());
	}

}
