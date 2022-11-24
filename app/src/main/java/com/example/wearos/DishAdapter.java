//всё взаимодействие со списком
package com.example.wearos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {

    private LayoutInflater inflater; //объект для создания объекта view по ресурсу разметки
    private int layout;
    private List<Dish> dishes;

    public DishAdapter(Context context, int resource, List<Dish> dishes) {
        super(context, resource, dishes);
        this.dishes = dishes;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    //метод для отображения элемента списка
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false); //создаем view для каждого отдельного элемента в списке

        //из заданного view получаем объекты по id
        ImageView dishView = view.findViewById(R.id.dishImage);
        TextView nameView = view.findViewById(R.id.dishName);

        Dish dish = dishes.get(position); //получение объекта по позиции, для которого создается разметка

        //наполняем из полученного по позиции объекта Dish
        dishView.setImageResource(dish.getImageResource());
        nameView.setText(dish.getName());

        //возвращаем созданный элемент
        return view;
    }

}
