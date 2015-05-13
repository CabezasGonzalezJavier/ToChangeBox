package com.thedeveloperworldisyours.box.activities;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.thedeveloperworldisyours.box.R;
import com.thedeveloperworldisyours.box.Utils.Constans;
import com.thedeveloperworldisyours.box.adapters.ImageAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private List<String> mColors;

    private String[] mColorsArray = new String[Constans.NUMBER];
    private String[] mNewColorsArray = new String[Constans.NUMBER];
    private ImageAdapter mImageAdapter;
    GridView mGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mColors = new ArrayList<String>();

        randonColors();

        mGridview = (GridView) findViewById(R.id.activity_main_gridview);

        paintGridView();
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                refresh(position);
            }
        });
    }

    public void paintGridView(){
        mImageAdapter = new ImageAdapter(this,mColors);
        mGridview.setAdapter(mImageAdapter);
    }

    public void refresh(int position){
        mImageAdapter.clear();
        mNewColorsArray = new String[Constans.NUMBER];
        changeColor(position);
        paintListColorAgain();
        paintGridView();
        mColorsArray = mNewColorsArray;
    }

    public void randonColors(){

        for (int i=0; i<Constans.NUMBER; i++){
            String colorArray[] = getResources().getStringArray(R.array.colorsArray);
            Random rand = new Random();
            int randomNum = rand.nextInt((colorArray.length - 1) + 1) + 0;
            mColorsArray[i]=colorArray[randomNum];
            mColors.add(i, colorArray[randomNum]);
        }
    }

    public void changeColor(int position){
        for (int i=0; i <mColorsArray.length; i++){
            if(i!= position){
                mNewColorsArray[i]=mColorsArray[i];
            }else{
                colorPlacedAtTheEnd(position);
                break;
            }
        }
    }

    public void colorPlacedAtTheEnd(int position){
        for (int i=position; i <mColorsArray.length-1; i++){
            mNewColorsArray[i]= mColorsArray[i+1];
        }
        mNewColorsArray[Constans.NUMBER-1]= mColorsArray[position];
    }

    public void paintListColorAgain(){
        for (int i=0; i<Constans.NUMBER; i++){
            mColors.add(i, mNewColorsArray[i]);
        }
    }

}
