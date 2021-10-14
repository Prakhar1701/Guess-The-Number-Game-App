package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    private int noOfGuesses = 0;
    //    private Button button;
    private EditText editText;

    private TextView textView51;
    private TextView textView52;
    private TextView textView53;
    private TextView textView54;
    private TextView textView55;
    private TextView textView56;
    private TextView textView57;
    private TextView textView58;
    private TextView textView59;
    private TextView textView60;
    private TextView textView61;
    private TextView textView62;
    private TextView textView63;
    private TextView textView64;
    private TextView textView65;
    private TextView textView66;
    private TextView textView67;
    private TextView textView68;
    private TextView textView69;
    private TextView textView70;
//    private TextView textView71;

    private long backPressedTime;
    private Toast backToast;
    private long validValueToastTime;
    private Toast validValueToast;

    @Override
    public void onBackPressed() {
        if (validValueToastTime+2000>System.currentTimeMillis()){
            validValueToast.cancel();
        }

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
        setContentView(R.layout.activity_main2);

//        button = findViewById(R.id.guess);
        editText = findViewById(R.id.editText);

        textView51 = findViewById(R.id.textView51);
        textView52 = findViewById(R.id.textView52);
        textView53 = findViewById(R.id.textView53);
        textView54 = findViewById(R.id.textView54);
        textView55 = findViewById(R.id.textView55);
        textView56 = findViewById(R.id.textView56);
        textView57 = findViewById(R.id.textView57);
        textView58 = findViewById(R.id.textView58);
        textView59 = findViewById(R.id.textView59);
        textView60 = findViewById(R.id.textView60);
        textView61 = findViewById(R.id.textView61);
        textView62 = findViewById(R.id.textView62);
        textView63 = findViewById(R.id.textView63);
        textView64 = findViewById(R.id.textView64);
        textView65 = findViewById(R.id.textView65);
        textView66 = findViewById(R.id.textView66);
        textView67 = findViewById(R.id.textView67);
        textView68 = findViewById(R.id.textView68);
        textView69 = findViewById(R.id.textView69);
        textView70 = findViewById(R.id.textView70);
//        textView71 = findViewById(R.id.textView71);
    }


    public void buttonClicked(View view) {
        if (validValueToastTime+2000>System.currentTimeMillis()){
            validValueToast.cancel();
        }
        if (backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
        }
        Game GuessTheNumber = new Game();
//        textView71.setText(Integer.toString(GuessTheNumber.getRamdonNumber()));
        if ((editText.getText().toString().matches("")) || (Integer.parseInt(editText.getText().toString()) == 0)) {
            //Note: Conditions in if are order specific.
            validValueToast = Toast.makeText(MainActivity2.this, "Enter a valid value !", Toast.LENGTH_SHORT);
            validValueToastTime = System.currentTimeMillis();
            validValueToast.show();
            editText.setText("");
            return;
        }
        int editTextValue = Integer.parseInt(editText.getText().toString());

        GuessTheNumber.setUserInput(editTextValue);


        switch (noOfGuesses) {
            case 0:
                textView51.setText(editText.getText());

                break;
            case 1:
                textView53.setText(editText.getText());

                break;
            case 2:
                textView55.setText(editText.getText());

                break;
            case 3:
                textView57.setText(editText.getText());

                break;
            case 4:
                textView59.setText(editText.getText());

                break;
            case 5:
                textView61.setText(editText.getText());

                break;
            case 6:
                textView63.setText(editText.getText());

                break;
            case 7:
                textView65.setText(editText.getText());

                break;
            case 8:
                textView67.setText(editText.getText());

                break;
            case 9:
                textView69.setText(editText.getText());
                break;
        }
        editText.setText("");
        if ((GuessTheNumber.getUserInput()) < (GuessTheNumber.getRamdonNumber())) {
            switch (noOfGuesses) {
                case 0:
                    textView52.setText("Guessed Number Is Small !");

                    break;
                case 1:
                    textView54.setText("Guessed Number Is Small !");

                    break;
                case 2:
                    textView56.setText("Guessed Number Is Small !");

                    break;
                case 3:
                    textView58.setText("Guessed Number Is Small !");

                    break;
                case 4:
                    textView60.setText("Guessed Number Is Small !");

                    break;
                case 5:
                    textView62.setText("Guessed Number Is Small !");

                    break;
                case 6:
                    textView64.setText("Guessed Number Is Small !");

                    break;
                case 7:
                    textView66.setText("Guessed Number Is Small !");

                    break;
                case 8:
                    textView68.setText("Guessed Number Is Small !");

                    break;
                case 9:
                    textView70.setText("Guessed Number Is Small !");
                    break;
            }

            noOfGuesses++;
            if (noOfGuesses == 10) {
                Intent ActivityThree = new Intent(this, MainActivity3.class);
                ActivityThree.putExtra("resultOne", "Too Many Guesses !");
                ActivityThree.putExtra("resultTwo", "GAME OVER");
                ActivityThree.putExtra("resultThree", "0");
                ActivityThree.putExtra("resultFour", GuessTheNumber.getRamdonNumber());
//                ActivityThree.putExtra("resultFour","Correct Number : ".concat(String.valueOf( GuessTheNumber.getRamdonNumber())));  //Another Method
                GuessTheNumber.setRamdonNumber(); //To change random value when played again.
                if (validValueToastTime+2000>System.currentTimeMillis()){
                    validValueToast.cancel();
                }
                finish(); //To exit this activity;
                startActivity(ActivityThree);
            }


        } else if ((GuessTheNumber.getUserInput()) > (GuessTheNumber.getRamdonNumber())) {
            switch (noOfGuesses) {
                case 0:
                    textView52.setText("Guessed Number Is Big !");

                    break;
                case 1:
                    textView54.setText("Guessed Number Is Big !");

                    break;
                case 2:
                    textView56.setText("Guessed Number Is Big !");

                    break;
                case 3:
                    textView58.setText("Guessed Number Is Big !");

                    break;
                case 4:
                    textView60.setText("Guessed Number Is Big !");

                    break;
                case 5:
                    textView62.setText("Guessed Number Is Big !");

                    break;
                case 6:
                    textView64.setText("Guessed Number Is Big !");

                    break;
                case 7:
                    textView66.setText("Guessed Number Is Big !");

                    break;
                case 8:
                    textView68.setText("Guessed Number Is Big !");

                    break;
                case 9:
                    textView70.setText("Guessed Number Is Big !");
                    break;
            }

            noOfGuesses++;
            if (noOfGuesses == 10) {
                Intent ActivityThree = new Intent(this, MainActivity3.class);
                ActivityThree.putExtra("resultOne", "Too Many Guesses !");
                ActivityThree.putExtra("resultTwo", "GAME OVER");
                ActivityThree.putExtra("resultThree", "0");
                ActivityThree.putExtra("resultFour", GuessTheNumber.getRamdonNumber());
                GuessTheNumber.setRamdonNumber(); //To change random value when played again.
                if (validValueToastTime+2000>System.currentTimeMillis()){
                    validValueToast.cancel();
                }
                finish(); //To exit this activity;
                startActivity(ActivityThree);
            }


        } else {

            switch (noOfGuesses) {
                case 0:
                    textView52.setText("Guessed Number Is Correct !");

                    break;
                case 1:
                    textView54.setText("Guessed Number Is Correct !");

                    break;
                case 2:
                    textView56.setText("Guessed Number Is Correct !");

                    break;
                case 3:
                    textView58.setText("Guessed Number Is Correct !");

                    break;
                case 4:
                    textView60.setText("Guessed Number Is Correct !");

                    break;
                case 5:
                    textView62.setText("Guessed Number Is Correct !");

                    break;
                case 6:
                    textView64.setText("Guessed Number Is Correct !");

                    break;
                case 7:
                    textView66.setText("Guessed Number Is Correct !");

                    break;
                case 8:
                    textView68.setText("Guessed Number Is Correct !");

                    break;
                case 9:
                    textView70.setText("Guessed Number Is Correct !");
                    break;

            }
            noOfGuesses++;
            int Score = (11 - noOfGuesses);
//Variable inside a method can not be declared with public,private or protected modifier.
            Intent ActivityThree = new Intent(this, MainActivity3.class);
            ActivityThree.putExtra("resultOne", "Congratulations !");
            ActivityThree.putExtra("resultTwo", "Guessed Number Is Correct !");
            ActivityThree.putExtra("resultThree", String.valueOf(Score));
            GuessTheNumber.setRamdonNumber(); //To change random value when played again.
            if (validValueToastTime+2000>System.currentTimeMillis()){
                validValueToast.cancel();
            }
            finish(); //To exit this activity;
            startActivity(ActivityThree);

        }
    }

    public void resetGame(View view) {
        if (validValueToastTime+2000>System.currentTimeMillis()){
            validValueToast.cancel();
        }
        Game GuessTheNumber = new Game();
        GuessTheNumber.setRamdonNumber();
        Intent ActivityTwo = new Intent(this, MainActivity2.class);
        if (backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
        }
        finish();
        startActivity(ActivityTwo);
    }
}

class Game {

    private static int ramdonNumber;
    private int userInput;

    static {
        ramdonNumber = 0;
    }

    public Game() {
        while (ramdonNumber == 0) {
            ramdonNumber = (int) (Math.random() * 100);
        }
    }

    public int getRamdonNumber() {
        return ramdonNumber;
    }

    public void setRamdonNumber() {
        ramdonNumber = 0;
    }


    public void setUserInput(int Input) {
        userInput = Input;
    }

    public int getUserInput() {
        return userInput;
    }
}

