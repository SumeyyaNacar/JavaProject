public class SifreAyarlar {

   private int uzunluk;
   private boolean buyukHarf;
   private boolean kucukHarf;
   private boolean rakam;
   private boolean ozelKarakter;

    public SifreAyarlar(int uzunluk, boolean buyukHarf, boolean kucukHarf, boolean rakam, boolean ozelKarakter) {
        this.uzunluk = uzunluk;
        this.buyukHarf = buyukHarf;
        this.kucukHarf = kucukHarf;
        this.rakam = rakam;
        this.ozelKarakter = ozelKarakter;

    }

    public int getUzunluk() {
        return uzunluk;
    }

    public boolean isBuyukHarf() {
        return buyukHarf;
    }

    public boolean isKucukHarf() {
        return kucukHarf;
    }

    public boolean isRakam() {
        return rakam;
    }

    public boolean isOzelKarakter() {
        return ozelKarakter;
    }
}
