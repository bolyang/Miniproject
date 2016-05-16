package main;

import java.util.Scanner;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import service.MemberServiceImpl2;
import service.ProductServiceImpl;

public class Main {
	public void start() {
		Scanner scan = new Scanner(System.in);
		MemberDAO memberDAO=new MemberDAOImpl();
		//ProductDAO productDAO=new ProductDAOImpl();

		while (ShopSession.getSession() != null) {
			System.out.println("******** 메인페이지 *********");
			System.out.println("1. 상품리스트");
			System.out.println("2. 회원정보 조회");
			System.out.println("3. 탈퇴");
			System.out.println("4. 종료");
			System.out.println("메뉴를 선택하시오.");

			switch (scan.nextLine().trim()) {
			case "1": // 상품리스트
				new ProductServiceImpl().productList();
				break;
			case "2":// 회원정보수정
				new MemberServiceImpl2(memberDAO).modifyMember();				
				break;
			case "3":// 회원탈퇴				
				memberDAO.deleteMember(ShopSession.getSession().getId());
				ShopSession.setSession(null);//세션종료.
				break;
			case "4":// 종료
				ShopSession.setSession(null);//세션종료.
				System.exit(0);//강제종료.
				break;
			default:
				break;
			}
		}
	}
}
