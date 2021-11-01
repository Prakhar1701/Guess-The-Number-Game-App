package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guessthenumber.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    private long backPressedTime;
    private Toast backToast;

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        binding.textView101.setText(intent.getStringExtra("resultOne"));
        binding.textView102.setText(intent.getStringExtra("resultTwo"));
        binding.textView103.setText(intent.getStringExtra("resultThree"));

        if (binding.textView103.getText().toString().matches("0")) {

            binding.textView105.setText("Correct Number : " + (Integer.toString(getIntent().getIntExtra("resultFour", 00))));
            binding.resultImage.setImageResource(R.drawable.sadness);
        } else {
            binding.resultImage.setImageResource(R.drawable.celebrating);
        }
    }

    public void playAgain(View view) {
//      Toast.makeText(MainActivity3.this, "Play Again", Toast.LENGTH_SHORT).show();
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
        }
        Intent ActivityTwo = new Intent(this, MainActivity2.class);
        finish();
        startActivity(ActivityTwo);
    }
}