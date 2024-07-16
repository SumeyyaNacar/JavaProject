package kullanici;

import randevu.RandevuIslemleri; // Randevu işlemlerini gerçekleştirmek için gerekli sınıf

import java.util.Scanner; // Kullanıcıdan veri almak için kullanılan sınıf

// Hasta sınıfı, Kullanici sınıfından türetilir ve hastaların sahip olduğu özellikler ve işlevler tanımlanır.
public class Hasta extends Kullanici {
    private int yas; // Hastanın yaşı
    private RandevuIslemleri randevuIslemleri; // Randevu işlemleri için nesne

    // Hasta sınıfının kurucusu
    // Kurucu metod, hastanın kimlik numarası, adı, şifresi, yaşı ve kullanıcı işlemleri nesnesini alır.
    // Bu bilgiler, hasta nesnesi oluşturulduğunda başlatılır.
    public Hasta(int id, String kullaniciAdi, String sifre, int yas, KullaniciIslemleri kullaniciIslemleri) {
        super(id, kullaniciAdi, sifre, "Hasta"); // Üst sınıfın (Kullanici) kurucu metodunu çağırır.
        this.yas = yas; // Hastanın yaşını başlatır.
        //this.randevuIslemleri = new RandevuIslemleri(kullaniciIslemleri); // Randevu işlemleri nesnesini başlatır.
    }

    public int getYas() {
        return yas; // Hastanın yaşını döndürür.
    }

    @Override

    // @Override ifadesi, bir metodun üst sınıftan (Kullanici) miras alındığını ve
    // bu metodun alt sınıfta (Doktor) yeniden tanımlandığını belirtir.
    // ve bu, polymorphism kavramının bir örneğidir.
    // Üst sınıftaki soyut metod (abstract method) alt sınıfta somut  hale getirilir.
    // Üst sınıfta yer alan bu metot extend edilen claslarda da kullanımak zorundaydı.
    // Üst sınıfta içi boşken burada doldu ve somut hala geldi.

    public void menu() {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri almak için Scanner nesnesi oluşturur.
        while (true) { // Sonsuz döngü, kullanıcı menüden çıkana kadar devam eder.
            System.out.println("Hasta Menüsü:");
            System.out.println("1. Yeni Randevu Oluşturma");
            System.out.println("2. Randevuları Listeleme");
            System.out.println("3. Randevu İptali");
            System.out.println("4. Geri Dön");

            int secim = scanner.nextInt(); // Kullanıcının seçimini alır.
            scanner.nextLine(); // Tamponu temizlemek için kullanılır.

            switch (secim) {
                case 1:

                    // Yeni randevu oluşturma metodu çağırlacak.
                    // Farklı bir pakette yer alan bir classta bu metot.
                    // (randevu paketinde, randevuIslemleri classında bunu yapan bir metot var)
                    // Yukarıda Oluşturduğumuz nesne ile çağıracağız.
                    break;
                case 2:
                    // Randevuları listeleme işlemini yapan metodu çağıracak.
                    break;
                case 3:
                    System.out.print("Randevu ID: ");
                    int randevuId = scanner.nextInt(); // Kullanıcının iptal etmek istediği randevunun ID'sini alır.
                    // Randevu iptal işlemi metodu çağırılacak, o metot bir parametre almalı. Buradan alınan ID o metoda verilecek
                    // Ve o metot bu id'yi arayıp bulup silecek.
                    break;
                case 4:
                    return; // Menüden geri dön
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}