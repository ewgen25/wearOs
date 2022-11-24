package com.example.wearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wearos.databinding.ActivityMainMainBinding;

public class MainMainActivity extends Activity {

    TextView time;
    Button nextBtn;
    private TextView mTextView;
    private ActivityMainMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mTextView = binding.text;

        nextBtn = findViewById(R.id.nextBtn);
    }
    public void Clicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}