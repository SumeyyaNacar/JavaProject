public class Oyuncu {
    private String isim;
    private int skor;

    public Oyuncu(String isim) {
        this.isim = isim;
        this.skor = 0;
    }

    public String getIsim() {
        return isim;
    }

    public int getSkor() {
        return skor;
    }
    public void skorArttir(){
        skor++;
    }
    public Secim secimYap(String secim){
       return Secim.secimDeger(secim);
    }
}
