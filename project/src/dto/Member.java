package dto;

public class Member { // 쇼핑몰 회원
	// id, pwd, address, email, phone
	private String name = "손님";
	private String id;
	private String pwd;
	private String address;
	private String email;
	private String phone;

	// 생성자 : 리턴타입 없는 메소드. 인스턴스 초기화.
	// 기본생성자 : 인스턴스 초기화(묵시적→명시적 초기화) 적용.
	public Member() {
		/*
		 * this.id="Guest"; this.pwd="Guest";
		 */
		this("Guest", "Guest");
	}

	// this : 인스턴스 생성시 클래스명 대신 사용.
	// this() : 인스턴스 생성시 생성자 대신 사용.

	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
