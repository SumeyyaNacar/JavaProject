package aracSigorta;

    /*
    Proje: Arac Siborta Prim Hesaplama
           Arac tipleri: otomobil, kamyon, otobus, motosiklet
                         --otobus : 18-30 koltuk veya 31 ve ustu koltuk
           Tarife donemi : Aralik 2022, Haziran 2022
           1. Donem:                            2. Donem:
              otomobil : 2000                      otomobil : 2500
              kamyon : 3000                        kamyon : 3500
              otobus : tip1 : 4000 tip2: 5000      otobus : tip1 : 4500 tip2: 5500
              motosiklet : 1500                    motosiklet : 1750
           Hatali giriste hesaplama basarisiz uyarisi verip tekrar menu gosterilsin.

     */

import java.util.Scanner;

public class AracSigortaApplication {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner input = new Scanner(System.in);
        boolean isFail;
        do {
            isFail =false;
            //menu ve tarife sonemi secimi
            System.out.println("--- Zorunlu Sigorta Primi Hesaplama---");
            System.out.println("Tarife donemi seciniz : ");
            System.out.println("1. Haziran 2022 ");
            System.out.println("2. Aralik 2022 ");
            int term = input.nextInt();
            //tarife donemi dogru girmisse isleme devam et
            //degilse uyari ver ve basa don
            if (term ==1 || term ==2){
                Arac arac = new Arac();
                System.out.println("Lutfen arac tipini giriniz");
                System.out.println("otomobil, kamyon, otobus, motosiklet");
                arac.type = input.next();
                

            }else {
                System.out.println("Hatali giris yaptiniz");
                isFail= true;//dongu basa donecek
            }


        }while (isFail);

    }
}
