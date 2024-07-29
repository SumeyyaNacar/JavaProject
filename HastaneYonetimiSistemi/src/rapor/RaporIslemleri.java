package rapor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class RaporIslemleri {
    private List<Rapor> raporlar;

    public RaporIslemleri() {
        raporlar = new ArrayList<>();
    }

    public void gunlukRaporOlustur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Günlük rapor içeriği: ");
        String icerik = scanner.nextLine();

        Rapor rapor = new Rapor("Günlük", icerik);
        raporlar.add(rapor);

        try {
            FileWriter writer = new FileWriter("gunluk_rapor.txt", true);
            writer.write(icerik + "\n");
            writer.close();
            System.out.println("Günlük rapor oluşturuldu ve kaydedildi.");
        } catch (IOException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

    public void aylikRaporOlustur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aylık rapor içeriği: ");
        String icerik = scanner.nextLine();

        Rapor rapor = new Rapor("Aylık", icerik);
        raporlar.add(rapor);

        try {
            FileWriter writer = new FileWriter("aylik_rapor.txt", true);
            writer.write(icerik + "\n");
            writer.close();
            System.out.println("Aylık rapor oluşturuldu ve kaydedildi.");
        } catch (IOException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

    public void randevuRaporlariGoruntule() {
        System.out.println("Randevu Raporları:");
        for (Rapor rapor : raporlar) {
            if (rapor.getRaporTuru().equals("Randevu")) {
                System.out.println(rapor.getIcerik());
            }
        }
    }
}
