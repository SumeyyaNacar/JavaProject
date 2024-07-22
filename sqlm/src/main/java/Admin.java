public class Admin extends Kullanici {

    public Admin(int id, String name, String userName, String password) {
        super(id, name, userName, password, "Admin");
    }

    @Override
    public void menu() {
        System.out.println("Hosgeldiniz Admin");
        System.out.println("1-Kullanici Ekle");
        System.out.println("2-Kullanici Sil");

    }
}
