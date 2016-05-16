package bangDAO;

public interface BangDAO {
    //하나의 객실정보를 조회한다.
    void getBang();
    //모든 객실정보를 조회한다.
    void getBangAll();
    //객실정보 하나씩 추가
    void insetBang();
    //객실정보 수정
    void updateBang();
    //객실정보 삭제
    void deleteBang();
}
