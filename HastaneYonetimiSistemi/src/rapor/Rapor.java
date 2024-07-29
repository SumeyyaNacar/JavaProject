package rapor;

public class Rapor {
    private String raporTuru;
    private String icerik;

    public Rapor(String raporTuru, String icerik) {
        this.raporTuru = raporTuru;
        this.icerik = icerik;
    }

    // Getter ve Setter metotları
    public String getRaporTuru() { return raporTuru; }
    public void setRaporTuru(String raporTuru) { this.raporTuru = raporTuru; }
    public String getIcerik() { return icerik; }
    public void setIcerik(String icerik) { this.icerik = icerik; }
}
