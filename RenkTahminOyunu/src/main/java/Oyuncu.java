public class Oyuncu {
    private String isim;
    private int dogruSayisi;

    public Oyuncu(String isim) {
        this.isim = isim;
        this.dogruSayisi = 0;
    }

    public String getIsim() {
        return isim;
    }

    public int getDogruSayisi() {
        return dogruSayisi;
    }

    public void dogruSayisiArttir() {
        dogruSayisi++;
    }

    public void dogruSayisiSifirla() {
        dogruSayisi = 0;
    }

}
