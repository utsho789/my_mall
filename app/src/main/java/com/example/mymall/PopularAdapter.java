package com.example.mymall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ImageHolder> {

    private Context mcontext;
    private List<Popular> mPopulars;

    public PopularAdapter(Context context, List<Popular>populars){

        mcontext = context;
        mPopulars = populars;

    }


    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=   LayoutInflater.from(mcontext).inflate(R.layout.popular_item,parent,false);

        return new ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {

        Popular popularcars = mPopulars.get(position);
        holder.pr_Name.setText(popularcars.getProduct_title());
        holder.pro_Price.setText(popularcars.getProduct_price());

        Picasso.with(mcontext).load(popularcars.getProduct_image()).placeholder(R.drawable.ic_image_product)

                .fit().centerCrop().into((Target) holder.pro_Image);






    }

    @Override
    public int getItemCount() {
        return mPopulars.size();
    }

    public class ImageHolder extends  RecyclerView.ViewHolder{

        private TextView pr_Name,pro_Price,pro_Image;


        public ImageHolder(@NonNull View itemView) {
            super(itemView);

            pr_Name = itemView.findViewById(R.id.prodNameId);
            pro_Price = itemView.findViewById(R.id.productPrice);
            pro_Image  = itemView.findViewById(R.id.prodImgIOd);


        }
    }

}
