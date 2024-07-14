import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezervasyon {
/*
Project: mesafeye ve sartlara gore otobus bileti fiyati hesaplayan uygulama
         Kullanicidan mesafe(km), yasi ve yolculuk tipi(Tek Yon, Gidis-Donus)
         koltuk no. bilgilerini alin.
         Mesafe basina ucret 1 TL/km olarak alin (Gidis-Donus*2)
         Ilk olarak ucusun toplam fiyatini hesaplayin ve sonrasindaki kosullara gore musteriye asagidaki
         kurallari uygulayin:

         Kullanicidan alinan degerler gecerli (mesafe ve yas degerleri pozitfi sayi, yolculuk tipi ise 1 ve 2)
         olmalidir. Aksi takdirde kullaniciya "Hatali Veri Girdiniz !" şeklinde bir uyari verilmelidir.
         1-Kisi "Yolculuk Tipi"ni gidis-donus secmisse bilet fiyati uzerinden %20 indirim uygulanir.
         2.Yas indirimi:
            Kisi 12 yasindan kucukse bilet fiyati uzerinden %50 indirim uygulanir.
            Kisi 12-24 yaslari  arasinda ise bilet fiyati uzerinden %10 indirim uygulanir.
            Kisi 65 yasindan buykse bilet fiyati uzerinden %30 indirim uygulanir.
         3. Tekli Koltuk Ucreti:
            Koltuk numarasi 3 veya 3 un kati ise bilet fiyati %20 artirilir.


 */

    public static void main(String[] args) {
        List<String> seatNo = new ArrayList<>();
        for (int i = 1; i < 33; i++) {
            seatNo.add(String.valueOf(i));//["1", "2", "3",...]
        }
        Bilet bilet = new Bilet();
        Bus bus = new Bus("34 IST 78", seatNo);
        start(bilet, bus);
    }

    public static void start(Bilet bilet, Bus bus) {
        Scanner scan = new Scanner(System.in);
        int select;
        do {
            System.out.println("=== Bilet Rezarvasyon Sistemine Hos Geldiniz ===");
            System.out.println("Lutfen gidilecek mesafeyi  km olarak giriniz : ");
            bilet.distance = scan.nextInt();
            System.out.println("Lutfen yasinizi giriniz: ");
            int age = scan.nextInt();
            System.out.println("Lutfen yolculuk tipini seciniz: ");
            System.out.println("1- Tek Yon \n 2-Gidis-Donus");
            bilet.typeNo = scan.nextInt();
            System.out.println("Lutfen koltuk no seciniz : ");
            System.out.println("Tekli koltuk ucreti %20 daha fazladir");
            System.out.println(bus.seats);//mevcut koltuk listesi
            bilet.seatNo = scan.nextInt();
            bus.seats.remove(String.valueOf(bilet.seatNo));//biletin ilgili indexindeki koltuk noyu kaldiracak
            boolean check = bilet.typeNo == 1 || bilet.typeNo == 2;
            //boolean check = (bilet.typeNo ==1 || bilet.typeNo ==2) && bilet.distance>0 &&age>0;
            if (bilet.distance > 0 && age > 0 && check) {
                bilet.price = getTotal(bilet, age);
                bilet.printBilet(bus);
            } else {
                System.out.println("Hatali giris yaptiniz.");

            }
            System.out.println("Yeni islem icin 1 , cikis icin 0");
            select = scan.nextInt();

        } while (select != 0);
        System.out.println("Iyi gunler dileriz");
    }
    public static double getTotal(Bilet bilet, int age) {
        double total = 0;
        int dist = bilet.distance;
        int seatNo = bilet.seatNo;
        int type = bilet.typeNo;

        switch (type) {
            case 1:
                if (seatNo % 3 == 0) {
                    total = dist * 1.2;
                } else {
                    total = dist * 1;
                }
                System.out.println("Toplam tutar: " + total);
                break;
            case 2:
                if (seatNo % 3 == 0) {
                    total = dist * 2.4;
                } else {
                    total = dist * 2;
                }
                System.out.println("Tutar : " + total);
                total = total * 0.8;//indirimli fiyat
                System.out.println("Cift yon indirimli tutar : " + total);
                break;
        }
        if (age <= 12) {
            total = total * 0.5;
            System.out.println("Yas indirimli tutar : " + total);
        } else if (age > 12 && age <= 24) {
            total = total * 0.90;
            System.out.println("Yas indirimli Tutar : " + total);
        } else if (age >= 65) {
            total = total * 0.70;
            System.out.println("65 yas ustu indirimli tutar : "+ total);
        }
        return total;

    }
}
