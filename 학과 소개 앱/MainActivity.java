package com.example.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnIntro, btnProfessors, btnNews, btnFacilities, btnStudentActivities, btnEmployment, btnCurriculum, btnAiEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntro = findViewById(R.id.button_intro);
        btnProfessors = findViewById(R.id.button_professors);
        btnNews = findViewById(R.id.button_news);
        btnFacilities = findViewById(R.id.button_facilities);
        btnStudentActivities = findViewById(R.id.button_student_activities);
        btnEmployment = findViewById(R.id.button_employment);
        btnCurriculum = findViewById(R.id.button_curriculum);
        btnAiEducation = findViewById(R.id.button_ai_education);

        btnIntro.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN4000016"));
        btnProfessors.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN4000017"));
        btnNews.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN4000038"));
        btnFacilities.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN4000022"));
        btnStudentActivities.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN9000043"));
        btnEmployment.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN9000065"));
        btnCurriculum.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN9000057"));
        btnAiEducation.setOnClickListener(view -> openWebPage("https://www.dit.ac.kr/cs/index.php?pCode=MN9000060"));
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
