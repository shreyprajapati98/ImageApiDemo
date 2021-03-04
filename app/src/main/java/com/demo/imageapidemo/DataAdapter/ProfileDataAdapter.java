package com.demo.imageapidemo.DataAdapter;

import android.content.Context;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.demo.imageapidemo.Model.ProfileResponse;
import com.demo.imageapidemo.R;


import java.util.List;

public class ProfileDataAdapter extends RecyclerView.Adapter<
        ProfileDataAdapter.MyViewHolder> {

    private List<ProfileResponse> profileDataList;
    private Context context;

  ;

    static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView photo;
        ProgressBar pb_image;
        MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.tvname1);
            photo = (ImageView) view.findViewById(R.id.imageView);
            pb_image = (ProgressBar) view.findViewById(R.id.pb_main);
        }
    }
    public  ProfileDataAdapter(Context context,List<ProfileResponse> profileDataList){
        this.context = context;
        this.profileDataList = profileDataList;
    }
    @NonNull
    @Override
    public ProfileDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_apidata,parent,false);

        return new ProfileDataAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProfileDataAdapter.MyViewHolder holder, int position) {

        ProfileResponse data = profileDataList.get(position);
        holder.name.setText(data.getTitle());
        Log.e("TAG", "onBindViewHolder: "+data.getUrl() );
        //Run karto
      //  Uri uri=Uri.parse(data.getUrl());
        //na thai
        //na thai....
        //na thai
//        KEM THATU NATHI
        //ME TO 2 var code lakhyo
        //aavu j aave 6e
//        RE BIJI API APU
//        JO BIJI KOI BHUL HASE NE TATRI TO TU GYO
        //PAN me badhu check karyu tame aek var joi lo
//        HU BADHU THODI CHECK KARVA BESIS LA... TNE AVDE J CHE PAN KOI NORMAL BHUL HASE NE TO GIYO LALA TU...
        //saru bcz me aaj je nahi that ae github and stakoverflow ma joi lidhu 6e VN LE BIJI API APU
        //saru
        //na thai  error vali image j aave
      //  String imageURL = data.getPhoto();

        /*Picasso.with(context)
                .load("https://www.tutorialspoint.com/images/tp-logo-diamond.png").into(holder.photo, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Log.e("App","Failed to load company logo");
            }
        });*/

        Log.e("TAG", "Step 1");
        Glide.with(context)
                .load("http://agrolee.com/Uploads/Category/ItemImage/140_HybridFennelVolinagmMangalam_09092020_191655_32.png")
                .error(R.drawable.ic_launcher_background)
                .thumbnail(0.01f)
               //.placeholder(R.drawable.progress)
               // .transition(DrawableTransitionOptions.withCrossFade())
              //  .apply(new RequestOptions()
             //           .override(Target.SIZE_ORIGINAL)
             //           .format(DecodeFormat.PREFER_ARGB_8888))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("TAG", "Step 2 " );
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                      //  Glide.with(context).load("http://agrolee.com/Uploads/Category/ItemImage/140_HybridFennelVolinagmMangalam_09092020_191655_32.png").into(holder.photo);
                        Log.e("TAG", "Step 3 ");
                        holder.pb_image.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return profileDataList.size();
    }
}
