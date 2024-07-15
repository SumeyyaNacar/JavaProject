package kullanici;

import randevu.RandevuIslemleri;

import java.util.Scanner;


public class Hasta extends Kullanici{

    public Hasta(int id, String kullaniciAdi, String sifre, String rol) {
        super(id, kullaniciAdi, sifre, rol);
    }

    private RandevuIslemleri randevuIslemleri;
    @Override
    public void menu() {
       while (true){
           Scanner scanner = new Scanner(System.in);
           System.out.println("*** Hasta Menusu ***");
           System.out.println("1.Yeni Randevu Alma");
           System.out.println("2. Randevu Listeleme");
           System.out.println("3. Randevu Iptali");
           System.out.println("4. Cikis");

           int secim = scanner.nextInt();
           scanner.nextLine();
           switch (secim){
               case 1:
                   randevuIslemleri.randevuEkle();
                   break;
               case 2:
                   break;
               case 3:
                   break;
               case 4:
                   break;
               default:
                   System.out.println("Gecersiz secim");
           }

       }


    }
}
