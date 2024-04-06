package com.example.ch5_06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RadioGroup radioGroup;
    private Button showImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        showImageButton = findViewById(R.id.show_image_button);

        showImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                if (checkedId != -1) {
                    RadioButton radioButton = findViewById(checkedId);
                    String text = radioButton.getText().toString();
                    int imageResource = 0;

                    switch (text) {
                        case "새":
                            imageResource = R.drawable.bird;
                            break;
                        case "강아지":
                            imageResource = R.drawable.dog;
                            break;
                        case "고양이":
                            imageResource = R.drawable.cat;
                            break;
                    }

                    imageView.setImageResource(imageResource);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}