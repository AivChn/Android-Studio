package net.aiv.Amishav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = username.getText().toString();
                if (usernameStr.isEmpty())
                    Toast.makeText(LoginActivity.this, "No username entered", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(LoginActivity.this, ExerciseActivity.class);
                    intent.putExtra("username", usernameStr);
                    startActivity(intent);
                }
            }
        });

    }
}