package hasta_bilgileri;

import java.util.ArrayList;
import java.util.List;

public class HastaGecmisi {
    private int hastaId;
    private List<String> randevuGecmisi;
    private List<String> ilacGecmisi;
    private List<String> oykuler;

    public HastaGecmisi(int hastaId) {
        this.hastaId = hastaId;
        this.randevuGecmisi = new ArrayList<>();
        this.ilacGecmisi = new ArrayList<>();
        this.oykuler = new ArrayList<>();
    }

    public int getHastaId() {
        return hastaId;
    }

    public List<String> getRandevuGecmisi() {
        return randevuGecmisi;
    }

    public void addRandevu(String randevu) {
        randevuGecmisi.add(randevu);
    }

    public List<String> getIlacGecmisi() {
        return ilacGecmisi;
    }

    public void addIlac(String ilac) {
        ilacGecmisi.add(ilac);
    }

    public List<String> getOykuler() {
        return oykuler;
    }

    public void addOykuler(String oykuler) {
        this.oykuler.add(oykuler);
    }
}
