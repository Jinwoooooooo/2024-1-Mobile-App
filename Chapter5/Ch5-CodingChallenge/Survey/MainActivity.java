package com.example.survey;

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
                        case "2.3.3":
                            imageResource = R.drawable.image_2_3_3;
                            break;
                        case "4.1":
                            imageResource = R.drawable.image_4_1;
                            break;
                        case "4.4":
                            imageResource = R.drawable.image_4_4;
                            break;
                    }

                    imageView.setImageResource(imageResource);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
