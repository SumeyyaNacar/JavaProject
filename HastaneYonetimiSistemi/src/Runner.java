import kullanici.Doktor;
import kullanici.Kullanici;
import kullanici.KullaniciIslemleri;
import kullanici.Yonetici;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        KullaniciIslemleri kullaniciIslemleri = new KullaniciIslemleri();
        //kullaniciIslemleri.kullaniciEkle(new Doktor(901,"Dr", "Dr1234", "Kardiyoloji");

        //kullaniciIslemleri.kullaniciEkle(new Yonetici(1, "admin", "admin"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanici Adinizi Giriniz");
        String kullaniciAdi = scanner.nextLine();
        System.out.println("Sifrenizi Giriniz");
        String sifre = scanner.nextLine();
        Kullanici kullanici = kullaniciIslemleri.girisYap(kullaniciAdi, sifre);
        if (kullanici !=null){
            System.out.println("Hosgeldiniz "+ kullanici.getKullaniciAdi());
            kullanici.menu();
        }else {
            System.out.println("Gecersiz Kullanici Adi");
        }


    }
}
