import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeriTabani {
    private final String URL="jdbc:postgresql://localhost:5432/B254JDBC_nt_tekrar";
    private final String USER = "B254nt_tekrar";
    private final String PASSWORD ="password";

    public Connection baglantiyiAc(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e) {
             e.printStackTrace();
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
            e.printStackTrace();
            System.out.println("Veri tabani kapatilamadi!");
        }
   }



}
