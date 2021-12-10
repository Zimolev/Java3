package com.company;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public float getWeight() {
        if (fruits.isEmpty()){
            return 0.0f;
        }
      return fruits.get(0).getWeight() * fruits.size();
    }

    public void change(Box<T> anotherBox){
        fruits.addAll(anotherBox.getFruits());
        anotherBox.getFruits().clear();
    }

    public void add (T fruit){
        fruits.add(fruit);
    }

    public boolean compare(Box <? extends Fruit> anotherBox){
        return getWeight()==anotherBox.getWeight();
    }
}
