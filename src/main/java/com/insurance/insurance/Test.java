package com.insurance.insurance;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        Predicate<Integer> val=y->y%2==0;
//        boolean test = val.test(34);
//        System.out.println(test);

//        Predicate<String>val= str->str.equals("sam");
//        boolean result = val.test("nayan");
//        System.out.println(result);

//        List<Integer> numbers = Arrays.asList(11, 15, 34, 39, 42, 25, 36);
//        List<Integer> res = numbers.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
//        System.out.println(res);

//        List<Integer> numbers = Arrays.asList(11, 12, 36, 14, 21, 51, 53, 61);
//        List<Integer> res = numbers.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
//        System.out.println(res);

        List<String> names = Arrays.asList("mike", "nayan", "kenal", "swapnil", "kenal");
        List<String> data1 = names.stream().filter(str -> str.startsWith("s")).collect(Collectors.toList());
        List<String> data2 = names.stream().filter(str -> str.equals("kenal")).collect(Collectors.toList());
        List<String> data3 = names.stream().filter(str -> str.endsWith("n")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
}
