package dao;

import java.util.ArrayList;

import dto.Member;
import source.MemberDB;

public class MemberDAOImpl implements MemberDAO {

	ArrayList<Member> memberList = MemberDB.getMemberList();

	public Member getMember(String id) {
		// String 비교 : 문자열.equals(문자열)
		// MemberDB.memberList
		Member member = null;
		for (int i = 0; i < memberList.size(); i++) {
			member = memberList.get(i);
			if (id.equals(member.getId())) {
				return member;
			}
		}
		return null;
	}

	public ArrayList<Member> getMemberList() {
		return MemberDB.getMemberList();
	}

	public int addMember(Member member) {
		// String 비교 : 문자열.equals(문자열)
		int result = -1; // 0:중복 , 1:가입성공
		if (getMember(member.getId()) != null) {
			result = 0; // 중복!!
		} else {
			memberList.add(member); // memberList에 추가.
			result = 1; // 가입성공
		}
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result = -1;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(member.getId())) {
				memberList.set(i, member);
				result = 1;
			} else {
				result = -1;
			}
		}
		return result;
	}

	@Override
	public int deleteMember(String id) {
		int findIndex=-1; // 삭제할 멤버의 인덱스
		int result=-1;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				findIndex=i;				
			}			
		}
		if(findIndex>-1){
			memberList.remove(findIndex);
			result=1;
		}
		return result;
	}
}






