package kullanici;

import java.util.Scanner;

public class Doktor extends Kullanici{

    public Doktor(int id, String kullaniciAdi, String sifre, String rol) {
        super(id, kullaniciAdi, sifre, rol);
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);//Kullanicidan veri almak icin scanner nesnesi

       while (true){

            System.out.println("***Doktor Menusu***");
            System.out.println("1. Randevu Yonetimi");
            System.out.println("2. Rapor ve Analiz");
            System.out.println("3. Bildirimler ve Uyarilar");
            System.out.println("4. Ilac Yazma");
            System.out.println("5. Hasta Bilgilerini Goruntuleme");
            System.out.println("6. Cikis");
            System.out.print("Seciminiz : ");
           int secim= scanner.nextInt();
           scanner.nextLine();
           switch (secim){
               case 1:
                   randevuYonetimi();
                   break;
                   //case->boyle bir kullanim da var
               case 2:
                   raporVeAnliz();
                   break;
               case 3:
                   bidirimlerVeUyarilar();
                   break;
               case 4:
                   ilacYazma();
                   break;
               case 5:
                   hastaBilgileriniGoruntuleme();
                   break;
               case 6:
                   System.out.println("Tesekkur eder, yine bekleriz");
                   return;
               default:
                   System.out.println("Gecersiz Secim");

           }

        }

    }

    private void randevuYonetimi() {
    }

    private void raporVeAnliz() {
    }

    private void bidirimlerVeUyarilar() {
    }

    private void ilacYazma() {
    }

    private void hastaBilgileriniGoruntuleme() {
    }
}
