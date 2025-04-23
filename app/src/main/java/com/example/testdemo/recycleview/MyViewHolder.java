package com.example.testdemo.recycleview;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testdemo.R;

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.iv);
    }

}