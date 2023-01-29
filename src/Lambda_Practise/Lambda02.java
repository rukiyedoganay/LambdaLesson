package Lambda_Practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");


        System.out.println("S1: ilkHarfBuyukGerisiKckList: " + ilkHarfBuyukGerisiKckList(list));
        System.out.println("*********");
        System.out.println("S2: ilkHarfEveyaCOlanlarList: " + ilkHarfEveyaCOlanlarList(list));
        System.out.println("*********");
        basaSonaYildiz(list);
        System.out.println("*********");
        icindeEvarMiList(list);
        System.out.println("*********");
        tumLHarfleriniSil(list);
        System.out.println("\n*********");
        ikinciHarfeGoreSiralaEnUzunuPrint(list);


    }
    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim

    public static List<String> ilkHarfBuyukGerisiKckList(List<String> l) {

        return l.
                stream().
                map(t -> (t.substring(0, 1)).toUpperCase() + t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim

    public static List<String> ilkHarfEveyaCOlanlarList(List<String> l) {
        return l.
                stream().
                filter(t -> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim

    public static void basaSonaYildiz(List<String> l) {
        l.stream().map(t -> "*" + t + "*").forEach(Utils::yazdirString);
    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz

    public static List<String> icindeEvarMiList(List<String> l) {
        return l.
                stream().
                filter(t -> t.contains("e")).
                collect(Collectors.toList());
    }

    //S5: tum 'l' leri silelim yazdiralim

    public static void tumLHarfleriniSil(List<String> l) {

        l.stream().map(t -> t.replace("l", "")).forEach(Utils::yazdirString);

    }

    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print

    public static void ikinciHarfeGoreSiralaEnUzunuPrint(List<String> l){
        System.out.println(l.
                stream().                                       //akışa sunduk
                sorted(Comparator.comparing(t -> t.charAt(1))). //list elemanlarını 2.harfe göre sıraladık
                limit(5).                                //ilk 5 elemanı alarak akışa devam ettik. Limit içinde yazan sayı kadar elemanı alır //akışa devam eden 5 elemanı uzunluklarına göre uzundan kısaya sıraladık
                sorted(Comparator.comparing(String::length).reversed()).//akışa devam eden 5 elemanı uzunluklarına göre uzundan kısaya sıraladık
                findFirst());                                   //akıştan gelen ilk elemanı aldık.

    }
}
