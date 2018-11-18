package com.owlnextedu.owlnextecommerce;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AIActivity extends AppCompatActivity{

    private LinearLayout bottomItem;
    private LinearLayout bottomStore;
    private LinearLayout bottomCart;

    private CardView fashionAICard;

    private MediaPlayer m = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        setupBottomButton();
        setupCard();
    }

    private void setupCard(){
        fashionAICard= this.findViewById(R.id.ai_feature_card);

        fashionAICard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(AIActivity.this, CameraActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setupBottomButton(){
        bottomItem = this.findViewById(R.id.bottom_item);
        bottomCart = this.findViewById(R.id.bottom_cart);
        bottomStore = this.findViewById(R.id.bottom_store);

        bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(AIActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(AIActivity.this,StoreActivity.class);
                startActivity(intent);
                finish();            }
        });

        bottomCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
