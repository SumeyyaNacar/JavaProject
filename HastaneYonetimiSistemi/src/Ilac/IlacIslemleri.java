package ilac;

import java.util.ArrayList;
import java.util.List;

public class IlacIslemleri {
    private List<Ilac> ilaclar;
    private int ilacIdSayac;

    public IlacIslemleri() {
        ilaclar = new ArrayList<>();
        ilacIdSayac = 1;
    }

    public void ilacEkle(String isim, String tur, String kullanimTalimatlari, int stok) {
        try {
            Ilac ilac = new Ilac(ilacIdSayac++, isim, tur, kullanimTalimatlari, stok);
            ilaclar.add(ilac);
            System.out.println("İlaç başarıyla eklendi. İlaç ID: " + ilac.getId());
        } catch (Exception e) {
            System.out.println("İlaç eklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void ilaclariListele() {
        try {
            System.out.println("\n**** İlaçlar ****");
            for (Ilac ilac : ilaclar) {
                System.out.println("İlaç ID: " + ilac.getId() + ", İsim: " + ilac.getIsim() + ", Tür: " + ilac.getTur() + ", Kullanım Talimatları: " + ilac.getKullanimTalimatlari() + ", Stok: " + ilac.getStok());
            }
        } catch (Exception e) {
            System.out.println("İlaçlar listelenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void ilacGuncelle(int id, String isim, String tur, String kullanimTalimatlari, int stok) {
        try {
            Ilac ilac = ilacBul(id);
            if (ilac != null) {
                ilac.setIsim(isim);
                ilac.setTur(tur);
                ilac.setKullanimTalimatlari(kullanimTalimatlari);
                ilac.setStok(stok);
                System.out.println("İlaç bilgileri güncellendi.");
            } else {
                System.out.println("İlaç bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("İlaç güncellenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void ilacSil(int id) {
        try {
            Ilac ilac = ilacBul(id);
            if (ilac != null) {
                ilaclar.remove(ilac);
                System.out.println("İlaç başarıyla silindi.");
            } else {
                System.out.println("İlaç bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("İlaç silinirken bir hata oluştu: " + e.getMessage());
        }
    }

    private Ilac ilacBul(int id) {
        try {
            for (Ilac ilac : ilaclar) {
                if (ilac.getId() == id) {
                    return ilac;
                }
            }
        } catch (Exception e) {
            System.out.println("İlaç bulunurken bir hata oluştu: " + e.getMessage());
        }
        return null;
    }
}
