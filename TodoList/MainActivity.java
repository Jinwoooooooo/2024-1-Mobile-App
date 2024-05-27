package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ToDoItem> toDoList;
    private ToDoAdapter adapter;
    private TextInputEditText editTextNewItem;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNewItem = findViewById(R.id.editTextNewItem);
        buttonAdd = findViewById(R.id.buttonAdd);

        toDoList = new ArrayList<>();
        adapter = new ToDoAdapter(toDoList);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String newItemText = editTextNewItem.getText().toString();
            if (!newItemText.isEmpty()) {
                ToDoItem newItem = new ToDoItem(toDoList.size(), newItemText, false);
                toDoList.add(newItem);
                adapter.notifyItemInserted(toDoList.size() - 1);
                editTextNewItem.setText("");
            }
        });
    }
}

