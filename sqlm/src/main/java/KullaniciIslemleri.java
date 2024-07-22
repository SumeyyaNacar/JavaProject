import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciIslemleri {

    private Connection connection;

    public KullaniciIslemleri(Connection connection) {
        this.connection = connection;
    }
    public Kullanici girisYap(String kullaniciAdi, String sifre){
        String query = "SELECT* FROM kullanici WHERE kullanici_adi =? AND sifre = ?";

        try {
            PreparedStatement stmt= connection.prepareStatement(query);
            stmt.setString(1,kullaniciAdi);
            stmt.setString(2,sifre);
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
