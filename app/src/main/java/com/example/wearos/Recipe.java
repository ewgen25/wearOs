package com.example.wearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wearos.databinding.ActivityRecipeBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Recipe extends Activity {

    String dishName;
    TextView textRecipe;
    ImageView imageRecipe;
    ImageView backBtn2;
    ImageView logoUp;
    TextView recipeText;
    InputStream inputStream;
    private TextView mTextView;
    private ActivityRecipeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textRecipe = findViewById(R.id.textRecipe);
        imageRecipe = findViewById(R.id.imageRecipe);
        backBtn2 = findViewById(R.id.backBtn2);
        recipeText = findViewById(R.id.recipeText);
        logoUp = findViewById(R.id.logoUp);
        dishName = getIntent().getStringExtra("name");

        textRecipe.setText(dishName);
        imageRecipe.setImageResource(getResources().getIdentifier(dishName, "drawable", getPackageName()));
        logoUp.setImageResource(getResources().getIdentifier(("ic_"+dishName), "drawable", getPackageName()));

        switch (dishName) {
            case "borsch":
                inputStream = getResources().openRawResource(R.raw.borsch);
                fulling();
                break;
            case "blinchik":
                inputStream = getResources().openRawResource(R.raw.blinchik);
                fulling();
                break;
            case "cesar":
                inputStream = getResources().openRawResource(R.raw.cesar);
                fulling();
                break;
            case "milkshake":
                inputStream = getResources().openRawResource(R.raw.milkshake);
                fulling();
                break;
            case "spagetti":
                inputStream = getResources().openRawResource(R.raw.spagetti);
                fulling();
                break;


        }
    }

    public void fulling() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        recipeText.setText(byteArrayOutputStream.toString());
    }

    public void Clicked(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}