package kr.co.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCounter = findViewById(R.id.textViewCounter);
    }

    public void increaseCounter(View view) {
        counter++;
        updateCounterText();
    }

    public void decreaseCounter(View view) {
        if (counter > 0) {
            counter--;
            updateCounterText();
        }
    }

    private void updateCounterText() {
        textViewCounter.setText("카운터: " + counter);
    }
}
