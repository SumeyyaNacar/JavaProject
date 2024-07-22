import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeriTabani {
    private final String URL="jdbc:postgresql://localhost:5432/practice";
    private final String USER = "admin";
    private final String PASSWORD ="Admin123";

    public Connection baglantiyiAc(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e) {
              return null;
        }
    }

   public void baglantiyiKapat(){
        try {
            Connection con = baglantiyiAc();
            if (con!=null){
                con.close();
            }
        }catch (SQLException e){
            System.out.println("Veri tabani kapatilamadi!");
        }
   }



}
