
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {


        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(ciftTopla(7));
        System.out.println(ilkXCiftToplam(4));
        ikininIlkXKuvvetPrint(9);
        System.out.println();
        System.out.println(istenenSayiFaktoriyel(5));
        System.out.println();
        System.out.println(istenenSayiFaktoriyel02(5));

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.


    //Structured
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam = toplam + i;
        }
        return toplam;
    }

    //Functional

    public static int toplaCincix(int x) {
        return IntStream. //int degerlerde bir akış sağlar. Sanki elimizde bir list var ve elimizde integerlar varmış gibi olur.
                range(1, x + 1).//range(a,b) --> a'dan b'ye kadar int degerler (b dahil degil) int degerler akısa alındı
                sum(); //akıstan gelen degerler toplandı
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int ciftTopla(int x) {

        return IntStream.
                rangeClosed(1, x).
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftToplam(int x) {
        return IntStream.
                iterate(2, t -> t + 2). //2'den sonsuza kadar elemanları 2 artırarak akışa alır. Yani--> 2,4,6,8,10,12,14,16.......sonsuza kadar gider
                        limit(x). //akışa aldığımız sonsuz cift sayının x'e kadar olanlarını sınırlar.
                        sum(); //sınırladıklarımızı (artık akıştakileri) toplar.
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXTekToplam(int x) {
        return IntStream.
                iterate(1, t -> t + 2).
                limit(x).
                sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) { // 2,4,8,16,32
        IntStream.
                iterate(2, t -> t * 2). // iterasyon için sartımızı yazdık
                limit(x). // x değeri ile sınırladık
                forEach(Lambda01::yazdir); //Lamnbda01 clasındaki yazdır() metodunu çağırarak ekrana yazdık
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenilenSayininIlkXKuvvetiPrint(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);

    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenenSayiFaktoriyel(int istenenSayi){ // 5---> 5*4*3*2

       return IntStream. //int akış başladı
               rangeClosed(1,istenenSayi). // rangeClosed(1,5) -->1,2,3,4,5
               reduce(1,(t,u)->t*u); //

    }
    public static OptionalInt istenenSayiFaktoriyel02(int istenenSayi){ // 5---> 5*4*3*2

        return IntStream.
                rangeClosed(1,istenenSayi).
                reduce(Math::multiplyExact);

    }

}
