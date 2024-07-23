package kullanici;

import hasta_bilgileri.HastaGecmisiIslemleri;
import randevu.RandevuIslemleri;
import bildirim.BildirimIslemleri;
import ilac.IlacIslemleri;
import rapor.RaporIslemleri;

import java.util.List;
import java.util.Scanner;

public class Doktor extends Kullanici {
    private RandevuIslemleri randevuIslemleri;
    private BildirimIslemleri bildirimIslemleri;
    private IlacIslemleri ilacIslemleri;
    private RaporIslemleri raporIslemleri;
    private HastaGecmisiIslemleri hastaGecmisiIslemleri;
    private KullaniciIslemleri kullaniciIslemleri;
    private String brans;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";


    public Doktor(int id, String kullaniciAdi, String sifre, String brans, KullaniciIslemleri kullaniciIslemleri, HastaGecmisiIslemleri hastaGecmisiIslemleri) {
        super(id, kullaniciAdi, sifre, "Doktor");
        this.randevuIslemleri = kullaniciIslemleri.getRandevuIslemleri();
        this.bildirimIslemleri = kullaniciIslemleri.getBildirimIslemleri();
        this.ilacIslemleri = kullaniciIslemleri.getIlacIslemleri();
        this.raporIslemleri = new RaporIslemleri();
        this.hastaGecmisiIslemleri = hastaGecmisiIslemleri;
        this.kullaniciIslemleri = kullaniciIslemleri;
        this.brans = brans;
    }

    public String getBrans() {
        return brans;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n****************************************");
            System.out.println("**** Doktor Menüsü ****");
            System.out.println(RED + "1. Randevu Yönetimi" + RESET);
            System.out.println(GREEN + "2. Raporlar ve Analiz" + RESET);
            System.out.println(YELLOW + "3. Bildirimler ve Uyarılar" + RESET);
            System.out.println(BLUE + "4. İlaç Yazma" + RESET);
            System.out.println(PURPLE + "5. Hasta Bilgileri Görüntüleme" + RESET);
            System.out.println(CYAN + "6. Hasta Geçmişi Görüntüleme" + RESET);
            System.out.println(RED + "7. Çıkış" + RESET);
            System.out.println("****************************************");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    randevuYonetimi();
                    break;
                case 2:
                    raporYonetimi();
                    break;
                case 3:
                    bildirimYonetimi();
                    break;
                case 4:
                    ilacYazma();
                    break;
                case 5:
                    hastaBilgileriGoruntuleme();
                    break;
                case 6:
                    hastaGecmisiGoruntuleme();
                    break;
                case 7:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void randevuYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Randevu Yönetimi ****");
            System.out.println("1. Randevuları Listeleme");
            System.out.println("2. Randevu Detayları Görüntüleme");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    randevuIslemleri.randevulariListele(this.getId());
                    break;
                case 2:
                    System.out.print("Randevu ID: ");
                    int randevuId = scanner.nextInt();
                    scanner.nextLine();
                    randevuIslemleri.randevuDetaylari(randevuId);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void raporYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Raporlar ve Analiz ****");
            System.out.println("1. Günlük Rapor Oluştur");
            System.out.println("2. Aylık Rapor Oluştur");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    raporIslemleri.gunlukRaporOlustur();
                    break;
                case 2:
                    raporIslemleri.aylikRaporOlustur();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void bildirimYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Bildirimler ve Uyarılar ****");
            System.out.println("1. Yeni Bildirim Oluşturma");
            System.out.println("2. Bildirimleri Listeleme");
            System.out.println("3. Bildirim Detaylarını Görüntüleme");
            System.out.println("4. Bildirimleri Temizleme");
            System.out.println("5. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Kullanıcı ID (Tüm kullanıcılar için -1 girin): ");
                    int kullaniciId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Mesaj: ");
                    String mesaj = scanner.nextLine();
                    bildirimIslemleri.yeniBildirim(kullaniciId, mesaj);
                    break;
                case 2:
                    System.out.print("Kullanıcı ID (Tüm kullanıcılar için -1 girin): ");
                    int listeleId = scanner.nextInt();
                    scanner.nextLine();
                    bildirimIslemleri.bildirimleriListele(listeleId);
                    break;
                case 3:
                    System.out.print("Bildirim ID: ");
                    int bildirimId = scanner.nextInt();
                    scanner.nextLine();
                    bildirimIslemleri.bildirimDetaylari(bildirimId);
                    break;
                case 4:
                    System.out.print("Kullanıcı ID (Temizlemek için -1 girin): ");
                    int temizleId = scanner.nextInt();
                    scanner.nextLine();
                    bildirimIslemleri.bildirimleriTemizle(temizleId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void ilacYazma() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** İlaç Yazma ****");
            System.out.println("1. Yeni İlaç Yazma");
            System.out.println("2. İlaçları Listeleme");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Hasta ID: ");
                    int hastaId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Mevcut İlaçlar:");
                    ilacIslemleri.ilaclariListele();
                    System.out.print("İlaç ID: ");
                    int ilacId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Dozaj: ");
                    String dozaj = scanner.nextLine();
                    System.out.print("Kullanım Talimatı: ");
                    String kullanimTalimat = scanner.nextLine();
                    String ilacBilgisi = "İlaç ID: " + ilacId + ", Dozaj: " + dozaj + ", Kullanım Talimatı: " + kullanimTalimat;
                    hastaGecmisiIslemleri.yeniIlacEkle(hastaId, ilacBilgisi);
                    System.out.println("İlaç başarıyla yazıldı.");
                    break;
                case 2:
                    ilacIslemleri.ilaclariListele();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void hastaBilgileriGoruntuleme() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Hasta Bilgileri Görüntüleme ****");
            System.out.println("1. Hasta Bilgilerini Görüntüleme");
            System.out.println("2. Hasta Geçmişini Görüntüleme");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    kullaniciIslemleri.kullanicilariListele();
                    break;
                case 2:
                    System.out.print("Hasta ID: ");
                    int hastaId = scanner.nextInt();
                    scanner.nextLine();
                    Kullanici hasta = kullaniciIslemleri.kullaniciBul(hastaId);
                    if (hasta instanceof Hasta) {
                        //"Hasta".equals(hasta.getRol()) veya (hasta.getRol().equals("Hasta"))

                        //instanceof kelimesi gelen obje o sınıfa ait mi diye bakar.
                        // Bunun yerine yukarıda olduğu gibi direk role de bakılabilirdi...


                        System.out.println("Hasta ID: " + hasta.getId());
                        System.out.println("Hasta Adı: " + hasta.getKullaniciAdi());
                        System.out.println("Hasta Yaşı: " + ((Hasta) hasta).getYas());
                        List<String> oykuListesi = hastaGecmisiIslemleri.hastaOykusunuGoruntule(hastaId);
                        if (!oykuListesi.isEmpty()) {
                            System.out.println("Öyküler:");
                            for (String oyku : oykuListesi) {
                                System.out.println(oyku);
                            }
                        } else {
                            System.out.println("Bu hasta için öykü bulunamadı.");
                        }
                        List<String> ilacListesi = hastaGecmisiIslemleri.hastaIlacGecmisiniGoruntule(hastaId);
                        if (!ilacListesi.isEmpty()) {
                            System.out.println("İlaç Geçmişi:");
                            for (String ilac : ilacListesi) {
                                System.out.println(ilac);
                            }
                        } else {
                            System.out.println("Bu hasta için ilaç geçmişi bulunamadı.");
                        }
                    } else {
                        System.out.println("Geçersiz hasta ID.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void hastaGecmisiGoruntuleme() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Hasta Geçmişi Görüntüleme ****");
            System.out.println("1. Öykü Görüntüle");
            System.out.println("2. İlaç Geçmişi Görüntüle");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Hasta ID: ");
                    int hastaId = scanner.nextInt();
                    scanner.nextLine();
                    List<String> oykuListesi = hastaGecmisiIslemleri.hastaOykusunuGoruntule(hastaId);
                    if (oykuListesi.isEmpty()) {
                        System.out.println("Bu hasta için öykü bulunamadı.");
                    } else {
                        System.out.println("Hasta ID: " + hastaId + " Öyküleri:");
                        for (String oyku : oykuListesi) {
                            System.out.println(oyku);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Hasta ID: ");
                    int hastaIdIlac = scanner.nextInt();
                    scanner.nextLine();
                    List<String> ilacListesi = hastaGecmisiIslemleri.hastaIlacGecmisiniGoruntule(hastaIdIlac);
                    if (ilacListesi.isEmpty()) {
                        System.out.println("Bu hasta için ilaç geçmişi bulunamadı.");
                    } else {
                        System.out.println("Hasta ID: " + hastaIdIlac + " İlaç Geçmişi:");
                        for (String ilac : ilacListesi) {
                            System.out.println(ilac);
                        }
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
