package com.example.movieposter;

// MainActivity.java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MoviePosterAdapter adapter;
    private List<Integer> moviePosterDrawables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        moviePosterDrawables = new ArrayList<>();
        // drawable에 추가한 포스터 이미지의 ID를 리스트에 추가
        moviePosterDrawables.add(R.drawable.poster1);
        moviePosterDrawables.add(R.drawable.poster2);
        moviePosterDrawables.add(R.drawable.poster3);
        moviePosterDrawables.add(R.drawable.poster4);
        moviePosterDrawables.add(R.drawable.poster1);
        moviePosterDrawables.add(R.drawable.poster2);
        moviePosterDrawables.add(R.drawable.poster3);
        moviePosterDrawables.add(R.drawable.poster4);
        moviePosterDrawables.add(R.drawable.poster1);
        moviePosterDrawables.add(R.drawable.poster2);
        moviePosterDrawables.add(R.drawable.poster3);
        moviePosterDrawables.add(R.drawable.poster4);
        moviePosterDrawables.add(R.drawable.poster1);
        moviePosterDrawables.add(R.drawable.poster2);
        moviePosterDrawables.add(R.drawable.poster3);
        moviePosterDrawables.add(R.drawable.poster4);
        moviePosterDrawables.add(R.drawable.poster1);
        moviePosterDrawables.add(R.drawable.poster2);
        moviePosterDrawables.add(R.drawable.poster3);
        moviePosterDrawables.add(R.drawable.poster4);
        // 이하 포스터 이미지의 ID를 추가

        adapter = new MoviePosterAdapter(this, moviePosterDrawables);
        recyclerView.setAdapter(adapter);
    }
}

