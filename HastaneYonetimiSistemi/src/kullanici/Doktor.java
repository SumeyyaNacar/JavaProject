package kullanici;


import randevu.RandevuIslemleri; // Randevu işlemlerini gerçekleştirmek için gerekli sınıf içe aktarıldı
// Bu Pakette şu Class'lar var: Randevu, RandevuIslemleri
import rapor.RaporIslemleri; // Rapor işlemlerini gerçekleştirmek için gerekli sınıf
// Bu Pakette şu Class'lar var: Rapor, RaporIslemleri
import bildirim.BildirimIslemleri; // Bildirim işlemlerini gerçekleştirmek için gerekli sınıf
// Bu Pakette şu Class'lar var: Bildirim, BildirimIslemleri
import Ilac.IlacIslemleri; // İlaç işlemlerini gerçekleştirmek için gerekli sınıf
// Bu Pakette şu Class'lar var: Ilac, IlacIslemleri

import java.util.Scanner; // Kullanıcıdan veri almak için kullanılan sınıf

// Doktor sınıfı, Kullanici sınıfından türetilir ve doktorlara özgü özellikler ve işlevler tanımlanır.
// Kullanici sınıfının özelliklerini ve metodlarını miras alır (inheritance kavramı bunu ifade eder).

public class Doktor extends Kullanici {
    // Özel (private) değişkenler, sadece bu sınıf içerisinde erişilebilir.
    // Doktorun branşı, randevu, rapor, bildirim ve ilaç işlemlerini yapar.
    // Bu işlemler farklı paketlerde yapılıyor örnek olarak rapor yazma işlemi rapor paketinde yer alan raporIslemleri clasında yapılıyor
    // Bu classtan orada yapılan işlemleri çağırmak için o işlemler için birer nesne oluşturmamız gereklidir.

    private String brans; // Doktorun branşı
    private RandevuIslemleri randevuIslemleri; // Randevu işlemleri için nesne
    private RaporIslemleri raporIslemleri; // Rapor işlemleri için nesne
    private BildirimIslemleri bildirimIslemleri; // Bildirim işlemleri için nesne
    private IlacIslemleri ilacIslemleri; // İlaç işlemleri için nesne

    // Doktor sınıfının kurucusu
    // Kurucu metod, doktorun kimlik numarası, adı, şifresi, branşı ve kullanıcı işlemleri nesnesini alır.
    // Bu bilgiler, doktor nesnesi oluşturulduğunda başlatılır.* Bu clastan her hangi bir şey oluşturulduğunda,
    // Bu clastan herhangi bir işlem tetiklendiğine kurucu metot var ise her zaman ilk çalışan yer olduğu için kurucu metot çalışacak ve değişkenler başlatılacak.
    public Doktor(int id, String kullaniciAdi, String sifre, String brans, KullaniciIslemleri kullaniciIslemleri) {
        super(id, kullaniciAdi, sifre, "Doktor"); // Üst sınıfın (Kullanici) kurucu metodunu çağırır.
        this.brans = brans; // Doktorun branşını başlatır.
       this.randevuIslemleri = new RandevuIslemleri(kullaniciIslemleri); // Randevu işlemleri nesnesini başlatır.
        this.raporIslemleri = new RaporIslemleri(); // Rapor işlemleri nesnesini başlatır.
        this.bildirimIslemleri = new BildirimIslemleri(); // Bildirim işlemleri nesnesini başlatır.
        this.ilacIslemleri = new IlacIslemleri(); // İlaç işlemleri nesnesini başlatır.

        // Artık bu nesneler aracılığı ile oralara ulaşabilirim. Bu nesneler en üstte private olarak oluşturulmuştu, bu metot aracılığı ile (this) atama yapıldı.
        // Metot public olduğu için burdan giren veri, extend edilen classlarda da (super çağrısı) erişilebilir veya kullanılabilir.
    }

    // @Override ifadesi, bir metodun üst sınıftan (Kullanici) miras alındığını ve
    // bu metodun alt sınıfta (Doktor) yeniden tanımlandığını belirtir.
    // ve bu, polymorphism kavramının bir örneğidir.
    // Üst sınıftaki soyut metod (abstract method) alt sınıfta somut  hale getirilir.
    // Üst sınıfta yer alan bu metot extend edilen claslarda da kullanımak zorundaydı.
    // Üst sınıfta içi boşken burada doldu ve somut hala geldi.
    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturduk.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam edecek.

            // Doktor girdiğinde bu menüyü görür, bu menüde seçtiği seçenek ile iç menü gelir örnek olarak
            // Randevu yönetimini seçerse bir menü daha gelecek, o menü de randevu ekle,sil güncelleme olacak...
            System.out.println("Doktor Menüsü:");
            System.out.println("1. Randevu Yönetimi");
            System.out.println("2. Raporlar ve Analiz");
            System.out.println("3. Bildirimler ve Uyarılar");
            System.out.println("4. İlaç Yazma");
            System.out.println("5. Hasta Bilgileri Görüntüleme");
            System.out.println("6. Çıkış");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Temizlemek için kullanılır.
            // Satır atlama vb. hatalar için scanner gördüğüm her yere yapıştırıyorum :)
            // Çünkü sonrasında dönüp bu hatanın geldiği yeri bulmak zor oluyor, güzel bir alışkanlık bence.

            // "switch" ifadesi, kullanıcı seçimlerine göre farklı işlemler gerçekleştirmek için kullanılır.
            // Seçim, case anahtar kelimeleri ile eşleşen bir değere göre belirlenir.
            switch (secim) {
                case 1:
                    randevuYonetimi(); // Randevu yönetimi metodu çağırılacak bu metodun içinde ise iç bir menü var.
                    break;
                case 2:
                    raporYonetimi(); // Rapor yönetimi çağırılacak bu metodun içinde ise iç bir menü var.
                    break;
                case 3:
                    bildirimYonetimi(); // Bildirim yönetimi çağırılacak bu metodun içinde ise iç bir menü var.
                    break;
                case 4:
                    ilacYonetimi(); // İlaç yönetimi çağırılacak bu metodun içinde ise iç bir menü var.
                    break;
                case 5:
                    hastaBilgileriGoruntuleme(); // Hasta bilgileri görüntüleme çağırılacak bu metodun içinde ise iç bir menü var.
                    break;
                case 6:
                    return; // Menüden çıkış
                // return; ifadesi o an içinde bulunduğu metodun veya fonksiyonun çalışmasını sonlandırır
                // ve çağrıldığı noktadan geri döner.
                // BU METOD BİR MENÜDEN ÇAĞRILDIĞI İÇİN TEKRAR MENÜ DÖNER....


                default:
                    System.out.println("Geçersiz seçim!");
            }


            // Bunu kısa da yazabiliriz böyle bir kullanımı da var.
//            switch (secim) {
//                case 1 -> randevuYonetimi(); // Randevu yönetimi
//                case 2 -> raporYonetimi(); // Rapor yönetimi
//                case 3 -> bildirimYonetimi(); // Bildirim yönetimi
//                case 4 -> ilacYonetimi(); // İlaç yönetimi
//                case 5 -> hastaBilgileriGoruntuleme(); // Hasta bilgileri görüntüleme
//                case 6 -> {} // Menüden çıkış (boş işlem)
//                default -> System.out.println("Geçersiz seçim!");
//            }
        }
    }

    // Randevu yönetim menüsü
    private void randevuYonetimi() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Randevu Yönetimi:");
            System.out.println("1. Randevuları Listeleme");
            System.out.println("2. Randevu Detayları Görüntüleme");
            System.out.println("3. Randevu Güncelleme");
            System.out.println("4. Randevu Silme");
            System.out.println("5. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Randevuları listeleme işlemi burada yapılacak
                    break;
                case 2:
                    // Randevu detaylarını görüntüleme işlemi burada yapılacak
                    break;
                case 3:
                    // Randevu güncelleme işlemi burada yapılacak
                    break;
                case 4:
                    // Randevu silme işlemi burada yapılacak
                    break;
                case 5:
                    return; // Menüden geri dön, yukarıda notu var, eğer burada kafamız karışıyor ise lütfen oraya tekrar bakın.
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
            System.out.println("2. Randevu Raporları Görüntüleme");
            System.out.println("3. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Günlük rapor oluşturma işlemi burada çağırılacak
                    // bu işlem rapor paketinde yer alan rapor işlemlerinde bir metot tarafından yapılıyor.
                    // biz o metodu burada çağıracağız ve böylelikle rapor oluşturma işlemi 1 seçildiğinde başlatıacak.
                    // o metot içerisinde yine bazı kodlar var mesela rapor içeriği soruluyor, rapor başlığı soruluyor
                    // bu metot buradan çağrıldığında o metot çalışır ve kullanıcıya gerekli bilgileri sorar ve işlemi yapar.
                    // burada tek tek soramazdık bu işlemleri kodumuz bu şekilde oldukça okunaklı oluyor.
                    break;
                case 2:
                    // Randevu raporlarını görüntüleme işlemi, yukarıda yazılan mantıkla aynıdır.
                    break;
                case 3:
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
                    // Yeni bildirim oluşturma işlemi 163.satırda açıklandığı mantıkla metot olarak çağrılacak.
                    //  O metot içerisinde bildirimin kime gideceği, bildirim metni vs soruluyor.
                    //  Ve sonra bizim çağırdığımız metot o bilgileri aldıktan sonra
                    //  Aynı classta olan (BildirimIslemleri clası) bildirim gönderme işlemini yapan ilgili metodu çağıracak :) Yani metor içinde metot var...
                    break;
                case 2:
                    // Bildirimleri listeleme işlemi metodu çağırılacak.
                    break;
                case 3:
                    // Bildirim detaylarını görüntüleme işlemi metodu çağırılacak.
                    break;
                case 4:
                    // Bildirimleri temizleme işlemi  metodu çağırılacak.
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
            System.out.println("İlaç Yazma:");
            System.out.println("1. İlaç Yazma");
            System.out.println("2. İlaç Listeleme");
            System.out.println("3. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // İlaç yazma işlemini yapan metot çağırılacak bu metot burada değildir.
                    // Diğerlerinde olduğu mantıkta ilac paketinde, ilac islemleri clasında yer alıyor.
                    // Biz yukarıda oluşturduğumuz nesne ile onu çağıracağız.
                    break;
                case 2:
                    // İlaçları listeleme işlemi metodu.
                    break;
                case 3:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Hasta bilgileri görüntüleme menüsü
    private void hastaBilgileriGoruntuleme() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Hasta Bilgileri Görüntüleme:");
            System.out.println("1. Hasta Bilgilerini Görüntüleme");
            System.out.println("2. Hasta Geçmişini Görüntüleme");
            System.out.println("3. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:
                    // Hasta bilgilerini görüntüleme metodu çağırılacak... Diğer paketten :)
                    break;
                case 2:
                    // Hasta geçmişini görüntüle metodu çağırılacak
                    break;
                case 3:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    public String getBrans() {
        return brans; // Doktorun branşını döndürür.
        //Branş burada tanımlanmıştı ve private idi, bu public metot sayesinde(getter ile) diğer claslar artık buradan branşı görebilir ve işlem yapabilir buna göre...
    }

    public void setBrans(String brans) {
        this.brans = brans; // Doktorun branşını belirler. Yönetici branş değişikliği yapabiliyor bu nedenle yönetici buradan set eder.
    }
}