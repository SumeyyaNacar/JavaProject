import java.util.Scanner;

public class Soru6 {
    public static void main(String[] args) {
        //6. How do you check if a list of integers contains only odd numbers in Java?--tek sayi
        Scanner scan = new Scanner(System.in);
        System.out.println("Lutfen bir sayi giriniz");
        int num = scan.nextInt();
        tekSayi1(num);
        //tekSayi2(num);


    }

    public static void tekSayi1(int num) {
        if (num % 2 != 0) {
            System.out.println("Tek sayi");
        } else {
            System.out.println("Cift sayi");
        }
    }

    public static void tekSayi2(int num) {
        String s = num % 2 != 0 ? "Tek sayi" : "Cift sayi";
        System.out.println(s);
    }
}
