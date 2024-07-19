import java.util.ArrayList;
import java.util.List;

public class DishService {

    List<Dish> dishList = new ArrayList<>();//yemeklerle ilgili butun bilgiler Dish tipinde objede tutulacak


    public void fillDishList(){
        Dish dish1 = new Dish(100, "Adana Kebap", 220.0);
        Dish dish2 = new Dish(101, "Urfa Kebap", 220.0);
        Dish dish3 = new Dish(103, "Çökertme Kebabı", 200.0);
        Dish dish4 = new Dish(104, "Baklava", 100.0);
        Dish dish5 = new Dish(105, "Kadayif", 85.0);
        Dish dish6 = new Dish(106, "Künefe", 75.0);
        Dish dish7 = new Dish(107, "Yayık Ayranı", 30.0);
        Dish dish8 = new Dish(108, "Kola", 35.0);
        Dish dish9 = new Dish(109, "Çay", 15.0);
        Dish dish10 = new Dish(110, "Su", 7.5);

        this.dishList.add(dish1);//bu classin objesine ekle
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);
    }
    public void showDishMenu(){
        System.out.println("            Lezzetlerimiz           ");
        System.out.printf("%-3s %-20s %-5s\n", "Kod", "Adi", "Fiyat");
        System.out.printf("%-3s %-20s %-5s\n", "---", "---", "---");
        for (Dish dish:this.dishList){
            System.out.printf("%-3s %-20s %-5s Lira\n", dish.getCode(),dish.getName(),dish.getPrice());
        }


    }



}
