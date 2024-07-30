package hasta_bilgileri;

public class HastaBilgileri {
    private int hastaId;
    private String hastaAdi;
    private int yas;

    public HastaBilgileri(int hastaId, String hastaAdi, int yas) {
        this.hastaId = hastaId;
        this.hastaAdi = hastaAdi;
        this.yas = yas;
    }

    public int getHastaId() {
        return hastaId;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public int getYas() {
        return yas;
    }
}
