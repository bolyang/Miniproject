package dao;

import java.util.ArrayList;

import dto.Product;
import source.ProductDB;

public class ProductDAOImpl implements ProductDAO {

	ArrayList<Product> productList=ProductDB.getMemberList();
	
	@Override
	public ArrayList<Product> getProductList() {		
		return productList;
	}

}
