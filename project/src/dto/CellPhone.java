package dto;

public class CellPhone extends Product{
	private final String productCode=super.getProductCode()+"C";
	private String carrier; 
			
	public CellPhone(String name, int price, String carrier){
		super(name, price);
		this.carrier=carrier;
	}
	
	public String toString(){
		return "상품명 : "+super.getName()
				+", 가격 : "+ super.getPrice()
				+", 제품코드 : "+this.productCode;
	}
}
