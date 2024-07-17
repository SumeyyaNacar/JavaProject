import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    //bu class userla ilgili islemleri yapmak icin olusturuldu
    //kullanic bilgileri listlerde tutulacak

    List<String> usernames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();


    public void register(){//kullanici kaydi olusturacaz
        Scanner inp = new Scanner(System.in);
        System.out.print("Ad-Soyad giriniz : ");
        String name = inp.nextLine();

        String userName;
        boolean existsUserName;
        do {
            System.out.print("Kullanici adi giriniz");
            userName = inp.nextLine();
            existsUserName=this.usernames.contains(userName);//this-> bize boolen bir deger dondurur
            //bu classtan uretmis oldugum objenin temsilcisi this. bununla usernames listesine git
            //kullanicidan gelen userName ile kiyasla. eger listede kullanicidan gelen bir userName
            //varsa true, yoksa false dondurecek.
            if (existsUserName){//eger username listte varsa true donecek ve if calisacak
                System.out.println("Bu username kullanilmis, farkli bir username deneyiniz.");
            }
        }while (existsUserName);





    }

}
