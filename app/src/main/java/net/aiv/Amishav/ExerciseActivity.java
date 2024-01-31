package net.aiv.Amishav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {

    private TextView greeting;

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