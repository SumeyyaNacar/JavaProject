import java.util.List;

public class Dish {

    private int code;
    private String name;
    private Double price;

    public Dish(Double price, String name, int code) {
        this.price = price;
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {//dish classindan olusturdugum objeleri direk yazdirmak icin override etmemiz gerekir
        return  "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price ;

    }
}
