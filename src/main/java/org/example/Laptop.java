/*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
    и выведет ноутбуки, отвечающие фильтру.
    Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев -
    сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
     */
package org.example;

public class Laptop {
    String name;
    String RAM;
    String diskCapacity;
    String opSystem;
    String color;

    public Laptop(String name, String RAM, String diskCapacity, String opSystem, String color) {
        this.name = name;
        this.RAM = RAM;
        this.diskCapacity = diskCapacity;
        this.opSystem = opSystem;
        this.color = color;
    }


    String getName(){
        return name;
    }

    String getRAM(){
        return RAM;
    }

    String getDiskCapacity(){
        return diskCapacity;
    }

    String getOpSystem(){
        return opSystem;
    }

    String getColor(){
        return color;
    }


    public String toString() {
        return "Ноутбук: \n" +
                "Название: " + name + ".\n" +
                "Оперативная память(ОЗУ) в ГБ: " + RAM + ".\n" +
                "Объём жёсткого диска в ГБ: " + diskCapacity + ".\n" +
                "Операционная система: " + opSystem + ".\n" +
                "Цвет: " + color + ".\n";
    }
}
