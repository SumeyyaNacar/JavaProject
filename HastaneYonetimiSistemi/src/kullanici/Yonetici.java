package kullanici;

import java.util.Scanner;

public class Yonetici extends Kullanici{
    public Yonetici(int id, String kullaniciAdi, String sifre, String rol) {
        super(id, kullaniciAdi, sifre, rol);
    }

    @Override
    public void menu() {

        Scanner scanner= new Scanner(System.in);
        while (true) {
            System.out.println("*** Yonetici Menusu ***");
            System.out.println("1. Randevu Yonetimi");
            System.out.println("2. Kullanici Yonetimi");
            System.out.println("3. Raporlar ve Analiz ");
            System.out.println("4. Bildirimler ve Uyarilar");
            System.out.println("5. Ilac Yonetimi");
            System.out.println("6. Cikis");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    randevuYonetimi();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Gecersiz Secim");
            }
        }

    }

    private void randevuYonetimi() {
        Scanner scanner= new Scanner(System.in);
        while (true){
            System.out.println("*** Randevu Yonetimi ***");
            System.out.println("1. Yeni Randevu Olusturma");
            System.out.println("2. Randevulari Listeleme");
            System.out.println("3. Randevu Detaylarini Goruntuleme");
            System.out.println("4. Randevu Guncelleme");
            System.out.println("5. Randevu Silme");
            System.out.println("6. Cikis");
            int secim = scanner.nextInt();

            switch (secim){
                case 1:
                    randevuYonetimi();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Gecersiz Secim");
            }
        }
    }
}
