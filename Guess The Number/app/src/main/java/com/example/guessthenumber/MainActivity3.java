package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView101;
    private TextView textView102;
    private TextView textView103;
    private TextView textView105;

    private ImageView resultImage;
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
        setContentView(R.layout.activity_main3);

        textView101 = findViewById(R.id.textView101);
        textView102 = findViewById(R.id.textView102);
        textView103 = findViewById(R.id.textView103);
        textView105 = findViewById(R.id.textView105);
        resultImage = findViewById(R.id.resultImage);
        Intent intent = getIntent();
        textView101.setText(intent.getStringExtra("resultOne"));
        textView102.setText(intent.getStringExtra("resultTwo"));
        textView103.setText(intent.getStringExtra("resultThree"));

        if (textView103.getText().toString().matches("0")) {

            textView105.setText("Correct Number : " + (Integer.toString(getIntent().getIntExtra("resultFour", 00))));
            resultImage.setImageResource(R.drawable.sadness);
        } else {
            resultImage.setImageResource(R.drawable.celebrating);
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