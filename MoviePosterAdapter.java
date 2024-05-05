package com.example.movieposter;

// MoviePosterAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterAdapter.ViewHolder> {

    private Context context;
    private List<Integer> moviePosterDrawables;

    public MoviePosterAdapter(Context context, List<Integer> moviePosterDrawables) {
        this.context = context;
        this.moviePosterDrawables = moviePosterDrawables;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie_poster, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int posterDrawable = moviePosterDrawables.get(position);
        holder.imageViewMoviePoster.setImageResource(posterDrawable);
    }

    @Override
    public int getItemCount() {
        return moviePosterDrawables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewMoviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewMoviePoster = itemView.findViewById(R.id.imageViewMoviePoster);
        }
    }
}

