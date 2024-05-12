package com.example.rotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText angleEditText;
    private Button rotateButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleEditText = findViewById(R.id.angleEditText);
        rotateButton = findViewById(R.id.rotateButton);
        imageView = findViewById(R.id.imageView);

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateImage();
            }
        });
    }

    private void rotateImage() {
        // 사용자가 입력한 각도 가져오기
        String angleStr = angleEditText.getText().toString();
        if (angleStr.isEmpty()) {
            return; // 각도가 입력되지 않았으면 종료
        }

        // 입력된 각도에 따라 이미지 회전
        float angle = Float.parseFloat(angleStr);
        imageView.setRotation(angle);
    }
}
