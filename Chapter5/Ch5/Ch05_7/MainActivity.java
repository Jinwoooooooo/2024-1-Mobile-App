package com.example.ch05_7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox phpCheckbox, javaCheckbox, cCheckbox, cppCheckbox, pythonCheckbox;
    private Button doneButton, cancelButton;
    private TextView selectedLanguagesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phpCheckbox = findViewById(R.id.phpCheckbox);
        javaCheckbox = findViewById(R.id.javaCheckbox);
        cCheckbox = findViewById(R.id.cCheckbox);
        cppCheckbox = findViewById(R.id.cppCheckbox);
        pythonCheckbox = findViewById(R.id.pythonCheckbox);
        doneButton = findViewById(R.id.doneButton);
        cancelButton = findViewById(R.id.cancelButton);
        selectedLanguagesTextView = findViewById(R.id.selectedLanguagesTextView);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedLanguages();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearSelection();
            }
        });
    }

    private void displaySelectedLanguages() {
        StringBuilder selectedLanguages = new StringBuilder();

        if (phpCheckbox.isChecked()) {
            selectedLanguages.append("PHP  ");
        }
        if (javaCheckbox.isChecked()) {
            selectedLanguages.append("JAVA  ");
        }
        if (cCheckbox.isChecked()) {
            selectedLanguages.append("C  ");
        }
        if (cppCheckbox.isChecked()) {
            selectedLanguages.append("C++  ");
        }
        if (pythonCheckbox.isChecked()) {
            selectedLanguages.append("PYTHON  ");
        }

        if (selectedLanguages.length() > 0) {
            selectedLanguagesTextView.setText(selectedLanguages.toString());
        } else {
            selectedLanguagesTextView.setText("선택된 언어가 없습니다.");
        }
    }

    private void clearSelection() {
        phpCheckbox.setChecked(false);
        javaCheckbox.setChecked(false);
        cCheckbox.setChecked(false);
        cppCheckbox.setChecked(false);
        pythonCheckbox.setChecked(false);
        selectedLanguagesTextView.setText("");
    }
}
