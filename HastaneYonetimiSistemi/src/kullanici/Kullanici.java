package kullanici;

// Kullanici sınıfı, tüm kullanıcıların temel özelliklerini ve
// davranışlarını tanımlar.
// Bu sınıf, soyut (abstract) bir sınıftır ve doğrudan nesne olarak kullanılamaz.
// Soyut sınıflar, alt sınıflar tarafından genişletilir ve ortak özellikleri barındırır.

public abstract class Kullanici {
    private int id; // Kullanıcının benzersiz kimlik numarası
    private String kullaniciAdi; // Kullanıcının adı
    private String sifre; // Kullanıcının şifresi
    private String rol; // Kullanıcının rolü (Doktor, Hasta, Yönetici)

    // Özel (private) değişkenler, sadece bu sınıf içerisinde erişilebilir.
    // Bu değişkenlere dışarıdan erişimi kısıtlamak için encapsulation
    // (kapsülleme) kullanılır.
    // Kapsülleme, veri güvenliğini ve veri bütünlüğünü sağlar.

    // Erişim belirleyiciler:
    // private: Yalnızca tanımlandığı sınıf içinde erişilebilir.
    // public: Her yerden erişilebilir.
    // protected: Aynı paket içinden veya alt sınıflardan erişilebilir.
    // default (hiçbir erişim belirleyici yazılmamışsa): Aynı paket içinden
    // erişilebilir.



    // Constructor (Kurucu) Metod:
    // Bir sınıftan yeni bir nesne oluşturulduğunda ilk çalışan metottur.
    // Kurucu metodlar, sınıfın değişkenlerini başlatmak için kullanılır.
    // Bu kurucu metod, kullanıcının kimlik numarası, adı, şifresi ve rolü gibi
    // temel bilgileri alır.
    public Kullanici(int id, String kullaniciAdi, String sifre, String rol) {
        this.id = id; // this.id, sınıfın id değişkenine erişimi sağlar ve onu
        // verilen id değeriyle başlatır.
        this.kullaniciAdi = kullaniciAdi; // this.kullaniciAdi, sınıfın
        // kullaniciAdi değişkenine erişimi sağlar
        // ve onu verilen kullaniciAdi değeriyle başlatır.
        this.sifre = sifre; // this.sifre, sınıfın sifre değişkenine
        // erişimi sağlar ve onu verilen sifre değeriyle başlatır.
        this.rol = rol; // this.rol, sınıfın rol değişkenine erişimi sağlar ve onu verilen rol değeriyle başlatır.
    }

    // Getter ve Setter Metodları:
    // Özel değişkenlere dışarıdan erişim sağlamak ve bu
    // değişkenlerin değerlerini değiştirmek için kullanılır.
    // Getter metotları, değişkenlerin değerlerini döndürür.
    // Setter metotları, değişkenlerin değerlerini ayarlar.
    public int getId() {
        return id; // Kullanıcının kimlik numarasını döndürür.
    }

    public void setId(int id) {
        this.id = id; // Kullanıcının kimlik numarasını belirler.
    }

    public String getKullaniciAdi() {
        return kullaniciAdi; // Kullanıcının adını döndürür.
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi; // Kullanıcının adını belirler.
    }

    public String getSifre() {
        return sifre; // Kullanıcının şifresini döndürür.
    }

    public void setSifre(String sifre) {
        this.sifre = sifre; // Kullanıcının şifresini belirler.
    }

    public String getRol() {
        return rol; // Kullanıcının rolünü döndürür.
    }

    public void setRol(String rol) {
        this.rol = rol; // Kullanıcının rolünü belirler.
    }

    // Soyut Metod (abstract method):
    // Soyut metodlar, alt sınıflar
    // tarafından mutlaka uygulanmalıdır.
    // Her kullanıcı türü (Doktor, Hasta, Yönetici)
    // kendi menü işlevini tanımlayacaktır.
    public abstract void menu();
}