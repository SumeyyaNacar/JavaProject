package randevu;

public class Randevu {
    private int id;
    private int hastaId;
    private int doktorId;
    private String brans;
    private String tarih;
    private String saat;
    private String randevuyuAlanAdi;
    private String randevuyuAlanSoyadi;

    public Randevu(int id, int hastaId, int doktorId, String brans, String tarih, String saat, String randevuyuAlanAdi, String randevuyuAlanSoyadi) {
        this.id = id;
        this.hastaId = hastaId;
        this.doktorId = doktorId;
        this.brans = brans;
        this.tarih = tarih;
        this.saat = saat;
        this.randevuyuAlanAdi = randevuyuAlanAdi;
        this.randevuyuAlanSoyadi = randevuyuAlanSoyadi;
    }

    public int getId() {
        return id;
    }

    public int getHastaId() {
        return hastaId;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public String getBrans() {
        return brans;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getRandevuyuAlanAdi() {
        return randevuyuAlanAdi;
    }

    public String getRandevuyuAlanSoyadi() {
        return randevuyuAlanSoyadi;
    }
}
