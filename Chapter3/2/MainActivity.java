package com.example.random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText guessEditText;
    private Button submitBtn;
    private TextView hintTextView;

    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessEditText = findViewById(R.id.guessEditText);
        submitBtn = findViewById(R.id.submitBtn);
        hintTextView = findViewById(R.id.hintTextView);

        // 컴퓨터가 정답을 선택
        Random random = new Random();
        answer = random.nextInt(100) + 1;

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        // 사용자가 입력한 정수 가져오기
        String guessStr = guessEditText.getText().toString();
        if (guessStr.isEmpty()) {
            Toast.makeText(this, "정수를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        int guess = Integer.parseInt(guessStr);

        // 정답 확인 및 힌트 표시
        if (guess == answer) {
            hintTextView.setText("정답입니다!");
        } else if (guess < answer) {
            hintTextView.setText("더 높은 수를 입력하세요.");
        } else {
            hintTextView.setText("더 낮은 수를 입력하세요.");
        }
    }
}
