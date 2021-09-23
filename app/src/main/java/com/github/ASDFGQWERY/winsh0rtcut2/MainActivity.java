package com.github.ASDFGQWERY.winsh0rtcut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String lang1 = Locale.getDefault().getLanguage();
        //Toast.makeText(this, lang1, Toast.LENGTH_SHORT).show();

        ImageView tbl = findViewById(R.id.tbl1);
        AssetManager assets = getResources().getAssets();

        if (lang1=="zh"){
            try (InputStream istream1 = assets.open("SC01b-zh.png")){
                Bitmap bitmap = BitmapFactory.decodeStream(istream1);
                tbl.setImageBitmap(bitmap);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try (InputStream istream1 = assets.open("SC01b.png")){
                Bitmap bitmap = BitmapFactory.decodeStream(istream1);
                tbl.setImageBitmap(bitmap);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


}