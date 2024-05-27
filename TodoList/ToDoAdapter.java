package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<ToDoItem> toDoList;

    public ToDoAdapter(List<ToDoItem> toDoList) {
        this.toDoList = toDoList;
    }

    public static class ToDoViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CheckBox checkBox;
        public ImageButton deleteButton;

        public ToDoViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewItem);
            checkBox = view.findViewById(R.id.checkBox);
            deleteButton = view.findViewById(R.id.buttonDelete);
        }
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDoItem item = toDoList.get(position);
        holder.textView.setText(item.getText());
        holder.checkBox.setChecked(item.isCompleted());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> item.setCompleted(isChecked));

        holder.deleteButton.setOnClickListener(v -> {
            toDoList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
