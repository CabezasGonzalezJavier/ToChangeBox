package com.thedeveloperworldisyours.box.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.thedeveloperworldisyours.box.R;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 13/5/15.
 */
public class ImageAdapter extends ArrayAdapter<String> {
    private Activity mActivity;
    private List<String> mColors;

    // Constructor
    public ImageAdapter(Activity activity,List<String> colors) {
        super(activity,0,colors);
        mActivity = activity;
        mColors = colors;
    }

    static class ViewHolder {
        ImageView imageView;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mActivity);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setBackgroundColor(Color.parseColor(mColors.get(position)));


        return imageView;
    }
}