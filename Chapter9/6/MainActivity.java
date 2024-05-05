package com.example.rolldice;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DiceView diceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceView = findViewById(R.id.diceView);
        diceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 주사위 이미지를 클릭할 때마다 다시 그리도록 요청합니다.
                diceView.invalidate();
            }
        });
    }
}