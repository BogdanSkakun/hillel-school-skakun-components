package enums;

import static enums.Level.LOW;

/**
 * Created by HillelNew5 on 12.04.2018.
 */
public class GradePrinter {
    public static void main(String[] args) {
        printGrade(Level.LOW);
        printGrade(Level.MEDIUM);
        printGrade(Level.HIGN);
        printGrade(Level.HIGN);
        printGrade(93);
        printGrade(15);
        printGrade(33);
        printGrade(66);
        printGrade(74);
        printGrade(75);
    }
    public static void printGrade(Level grade){
        if(grade.equals(Level.HIGN)){
            System.out.println("You have excellent grade");
        }else if(grade.equals(Level.MEDIUM)){
            System.out.println("You have good grade");
        }else if(grade.equals(LOW)){
            System.out.println("You should retake test");
        }else{
            System.out.println("Oops");
        }

    }
    public static void printGrade(int grade){
        if(grade >=Level.HIGN.getGrade()){
            System.out.println("Perfect");
        }else if(grade>=Level.MEDIUM.getGrade()){
            System.out.println("GOOD");
        }else if(grade >= Level.LOW.getGrade()){
            System.out.println("Passed but not good");
        }else if(grade >= Level.FAILED.getGrade()){
            System.out.println("FAILED");
        }
    }

}
