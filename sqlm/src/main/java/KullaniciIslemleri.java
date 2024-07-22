import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciIslemleri {

    private Connection connection;

    public KullaniciIslemleri(Connection connection) {
        this.connection = connection;
    }

    public Kullanici girisYap(String kullaniciAdi, String sifre) {
        String query = "SELECT* FROM kullanici WHERE kullanici_adi =? AND sifre = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, kullaniciAdi);
            stmt.setString(2, sifre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String isim = rs.getString("isim");
                String rol = rs.getString("rol");
                if (rol.equals("Admin")) {
                    return new Admin(id, isim, kullaniciAdi, sifre);
                } else if (rol.equals("Misafir")) {
                    return new Misafir(id, isim, kullaniciAdi, sifre);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
