/*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
    и выведет ноутбуки, отвечающие фильтру.
    Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
    1 - название
    2 - ОЗУ
    3 - Объем ЖД
    4 - Операционная система
    5 - Цвет
    Далее нужно запросить минимальные значения для указанных критериев -
    сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
     */
package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        finalTask();
    }
    static void finalTask(){

        showMainMenu();
    }
    private static Set<Laptop> setOfLaptops (){
        Set<Laptop> laptops= new HashSet<>();
        laptops.add(new Laptop("Acer", "8", "512", "Windows", "серебряный"));
        laptops.add(new Laptop("Honor", "16", "512", "Windows", "серый"));
        laptops.add(new Laptop("Apple", "16", "1000", "macOS", "серый"));
        laptops.add(new Laptop("Lenovo", "8", "512", "Windows", "чёрный"));
        laptops.add(new Laptop("Apple", "8", "1000", "macOS", "серый"));
        return laptops;
    }
    private static void showMainMenu() {
        Map<Integer, String> initialMap = firstMenu(firstCriteria());
        mainSort(initialMap, setOfLaptops());

    }
    private static Map<Integer, String> firstMenu (Map<Integer,String> map) {
        Map<Integer, String> outputMap = new HashMap<>();
        print(map);                                    //печатаем первые критерии и просим пользователя выбрать цифру
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию," +
                " по которому хотите отфильтровать ноутбуки: \n");
        int currentKey = sc.nextInt();

        secondCriteria(currentKey);//вызываем вторые критерии и просим пользователя выбрать конкретный параметр

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите необходимый вам параметр/минимальное необходимое значение: ");
        String currentValue = sc1.nextLine();
        outputMap.put(currentKey, currentValue);
        return outputMap;
    }

    private static Map<Integer, String> firstCriteria() { //первые критерии
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Название");
        map.put(2, "Объём оперативной памяти(ОЗУ)");
        map.put(3, "Объем жесткого диска");
        map.put(4, "Операционная система");
        map.put(5, "Цвет");
        return map;
    }
    private static void secondCriteria(int num){ //вторые критерии(вызываются в firstMenu после выбора
        // пользователем первого критерия)
        switch (num) {
            case 1 -> System.out.println("Доступны следующие модели ноутбуков: Acer, Honor, Apple, Lenovo, Apple");
            case 2 -> System.out.println("Доступны ноутбуки со следующим оперативной памяти(ОЗУ): 8, 16");
            case 3 -> System.out.println("Доступны ноутбуки со следующим объёмом жёсткого диска: 512, 1000");
            case 4 -> System.out.println("Доступны ноутбуки со следующими операционными системами: Windows, macOS");
            case 5 -> System.out.println("Доступны ноутбуки со следующими цветами: серебряный, серый, чёрный");
            default -> System.out.println("Ошибка ввода");
        }
    }
    private static void print(Map<Integer, String> map) { // метод, печатающий первые критерии
        for (int i : map.keySet()) {
            System.out.println(i + " - " + map.get(i));
        }
    }
    private static void mainSort(Map<Integer, String> filters, Set<Laptop> laptops) {
        Set<Laptop> resultSet = new HashSet<>();
        for (Laptop laptop : laptops) {
            for(int key: filters.keySet()){
                if(key == 1 && laptop.getName().equals(filters.get(key))){
                    resultSet.add(laptop);
                    break;
                }
                if(key == 2 && laptop.getRAM().equals(filters.get(key))){
                    resultSet.add(laptop);
                    break;
                }
                if(key == 3 && laptop.getDiskCapacity().equals(filters.get(key))){
                    resultSet.add(laptop);
                    break;
                }
                if ((key == 4 && laptop.getOpSystem().equals(filters.get(key)))){
                    resultSet.add(laptop);
                    break;
                }
                if(key == 5 && laptop.getColor().equals(filters.get(key))){
                    resultSet.add(laptop);
                    break;
                }

                }

        } System.out.println("По введённым вами параметрам имеются следующие ноутбуки: \n" + resultSet);
        }



}