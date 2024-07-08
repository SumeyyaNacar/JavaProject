import java.util.Random;

public enum Secim {
    TAS, KAGIT, MAKAS;

    public static Secim rastgeleSecim() {
        return values()[(int)(Math.random()*values().length)];//Bu satir secim enum'in tüm degerini bir dizi olarak dondurur ve
                                                              // Math.random() methodu ile bir deger dondurur.
    }

    public static Secim secimDeger(String secim){
        switch (secim.toUpperCase()){
            case "TAS":
                return TAS;
            case "KAGIT":
                return KAGIT;
            case "MAKAS":
                return MAKAS;
            default:
                return null;
        }
    }
}
