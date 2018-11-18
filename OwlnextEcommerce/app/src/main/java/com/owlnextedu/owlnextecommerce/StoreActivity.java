package com.owlnextedu.owlnextecommerce;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    private LinearLayout bottomItem;
    private LinearLayout bottomStore;
    private LinearLayout bottomCart;

    private ImageView topAI;

    private CardView cardView1;

    private MediaPlayer m = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        setupBottomButton();
        setupCard();
        setupTopButton();
    }

    private void setupBottomButton(){
        bottomItem = this.findViewById(R.id.bottom_item);
        bottomCart = this.findViewById(R.id.bottom_cart);
        bottomStore = this.findViewById(R.id.bottom_store);

        bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(StoreActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Toast.makeText(getApplicationContext(), "You are currently at this page already", Toast.LENGTH_SHORT).show();
            }
        });

        bottomCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
            }
        });

    }

    private void setupTopButton(){
        topAI = this.findViewById(R.id.ai_feature);

        topAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(StoreActivity.this,AIActivity.class);
                startActivity(intent);
                playButtonClick();
                finish();
            }
        });
    }


    private void setupCard(){
        cardView1=this.findViewById(R.id.card1);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoreActivity.this,StoreActivity1.class);
                startActivity(intent);
                playButtonClick();
            }
        });
    }


    private void playButtonClick(){

        try {
            if (m.isPlaying()) {
                m.stop();
                m.release();
                m = new MediaPlayer();
            }

            AssetFileDescriptor descriptor = getAssets().openFd("android_btn_click.mp3");
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(false);
            m.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
