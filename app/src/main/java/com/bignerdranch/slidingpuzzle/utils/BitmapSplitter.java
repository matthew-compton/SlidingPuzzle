package com.bignerdranch.slidingpuzzle.utils;

import android.graphics.Bitmap;

public class BitmapSplitter {

    private Bitmap mOriginal;
    private Bitmap[] mSections;

    public BitmapSplitter(Bitmap bitmap) {
        mOriginal = bitmap;
        mSections = split();
    }

    public Bitmap getSection(int i) {
        return mSections[i];
    }

    public Bitmap[] getSections() {
        return mSections;
    }

    /*
     * Splits the Bitmap into 9 equal sections
     */
    private Bitmap[] split() {
        Bitmap[] sections = new Bitmap[9];
        sections[0] = Bitmap.createBitmap(mOriginal, 0,                             0,                              mOriginal.getWidth() / 3,       mOriginal.getHeight() / 3);
        sections[1] = Bitmap.createBitmap(mOriginal, mOriginal.getWidth() / 3,      0,                              2 * mOriginal.getWidth() / 3,   mOriginal.getHeight() / 3);
        sections[2] = Bitmap.createBitmap(mOriginal, 2 * mOriginal.getWidth() / 3,  0,                              mOriginal.getWidth(),           mOriginal.getHeight() / 3);
        sections[3] = Bitmap.createBitmap(mOriginal, 0,                             mOriginal.getHeight() / 3,      mOriginal.getWidth() / 3,       2 * mOriginal.getHeight() / 3);
        sections[4] = Bitmap.createBitmap(mOriginal, mOriginal.getWidth() / 3,      mOriginal.getHeight() / 3,      2 * mOriginal.getWidth() / 3,   2 * mOriginal.getHeight() / 3);
        sections[5] = Bitmap.createBitmap(mOriginal, 2 * mOriginal.getWidth() / 3,  mOriginal.getHeight() / 3,      mOriginal.getWidth(),           2 * mOriginal.getHeight() / 3);
        sections[6] = Bitmap.createBitmap(mOriginal, 0,                             2 * mOriginal.getHeight() / 3,  mOriginal.getWidth() / 3,       mOriginal.getHeight());
        sections[7] = Bitmap.createBitmap(mOriginal, mOriginal.getWidth() / 3,      2 * mOriginal.getHeight() / 3,  2 * mOriginal.getWidth() / 3,   mOriginal.getHeight());
        sections[8] = Bitmap.createBitmap(mOriginal, 2 * mOriginal.getWidth() / 3,  2 * mOriginal.getHeight() / 3,  mOriginal.getWidth(),           mOriginal.getHeight());
        return sections;
    }

}
