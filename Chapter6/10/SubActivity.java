package com.example.returnstring;

// SubActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final EditText editText = findViewById(R.id.editText);
        Button btnInputDone = findViewById(R.id.btnInputDone);
        btnInputDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("RETURNED_STRING", userInput);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}

