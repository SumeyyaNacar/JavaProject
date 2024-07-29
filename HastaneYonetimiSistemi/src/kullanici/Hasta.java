package kullanici;

import randevu.RandevuIslemleri;
import bildirim.BildirimIslemleri;
import hasta_bilgileri.HastaGecmisiIslemleri;
import rapor.RaporIslemleri;

import java.util.List;
import java.util.Scanner;

public class Hasta extends Kullanici {
    private int yas;
    private RandevuIslemleri randevuIslemleri;
    private BildirimIslemleri bildirimIslemleri;
    private HastaGecmisiIslemleri hastaGecmisiIslemleri;
    private RaporIslemleri raporIslemleri;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public Hasta(int id, String kullaniciAdi, String sifre, int yas, KullaniciIslemleri kullaniciIslemleri, HastaGecmisiIslemleri hastaGecmisiIslemleri) {
        super(id, kullaniciAdi, sifre, "Hasta");
        this.yas = yas;
        this.randevuIslemleri = kullaniciIslemleri.getRandevuIslemleri();
        this.bildirimIslemleri = kullaniciIslemleri.getBildirimIslemleri();
        this.hastaGecmisiIslemleri = hastaGecmisiIslemleri;
        this.raporIslemleri = new RaporIslemleri();
    }

    public int getYas() {
        return yas;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n****************************************");
            System.out.println("**** Hasta Menüsü ****");
            System.out.println(RED + "1. Yeni Randevu Oluşturma" + RESET);
            System.out.println(GREEN + "2. Randevuları Listeleme" + RESET);
            System.out.println(YELLOW + "3. Randevu İptali" + RESET);
            System.out.println(BLUE + "4. Bildirimleri Görüntüleme" + RESET);
            System.out.println(PURPLE + "5. Reçetelerim" + RESET);
            System.out.println(CYAN + "6. Rapor Görüntüle" + RESET);
            System.out.println(RED + "7. Geri Dön" + RESET);
            System.out.println("****************************************");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    randevuIslemleri.yeniRandevuOlusturma(this.getId());
                    break;
                case 2:
                    randevuIslemleri.randevulariListele(this.getId());
                    break;
                case 3:
                    System.out.print("Randevu ID: ");
                    int randevuId = scanner.nextInt();
                    randevuIslemleri.randevuSil(randevuId);
                    break;
                case 4:
                    bildirimleriGoruntuleme();
                    break;
                case 5:
                    recetelerimiGoruntule();
                    break;
                case 6:
                    raporIslemleri.raporGoruntule(this.getId());
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void bildirimleriGoruntuleme() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Bildirimleri Görüntüleme ****");
            System.out.println("1. Bana Özel Bildirimler");
            System.out.println("2. Tüm Kullanıcılara Gönderilen Bildirimler");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    bildirimIslemleri.bildirimleriListele(this.getId(), true);
                    break;
                case 2:
                    bildirimIslemleri.bildirimleriListele(this.getId(), false);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void recetelerimiGoruntule() {
        System.out.println("Reçetelerim:");
        List<String> receteler = hastaGecmisiIslemleri.hastaReceteleriniGoruntule(this.getId());
        if (receteler.isEmpty()) {
            System.out.println("Reçeteniz bulunmamaktadır.");
        } else {
            for (String recete : receteler) {
                System.out.println(recete);
            }
        }
    }
}
