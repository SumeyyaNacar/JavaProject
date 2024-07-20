import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    List<Order> orderList = new ArrayList<>();

    public void createOrder(DishService dishService){//methodun icerisinde obje olsuturursak method her cagrldiginda farkli bir dishService olustururdu

        Scanner inp = new Scanner(System.in);
        int dishCode=-1;
        while (dishCode!=0){
            System.out.print("Lutfen urun kodunu giriniz : (Cikis: O)");//urun kodu
            dishCode = inp.nextInt();//girilen kod ile urunu bulmamiz gerekiyor
            Dish dish =  dishService.findDishCode(dishCode);//girilen kod ile yemegi buldu
            if (dishCode>0){
                System.out.print("Adet giriniz : ");//adet
                int num = inp.nextInt();
                Order order = new Order(dish,num);
                order.setPrice();//fiyati hesapladik
                order.setOrderCode(1000 + this.orderList.size()+1);//siparis kodu olusturuldu ve her siparis sonrasi 1 tane artiracak
                this.orderList.add(order);//listeye siparisi ekledik


            }
            for (Order order:this.orderList){
                System.out.printf("Siparis kodu:%-5s  lezzet kodu:%-4s adi:%-20s adet:%-3s\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish);
            }
        }
    }



}
