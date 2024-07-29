package bildirim;

import java.util.ArrayList;
import java.util.List;

public class BildirimIslemleri {
    private List<Bildirim> bildirimler;

    public BildirimIslemleri() {
        bildirimler = new ArrayList<>();
    }

    public void yeniBildirim(int kullaniciId, String mesaj) {
        int bildirimId = bildirimler.size() + 1;
        Bildirim yeniBildirim = new Bildirim(bildirimId, kullaniciId, mesaj);
        bildirimler.add(yeniBildirim);
        System.out.println("Bildirim başarıyla eklendi.");
    }

    public void bildirimleriListele(int kullaniciId) {
        for (Bildirim b : bildirimler) {
            if (b.getKullaniciId() == kullaniciId || b.getKullaniciId() == -1) {
                System.out.println("Bildirim ID: " + b.getBildirimId() + ", Kullanıcı ID: " + b.getKullaniciId() + ", Mesaj: " + b.getMesaj());
            }
        }
    }

    public void bildirimDetaylari(int bildirimId) {
        Bildirim bildirim = bildirimBul(bildirimId);
        if (bildirim != null) {
            System.out.println("Bildirim Detayları:");
            System.out.println("Bildirim ID: " + bildirim.getBildirimId());
            System.out.println("Kullanıcı ID: " + bildirim.getKullaniciId());
            System.out.println("Mesaj: " + bildirim.getMesaj());
        } else {
            System.out.println("Bildirim bulunamadı.");
        }
    }

    private Bildirim bildirimBul(int id) {
        for (Bildirim bildirim : bildirimler) {
            if (bildirim.getBildirimId() == id) {
                return bildirim;
            }
        }
        return null;
    }
}
