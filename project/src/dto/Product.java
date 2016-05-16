package dto;

public abstract class Product {
	private final String productCode="P";
	private int price; //가격
	private String name; //이름
	
	Product(){}
	Product(String name, int price){
		this.name=name;
		this.price=price;		
	}
		
	
	public String getProductCode() {
		return productCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return "상품명 : "+this.name
				+", 가격 : "+ this.price
				+", 제품코드 : "+this.productCode;
	}
}



