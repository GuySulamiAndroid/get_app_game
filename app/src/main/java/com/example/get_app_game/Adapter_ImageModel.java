package com.example.get_app_game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter_ImageModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_MUSCLES = 0;
    private final int VIEW_EXERCISES = 1;
    private Context context;
    private ArrayList<Muscle> muscles;
    private ArrayList<Exercise> exercises;
    private OnItemClickListener mItemClickListener;

    public Adapter_ImageModel(Context context, ArrayList images){
        this.context = context;
        this.muscles = images;
        this.exercises = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_MUSCLES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list, parent, false);
            return new MuscleViewHolder(view);
        }

        if(viewType == VIEW_EXERCISES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list, parent, false);
            return new ExerciseViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MuscleViewHolder){
            final Muscle muscle = (Muscle)getItem(position, holder);
            final MuscleViewHolder genericViewHolder= (MuscleViewHolder)holder;
            genericViewHolder.muscle_img.setImageResource(muscle.getMuscleImgId());
        }

        if(holder instanceof ExerciseViewHolder){
            final Exercise exercise = (Exercise)getItem(position, holder);
            final ExerciseViewHolder genericViewHolder= (ExerciseViewHolder)holder;
            genericViewHolder.exercise_img.setImageResource(exercise.getExerciseImgId());
        }
    }

    @Override
    public int getItemCount() {
        if(muscles.size() > 6 || exercises.size() > 6){
            return 6;
        }else{
            return muscles.size();
        }
    }

    private Object getItem(int position, RecyclerView.ViewHolder holder){
        if(holder instanceof MuscleViewHolder){
            return muscles.get(position);
        }

        if(holder instanceof ExerciseViewHolder){
            return exercises.get(position);
        }

        return null;
    }

    public class MuscleViewHolder extends RecyclerView.ViewHolder{

        private ImageButton muscle_img;

        public MuscleViewHolder(final View itemView){
            super(itemView);
            this.muscle_img = itemView.findViewById(R.id.chosen_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition(), MuscleViewHolder.this));
                }
            });
        }
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder{

        private ImageButton exercise_img;

        public ExerciseViewHolder(final View itemView){
            super(itemView);
            this.exercise_img = itemView.findViewById(R.id.chosen_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition(), ExerciseViewHolder.this));
                }
            });
        }
    }

    public void removeAt(int position, RecyclerView.ViewHolder holder ){
        if(holder instanceof MuscleViewHolder){
            muscles.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, muscles.size());
        }

        if(holder instanceof ExerciseViewHolder){
            exercises.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, exercises.size());
        }
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener =mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Object relevantObj);
    }
}
