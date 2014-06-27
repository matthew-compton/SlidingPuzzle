package com.bignerdranch.slidingpuzzle;

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

        int one_third = mOriginal.getWidth() / 3;
        int two_third = 2 * mOriginal.getWidth() / 3;

        sections[0] = Bitmap.createBitmap(mOriginal, 0, 0, one_third, one_third);
        sections[1] = Bitmap.createBitmap(mOriginal, one_third, 0, one_third, one_third);
        sections[2] = Bitmap.createBitmap(mOriginal, two_third, 0, one_third, one_third);
        sections[3] = Bitmap.createBitmap(mOriginal, 0, one_third, one_third, one_third);
        sections[4] = Bitmap.createBitmap(mOriginal, one_third, one_third, one_third, one_third);
        sections[5] = Bitmap.createBitmap(mOriginal, two_third, one_third, one_third, one_third);
        sections[6] = Bitmap.createBitmap(mOriginal, 0, two_third, one_third, one_third);
        sections[7] = Bitmap.createBitmap(mOriginal, one_third, two_third, one_third, one_third);
        sections[8] = Bitmap.createBitmap(mOriginal, two_third, two_third, one_third, one_third);

        return sections;
    }

}
