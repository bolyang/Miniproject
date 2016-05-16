package main;

import java.util.Scanner;

public class ShopLauncher {

	public static void main(String[] args) {
		IShop shop = new MyShop();
		Scanner scan = new Scanner(System.in);

		System.out.println("******* Kim's Shop *******");
		System.out.println("Kim's Shop 에 오신걸 환영합니다.");
		System.out.println();
		System.out.println();
		while (true) {
			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("메뉴를 선택하세요.");
			switch (scan.nextLine()) {
			case "1":
				shop.login(); //로그인 시도.
				if(ShopSession.getSession()!=null) {				
					new Main().start();
				}
				
				break;
			case "2":
				shop.joinus();
				break;
			default:
				System.out.println("\n메뉴 선택이 올바르지 않습니다.\n");				
				break;
			}
		}

	}

}
