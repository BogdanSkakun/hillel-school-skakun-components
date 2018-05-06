package enums;

/**
 * Created by HillelNew5 on 12.04.2018.
 */
public enum Level {
    HIGN(90),
    MEDIUM(75),
    LOW(60),
    FAILED(0);

    private  int grade;

     Level(int grade){
        this.grade = grade;
    }
    public int getGrade(){
         return this.grade;
    }
}
