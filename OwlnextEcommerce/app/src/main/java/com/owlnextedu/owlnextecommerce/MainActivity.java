package com.owlnextedu.owlnextecommerce;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout bottomItem;
    private LinearLayout bottomStore;
    private LinearLayout bottomCart;

    private ImageView topAI;

    private CardView cardView1;
    private CardView cardView3;

    private MediaPlayer m = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTopButton();
        setupBottomButton();
        setupCard();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            checkPermission();
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
                        != PackageManager.PERMISSION_GRANTED)
        {//Can add more as per requirement

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA,Manifest.permission.INTERNET},
                    123);
        } else {


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void setupBottomButton(){
        bottomItem = this.findViewById(R.id.bottom_item);
        bottomCart = this.findViewById(R.id.bottom_cart);
        bottomStore = this.findViewById(R.id.bottom_store);

        bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Toast.makeText(getApplicationContext(), "You are currently at this page already", Toast.LENGTH_SHORT).show();
            }
        });

        bottomStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(MainActivity.this,StoreActivity.class);
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
                Intent intent = new Intent(MainActivity.this,AIActivity.class);
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
                Intent intent = new Intent(MainActivity.this,ItemActivity1.class);
                startActivity(intent);
                playButtonClick();
            }
        });

        cardView3 = this.findViewById(R.id.card3);

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ItemActivity3.class);
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
