import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VeriTabani veriTabani = new VeriTabani();
        Connection con = veriTabani.baglantiyiAc();

        if (con!=null){
            KullaniciIslemleri kullaniciIslemleri = new KullaniciIslemleri(con);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Lutfen kullanici adi giriniz");
            String kullaniciAdi = scanner.nextLine();
            System.out.println("Lutfen sifre giriniz");
            String sifre = scanner.nextLine();

            Kullanici kullanici = kullaniciIslemleri.girisYap(kullaniciAdi,sifre);
            if (kullanici!=null){
                kullanici.menu();
            }else {
                System.out.println("Gecersiz kullanici adi ve sifre");

            }
        }else {
            System.out.println("Con null dondu veri tabani baglanilamadi");
        }
        veriTabani.baglantiyiKapat();


    }
}
