package kullanici;

import randevu.RandevuIslemleri;
import rapor.RaporIslemleri;
import bildirim.BildirimIslemleri;
import Ilac.IlacIslemleri;

import java.util.Scanner;

// Yönetici sınıfı, Kullanici sınıfından türetilir ve yöneticilerin sahip olduğu özellikler ve işlevler tanımlanır.
public class Yonetici extends Kullanici {
    private RandevuIslemleri randevuIslemleri; // Randevu işlemleri için nesne
    private RaporIslemleri raporIslemleri; // Rapor işlemleri için nesne
    private BildirimIslemleri bildirimIslemleri; // Bildirim işlemleri için nesne
    private IlacIslemleri ilacIslemleri; // İlaç işlemleri için nesne
    private KullaniciIslemleri kullaniciIslemleri; // Kullanıcı işlemleri için nesne

    // Yönetici sınıfının kurucusu
    // Kurucu metod, yöneticinin kimlik numarası, adı, şifresi ve kullanıcı işlemleri nesnesini alır.
    // Bu bilgiler, yönetici nesnesi oluşturulduğunda başlatılır.
    public Yonetici(int id, String kullaniciAdi, String sifre, KullaniciIslemleri kullaniciIslemleri) {
        super(id, kullaniciAdi, sifre, "Yönetici"); // Üst sınıfın (Kullanici) kurucu metodunu çağırır.

        this.kullaniciIslemleri = kullaniciIslemleri; // Kullanıcı işlemleri nesnesini başlatır.
        this.randevuIslemleri = new RandevuIslemleri(kullaniciIslemleri); // Randevu işlemleri nesnesini başlatır.
        this.raporIslemleri = new RaporIslemleri(); // Rapor işlemleri nesnesini başlatır.
        this.bildirimIslemleri = new BildirimIslemleri(); // Bildirim işlemleri nesnesini başlatır.
        this.ilacIslemleri = new IlacIslemleri(); // İlaç işlemleri nesnesini başlatır.
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Yönetici Menüsü:");
            System.out.println("1. Randevu Yönetimi");
            System.out.println("2. Kullanıcı Yönetimi");
            System.out.println("3. Raporlar ve Analiz");
            System.out.println("4. Bildirimler ve Uyarılar");
            System.out.println("5. İlaç Yönetimi");
            System.out.println("6. Çıkış");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.


            // Aşağıda yer alan metotların içerisinde yine birer menü vardır.
            // Çünkü eğer 1 seçildi ise yani randevu yönetimi burada ek seçenekler var .
            // Bu seçildiğinde randevu ekleme, silme, güncelleme gibi işlemler sorulacak ve birini seçecek.
            switch (secim) {
                case 1:
                    randevuYonetimi(); // Randevu yönetimi metodu çağrıldı.
                    break;
                case 2:
                    kullaniciYonetimi(); // Kullanıcı yönetimi metodu çağrıldı.
                    break;
                case 3:
                    raporYonetimi(); // Rapor yönetimi metodu çağrıldı.
                    break;
                case 4:
                    bildirimYonetimi(); // Bildirim yönetimi metodu çağrıldı.
                    break;
                case 5:
                    ilacYonetimi(); // İlaç yönetimi metodu çağrıldı.
                    break;
                case 6:
                    return; // Menüden çıkış
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Randevu yönetim menüsü
    private void randevuYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Randevu Yönetimi:");
            System.out.println("1. Yeni Randevu Oluşturma");
            System.out.println("2. Randevuları Listeleme");
            System.out.println("3. Randevu Detayları Görüntüleme");
            System.out.println("4. Randevu Güncelleme");
            System.out.println("5. Randevu Silme");
            System.out.println("6. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine();

            switch (secim) {
                case 1:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 2:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 3:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 4:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                case 5:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 6:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Kullanıcı yönetim menüsü
    private void kullaniciYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Kullanıcı Yönetimi:");
            System.out.println("1. Yeni Kullanıcı Ekleme");
            System.out.println("2. Kullanıcı Listeleme");
            System.out.println("3. Kullanıcı Bilgilerini Güncelleme");
            System.out.println("4. Kullanıcı Silme");
            System.out.println("5. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    System.out.println("Kullanici rolu secin : 1-Dotor, 2-Hasta, 3-Yonetici");
                    int rolSecim =scanner.nextInt();
                    System.out.println("Kullanici Adi : ");
                    String kullaniciAdi = scanner.nextLine();
                    System.out.println("Sifre : ");
                    String sifre =scanner.nextLine();
                    if (rolSecim==1){
                        System.out.println("Bransinizi girin");
                        String brans = scanner.nextLine();
                        kullaniciIslemleri.kullaniciEkle(new Doktor(0,kullaniciAdi,sifre,brans,kullaniciIslemleri));
                    }

                    break;
                case 2:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 3:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 4:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    break;
                case 5:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Rapor yönetim menüsü
    private void raporYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Raporlar ve Analiz:");
            System.out.println("1. Günlük Rapor Oluşturma");
            System.out.println("2. Aylık Rapor Oluşturma");
            System.out.println("3. Randevu Raporları Görüntüleme");
            System.out.println("4. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    // Günlük rapor oluşturma işlemlerini yapan metod...
                    break;
                case 2:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    // Aylık rapor oluşturma işlemlerini yapan metod...
                    break;
                case 3:
                    // Seçilen işlemle ilgili kodlar burada olacak.
                    // Randevu raporlarını görüntüleme işlemlerini yapan metod...
                    break;
                case 4:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Bildirim yönetim menüsü
    private void bildirimYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Bildirimler ve Uyarılar:");
            System.out.println("1. Yeni Bildirim Oluşturma");
            System.out.println("2. Bildirimleri Listeleme");
            System.out.println("3. Bildirim Detaylarını Görüntüleme");
            System.out.println("4. Bildirimleri Temizleme");
            System.out.println("5. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Yeni bildirim oluşturma işlemi
                    break;
                case 2:
                    // Bildirimleri listeleme işlemi
                    break;
                case 3:
                    // Bildirim detaylarını görüntüleme işlemi
                    break;
                case 4:
                    // Bildirimleri temizleme işlemi
                    break;
                case 5:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // İlaç yönetim menüsü
    private void ilacYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("İlaç Yönetimi:");
            System.out.println("1. Yeni İlaç Ekleme");
            System.out.println("2. İlaçları Listeleme");
            System.out.println("3. İlaç Güncelleme");
            System.out.println("4. İlaç Silme");
            System.out.println("5. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Yeni ilaç ekleme işlemi
                    break;
                case 2:
                    // İlaçları listeleme işlemi
                    break;
                case 3:
                    // İlaç güncelleme işlemi
                    break;
                case 4:
                    // İlaç silme işlemi
                    break;
                case 5:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}