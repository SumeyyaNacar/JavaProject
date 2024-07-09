public enum Renk {

    PEMBE, KIRMIZI, MAVI, SARI, BEYAZ;

    public static Renk rastgeleSecim(){
        return values()[(int) (Math.random()*values().length)];
    }


}
