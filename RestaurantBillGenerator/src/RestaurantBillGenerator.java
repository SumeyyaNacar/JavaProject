import java.util.Scanner;

public class RestaurantBillGenerator {
   /*
   Proje: Restaurant Fis Uretme Uygulamasi(BillGenerator)
          1- Bir restaurantin online sisteminde hesabi yazdiran uygulama tasarlayiniz

          2- Restauranttaki yiyecekler bir listte tutulsun.
          Yiyeceklerin kodu, ismi ve ucreti olsun.

          3- Yiyecek menusu, siparis olusturma/iptal ve hesap olusturma icin secim menusu
          gosterilsin

          4- Yiyecek menu: Listedeki yiyecekler menu seklinde listelensin
             Siparis girme: Yiyecegin kodu ve istenilen adet girilerek siparis olusturulsun
                            Her siparis icin secim menusu gosterilsin

             Siparis iptal: Siparis kodu girilerek siparis silinsin
             Hesap olusturma : Tutarlari ile birlikte siparisleri ve toplam tutari gosteren
                               bir hesap fisi yazdirilsin
    */
   public static void main(String[] args) {
       start();

   }

    private static void start() {
        DishService dishService = new DishService();//object olusturduk
        dishService.fillDishList();//yemekler eklenecek
        getSelectionMenu(dishService);


    }
    public static void getSelectionMenu(DishService dishService){//obje olusturarak cagirmak yerine data type olarak parametre girdik
        Scanner input = new Scanner(System.in);

        int select =-1;
        while (select!=0){
            System.out.println("========================================");
            System.out.println("*** Lezzet Restaurant Siparis Menusu ***");
            System.out.println("1- Menu");
            System.out.println("2- Siparis Girme");
            System.out.println("3- Siparisi Iptal Etme");
            System.out.println("4- Hesap Olusturma");
            System.out.println("0- Cikis");
            System.out.print("Seciminiz : ");
            select = input.nextInt();
            System.out.println("========================================");
            switch (select){
                case 1:
                    //menu gosterme
                    dishService.showDishMenu();
                    break;
                case 2:
                    //siparisGirme
                    break;
                case 3:
                    //siparisIptalEtme
                    break;
                case 4:
                    //hesapOlusturma
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz");
            }

        }
        System.out.println("Iyi gunler dileriz");


    }


}
