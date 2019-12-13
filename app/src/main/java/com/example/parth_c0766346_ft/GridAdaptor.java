package com.example.parth_c0766346_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdaptor extends BaseAdapter {

    Context context;
    int[] allImages;

    public GridAdaptor(Context context, int[] images){
        this.context = context;
        this.allImages = images;
    }


    @Override
    public int getCount() {
        return allImages.length;
    }

    @Override
    public Object getItem(int position) {
        return allImages[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_traffic, null);

            ImageView imageView = convertView.findViewById(R.id.trafficI);
            imageView.setImageResource(allImages[position]);

        }

        return convertView;
    }
}
