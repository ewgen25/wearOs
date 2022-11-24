//здесь определяется модель, данные которой будут отображаться в списке

package com.example.wearos;
public class Dish {
    private String name; //название блюда
    private int imageResource; //ресурс картинки блюда

    //конструктор класса
    public Dish(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    //специальные методы доступа
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageResource() {
        return imageResource;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
