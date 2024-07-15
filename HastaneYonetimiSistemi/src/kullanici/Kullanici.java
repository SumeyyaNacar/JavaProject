package kullanici;

public abstract class Kullanici {

    private int id;//kullanicinin benzersiz kimlik TC
    private String kullaniciAdi;//kullanicinin adi
    private String sifre;
    private String rol; //kullanicinin rolu(doktor, hasta, yonetici)

    //private degiskenler-- sadece bu class icerisinden erisilebilir
    //encapsulation-- veri guvenligini ve veri butunlugunu saglar.
    //public: her yerden erisilebilir
    //protected: ayni paket icerisinden veya alt siniflardan erisilebilir
    //default : Ayni paket icerisinden erisilebilir


    public Kullanici(int id, String kullaniciAdi, String sifre, String rol) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

}
