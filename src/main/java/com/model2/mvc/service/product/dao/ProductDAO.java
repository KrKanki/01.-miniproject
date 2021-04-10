package com.model2.mvc.service.product.dao;
//		com.model2.mvc.service.product.dao.ProductDAO
import java.sql.Connection;
import java.sql.PreparedStatement;


import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;


public class ProductDAO {

	public ProductDAO() {
	}
	
	public void insertProduct(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "INSERT INTO product"+					
					" values( seq_product_prod_no.nextval, ?, ?, ?, ?, ?, sysdate)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		stmt.setString(5, productVO.getFileName());
		
		stmt.executeUpdate();
		
		con.close();	
	}
	/*
	public  HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		String sql = "SELECT * FROM PRODUCT" ;
 
		if(searchVO.getSearchCondition() != null) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " where USER_ID='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " where USER_NAME='" + searchVO.getSearchKeyword()
						+ "'";
			}
		}
		PreparedStatement stmt = 
				con.prepareStatement(	sql,
															ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
			
		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));
		
		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());	 

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt("prod_no"));
				vo.setProdName(rs.getString("prod_name"));
				vo.setPrice(rs.getInt("price"));
				vo.setRegDate(rs.getDate("reg_date"));
				

				list.add(vo);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
		
	}

public void findProduct(ProductVO productVO) throws Exception {
	
	Connection con = DBUtil.getConnection();
	
	String sql = 
	
	//PreparedStatement stmt = con.prepareStatement(sql);
	//stmt.setString(1, productVO.getProdName());
	//stmt.setString(2, productVO.getProdDetail());
	//stmt.setString(3, productVO.getProdDetail());
	//stmt.setInt(4, productVO.getPrice());
	//stmt.setString(5, productVO.getFileName());
	
	//stmt.executeUpdate();
	
	//con.close();	
}

public void updateProduct(ProductVO productVO) throws Exception {
	
	Connection con = DBUtil.getConnection();
	
	String sql = ""
	
	//PreparedStatement stmt = con.prepareStatement(sql);
//	stmt.setString(1, productVO.getProdName());
	//stmt.setString(2, productVO.getProdDetail());
	//stmt.setString(3, productVO.getProdDetail());
	//stmt.setInt(4, productVO.getPrice());
	//stmt.setString(5, productVO.getFileName());
	
	//stmt.executeUpdate();
	
	con.close();	
}
*/

}	
