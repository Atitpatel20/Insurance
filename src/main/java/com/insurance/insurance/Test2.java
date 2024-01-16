package com.insurance.insurance;

import com.insurance.insurance.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(
                new Employee("siraj", 34, "hydrabad"),
                new Employee("kohli", 35, "delhi"),
                new Employee("rohit", 36, "mumbai"),
                new Employee("rahul", 32, "luckhnow"),
                new Employee("surya", 32, "mumbai")

        );
        Map<String, List<Employee>> collect = data.stream().collect(Collectors.groupingBy(str -> str.getCity()));

       for ( Map.Entry <String,List<Employee>> entry:collect.entrySet()){
           String city = entry.getKey();
           List<Employee> value = entry.getValue();
           System.out.println("city:"+city+"---");
           for (Employee e:value){
               System.out.println(e.getName());
               System.out.println(e.getAge());
           }
       }

    }
}
