import java.util.Scanner;

public class LoginPageApp {

/*
Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, kullanici adi, email ve şifre bilgileri alınız.
                             kullanici adi, email ve şifre birer listede tutulur.
                             aynı kullanici adi veya email kabul edilmez.

         giriş(login): kullanici adi/email ve şifre girilir.
                       kullanici adi/ email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       kullanici adi/email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
*/
    public static void main(String[] args) {
        start();

    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TECHPROEDUCATION ===");
        int select;
        do {
            showMenu();
            select = scanner.nextInt();
            switch (select){
                case 1:
                    //uye olma
                    break;
                case 2:
                    //giris yapma
                    break;
                case 0:
                    System.out.println("Iyi gunşer dileriz...");

                default:
                    System.out.println("Hatali giris yaptiniz, tekrar deneyiniz...");
            }
        }while (select != 0);


    }

    private static void showMenu() {
        System.out.println("1- Uye ol");
        System.out.println("2- Giris Yap");
        System.out.println("0- Cisik");
        System.out.println("Seciminiz : ");
    }

}
