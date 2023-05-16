package com.example.fetch_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView2;
    Button button, button1;
    String url = "https://picsum.photos/200/300/?random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button2);


        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadImage();

                    }
                }
        );

        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //imageView2.setImageDrawable(imageView.getDrawable());
                        cachedImage();



                    }
                }
        );
    }

    public void loadImage(){

        Glide.with(this)
                .load(url)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);



    }
    public void cachedImage(){

        Glide.with(this)
                .load(url)
                .fitCenter()
                .placeholder(imageView.getDrawable())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView2);



    }
}