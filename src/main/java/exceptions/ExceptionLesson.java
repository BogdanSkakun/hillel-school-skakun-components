package exceptions;

/**
 * Created by HillelNew5 on 05.04.2018.
 */
public class ExceptionLesson {

    public static void main(String[] args) {
        int a = 0;
        try{
            a = divide(30,0);
       /*}catch(ArithmeticException e){
           e.printStackTrace();*/
       }catch(NullPointerException e){
           e.printStackTrace();
        }/*catch (NegativeArraySizeException e){
           e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        finally{
            System.out.println("Finally block code");
        }
        System.out.println(a);
    }
    public static int divide(int a, int b){
        return a/b;
    }
}
