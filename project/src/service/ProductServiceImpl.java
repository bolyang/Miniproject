package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import dto.Product;
import source.ProductDB;

public class ProductServiceImpl implements ProductService {

	ProductDAO productDAO = new ProductDAOImpl();
	ArrayList<Product> selectProduct = new ArrayList<Product>(); // 장바구니
	ArrayList<Product> productList = productDAO.getProductList(); // 상품리스트

	@Override
	public void productList() {
		int i = 0;
		for (Product product : productList) {
			i++;
			System.out.printf("[%d]", i);
			System.out.println(product);
		}
		buyProduct();
	}

	public void buyProduct() { // 상품구매
		Scanner scan = new Scanner(System.in);
		String menu = ""; // 메뉴선택
		int menuNum = 0; // 메뉴번호
		boolean flag = true; // 입력오류 판단변수.
		System.out.println("구매할 품목을 선택하세요. (종료 : q)");
		System.out.println("결재하기 : c");
		menu = scan.nextLine();
		// 종료/결재 판단......
		if (menu.equalsIgnoreCase("c")) {
			// 결재하기
			credit();
			selectProduct.clear();//장바구니 비우기.
			return;
		} else if (menu.equalsIgnoreCase("q")) {
			return; // 종료.
		}
		try { // 문자열 입력.....
			menuNum = Integer.parseInt(menu);
		} catch (Exception e) {
			flag = false;
			System.out.println("메뉴선택이 잘못되었습니다.");
		}
		if (menuNum > ProductDB.getMemberList().size()) {
			flag = false;
			System.out.println("존재하지 않는 상품입니다.");
		}
		if (flag) {
			selectProduct.add(productList.get(menuNum));
		}
		productList();
	}

	public void credit() {
		Scanner scan = new Scanner(System.in);
		int totalPay = 0; // 결재 금액
		System.out.println("\n\n결재 화면입니다.");
		System.out.println("상품 목록");
		for (Product product : selectProduct) {
			System.out.println(product);
			totalPay += product.getPrice();
		}
		System.out.println("결재금액은 " + totalPay + "입니다.");
		System.out.println("결재수단 : 1.현금\t2.신용카드");
		switch (scan.nextLine()) {
		case "1":
			System.out.println("현금결재 완료");
			break;
		case "2":
			System.out.println("카드결재 완료");
			break;
		default:
			System.out.println("메뉴 선택이 올바르지 않습니다.");
			credit();
			break;
		}

	}

}
