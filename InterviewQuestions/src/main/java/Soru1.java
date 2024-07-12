import java.util.Arrays;

public class Soru1 {
    public static void main(String[] args) {
       /*1. How do you reverse a string in Java?

        There is no reverse() utility method in the String class.
        However, you can create a character array from the string and then iterate it from the end to the start.
        You can append the characters to a string builder and finally return the reversed string.
        */

        //1.yol
        String s = "ankara";
        String[] arr = s.split("");
        System.out.println(Arrays.toString(arr));

        System.out.print("Reverse: " );
        for (int i = arr.length-1; i >=0 ; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();


        //2.yol
        StringBuilder sb = new StringBuilder("ankara");
        System.out.println(sb.reverse());


    }
}