package com.royal.myfinalapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageGallary extends AppCompatActivity {


    Button btnGallery , btncamera;
    private ImageView imgdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallary);
        btnGallery = findViewById(R.id.btn);
       imgdp = (ImageView)findViewById(R.id.img_gallary);
       btncamera = findViewById(R.id.btn_camera);

       btnGallery.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent();
               i.setType("image/*");
               i.setAction(Intent.ACTION_PICK);
               startActivityForResult(i,11);
           }
       });
       btncamera.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent();
               i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(i,12);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11)
        {
            Uri uri = data.getData();
            imgdp.setImageURI(uri);

        }

        if(requestCode == 12){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgdp.setImageBitmap(bitmap);
        }
    }
}