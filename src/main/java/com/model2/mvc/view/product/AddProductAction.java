package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
 


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productVO = new ProductVO();
		HttpSession session = request.getSession();
		
		System.out.println("�׽�Ʈ"+request.getParameter("price"));
		System.out.println(request.getParameter("prodName"));
		System.out.println(request.getParameter("prodDetail"));
		 
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
	 	productVO.setManuDate((request.getParameter("manuDate")).replaceAll("-", "")); 
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
				
		
		System.out.println(productVO);
		
		ProductService service= new ProductServiceImpl();
		service.addProduct(productVO);
		session.setAttribute("VO", productVO);
		
		return "redirect:/product/addProductAction.jsp";
	}

 
}