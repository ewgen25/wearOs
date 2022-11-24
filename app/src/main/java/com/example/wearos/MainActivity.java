package com.example.wearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wearos.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    ArrayList<Dish> dishes = new ArrayList();
    ListView dishesList;
    ImageView backBtn;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityMainBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        //mTextView = binding.text;
        setInitialData();

        dishesList = (ListView) findViewById(R.id.dishesList);
        backBtn = (ImageView) findViewById(R.id.backBtn);

        //создание адаптера
        DishAdapter dishAdapter = new DishAdapter(this, R.layout.list_items, dishes);

        //устанавливает адаптер списку
        dishesList.setAdapter(dishAdapter);

        //слушатель списка
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Dish selectedDish = (Dish)parent.getItemAtPosition(position);
                selected = selectedDish.getName();

                Intent toRecipe = new Intent(MainActivity.this, Recipe.class);
                toRecipe.putExtra("name", selected);
                startActivity(toRecipe);
            }
        };

        dishesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData(){
        dishes.add(new Dish("borsch",  R.drawable.ic_borsch));
        dishes.add(new Dish("blinchik",  R.drawable.ic_blinchik));
        dishes.add(new Dish("cesar",  R.drawable.ic_cesar));
        dishes.add(new Dish("milkshake",  R.drawable.ic_milkshake));
        dishes.add(new Dish("spagetti",  R.drawable.ic_spagetti));



    }

    public void Clicked(View v){
        Intent intent = new Intent(this, MainMainActivity.class);
        startActivity(intent);
    }
}