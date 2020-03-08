package com.example.get_app_game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter_ImageModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Muscle> muscles;
    private OnItemClickListener mItemClickListener;

    public Adapter_ImageModel(Context context, ArrayList<Muscle> muscles){
        this.context = context;
        this.muscles = muscles;
    }

    public void updateList(ArrayList<Muscle> muscles){
        this.muscles = muscles;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder){
            final Muscle muscle = getItem(position);
            final ViewHolder genericViewHolder= (ViewHolder)holder;
            genericViewHolder.muscle_img.setImageResource(muscle.getMuscleImgId());
        }
    }

    @Override
    public int getItemCount() {
        if(muscles.size() > 6){
            return 6;
        }else{
            return muscles.size();
        }
    }

    private Muscle getItem(int position){
        return muscles.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageButton muscle_img;

        public ViewHolder(final View itemView){
            super(itemView);
            this.muscle_img = itemView.findViewById(R.id.muscle_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position){
        muscles.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, muscles.size());
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener =mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Muscle muscle);
    }
}
