package dao;

import java.util.ArrayList;

import dto.Member;

public interface MemberDAO {	

	Member getMember(String id); //id로 회원검색
	ArrayList<Member> getMemberList(); // 회원리스트
	int addMember(Member member); // 회원등록
	int updateMember(Member member);//회원수정 -1 :실패 , 1:성공
	int deleteMember(String id);///회원삭제 -1:실패, 1:성공
}






