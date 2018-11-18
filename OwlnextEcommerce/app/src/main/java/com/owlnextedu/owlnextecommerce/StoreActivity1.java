package com.owlnextedu.owlnextecommerce;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StoreActivity1 extends AppCompatActivity {

    private Button vrButton;

    private LinearLayout bottomItem;
    private LinearLayout bottomCart;
    private LinearLayout bottomStore;

    private ImageView topAI;

    private MediaPlayer m = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store1);

        vrButton = this.findViewById(R.id.btn_vr);
        vrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoreActivity1.this,VRActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setupBottomButton();
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
                Intent intent = new Intent(StoreActivity1.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(StoreActivity1.this,StoreActivity.class);
                startActivity(intent);
                finish();
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
                Intent intent = new Intent(StoreActivity1.this,AIActivity.class);
                startActivity(intent);
                playButtonClick();
                finish();
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
