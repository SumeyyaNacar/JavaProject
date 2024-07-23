package ilac;

public class Ilac {
    private int id;
    private String isim;
    private String tur;
    private String kullanimTalimatlari;
    private int stok;

    public Ilac(int id, String isim, String tur, String kullanimTalimatlari, int stok) {
        this.id = id;
        this.isim = isim;
        this.tur = tur;
        this.kullanimTalimatlari = kullanimTalimatlari;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getTur() {
        return tur;
    }

    public String getKullanimTalimatlari() {
        return kullanimTalimatlari;
    }

    public int getStok() {
        return stok;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public void setKullanimTalimatlari(String kullanimTalimatlari) {
        this.kullanimTalimatlari = kullanimTalimatlari;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
