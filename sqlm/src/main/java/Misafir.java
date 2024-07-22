public class Misafir extends Kullanici{

    public Misafir(int id, String name, String userName, String password) {
        super(id, name, userName, password, "Misafir");
    }

    @Override
    public void menu() {
        System.out.println("Hosgeldiniz Misafir");
        System.out.println("1-Urun Satin Al");
        System.out.println("2-Urun Iade Et");


    }
}
