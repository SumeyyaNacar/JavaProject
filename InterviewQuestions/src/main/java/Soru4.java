import java.util.Scanner;

public class Soru4 {
    public static void main(String[] args) {

        //4. Write a Java program to check if the given number is a prime number.(asal sayi)


        Scanner scan = new Scanner(System.in);
        System.out.println("Bir sayi giriniz");
        int num= scan.nextInt();
        System.out.println(isPrimeNumber(num));
    }
    public static boolean isPrimeNumber(int a){

        int k = 0;
        for (int i = 2; i < a; i++) {
            if (a%i==0 ){
                k=k+1;
            }
        }
        if (k==0){
            return true;
        } else if(a==2){
            return false;
        }
        else {
            return false;
        }
    }


}
