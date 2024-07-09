import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oyun {

    private Oyuncu oyuncu;
    private int tahminSayisi;

    public Oyun(String isim) {
        this.oyuncu = new Oyuncu(isim);
        this.tahminSayisi =1;
    }
    public void baslat(){
        List<String> renkListesi = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String renk = String.valueOf(Renk.rastgeleSecim()); //Renk enum ve string degere atasin

            if (!renkListesi.contains(renk)){
                renkListesi.add(renk);
            }else {
                i--;
            }
        }

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(renkListesi);
            System.out.println("Renkler: PEMBE, KIRMIZI, MAVI, SARI, BEYAZ");
            System.out.println("Tahminlerinizi yapiniz!");
            String oyuncuSecim1 = scan.nextLine();
            String oyuncuSecim2 = scan.nextLine();
            String oyuncuSecim3 = scan.nextLine();
            String oyuncuSecim4 = scan.nextLine();
            String oyuncuSecim5 = scan.nextLine();

            if (oyuncuSecim1.equalsIgnoreCase(renkListesi.get(0))){
                oyuncu.dogruSayisiArttir();
            }
            if (oyuncuSecim2.equalsIgnoreCase(renkListesi.get(1))){
                oyuncu.dogruSayisiArttir();
            }
            if (oyuncuSecim3.equalsIgnoreCase(renkListesi.get(2))){
                oyuncu.dogruSayisiArttir();
            }
            if (oyuncuSecim4.equalsIgnoreCase(renkListesi.get(3))){
                oyuncu.dogruSayisiArttir();
            }
            if (oyuncuSecim5.equalsIgnoreCase(renkListesi.get(4))){
                oyuncu.dogruSayisiArttir();
            }
            System.out.println(oyuncu.getDogruSayisi()+" tanesi dogru");

            if (oyuncu.getDogruSayisi()!=5) {
                tahminSayisi++;
                oyuncu.dogruSayisiSifirla();
            }

        }while (oyuncu.getDogruSayisi()!=5);
        System.out.println("Tebrikler tum renkleri dogru tahmin ettiniz ");
        System.out.println("Oyuncu ismi : "+ oyuncu.getIsim());
        System.out.println("Tahmin sayiniz : "+ tahminSayisi);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Lutfen isminizi giriniz : ");
        String oyuncuIsim = scan.nextLine();
        Oyun oyun = new Oyun(oyuncuIsim);
        oyun.baslat();
    }
}
