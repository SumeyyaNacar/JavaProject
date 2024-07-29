package bildirim;

public class Bildirim {
    private int bildirimId;
    private int kullaniciId;
    private String mesaj;

    public Bildirim(int bildirimId, int kullaniciId, String mesaj) {
        this.bildirimId = bildirimId;
        this.kullaniciId = kullaniciId;
        this.mesaj = mesaj;
    }

    // Getter ve Setter metotları
    public int getBildirimId() { return bildirimId; }
    public void setBildirimId(int bildirimId) { this.bildirimId = bildirimId; }
    public int getKullaniciId() { return kullaniciId; }
    public void setKullaniciId(int kullaniciId) { this.kullaniciId = kullaniciId; }
    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
}
