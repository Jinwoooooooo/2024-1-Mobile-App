package com.example.imagedrag;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private float lastX, lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = event.getRawX() - imageView.getX();
                        lastY = event.getRawY() - imageView.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getRawX() - lastX;
                        float newY = event.getRawY() - lastY;
                        moveImage(newX, newY);
                        break;
                }
                return true;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void moveImage(float newX, float newY) {
        imageView.setX(newX);
        imageView.setY(newY);
    }
}


