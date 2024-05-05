package com.example.loginwindow;

// SecondActivity.java
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewId = findViewById(R.id.textViewId);
        TextView textViewPassword = findViewById(R.id.textViewPassword);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("ID");
            String password = extras.getString("PASSWORD");

            textViewId.setText("아이디: " + id);
            textViewPassword.setText("패스워드: " + password);
        }
    }
}
