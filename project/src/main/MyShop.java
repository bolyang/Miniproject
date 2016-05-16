package main;

import java.util.Scanner;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

public class MyShop implements IShop {

	
	@Override
	public void login() {
		Scanner scan=new Scanner(System.in);
		String id="",pwd="";
		System.out.println("********* 로그인 **********");
		System.out.print("아 이 디 :"); id=scan.nextLine().trim();
		System.out.print("패스워드 :"); pwd=scan.nextLine().trim();
		
		MemberDAO memberDAO=new MemberDAOImpl();
		Member member = memberDAO.getMember(id);
		if(member==null){
			System.out.println("존재하지 않는 아이디 입니다.");
		}else{
			if (member.getPwd().equals(pwd)){ //패스워드 일치
				ShopSession.setSession(member);	//세션설정..............!!!!			
			}else{ //패스워드 불일치
				System.out.println("패스워드가 일치하지 않습니다");
			}
		}

	}

	@Override
	public void joinus() {
		MemberService memberService=new MemberServiceImpl(new MemberDAOImpl());
		memberService.joinMember();
	}

}
