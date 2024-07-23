import hasta_bilgileri.HastaGecmisiIslemleri;
import kullanici.*;

public class Main {
    public static void main(String[] args) {

        KullaniciIslemleri kullaniciIslemleri = new KullaniciIslemleri();
        HastaGecmisiIslemleri hastaGecmisiIslemleri = new HastaGecmisiIslemleri();

        // Manuel Olarak Kullanıcıları ekleme
        kullaniciIslemleri.kullaniciEkle(new Yönetici(1, "admin", "admin", kullaniciIslemleri, hastaGecmisiIslemleri));
        kullaniciIslemleri.kullaniciEkle(new Doktor(900, "doktor", "doktor", "Kardiyoloji", kullaniciIslemleri, hastaGecmisiIslemleri));
        kullaniciIslemleri.kullaniciEkle(new Hasta(100, "hasta", "hasta", 30, kullaniciIslemleri, hastaGecmisiIslemleri));

        // Kullanıcı girişi metodu
        kullaniciIslemleri.kullaniciGirisi();
    }
}
