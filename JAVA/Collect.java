import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

public class Collect {
    public static void main(String[] args) throws IOException {

        Dishes[] dishesArr = {
                new Dishes("김치볶음밥", 6500, true),
                new Dishes("김치찌개", 8000, true),
                new Dishes("계란말이", 5000, true),
                new Dishes("마라샹궈", 13000, false),
                new Dishes("짬뽕", 6500, false),
                new Dishes("꿔바로우", 18000, false),
                new Dishes("떡볶이", 5500, true)
        };

        Map<Boolean, List<Dishes>> dishByKor = Stream.of(dishesArr).collect(partitioningBy(Dishes::getKoreanDishes));

        List<Dishes> koreanDishes = dishByKor.get(true);
        List<Dishes> chineseDishes = dishByKor.get(false);

        for (Dishes korean : koreanDishes) {
            System.out.println("한국 음식 : " + korean);
        }

        for (Dishes chinese : chineseDishes) {
            System.out.println("중국 음식" + chinese);
        }

        Map<Boolean, Long> count = Stream.of(dishesArr).collect(partitioningBy(Dishes::getKoreanDishes, counting()));
        System.out.println("한국 음식의 갯수 : " + count.get(true));
        System.out.println("중국 음식의 갯수 : " + count.get(false));

        Map<Boolean, Optional<Dishes>> booleanOptionalMap
                = Stream.of(dishesArr).collect(partitioningBy(Dishes::getKoreanDishes, maxBy(Comparator.comparingInt(Dishes::getPrice))));

        System.out.println("한국 음식 중 가장 높은 가격의 음식" + booleanOptionalMap.get(true).get());
        System.out.println("중국 음식 중 가장 높은 가격의 음식" + booleanOptionalMap.get(false).get());

//        Map<String, List<Dishes.CheckPrice>> list = Stream.of(dishesArr).collect(
//                groupingBy(d->d.getName() + " "  + d.getPrice(),
//                            mapping(d ->{
//                                        if(d.getPrice() > 10000) return Dishes.CheckPrice.HIGH;
//                                        else if (d.getPrice() > 5000) return Dishes.CheckPrice.MID;
//                                        else return Dishes.CheckPrice.LOW;
//                                        },toList()
//
//                                 )
//                            )
//        );


//        Map<String, Set<Dishes.CheckNation>> list = Stream.of(dishesArr).collect(
//                groupingBy(d->d.getName() + " "  + d.getPrice(),
//                        mapping(d ->{
//                                    if(d.getKoreanDishes()) return Dishes.CheckNation.KOREAN;
//                                    else return Dishes.CheckNation.CHINESE;
//                                },toSet()
//
//                        )
//                )
//        );
//
//        Set<String> stringSet = list.keySet();
//        for(String str : stringSet){
//            System.out.println(str + list.get(str));
//        }


//        Map<String, List<Dishes.CheckNation>> list = Stream.of(dishesArr).collect(
//                groupingBy(d->d.getName() + " "  + d.getPrice(),
//                        mapping(d ->{
//                                    if(d.getKoreanDishes()) return Dishes.CheckNation.KOREAN;
//                                    else return Dishes.CheckNation.CHINESE;
//                                },toList()
//
//                        )
//                )
//        );
//        Set<String> set = list.keySet();
//
//        for(String str : set){
//            System.out.println(str + list.get(str));
//        }
//    }

        Map<String, List<Dishes.CheckPrice>> list = Stream.of(dishesArr).collect(
                groupingBy(d -> d.getName() + " " + d.getPrice(),
                        mapping(d -> {
                                    if (d.getPrice() > 10000) return Dishes.CheckPrice.HIGH;
                                    else if (d.getPrice() > 5000) return Dishes.CheckPrice.MID;
                                    else return Dishes.CheckPrice.LOW;
                                }, toList()

                        )
                )
        );

        Set<String> set = list.keySet();
        for (String str : set) {
            System.out.println(str + list.get(str));
        }
    }
}

class Dishes {
    String name;
    int price;
    Boolean isKoreanDishes;

    public Dishes(String name, int price, Boolean isKoreanDishes) {
        this.name = name;
        this.price = price;
        this.isKoreanDishes = isKoreanDishes;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Boolean getKoreanDishes() {
        return isKoreanDishes;
    }

    @Override
    public String toString() {
        return String.format("%10s, %10d",name, price);
    }

    enum CheckNation{
        KOREAN, CHINESE
    }

    enum CheckPrice{
        HIGH, MID, LOW
    }
}