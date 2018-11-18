package com.owlnextedu.owlnextecommerce;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import im.delight.android.webview.AdvancedWebView;

public class CameraActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    private LinearLayout bottomItem;
    private LinearLayout bottomStore;
    private LinearLayout bottomCart;

    private ImageView topAI;

    private MediaPlayer m = new MediaPlayer();

    private AdvancedWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.loadUrl("https://cogniticsapi.firebaseapp.com");

        // ...
        setupBottomButton();
        setupTopButton();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) { }

    @Override
    public void onPageFinished(String url) { }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) { }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }


    private void setupBottomButton(){
        bottomItem = this.findViewById(R.id.bottom_item);
        bottomCart = this.findViewById(R.id.bottom_cart);
        bottomStore = this.findViewById(R.id.bottom_store);

        bottomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(CameraActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
                Intent intent = new Intent(CameraActivity.this,StoreActivity.class);
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
                Intent intent = new Intent(CameraActivity.this,AIActivity.class);
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

//
//    private void uploadToFirebase(Bitmap bitmap){
////        progressDialog.show();
//        final StorageReference ref = storageReference.child("drivers/test.jpg");
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
//        byte[] data = baos.toByteArray();
//
//        final UploadTask uploadTask = ref.putBytes(data);
//        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
////                progressDialog.dismiss();
//                Toast.makeText(CameraActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
//
//                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
//                    @Override
//                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
//                        if (!task.isSuccessful()) {
//                            throw task.getException();
//                        }
//                        return ref.getDownloadUrl();
//                    }
//                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Uri> task) {
//                        if (task.isSuccessful()) {
//                            Uri downUri = task.getResult();
//                            Log.d("Final URL", "onComplete: Url: " + downUri.toString());
//                        }
//                    }
//                });
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
////                progressDialog.dismiss();
//                Toast.makeText(CameraActivity.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
