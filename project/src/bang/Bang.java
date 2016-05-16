package bang;

public class Bang {
    //객실 클래스 : 최종수정(16.05.16.이성현)
    String bangNum="";//방번호
    String bangName="";//방이름
    int bangCost=0;//방의 기본가격
    String bangSize="";//방크기
    String bangMaxPerson="";//최대수용인원
    String bangOption="";//비고 : 방에 관련된 일체의 기타 정보
    
    
    
    
    //객실 생성자 및 초기화
    public Bang() {}
    public Bang(String bangNum, String bangName, int bangCost, String bangSize,
            String bangMaxPerson, String bangOption) {
        this.bangNum = bangNum;
        this.bangName = bangName;
        this.bangCost = bangCost;
        this.bangSize = bangSize;
        this.bangMaxPerson = bangMaxPerson;
        this.bangOption = bangOption;
        
    }


    //get,set 메소드
    public String getBangNum() {
        return bangNum;
    }
    public void setBangNum(String bangNum) {
        this.bangNum = bangNum;
    }
    public String getBangName() {
        return bangName;
    }
    public void setBangName(String bangName) {
        this.bangName = bangName;
    }
    public int getBangCost() {
        return bangCost;
    }
    public void setBangCost(int bangCost) {
        this.bangCost = bangCost;
    }
    public String getBangSize() {
        return bangSize;
    }
    public void setBangSize(String bangSize) {
        this.bangSize = bangSize;
    }
    public String getBangMaxPerson() {
        return bangMaxPerson;
    }
    public void setBangMaxPerson(String bangMaxPerson) {
        this.bangMaxPerson = bangMaxPerson;
    }
    public String getBangOption() {
        return bangOption;
    }
    public void setBangOption(String bangOption) {
        this.bangOption = bangOption;
    }
    //
    @Override
    public String toString() {
        return "[객실정보] 방번호 :" + bangNum + ", 방이름 : " + bangName
                + ", 가격 : " + bangCost + ", 방크기 : " + bangSize
                + ", 최대수용가능이원 : " + bangMaxPerson + ", 비고 : "
                + bangOption + "";
    }





    
}
