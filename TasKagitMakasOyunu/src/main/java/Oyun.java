import java.util.Scanner;

public class Oyun {
    private Oyuncu oyuncu1;
    private Oyuncu oyuncu2;
    private int roundSayisi;

    public Oyun(String oyuncu1Isim, String oyuncu2Isim, int roundSayisi) {
        this.oyuncu1 = new Oyuncu(oyuncu1Isim);
        this.oyuncu2 = new Oyuncu(oyuncu2Isim);
        this.roundSayisi = roundSayisi;
    }
    public void baslat(){
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 1; i <=roundSayisi ; i++) {
            System.out.println("Round sayisi : " + i);
            System.out.println(oyuncu1.getIsim() + ",seciminiz (TAS/KAGIT/MAKAS)");
            Secim oyuncu1Secim = oyuncu1.secimYap(scanner.nextLine());
            
            Secim oyuncu2Secim = Secim.rastgeleSecim();
            System.out.println(oyuncu2.getIsim() + "secimi: " + oyuncu2Secim);
            if (oyuncu1Secim == oyuncu2Secim) {
                System.out.println("Berabere!");
            } else if ((oyuncu1Secim == Secim.TAS && oyuncu2Secim == Secim.MAKAS)||
            (oyuncu1Secim == Secim.KAGIT && oyuncu2Secim == Secim.TAS)||
            (oyuncu1Secim == Secim.MAKAS && oyuncu2Secim == Secim.KAGIT)) {
                System.out.println(oyuncu1.getIsim() + " kazandı!");
                oyuncu1.skorArttir();
            } else {
                System.out.println(oyuncu2.getIsim() + " kazandı!");
                oyuncu2.skorArttir();
            }
        }
        skorlariGoster();
    }

    private void skorlariGoster() {
        System.out.println(oyuncu1.getIsim() + " skoru :" + oyuncu1.getSkor());
        System.out.println(oyuncu2.getIsim() + " skoru :" + oyuncu2.getSkor());
        if (oyuncu1.getSkor()>oyuncu2.getSkor()){
            System.out.println(oyuncu1.getIsim()+ " oyunu kazandi!");
        }else if (oyuncu2.getSkor()>oyuncu1.getSkor()){
            System.out.println(oyuncu2.getIsim()+ " oyunu kazandi!");
        }else {
            System.out.println("Oyun berabere...!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Oyuncu ismi : ");
        String oyuncu1Isim = scanner.nextLine();

        System.out.print("Round sayisini giriniz : ");
        int roundSayisi = scanner.nextInt();
        scanner.nextLine();

        Oyun oyun = new Oyun(oyuncu1Isim,"Bilgisayar", roundSayisi);
        oyun.baslat();


    }
}
