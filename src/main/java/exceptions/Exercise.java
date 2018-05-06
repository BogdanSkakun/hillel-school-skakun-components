package exceptions;

/**
 * Created by HillelNew5 on 05.04.2018.
 */
public class Exercise {

    public static void main(String[] args) {
        int[] arr = new int[10];
        try {
            System.out.println(arr[9001]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("problem with code was found");
        }
    }
}
