import java.security.SecureRandom;

public class SifreOlusturucu {

    private static final String BUYUKHARFLER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String KUCUK_HARFLER = "abcdefghijklmnopqrstuvwxyz";
    private static final String RAKAMLAR = "0123456789";
    private static final String OZEL_KARAKTERLER = "!@#$%^&*()-=+<>?";

    private SecureRandom secureRandom = new SecureRandom();

    public String sifreOlustur(SifreAyarlar ayarlar){
        StringBuilder karakterHavuzu = new StringBuilder();
        if (ayarlar.isBuyukHarf()){
            karakterHavuzu.append(BUYUKHARFLER);
        }
        if (ayarlar.isKucukHarf()){
            karakterHavuzu.append(KUCUK_HARFLER);
        }
        if (ayarlar.isOzelKarakter()){
            karakterHavuzu.append(OZEL_KARAKTERLER);
        }
        if (ayarlar.isRakam()){
            karakterHavuzu.append(RAKAMLAR);
        }

        if (karakterHavuzu.length()==0){
            throw new IllegalArgumentException("En az bir karakter turu secilmelidir. ");
        }
        StringBuilder sifre= new StringBuilder(ayarlar.getUzunluk());

        for (int i = 0; i < ayarlar.getUzunluk(); i++) {
            int index = secureRandom.nextInt(karakterHavuzu.length());

            sifre.append(karakterHavuzu.charAt(index));
        }
        return sifre.toString();
    }

    


}
