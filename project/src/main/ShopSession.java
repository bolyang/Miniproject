package main;

import dto.Member;

public final class ShopSession {
	private static Member session=null;
	
	private ShopSession(){};
	
	public static Member getSession() {
		return session;
	}

	public static void setSession(Member session) {
		ShopSession.session = session;
	}
	
}
