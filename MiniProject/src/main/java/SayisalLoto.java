import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    /*
    Proje : Sayisal Loto Uygulamasi
    Bilet icin rastgele n tane sayi uretilsin.
    Loto sonucu rastgele n tane sayi ile uretilsin.
    sayisal lotoda tekrarli sayilar olmamali.

    n(hane sayisi), sayilar icin min ve max degerler kullnicidan alinsin

    sonuc ve bilet karsilastirilsin, kac eslesme oldugu kullaniciya bildirilsin

     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayisal loto icin hane sayisi giriniz");
        int slots = input.nextInt();
        System.out.println("Sayilar icin min deger giriniz");
        int min = input.nextInt();
        System.out.println("Sayilar icin max deger giriniz");
        int max = input.nextInt();

        int[] lotArr = new int[slots];
        int[] ticketArr = new int[slots];

        int randomNumber1 = 0;
        int randomNumber2 = 0;
        Random random = new Random();
        boolean isRepeated = false;

        for (int i = 0; i < slots; i++) {
            do {
                isRepeated = false;

                //randomNumber1 = random.nextInt(10+1-5)+5;--> 0,1,2,3,4,5--->5,6,7,8,9,10
                //icine arguman olarak aldigi sayinin 0 ile girilen deger arasinda rastgele sayi uretir.
                // ust sinir olan deger dahil degil
                //aralil 0 'dan baslamasin diye min. degeri  ekleyerek biz alt limit belirliyoruz ancak
                //eklenen min deger araliktaki butun elemanlara eklendigi icinde parantez icinden min
                //degeri dusuyoruz. ust siniri max'a getirelim

                randomNumber1 = random.nextInt(max + 1 - min) + min;
                for (int j = 0; j < slots; j++) {
                    if (lotArr[j] == randomNumber1) {
                        isRepeated=true;//ayni sayi var diziye eklemesin ve donguyu kirip basa donsun ve yeni sayi uretsin
                        break;
                    }
                }

            }while (isRepeated);
            lotArr[i] = randomNumber1;


        }


    }

}
