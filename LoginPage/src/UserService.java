import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    //bu class userla ilgili islemleri yapmak icin olusturuldu
    //kullanic bilgileri listlerde tutulacak

    List<String> usernames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();


    public void register() {//kullanici kaydi olusturacaz
        Scanner inp = new Scanner(System.in);
        System.out.print("Ad-Soyad giriniz : ");
        String name = inp.nextLine();

        String userName;
        boolean existsUserName;//username listede varsa true, yoksa false donecek
        do {
            System.out.print("Kullanici adi giriniz");
            userName = inp.nextLine();
            existsUserName = this.usernames.contains(userName);//this-> bize boolen bir deger dondurur
            //bu classtan uretmis oldugum objenin temsilcisi this. bununla usernames listesine git
            //kullanicidan gelen userName ile kiyasla. eger listede kullanicidan gelen bir userName
            //varsa true, yoksa false dondurecek.
            if (existsUserName) {//eger username listte varsa true donecek ve if calisacak
                System.out.println("Bu username kullanilmis, farkli bir username deneyiniz.");
            }
        } while (existsUserName);
        usernames.add(userName);//listeye ekle

        String email;
        boolean existsEmail;
        do {
            System.out.println("Email giriniz");
            email = inp.nextLine();
            existsEmail = this.emails.contains(email);
            if (existsEmail) {
                System.out.println("Bu email zaten kayitli, farkli bir email giriniz");
            }


        } while (existsEmail);
        emails.add(email);

    }

    public boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainsAt = email.contains("@");
        if (space) {
            System.out.println("Email bosluk iceremez");
            isValid = false;
        } else if (!isContainsAt) {
            System.out.println("Email @ sembolu icermelidir.");
            isValid = false;
        } else {//2 alan kontrolu var. 1-username kismi, 2-mail uzantisi kismi
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[A-Za-z0-9]", "").length();
            boolean checkStart = notValid == 0;

            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");
            if (!checkStart) {
                System.out.println("email kullanici adi buyuk harf, kucuk harf, rakam, -,.,_ sisinda karakter iceremez");
            } else if (!checkEnd) {
                System.out.println("email gmail.com, hotmail.com yaha yahoo.com ile bitmelidir!");
            }
            isValid = checkEnd && checkStart;
        }
        if (!isValid) {
            System.out.println("Gecersiz email, tekrar deneyiniz!");
        }
        return isValid;
    }

    public boolean validatePassword(String password) {
        boolean isValid;
        String upperLetter = password.replaceAll("[^A-Z]", "");
        String lowerLetter = password.replaceAll("[^a-z]", "");
        String digits = password.replaceAll("[\\D]", "");
        String symbol = password.replaceAll("[\\p{Punct}]", "");

        boolean space = password.contains(" ");
        boolean lengthGT6 = password.length() >= 6;
        boolean existsUpper = upperLetter.length() > 0;
        boolean existsLower = lowerLetter.length() > 0;
        boolean existsDigit = digits.length() > 0;
        boolean existsSymbol = symbol.length() > 0;

        isValid = !space && lengthGT6 && existsUpper && existsLower && existsDigit && existsSymbol;
        if (space){
            System.out.println("Sifre bosluk iceremez");
        } else if (!lengthGT6) {
            System.out.println("Sifre en az 6 karakter icermelidir.");
        }else if (!existsUpper){
            System.out.println("Sifre en az bir tane buyuk harf icermelidir.");
        }else if (!existsLower){
            System.out.println("Sifre en az bir tane kucuk harf icermelidir.");
        } else if (!existsDigit) {
            System.out.println("Sifre en az bir tane rakam icermelidir");
        }else if (!existsSymbol{
            System.out.println("Sifre en az bir tane sembol icermelidir");
        }
        if (!isValid){
            System.out.println("Gecersiz password, tekrar deneyiniz!");
        }


        return isValid;

    }

}
