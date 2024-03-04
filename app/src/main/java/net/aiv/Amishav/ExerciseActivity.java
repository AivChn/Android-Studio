package net.aiv.Amishav;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {

    private TextView greeting;

    private Button rateButton;
    private TextView rateDisplay;

    private Button multiBoard;
    private Button multiTo20;
    private Button challenge;

    private TextView firstNum;
    private TextView secondNum;
    private EditText answer;
    private Button checkAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        greeting = findViewById(R.id.greeting);

        rateButton = findViewById(R.id.exercise_rate_button);
        rateDisplay = findViewById(R.id.rate_display);

        multiBoard = findViewById(R.id.multiBoard);
        multiTo20 = findViewById(R.id.multiTo20);
        challenge = findViewById(R.id.challengeButton);

        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);
        answer = findViewById(R.id.answerBox);

        checkAnswer = findViewById(R.id.checkButton);

        MainViewModel viewModelMain = new ViewModelProvider(this).get(MainViewModel.class);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String greetingStr = "Hello, " + username;
        greeting.setText(greetingStr);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callingIntent = new Intent(ExerciseActivity.this, RateActivity.class);

                ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(

                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult o) {

                                if (o.getResultCode() == Activity.RESULT_OK) {

                                    int rate = o.getData().getIntExtra("rate", 0);

                                    rateDisplay.setText(String.valueOf(rate));
                                    Toast.makeText(ExerciseActivity.this,
                                            "You rated " + String.valueOf(rate),
                                            Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(ExerciseActivity.this,
                                            "Unknown error",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        }

                );

            }
        });

        multiBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelMain.exerciseMultiBoard();
            }
        });

        multiTo20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelMain.exerciseMultiTo20();
            }
        });

        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelMain.exerciseChallenge();
            }
        });

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answerStr = answer.getText().toString();

                if (answerStr.isEmpty()) {
                    Toast.makeText(ExerciseActivity.this, "You didn't enter an answer!",
                            Toast.LENGTH_SHORT).show();
                } else if (firstNum.getText().toString().isEmpty())
                    Toast.makeText(ExerciseActivity.this, "You didn't choose an exercise!",
                            Toast.LENGTH_SHORT).show();
                else {

                    int answerInt = Integer.parseInt(answerStr);
                    boolean isCorrect = viewModelMain.checkAnswer(answerInt);

                    Toast.makeText(ExerciseActivity.this,
                            (isCorrect ? "Correct!" : "Incorrect!"), Toast.LENGTH_SHORT).show();

                }

            }
        });

        viewModelMain.getFirstNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer num) {
                firstNum.setText(num);
            }
        });

        viewModelMain.getSecondNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer num) {
                secondNum.setText(num);
            }
        });



    }
}