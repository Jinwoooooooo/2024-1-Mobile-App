package com.example.returnstring;

// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SUB_ACTIVITY = 1001;
    private TextView tvReturnedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenSubActivity = findViewById(R.id.btnOpenSubActivity);
        btnOpenSubActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SUB_ACTIVITY);
            }
        });

        tvReturnedString = findViewById(R.id.tvReturnedString);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SUB_ACTIVITY) {
            if (resultCode == RESULT_OK && data != null) {
                String returnedString = data.getStringExtra("RETURNED_STRING");
                tvReturnedString.setText("반환된 문자열: " + returnedString);
            }
        }
    }
}

