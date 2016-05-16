package bang;

import java.util.ArrayList;

public class BangDB {
    
    //객실 DB : 객실 클래스 를 공유할 수 있도록 Static 하고 인스턴스를 하나만 생성해서 공유한다.(최종수정:16.05.16.이성현)
    private static ArrayList<Bang> bangDBList = new ArrayList<Bang>();
    //BangDB 클래스 생성제어자 사용해 생성 제한한다.
    private static BangDB bangDB = new BangDB();
    //BangDB 클래스 를 반환한다.
    public static BangDB bangDB(){
        return bangDB;
    }
    //bagDB 에 들어있는 모든 정보를 반환한다.
    public static ArrayList<Bang> getBangDB() {
        return bangDBList;
    }
    //bangDB 에 정보를 추가 입력한다.
    public static void setBangDB(Bang bang) {
        BangDB.bangDBList.add(bang);
    }
    
}
