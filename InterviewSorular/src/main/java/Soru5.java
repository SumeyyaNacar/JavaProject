import java.util.Scanner;

public class Soru5 {
    public static void main(String[] args) {
        //5. Write a Java program to print a Fibonacci sequence using recursion.


        fibonacci(10);


    }
    public static void fibonacci (int sayi){
        int a= 0;
        int b= 1;
        int c = 1;

        for (int i = 0; i < sayi; i++) {
            System.out.print(a +" ");
            a=b;
            b=c;
            c=a+b;
        }
    }
}
