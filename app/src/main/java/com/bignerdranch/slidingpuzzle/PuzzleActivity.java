package com.bignerdranch.slidingpuzzle;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bignerdranch.slidingpuzzle.utils.BitmapSplitter;

import java.io.IOException;
import java.io.InputStream;


public class PuzzleActivity extends Activity {

    private Bitmap mBitmapOriginal;
    private Bitmap[] mBitmapSections;

    private ImageView mImageViewOriginal;
    private ImageView mImageViewSection1;
    private ImageView mImageViewSection2;
    private ImageView mImageViewSection3;
    private ImageView mImageViewSection4;
    private ImageView mImageViewSection5;
    private ImageView mImageViewSection6;
    private ImageView mImageViewSection7;
    private ImageView mImageViewSection8;
    private ImageView mImageViewSection9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        mImageViewOriginal = (ImageView) findViewById(R.id.original);
        mImageViewSection1 = (ImageView) findViewById(R.id.section_1);
        mImageViewSection2 = (ImageView) findViewById(R.id.section_2);
        mImageViewSection3 = (ImageView) findViewById(R.id.section_3);
        mImageViewSection4 = (ImageView) findViewById(R.id.section_4);
        mImageViewSection5 = (ImageView) findViewById(R.id.section_5);
        mImageViewSection6 = (ImageView) findViewById(R.id.section_6);
        mImageViewSection7 = (ImageView) findViewById(R.id.section_7);
        mImageViewSection8 = (ImageView) findViewById(R.id.section_8);
        mImageViewSection9 = (ImageView) findViewById(R.id.section_9);

        mBitmapOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        if (mBitmapOriginal != null && mBitmapOriginal.getWidth() == mBitmapOriginal.getHeight()) {
            Log.i("PuzzleActivity", "Image is not null.");
            BitmapSplitter splitter = new BitmapSplitter(mBitmapOriginal);
            mBitmapSections = splitter.getSections();
            mImageViewSection1.setImageBitmap(mBitmapSections[0]);
            mImageViewSection2.setImageBitmap(mBitmapSections[1]);
            mImageViewSection3.setImageBitmap(mBitmapSections[2]);
            mImageViewSection4.setImageBitmap(mBitmapSections[3]);
            mImageViewSection5.setImageBitmap(mBitmapSections[4]);
            mImageViewSection6.setImageBitmap(mBitmapSections[5]);
            mImageViewSection7.setImageBitmap(mBitmapSections[6]);
            mImageViewSection8.setImageBitmap(mBitmapSections[7]);
            mImageViewSection9.setImageBitmap(mBitmapSections[8]);
        } else {
            Log.i("PuzzleActivity", "Image not square.");
        }

    }

}
