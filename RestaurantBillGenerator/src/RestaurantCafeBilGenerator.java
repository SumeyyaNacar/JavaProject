import java.util.Scanner;

public class RestaurantCafeBilGenerator {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        OrderService orderService= new OrderService();
        DishService dishService = new DishService();//object olusturduk
        dishService.fillDishList();//yemekler eklenecek
        getSelectionMenu(dishService,orderService);
    }
    public static void getSelectionMenu(DishService dishService, OrderService orderService){//obje olusturarak cagirmak yerine data type olarak parametre girdik
        Scanner input = new Scanner(System.in);

        int select =-1;
        while (select!=0){
            System.out.println("========================================");
            System.out.println("*** Lezzet Restaurant/Cafe Siparis Menusu ***");
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
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    //siparisIptalEtme
                    orderService.deleteOrder();
                    break;
                case 4:
                    //hesapOlusturma
                    orderService.printBill();
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
