package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.Member;
import main.ShopSession;
import source.MemberDB;

public class MemberServiceImpl2 implements MemberService {

	MemberDAO memberDAO;

	public MemberServiceImpl2(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void start() {
		// 메뉴 1. 회원등록 2. 회원검색 3.회원명단 4.회원수정 5.회원탈퇴 6.종료
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		while (!quit) {
			System.out.println("************* 회원 관리 프로그램 *************");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원조회");
			System.out.println("3. 회원리스트");
			System.out.println("4. 회원수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("6. 종료");
			System.out.print("메뉴를 선택하세요.");
			// switch(menu)
			switch (scan.nextLine()) {
			case "1":// 가입
				joinMember();
				break;
			case "2":// 조회
				searchMember();
				break;
			case "3":// 리스트
				memberList();
				break;
			case "4":// 수정
				modifyMember();
				break;
			case "5":// 삭제
				deleteMember();
				break;
			case "6":// 종료
				quit = true;
				break;

			default:
				;
			}

		} // while(!quit)
	} // main()

	public void joinMember() {
		// 가입양식
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		System.out.println("************ 회원가입 ************");
		System.out.print("이     름 : ");
		member.setName(scan.nextLine());
		System.out.print("아 이 디 : ");
		member.setId(scan.nextLine());
		if (!(memberDAO.getMember(member.getId()) == null)) { // 중복체크
			System.out.println("아이디가 중복됩니다. 초기메뉴로 돌아갑니다.\n");
			return;
		}
		System.out.print("패스워드 : ");
		member.setPwd(scan.nextLine());
		System.out.print("주     소 : ");
		member.setAddress(scan.nextLine());
		System.out.print("전화번호 : ");
		member.setPhone(scan.nextLine());

		switch (memberDAO.addMember(member)) {
		case -1: // 정원초과
			System.out.println("정원 초과입니다.\n");
			break;
		case 0: // 중복
			System.out.println("중복된 아이디 입니다.\n");
			break;
		case 1: // 가입완료
			System.out.println("가입이 정상적으로 이루어졌습니다.\n");
			break;
		}

	}

	public void searchMember() {
		Member member = null;
		Scanner scan = new Scanner(System.in);
		String id = null;

		System.out.println("************ 회원조회 ************");
		System.out.print("아이디 : ");

		id = scan.nextLine();
		member = memberDAO.getMember(id);
		if (member != null) {

			System.out.println("이    름 : " + member.getName());
			System.out.println("아 이 디 : " + member.getId());
			System.out.println("패스워드 : " + member.getPwd());
			System.out.println("주    소 : " + member.getAddress());
			System.out.println("전화번호 : " + member.getPhone());
		} else {
			System.out.println("존재하지 않는 아이디 입니다.\n");
		}
	}

	public void memberList() {
		ArrayList<Member> memberList = memberDAO.getMemberList();
		System.out.println("***************** 회원리스트 *****************");
		System.out.println();
		System.out.println("이     름" + "\t" + "아 이 디" + "\t" + "주     소" + "\t" + "전화번호");
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i).getName() + "\t" + memberList.get(i).getId() + "\t"
					+ memberList.get(i).getAddress() + "\t" + memberList.get(i).getPhone() + "\t");
		}
	}

	@Override
	public void modifyMember() {
		Scanner scan = new Scanner(System.in);
		Member member = ShopSession.getSession();

		int result = -1;
		System.out.println("변경할 내용을 선택하세요.");
		System.out.println("1. 패스워드");
		System.out.println("2. 이름 : " + member.getName());
		System.out.println("3. 주소 : " + member.getAddress());
		System.out.println("4. 전화번호 : " + member.getPhone());
		System.out.println("항목을 선택하세요.");
		switch (scan.nextLine()) {
		case "1": // 패스워드
			System.out.print("패스워드:");
			member.setPwd(scan.nextLine());
			break;
		case "2":// 이름
			System.out.print("이름:");
			member.setName(scan.nextLine());
			break;
		case "3":// 주소
			System.out.print("주소:");
			member.setAddress(scan.nextLine());
			break;
		case "4":// 전화번호
			System.out.print("전화번호:");
			member.setPhone(scan.nextLine());
			break;
		default:
			System.out.println("메뉴선택이 잘못되었습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		}
		result = memberDAO.updateMember(member);
		if (result == 1) {
			System.out.println("회원정보가 변경되었습니다.");
		} else {
			System.out.println("회원정보가 변경이 실패했습니다.");
		}
	}

	@Override
	public void deleteMember() {
		Scanner scan = new Scanner(System.in);
		String id = "";
		int result = -1;
		System.out.println("***************** 회원탈퇴 *****************");
		System.out.println("탈퇴한 회원의 아이디를 입력하세요.");
		id = scan.nextLine().trim();
		Member member = memberDAO.getMember(id);
		if (member == null) {
			System.out.println("일치하는 회원이 없습니다.");
			return;
		} else {
			result = memberDAO.deleteMember(id);
			if (result == 1) {// 삭제 성공
				System.out.println("회원을 탈퇴시켰습니다.");
			} else {// 삭제 실패
				System.out.println("회원탈퇴를 실패했습니다.");
			}
		}

	}
}
