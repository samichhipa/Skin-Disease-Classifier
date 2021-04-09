package com.example.arkadeep.skindiseaseclassifier.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arkadeep.skindiseaseclassifier.Camera2BasicFragment;
import com.example.arkadeep.skindiseaseclassifier.R;

import java.util.List;

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.ViewHolder> {

    List<Signs> signsList;
    Context context;
    onItemClickListener mlistener;
    public PicturesAdapter(List<Signs> signsList, Context context) {
        this.signsList = signsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=LayoutInflater.from(context).inflate(R.layout.sign_item_layout,parent,false);
     return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Signs signs=signsList.get(position);

        holder.linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_unselected));
        Glide.with(context).load(signs.image).into(holder.img);
        holder.txt_sign.setText(signs.name);

        if (position==Camera2BasicFragment.isItemSelectedPos){
            holder.linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_selected));
            mlistener.SignClick(signs,holder.linearLayout,position);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Camera2BasicFragment.isItemSelectedPos=position;
                notifyDataSetChanged();
                 // holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                mlistener.SignClick(signs,holder.linearLayout,position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return signsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView txt_sign;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.sign_image);
            txt_sign=itemView.findViewById(R.id.sign_name);
            linearLayout=itemView.findViewById(R.id.selectd_bg);
        }
    }


    public interface onItemClickListener {

        void SignClick(Signs signs,LinearLayout linearLayout,int position);

    }
    public void setOnItemClickListener(onItemClickListener listener) {


        mlistener = listener;


    }
}
