import java.util.Scanner;

public class Oyun {
    private Kelime kelime;
    private OyunDurumu durum;

    public Oyun() {
       kelime = new Kelime();
       durum = new OyunDurumu(kelime.getKelime().length());
    }

    public void baslat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adam asmaca oyununa hos geldiniz...");
        while (!durum.oyunBittiMi()){
            durum.durumGoster();
            System.out.println("Lutfen harf giriniz : ");
            char harf = scanner.next().toLowerCase().charAt(0);
            if (!durum.harfTahminEt(harf,kelime.getKelime())){
                System.out.println("Yanlis tahmin!!");
            }
        }
        if (durum.kazandinizMi()){
            System.out.println("Tebrikler kazandiniz!! ");
            System.out.println("Kelime : " + kelime.getKelime().toUpperCase());
        }else {
            System.out.println("Kaybettiniz... Kelime : " +kelime.getKelime());
        }
    }

    public static void main(String[] args) {
        Oyun oyun = new Oyun();
        oyun.baslat();
    }
}
