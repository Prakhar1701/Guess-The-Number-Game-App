package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guessthenumber.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    private int noOfGuesses = 0;


    private long backPressedTime;
    private Toast backToast;
    private long validValueToastTime;
    private Toast validValueToast;

    @Override
    public void onBackPressed() {
        if (validValueToastTime + 2000 > System.currentTimeMillis()) {
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
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }


    public void buttonClicked(View view) {
        if (validValueToastTime + 2000 > System.currentTimeMillis()) {
            validValueToast.cancel();
        }
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
        }
        Game GuessTheNumber = new Game();
//        binding.textView71.setText(Integer.toString(GuessTheNumber.getRamdonNumber()));
        if ((binding.editText.getText().toString().matches("")) || (Integer.parseInt(binding.editText.getText().toString()) == 0)) {
            //Note: Conditions in if are order specific.
            validValueToast = Toast.makeText(MainActivity2.this, "Enter a valid value !", Toast.LENGTH_SHORT);
            validValueToastTime = System.currentTimeMillis();
            validValueToast.show();
            binding.editText.setText("");
            return;
        }
        int editTextValue = Integer.parseInt(binding.editText.getText().toString());

        GuessTheNumber.setUserInput(editTextValue);


        switch (noOfGuesses) {
            case 0:
                binding.textView51.setText(binding.editText.getText());

                break;
            case 1:
                binding.textView53.setText(binding.editText.getText());

                break;
            case 2:
                binding.textView55.setText(binding.editText.getText());

                break;
            case 3:
                binding.textView57.setText(binding.editText.getText());

                break;
            case 4:
                binding.textView59.setText(binding.editText.getText());

                break;
            case 5:
                binding.textView61.setText(binding.editText.getText());

                break;
            case 6:
                binding.textView63.setText(binding.editText.getText());

                break;
            case 7:
                binding.textView65.setText(binding.editText.getText());

                break;
            case 8:
                binding.textView67.setText(binding.editText.getText());

                break;
            case 9:
                binding.textView69.setText(binding.editText.getText());
                break;
        }
        binding.editText.setText("");
        if ((GuessTheNumber.getUserInput()) < (GuessTheNumber.getRamdonNumber())) {
            switch (noOfGuesses) {
                case 0:
                    binding.textView52.setText("Guessed Number Is Small !");

                    break;
                case 1:
                    binding.textView54.setText("Guessed Number Is Small !");

                    break;
                case 2:
                    binding.textView56.setText("Guessed Number Is Small !");

                    break;
                case 3:
                    binding.textView58.setText("Guessed Number Is Small !");

                    break;
                case 4:
                    binding.textView60.setText("Guessed Number Is Small !");

                    break;
                case 5:
                    binding.textView62.setText("Guessed Number Is Small !");

                    break;
                case 6:
                    binding.textView64.setText("Guessed Number Is Small !");

                    break;
                case 7:
                    binding.textView66.setText("Guessed Number Is Small !");

                    break;
                case 8:
                    binding.textView68.setText("Guessed Number Is Small !");

                    break;
                case 9:
                    binding.textView70.setText("Guessed Number Is Small !");
                    break;
            }

            noOfGuesses++;
            if (noOfGuesses == 10) {
                Intent ActivityThree = new Intent(this, MainActivity3.class);
                ActivityThree.putExtra("resultOne", "Too Many Guesses !");
                ActivityThree.putExtra("resultTwo", "GAME OVER");
                ActivityThree.putExtra("resultThree", "0");
                ActivityThree.putExtra("resultFour", GuessTheNumber.getRamdonNumber());
//              ActivityThree.putExtra("resultFour","Correct Number : ".concat(String.valueOf( GuessTheNumber.getRamdonNumber())));  //Another Method
                GuessTheNumber.setRamdonNumber(); //To change random value when played again.
                if (validValueToastTime + 2000 > System.currentTimeMillis()) {
                    validValueToast.cancel();
                }
                finish(); //To exit this activity;
                startActivity(ActivityThree);
            }


        } else if ((GuessTheNumber.getUserInput()) > (GuessTheNumber.getRamdonNumber())) {
            switch (noOfGuesses) {
                case 0:
                    binding.textView52.setText("Guessed Number Is Big !");

                    break;
                case 1:
                    binding.textView54.setText("Guessed Number Is Big !");

                    break;
                case 2:
                    binding.textView56.setText("Guessed Number Is Big !");

                    break;
                case 3:
                    binding.textView58.setText("Guessed Number Is Big !");

                    break;
                case 4:
                    binding.textView60.setText("Guessed Number Is Big !");

                    break;
                case 5:
                    binding.textView62.setText("Guessed Number Is Big !");

                    break;
                case 6:
                    binding.textView64.setText("Guessed Number Is Big !");

                    break;
                case 7:
                    binding.textView66.setText("Guessed Number Is Big !");

                    break;
                case 8:
                    binding.textView68.setText("Guessed Number Is Big !");

                    break;
                case 9:
                    binding.textView70.setText("Guessed Number Is Big !");
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
                if (validValueToastTime + 2000 > System.currentTimeMillis()) {
                    validValueToast.cancel();
                }
                finish(); //To exit this activity;
                startActivity(ActivityThree);
            }


        } else {

            switch (noOfGuesses) {
                case 0:
                    binding.textView52.setText("Guessed Number Is Correct !");

                    break;
                case 1:
                    binding.textView54.setText("Guessed Number Is Correct !");

                    break;
                case 2:
                    binding.textView56.setText("Guessed Number Is Correct !");

                    break;
                case 3:
                    binding.textView58.setText("Guessed Number Is Correct !");

                    break;
                case 4:
                    binding.textView60.setText("Guessed Number Is Correct !");

                    break;
                case 5:
                    binding.textView62.setText("Guessed Number Is Correct !");

                    break;
                case 6:
                    binding.textView64.setText("Guessed Number Is Correct !");

                    break;
                case 7:
                    binding.textView66.setText("Guessed Number Is Correct !");

                    break;
                case 8:
                    binding.textView68.setText("Guessed Number Is Correct !");

                    break;
                case 9:
                    binding.textView70.setText("Guessed Number Is Correct !");
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
            if (validValueToastTime + 2000 > System.currentTimeMillis()) {
                validValueToast.cancel();
            }
            finish(); //To exit this activity;
            startActivity(ActivityThree);

        }
    }

    public void resetGame(View view) {
        if (validValueToastTime + 2000 > System.currentTimeMillis()) {
            validValueToast.cancel();
        }
        Game GuessTheNumber = new Game();
        GuessTheNumber.setRamdonNumber();
        Intent ActivityTwo = new Intent(this, MainActivity2.class);
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
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

