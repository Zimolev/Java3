package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
	String arr2[] = {"Вася", "Петя", "Катя", "Маша", "Эдуард"};

/**
 * Большая задача
 * */
	    Box<Apple> appleBox1 = new Box<>();
	    Box<Apple> appleBox2 = new Box<>();
	    Box<Orange> orangeBox1 = new Box<>();
	    Box<Orange> orangeBox2 = new Box<>();
        for (int j = 0; j < 2; j++) {
            orangeBox1.add(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            appleBox1.add(new Apple());
        }
        for (int i = 0; i < 4; i++) {
            appleBox2.add(new Apple());
        }

        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.compare(appleBox1));
        orangeBox1.change(orangeBox2);
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());


	creatingArrayList(arr1);
	creatingArrayList(arr2);

	exchangePlases(arr1, 0, 3);
	exchangePlases(arr2, 2, 4);

    }

    public static <T> void exchangePlases(T[] array, int i, int j){
        /**
         Написать метод, который меняет два элемента массива местами
         (массив может быть любого ссылочного типа);
         */
        T exP = array[i];
        array[i] = array[j];
        array[j] = exP;
        System.out.println(Arrays.toString(array));
    }

    public static <T> void creatingArrayList(T[] array){
        /**
         Написать метод, который преобразует массив в ArrayList
         */
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
    }
}
