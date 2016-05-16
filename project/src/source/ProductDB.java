package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dto.CellPhone;
import dto.Product;
import dto.SmartTv;

public class ProductDB {
	private static ArrayList<Product> productList =new ArrayList<Product>();
	// arraylist를 product형식으로 불러온다 
	//
	static{
		productList.add(new SmartTv("파브",10988668,"001"));
		productList.add(new SmartTv("파브2",10934368,"002"));
		productList.add(new CellPhone("iPhone",10465656,"002"));
		productList.add(new CellPhone("G3",13434656,"001"));
		productList.add(new CellPhone("GaluxyS5",1042332256,"001"));
		Collections.sort(productList,new ProductComparator());
	}
	//arraylist 추가
	
	private ProductDB(){}
	public static ArrayList<Product> getMemberList(){
		return productList;
	}
}

class ProductComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Product && o2 instanceof Product){
			Product p1=(Product)o1;
			Product p2=(Product)o2;
			return p1.getPrice()-p2.getPrice();
		}
		return 0;
	}
	
}












