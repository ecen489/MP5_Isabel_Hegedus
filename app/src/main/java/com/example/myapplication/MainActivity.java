package com.example.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    MediaPlayer[] mpList= new MediaPlayer[3];
    int sel=0;
    ImageView[] imgList= new ImageView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpList[0]= MediaPlayer.create(this,R.raw.worksong);
        mpList[1]= MediaPlayer.create(this,R.raw.dermotkennedyglory);
        mpList[2]= MediaPlayer.create(this,R.raw.goodtobealone);

        imgList[0]=findViewById(R.id.hozier_im);
        imgList[1]=findViewById(R.id.kennedy_im);
        imgList[2]=findViewById(R.id.corby_im);


        RadioGroup g = findViewById(R.id.rad);
        g.setOnCheckedChangeListener(this);

    }
    public void b_start(View v){
        if(!mpList[sel].isPlaying()){
            mpList[sel].start();
        }
    }
    public void b_stop(View v){
        if(mpList[sel].isPlaying()) {
            mpList[sel].stop();
            try{mpList[sel].prepare();}
            catch (Exception e){

            }
        }
    }
    public void onCheckedChanged(RadioGroup group,int checkedId){
        if(mpList[sel].isPlaying()) {
            mpList[sel].stop();
            try{mpList[sel].prepare();}
            catch (Exception e){

            }
        }
        hideImage();
        System.out.print(checkedId);
        sel=checkedId-1;
        showImage();
    }
    public void hideImage(){
        imgList[sel].setVisibility(View.GONE);
    }

    public void showImage(){
        imgList[sel].setVisibility(View.VISIBLE);

    }
}
