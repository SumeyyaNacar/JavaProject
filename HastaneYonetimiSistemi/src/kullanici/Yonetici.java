package kullanici;

import hasta_bilgileri.HastaGecmisiIslemleri;
import randevu.RandevuIslemleri;
import bildirim.BildirimIslemleri;
import ilac.IlacIslemleri;
import rapor.RaporIslemleri;

import java.util.List;
import java.util.Scanner;

public class Yönetici extends Kullanici {
    private KullaniciIslemleri kullaniciIslemleri;
    private RandevuIslemleri randevuIslemleri;
    private BildirimIslemleri bildirimIslemleri;
    private IlacIslemleri ilacIslemleri;
    private RaporIslemleri raporIslemleri;
    private HastaGecmisiIslemleri hastaGecmisiIslemleri;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";


    public Yönetici(int id, String kullaniciAdi, String sifre, KullaniciIslemleri kullaniciIslemleri, HastaGecmisiIslemleri hastaGecmisiIslemleri) {
        super(id, kullaniciAdi, sifre, "Yönetici");
        this.kullaniciIslemleri = kullaniciIslemleri;
        this.randevuIslemleri = kullaniciIslemleri.getRandevuIslemleri();
        this.bildirimIslemleri = kullaniciIslemleri.getBildirimIslemleri();
        this.ilacIslemleri = kullaniciIslemleri.getIlacIslemleri();
        this.raporIslemleri = new RaporIslemleri();
        this.hastaGecmisiIslemleri = hastaGecmisiIslemleri;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n****************************************");
            System.out.println("**** Yönetici Menüsü ****");
            System.out.println(RED + "1. Randevu Yönetimi" + RESET);
            System.out.println(GREEN + "2. Kullanıcı Yönetimi" + RESET);
            System.out.println(YELLOW + "3. Raporlar ve Analiz" + RESET);
            System.out.println(BLUE + "4. Bildirimler ve Uyarılar" + RESET);
            System.out.println(PURPLE + "5. İlaç Yönetimi" + RESET);
            System.out.println(CYAN + "6. Hasta Geçmişi Yönetimi" + RESET);
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
                    kullaniciYonetimi();
                    break;
                case 3:
                    raporYonetimi();
                    break;
                case 4:
                    bildirimYonetimi();
                    break;
                case 5:
                    ilacYonetimi();
                    break;
                case 6:
                    hastaGecmisiYonetimi();
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
            System.out.println("1. Yeni Randevu Oluşturma");
            System.out.println("2. Randevuları Listeleme");
            System.out.println("3. Randevu Detayları Görüntüleme");
            System.out.println("4. Randevu Güncelleme");
            System.out.println("5. Randevu Silme");
            System.out.println("6. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    yeniRandevuOlustur();
                    break;
                case 2:
                    randevulariListele();
                    break;
                case 3:
                    randevuDetaylari();
                    break;
                case 4:
                    randevuGuncelle();
                    break;
                case 5:
                    randevuSil();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void yeniRandevuOlustur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hasta ID: ");
        int hastaId = scanner.nextInt();
        scanner.nextLine();
        randevuIslemleri.yeniRandevuOlusturma(hastaId);
    }

    private void randevulariListele() {
        randevuIslemleri.randevulariListele();
    }

    private void randevuDetaylari() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Randevu ID: ");
        int randevuId = scanner.nextInt();
        scanner.nextLine();
        randevuIslemleri.randevuDetaylari(randevuId);
    }

    private void randevuGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Randevu ID: ");
        int randevuId = scanner.nextInt();
        scanner.nextLine();
        randevuIslemleri.randevuGuncelle(randevuId);
    }

    private void randevuSil() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Randevu ID: ");
        int randevuId = scanner.nextInt();
        scanner.nextLine();
        randevuIslemleri.randevuSil(randevuId);
    }

    private void kullaniciYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Kullanıcı Yönetimi ****");
            System.out.println("1. Yeni Kullanıcı Ekleme");
            System.out.println("2. Kullanıcı Listeleme");
            System.out.println("3. Kullanıcı Bilgilerini Güncelleme");
            System.out.println("4. Kullanıcı Silme");
            System.out.println("5. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    yeniKullaniciEkleme();
                    break;
                case 2:
                    kullaniciIslemleri.kullanicilariListele();
                    break;
                case 3:
                    kullaniciBilgileriniGuncelle();
                    break;
                case 4:
                    kullaniciSil();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void yeniKullaniciEkleme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kullanıcı Rolü Seçin: 1. Doktor - 2. Hasta");
        int rolSecim = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kullanıcı Adı: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();

        if (rolSecim == 1) {
            System.out.print("Branş: ");
            String brans = scanner.nextLine();
            int id = kullaniciIslemleri.kullaniciEkle(new Doktor(0, kullaniciAdi, sifre, brans, kullaniciIslemleri, hastaGecmisiIslemleri));
            System.out.println("Doktor eklendi. ID: " + id);
        } else if (rolSecim == 2) {
            System.out.print("Yaş: ");
            int yas = scanner.nextInt();
            scanner.nextLine();
            int id = kullaniciIslemleri.kullaniciEkle(new Hasta(0, kullaniciAdi, sifre, yas, kullaniciIslemleri, hastaGecmisiIslemleri));
            System.out.println("Hasta eklendi. ID: " + id);
        } else {
            System.out.println("Geçersiz rol seçimi.");
        }
    }

    private void kullaniciBilgileriniGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        kullaniciIslemleri.kullaniciGuncelle(id);
    }

    private void kullaniciSil() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı ID: ");
        int silinecekId = scanner.nextInt();
        scanner.nextLine();
        kullaniciIslemleri.kullaniciSil(silinecekId);
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

    private void ilacYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** İlaç Yönetimi ****");
            System.out.println("1. Yeni İlaç Ekleme");
            System.out.println("2. İlaçları Listeleme");
            System.out.println("3. İlaç Güncelleme");
            System.out.println("4. İlaç Silme");
            System.out.println("5. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    ilacEkle();
                    break;
                case 2:
                    ilacIslemleri.ilaclariListele();
                    break;
                case 3:
                    ilacGuncelle();
                    break;
                case 4:
                    ilacSil();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void ilacEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("İlaç Adı: ");
        String ad = scanner.nextLine();
        System.out.print("İlaç Türü: ");
        String tur = scanner.nextLine();
        System.out.print("Kullanım Talimatları: ");
        String talimat = scanner.nextLine();
        System.out.print("Stok Miktarı: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        ilacIslemleri.ilacEkle(ad, tur, talimat, stok);
    }

    private void ilacGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("İlaç ID: ");
        int ilacId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Yeni İlaç Adı: ");
        String yeniAd = scanner.nextLine();
        System.out.print("Yeni İlaç Türü: ");
        String yeniTur = scanner.nextLine();
        System.out.print("Yeni Kullanım Talimatları: ");
        String yeniTalimat = scanner.nextLine();
        System.out.print("Yeni Stok Miktarı: ");
        int yeniStok = scanner.nextInt();
        scanner.nextLine();
        ilacIslemleri.ilacGuncelle(ilacId, yeniAd, yeniTur, yeniTalimat, yeniStok);
    }

    private void ilacSil() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("İlaç ID: ");
        int ilacId = scanner.nextInt();
        scanner.nextLine();
        ilacIslemleri.ilacSil(ilacId);
    }

    private void hastaGecmisiYonetimi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Hasta Geçmişi Yönetimi ****");
            System.out.println("1. Yeni Öykü Ekleme");
            System.out.println("2. Hasta Geçmişini Görüntüleme");
            System.out.println("3. Geri Dön");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    yeniOykuEkle();
                    break;
                case 2:
                    hastaGecmisiniGoruntule();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void yeniOykuEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hasta ID: ");
        int hastaId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Öykü: ");
        String oyku = scanner.nextLine();
        hastaGecmisiIslemleri.yeniOykuEkle(hastaId, oyku);
        System.out.println("Öykü başarıyla eklendi.");
    }

    private void hastaGecmisiniGoruntule() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hasta ID: ");
        int hastaId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Geçmiş filtrele (oyku-ilac): ");
        String filtre = scanner.nextLine();
        if (filtre.equalsIgnoreCase("oyku")) {
            List<String> oykuListesi = hastaGecmisiIslemleri.hastaOykusunuGoruntule(hastaId);
            if (oykuListesi.isEmpty()) {
                System.out.println("Bu hasta için öykü bulunamadı.");
            } else {
                System.out.println("Hasta ID: " + hastaId + " Öyküleri:");
                for (String o : oykuListesi) {
                    System.out.println(o);
                }
            }
        } else if (filtre.equalsIgnoreCase("ilac")) {
            List<String> ilacListesi = hastaGecmisiIslemleri.hastaIlacGecmisiniGoruntule(hastaId);
            if (ilacListesi.isEmpty()) {
                System.out.println("Bu hasta için ilaç geçmişi bulunamadı.");
            } else {
                System.out.println("Hasta ID: " + hastaId + " İlaç Geçmişi:");
                for (String i : ilacListesi) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Geçersiz filtre.");
        }
    }
}
