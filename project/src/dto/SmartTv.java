package dto;

public class SmartTv extends Product{
	private final String productCode=super.getProductCode()+"S";
	private String resolution; 
			
	public SmartTv(String name, int price, String resolution){
		super(name, price);
		this.resolution=resolution;
	}
	
	public String toString(){
		return "상품명 : "+super.getName()
				+", 가격 : "+ super.getPrice()
				+", 제품코드 : "+this.productCode;
	}

}
