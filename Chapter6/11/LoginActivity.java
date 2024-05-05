package com.example.loginwindow;

// LoginActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextId = findViewById(R.id.editTextId);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String password = editTextPassword.getText().toString();

                Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("PASSWORD", password);
                startActivity(intent);
            }
        });
    }
}
