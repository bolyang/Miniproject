package yeyac;

import java.util.ArrayList;

public class YeyacDB {
    
    //객실 DB : 객실 클래스 를 공유할 수 있도록 Static 하고 인스턴스를 하나만 생성해서 공유한다.(최종수정:16.05.16.이성현)
    private static ArrayList<Yeyac> yeyacDBList = new ArrayList<Yeyac>();
    //BangDB 클래스 생성제어자 사용해 생성 제한한다.
    private static YeyacDB yeyacDB = new YeyacDB();
    //BangDB 클래스 를 반환한다.
    public static YeyacDB yeyacDB(){
        return yeyacDB;
    }
    //bagDB 에 들어있는 모든 정보를 반환한다.
    public static ArrayList<Yeyac> getYeyacDB() {
        return yeyacDBList;
    }
    //bangDB 에 정보를 추가 입력한다.
    public static void setYeyacDB(Yeyac bang) {
        YeyacDB.yeyacDBList.add(bang);
    }
    
}
