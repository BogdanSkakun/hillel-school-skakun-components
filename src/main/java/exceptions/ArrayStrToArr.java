package exceptions;

/**
 * Created by HillelNew5 on 05.04.2018.
 */
public class ArrayStrToArr {


    public static void main(String[] args) {

        String[] arrayOne = {"16","28","14"};
        String[] arrayTwo = {"a","b","c"};
        String[] arrayThree = null;
        String[] arrayFour = {"34","56"};

        formatStrArrToIntArr(arrayOne);
        formatStrArrToIntArr(arrayTwo);
        formatStrArrToIntArr(arrayThree);
        formatStrArrToIntArr(arrayFour);

    }

    public static int[] formatStrArrToIntArr(String[] strArray) {

        int[] array = null;
        try {
            array = new int[strArray.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(strArray[i]);
            }
        } catch(NullPointerException e ) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return  array;
    }
}
