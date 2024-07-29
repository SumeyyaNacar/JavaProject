package randevu;

import kullanici.Doktor;
import kullanici.Kullanici;
import kullanici.KullaniciIslemleri;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RandevuIslemleri {
    private List<Randevu> randevular;
    private int randevuIdSayac;
    private KullaniciIslemleri kullaniciIslemleri;

    public RandevuIslemleri(KullaniciIslemleri kullaniciIslemleri) {
        this.kullaniciIslemleri = kullaniciIslemleri;
        randevular = new ArrayList<>();
        randevuIdSayac = 1;
    }

    public List<Doktor> doktorlariListele() {
        return kullaniciIslemleri.doktorlariListele();
    }

    public void yeniRandevuOlusturma(int hastaId) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Doktor> doktorlar = doktorlariListele();
            System.out.println("\n**** Doktorlar ve Branşları ****");
            for (Doktor doktor : doktorlar) {
                System.out.println("ID: " + doktor.getId() + ", Adı: " + doktor.getKullaniciAdi() + ", Branş: " + doktor.getBrans());
            }

            System.out.print("Doktor ID: ");
            int doktorId = scanner.nextInt();
            scanner.nextLine();

            Doktor secilenDoktor = null;
            for (Doktor doktor : doktorlar) {
                if (doktor.getId() == doktorId) {
                    secilenDoktor = doktor;
                    break;
                }
            }

            //Lambda Hali
            // Doktor secilenDoktor = doktorlar.stream()
            //        .filter(doktor -> doktor.getId() == doktorId)
            //        .findFirst()
            //        .orElse(null);


            if (secilenDoktor == null) {
                System.out.println("Geçersiz Doktor ID!");
                return;
            }

            System.out.println("\n**** Uygun Saatler ****");
            List<String> uygunSaatler = getUygunSaatler(secilenDoktor);
            for (String saat : uygunSaatler) {
                System.out.println(saat);
            }

            System.out.print("Saat (ss:dd): ");
            String saat = scanner.nextLine();

            if (!uygunSaatler.contains(saat)) {
                System.out.println("Seçtiğiniz saat uygun değil.");
                return;
            }

            System.out.print("Tarih (gg/aa/yyyy): ");
            String tarih = scanner.nextLine();

            if (!isValidDate(tarih)) {
                System.out.println("Geçmişe yönelik randevu alınamaz.");
                return;
            }

            System.out.print("Randevuyu alan kişinin adı: ");
            String randevuyuAlanAdi = scanner.nextLine();

            System.out.print("Randevuyu alan kişinin soyadı: ");
            String randevuyuAlanSoyadi = scanner.nextLine();

            Randevu yeniRandevu = new Randevu(randevuIdSayac++, hastaId, doktorId, secilenDoktor.getBrans(), tarih, saat, randevuyuAlanAdi, randevuyuAlanSoyadi);
            randevular.add(yeniRandevu);

            System.out.println("Randevu başarıyla eklendi.");
        } catch (Exception e) {
            System.out.println("Randevu oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    private boolean isValidDate(String tarih) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date randevuTarihi = sdf.parse(tarih);
            Date bugun = new Date();
            return !randevuTarihi.before(bugun);
        } catch (ParseException e) {
            System.out.println("Geçersiz tarih formatı.");
            return false;
        }
    }

    private List<String> getUygunSaatler(Doktor doktor) {
        List<String> uygunSaatler = new ArrayList<>();
        for (int i = 9; i < 18; i++) {
            uygunSaatler.add(i + ":00");
        }
        for (Randevu randevu : randevular) {
            if (randevu.getDoktorId() == doktor.getId()) {
                uygunSaatler.remove(randevu.getSaat());
            }
        }
        return uygunSaatler;

        //Lambda Hali;
        // randevular.stream()
        //         .filter(randevu -> randevu.getDoktorId() == doktor.getId())
        //         .forEach(randevu -> uygunSaatler.remove(randevu.getSaat()));
        //return uygunSaatler;
    }

    public void randevulariListele() {
        try {
            if (randevular.isEmpty()) {
                System.out.println("Randevu bulunamadı.");
                return;
            }

            for (Randevu randevu : randevular) {
                System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: "
                        + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat());
            }
        } catch (Exception e) {
            System.out.println("Randevular listelenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void randevulariListele(int kullaniciId) {
        try {
            boolean randevuBulundu = false;
            for (Randevu randevu : randevular) {
                if (randevu.getHastaId() == kullaniciId) {
                    System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: " + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat());
                    randevuBulundu = true;
                }
            }

            //Lambda Hali;
            //     boolean randevuBulundu = randevular.stream()
            //            .filter(randevu -> randevu.getHastaId() == kullaniciId)
            //            .peek(randevu -> System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: " + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat()))
            //            .count() > 0;


            if (!randevuBulundu) {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevular listelenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void randevuDetaylari(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId);
            if (randevu != null) {
                System.out.println("Randevu Detayları:");
                System.out.println("Randevu ID: " + randevu.getId());
                System.out.println("Hasta ID: " + randevu.getHastaId());
                System.out.println("Doktor ID: " + randevu.getDoktorId());
                System.out.println("Doktor Branş: " + randevu.getBrans());
                System.out.println("Tarih: " + randevu.getTarih());
                System.out.println("Saat: " + randevu.getSaat());
                System.out.println("Randevuyu Alan: " + randevu.getRandevuyuAlanAdi() + " " + randevu.getRandevuyuAlanSoyadi());
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu detayları görüntülenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void randevuGuncelle(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId);
            if (randevu != null) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Yeni Tarih (gg/aa/yyyy): ");
                String yeniTarih = scanner.nextLine();

                if (!isValidDate(yeniTarih)) {
                    System.out.println("Geçmişe yönelik randevu alınamaz.");
                    return;
                }

                System.out.print("Yeni Saat (ss:dd): ");
                String yeniSaat = scanner.nextLine();

                Kullanici kullanici = kullaniciIslemleri.kullaniciBul(randevu.getDoktorId());
                if (kullanici instanceof Doktor) {
                    Doktor doktor = (Doktor) kullanici;
                    if (!getUygunSaatler(doktor).contains(yeniSaat)) {
                        System.out.println("Seçtiğiniz saat uygun değil.");
                        return;
                    }
                } else {
                    System.out.println("Geçersiz doktor ID.");
                    return;
                }

                randevu.setTarih(yeniTarih);
                randevu.setSaat(yeniSaat);

                System.out.println("Randevu başarıyla güncellendi.");
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu güncellenirken bir hata oluştu: " + e.getMessage());
        }
    }

    public void randevuSil(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId);
            if (randevu != null) {
                randevular.remove(randevu);
                System.out.println("Randevu başarıyla silindi.");
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu silinirken bir hata oluştu: " + e.getMessage());
        }
    }

    private Randevu randevuBul(int randevuId) {
        for (Randevu randevu : randevular) {
            if (randevu.getId() == randevuId) {
                return randevu;
            }
        }

        //Lambda Hali
        //    return randevular.stream()
        //            .filter(randevu -> randevu.getId() == randevuId)
        //            .findFirst()
        //            .orElse(null);
        return null;
    }
}
