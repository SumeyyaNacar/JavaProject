import java.util.Scanner;

public class AnaProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Sifre uzunlugu giriniz : ");
        int uzunluk = scanner.nextInt();

        System.out.println("Buyuk harf kullanilsin mi ? (true/false)");
        boolean buyukHarf = scanner.nextBoolean();

        System.out.println("Kucuk harf kullanilsin mi? (true/false)");
        boolean kucukHarf = scanner.nextBoolean();

        System.out.println("Rakam kullanilsin mi? (true/false)");
        boolean rakam = scanner.nextBoolean();

        System.out.println("Ozel karakter kullanilsin mi? (true/false)");
        boolean ozelKarakter = scanner.nextBoolean();

        SifreAyarlar ayarlar = new SifreAyarlar(uzunluk, buyukHarf, kucukHarf, rakam, ozelKarakter);
        SifreOlusturucu olusturucu = new SifreOlusturucu();

        String rastgeleSifre = olusturucu.sifreOlustur(ayarlar);
        System.out.println("Olusturulan sifre: " + rastgeleSifre);



    }
}
