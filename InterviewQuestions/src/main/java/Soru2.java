public class Soru2 {
    public static void main(String[] args) {
        /*
         2. How do you swap two numbers without using a third variable in Java?
         */

        int a=11;
        int b=13;


        b= b+a;//24
        a=b-a;//a'nin yeni degeri = toplam(b)-a'nin eski degeri
        b= b-a;// b= b'nin yeni degeri- a'nin yeni degeri

    }
}
