import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    List<Order> orderList = new ArrayList<>();

    public void createOrder(){

        Scanner inp = new Scanner(System.in);
        int dishCode=-1;
        while (dishCode!=0){
            System.out.print("Lutfen urun kodunu giriniz : (Cikis: O)");
            dishCode = inp.nextInt();//girilen kod ile urunu bulmamiz gerekiyor




        }
    }



}
