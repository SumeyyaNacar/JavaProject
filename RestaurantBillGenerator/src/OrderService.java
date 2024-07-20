import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    List<Order> orderList = new ArrayList<>();
    Scanner inp = new Scanner(System.in);

    public void createOrder(DishService dishService) {//methodun icerisinde obje olsuturursak method her cagrldiginda farkli bir dishService olustururdu

        int dishCode = -1;
        while (dishCode != 0) {
            System.out.println("Lutfen urun kodunu giriniz : (Cikis: O)");//urun kodu
            dishCode = inp.nextInt();//girilen kod ile urunu bulmamiz gerekiyor
            Dish dish = dishService.findDishCode(dishCode);//girilen kod ile yemegi buldu
            if (dishCode > 0) {
                System.out.print("Adet giriniz : ");//adet
                int num = inp.nextInt();
                Order order = new Order(dish, num);
                order.setPrice();//fiyati hesapladik
                order.setOrderCode(1000 + this.orderList.size());//siparis kodu olusturuldu ve her siparis sonrasi 1 tane artiracak
                this.orderList.add(order);//listeye siparisi ekledik

            }
            for (Order order : this.orderList) {
                System.out.printf("Siparis kodu:%-5s  lezzet kodu:%-4s adi:%-20s adet:%-3s\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish);
            }
        }
    }

    public void deleteOrder() {
        boolean isValid = true;
        if (orderList.isEmpty()) {
            System.out.println("Sipraisiniz bulunmamaktadir.");
        } else {
            System.out.print("Iptal etmek istediginiz siparisin kodunu giriniz : ");
            int code = inp.nextInt();
            for (Order order : this.orderList) {
                if (order.orderCode == code) {//gecerli bir siparis kodu
                    this.orderList.remove(order);
                    System.out.println("Siparisiniz iptal edildi : " + order.dish.toString());
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
            if (isValid){//isValid eslesme olmadiginda false olacak ve bura calisacak
                System.out.println("Siparis kodu gecersiz!");
            }
        }
    }

    public void printBill(){
        Double totalPrice = 0.0;
        System.out.println("            Lezzet Fisiniz          ");
        for (Order order: this.orderList){
            System.out.printf("Lezzet kodu: %-5s adi: %-20 adet: %-5s siparis tutari: %-5s Lira\n",
                    order.dish.getCode(), order.dish.getName(), order.numberOfDish, order.orderPrice);
            totalPrice = order.orderPrice;
        }
        System.out.println("Toplam tutar : "+ totalPrice);
        System.out.println("Afiyet olsun...");
        this.orderList = new ArrayList<>();//siparis tamamlandiktan sonra yeni bir liste olusturulsun
    }

}
