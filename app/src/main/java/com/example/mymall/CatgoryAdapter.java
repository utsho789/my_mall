package com.example.mymall;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CatgoryAdapter extends RecyclerView.Adapter<CatgoryAdapter.ImageViewHolder> {

    private Context context;
    private List<Catagory> mcatagory;

    public CatgoryAdapter(Context context, List<Catagory> mcatagory) {
        this.context = context;
        this.mcatagory = mcatagory;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View v =  LayoutInflater.from(context).inflate(R.layout.catagory_item,parent,false);

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        Catagory catagory =  mcatagory.get(position);
        holder.catTitle.setText(catagory.getCatname());
       holder.catTitle.setBackgroundColor(Color.parseColor(catagory.getCatTitlebg()));

       holder.longWrapper.setBackgroundColor(Color.parseColor(catagory.getCatbg()));
        Picasso.with(context)
                .load(catagory.getCaticon()).placeholder(R.drawable.ic_image_product)
                .fit()
                .centerCrop()
                .into(holder.imgicon);






    }

    @Override
    public int getItemCount() {
        return mcatagory.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView catTitle;
        public ImageView imgicon;
        public LinearLayout longWrapper;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            catTitle = itemView.findViewById(R.id.catNameId);
            imgicon = itemView.findViewById(R.id.catImageIcon);
            longWrapper = itemView.findViewById(R.id.iconWrapperId);
        }
    }
}
