import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);//Task-1
        System.out.println("\n**************");
        tekKupBirFazlaPrint(sayi); //Task-2
        System.out.println("\n**************");
        ciftKarakokPrint(sayi); //Task-3
        System.out.println("\n**************");
        maxElBul(sayi);//Task-4
        System.out.println("\n**************");
        ciftMaxElPrint(sayi);//Task-5
        System.out.println("\n**************");
        elTopla(sayi);//Task-6
        System.out.println("\n**************");
        elCarp(sayi);//Task-7==> 2 çözüm oluşturduk
        System.out.println("\n**************");
        minBul(sayi);//Task-8
        System.out.println("\n**************");
        bestenBykTekSayi(sayi);//Task-9
        System.out.println("\n**************");
        ciftlerinKareSortPrint(sayi);//Task-10

    }
    //Task-1: Functional Programming ile listin cift elemanlarının karelerini aynı satırda aralarına bosluk bırakarak print ediniz.

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul). //Akıştaki çift sayıları filtreledim. (4,2,6)
                map(t -> t * t).              //Map'ın sağladığı şey streamdeki akışı başka şeylere dönüştürür. Burada 4,2,6 artık => 16,4,36'ya dönüştü
                forEach(Lambda01::yazdir);

    }

    //Task-2: Functional Programming ile listin tek elemanlarinin  küplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void tekKupBirFazlaPrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda02::tekBul).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::yazdir);


    }

    //Task-2'de kullanmak üzere tek sayi bulmak için method oluşturuyorum:
    public static boolean tekBul(int a) {

        return a % 2 != 0; //tek sayi ise true verir.
    }

    //Task-3: Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarakokPrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t -> System.out.print(String.format("%.2f", t) + " "));

    }


    //Task-4: list'in en buyuk elemanini yazdiriniz.

    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().reduce(Math::max);//Eger benim result'ım tek bir değer ise o zaman reduce terminal operatorü kullanılır.
        System.out.println(maxSayi);
    }

    //Task-4'ü structured yapı ile çözüm:
    public static void structuredMaxElBul(List<Integer> sayi) {
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max); // max.soutv
        for (int i = 0; i < sayi.size(); i++) {
            if (sayi.get(i) > max) max = sayi.get(i);
        }
        System.out.println("en büyük sayı : " + max);

    }

    //Task-5:List'in cift elemanlarin karelerinin en buyugunu print ediniz.

    public static void ciftMaxElPrint(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));// Integer::max methodu Math::max'a gore daha hızlı çalışır.

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    //!!!!!!!!!!!!!!!!!TEK SONUC ALMAYI HEDEFLİYORSAK   reduce. kullanılır.

    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.
                stream().
                reduce(0, (a, b) -> a + b);
        System.out.println("toplam = " + toplam);
    }

    /*ÇÖZÜM:
     a ilk degerini her zaman atanan degerden (ilk parametre) alır,bu örnekte 0 oluyor
     b degerini her zamana  stream()'dan akısdan alır
     a ilk degerinden sonraki her değeri action(işlem)'dan alır

    */

    //Task 7- List'teki cift elemanların çarpımını yazdırınız.

    public static void elCarp(List<Integer> sayi) {
        //1.Yol:
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));


        //2.Yol:
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b));

    }

    //Task-8:List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1.Yol:
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); //Math::min

        //2.Yol:
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byRukiMin));
    }

    public static int byRukiMin(int a, int b) {
        return (a < b) ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykTekSayi(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 != 0)).
                reduce(Lambda02::byRukiMin));
    }

    //Task-10: list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.


    public static void ciftlerinKareSortPrint(List<Integer> sayi){

        sayi.
                stream().                   //akışı başlattık
                filter(Lambda01::ciftBul).  //akış içindeki çift sayıları aldık
                map(t-> t*t).               //sayiların kareleri ile yeni bir akış oluşturduk
                sorted().                   //akış içindeki sayıları natural-order olarak sıraladık
                forEach(Lambda01::yazdir);  //akıştaki sayıları ekrana yazdırdık

    }
}

