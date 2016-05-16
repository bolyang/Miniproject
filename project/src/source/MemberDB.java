package source;

import java.util.ArrayList;

import dto.Member;

public class MemberDB {
	private static ArrayList<Member> memberList =new ArrayList<Member>();
	private MemberDB(){}
	public static ArrayList<Member> getMemberList(){
		return memberList;
	}
}






