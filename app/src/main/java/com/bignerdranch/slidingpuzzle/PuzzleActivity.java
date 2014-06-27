package com.bignerdranch.slidingpuzzle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class PuzzleActivity extends Activity {

    private TextView mMovesTextView;
    private TextView mVictoryTextView;
    private Button mRestartButton;

    private CardView mCardView0;
    private CardView mCardView1;
    private CardView mCardView2;
    private CardView mCardView3;
    private CardView mCardView4;
    private CardView mCardView5;
    private CardView mCardView6;
    private CardView mCardView7;
    private CardView mCardView8;

    private Bitmap mBitmapOriginal;
    private Bitmap[] mBitmapSections;

    private int mEmptyPosition;
    private int mMoveCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        mMovesTextView = (TextView) findViewById(R.id.text_moves);
        mVictoryTextView = (TextView) findViewById(R.id.text_victory);

        mRestartButton = (Button) findViewById(R.id.button_restart);
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });

        restart();
    }

    private void restart() {
        setupCards();
        setupBitmaps();
        setupImages();

        mEmptyPosition = 8;
        mBitmapSections[mEmptyPosition] = BitmapFactory.decodeResource(getResources(), R.drawable.empty);

        mMoveCounter = 0;
        randomizeStartingBoard();

        mMoveCounter = 0;
        mMovesTextView.setText(getString(R.string.moves, mMoveCounter));
        mVictoryTextView.setVisibility(View.INVISIBLE);
    }

    private void setupBitmaps() {
        mBitmapOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        if (mBitmapOriginal != null && mBitmapOriginal.getWidth() == mBitmapOriginal.getHeight()) {
            BitmapSplitter splitter = new BitmapSplitter(mBitmapOriginal);
            mBitmapSections = splitter.getSections();
        }
    }

    private void setupImages() {
        ((ImageView) findViewById(R.id.image0)).setImageBitmap(mBitmapSections[0]);
        ((ImageView) findViewById(R.id.image1)).setImageBitmap(mBitmapSections[1]);
        ((ImageView) findViewById(R.id.image2)).setImageBitmap(mBitmapSections[2]);
        ((ImageView) findViewById(R.id.image3)).setImageBitmap(mBitmapSections[3]);
        ((ImageView) findViewById(R.id.image4)).setImageBitmap(mBitmapSections[4]);
        ((ImageView) findViewById(R.id.image5)).setImageBitmap(mBitmapSections[5]);
        ((ImageView) findViewById(R.id.image6)).setImageBitmap(mBitmapSections[6]);
        ((ImageView) findViewById(R.id.image7)).setImageBitmap(mBitmapSections[7]);
        ((ImageView) findViewById(R.id.image8)).setImageBitmap(mBitmapSections[8]);
    }

    private void setupCards() {
        mCardView0 = (CardView) findViewById(R.id.card0);
        mCardView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(0);
            }
        });

        mCardView1 = (CardView) findViewById(R.id.card1);
        mCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(1);
            }
        });

        mCardView2 = (CardView) findViewById(R.id.card2);
        mCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(2);
            }
        });

        mCardView3 = (CardView) findViewById(R.id.card3);
        mCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(3);
            }
        });

        mCardView4 = (CardView) findViewById(R.id.card4);
        mCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(4);
            }
        });

        mCardView5 = (CardView) findViewById(R.id.card5);
        mCardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(5);
            }
        });

        mCardView6 = (CardView) findViewById(R.id.card6);
        mCardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(6);
            }
        });

        mCardView7 = (CardView) findViewById(R.id.card7);
        mCardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(7);
            }
        });

        mCardView8 = (CardView) findViewById(R.id.card8);
        mCardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap(8);
            }
        });

    }

    private void swap(int position) {
        if (isAdjacentToEmpty(position)) {
            mMoveCounter++;
            mMovesTextView.setText(getString(R.string.moves, mMoveCounter));

            Bitmap tmp = mBitmapSections[position];
            mBitmapSections[position] = mBitmapSections[mEmptyPosition];
            mBitmapSections[mEmptyPosition] = tmp;
            mEmptyPosition = position;
            setupImages();

            checkForVictory();
        }
    }

    private boolean isAdjacentToEmpty(int position) {
        switch (mEmptyPosition) {
            case 0:
                return (position == 1 || position == 3);
            case 1:
                return (position == 0 || position == 2 || position == 4);
            case 2:
                return (position == 1 || position == 5);
            case 3:
                return (position == 0 || position == 4 || position == 6);
            case 4:
                return (position == 1 || position == 3 || position == 5 || position == 7);
            case 5:
                return (position == 2 || position == 4 || position == 8);
            case 6:
                return (position == 3 || position == 7);
            case 7:
                return (position == 4 || position == 6 || position == 8);
            case 8:
                return (position == 5 || position == 7);
            default:
                return false;
        }
    }

    private void randomizeStartingBoard() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            swap(random.nextInt(8));
        }
    }

    private void checkForVictory() {
        if (false) {
            victory();
        }
    }

    private void victory() {
        mVictoryTextView.setVisibility(View.VISIBLE);
        mCardView0.setOnClickListener(null);
        mCardView1.setOnClickListener(null);
        mCardView2.setOnClickListener(null);
        mCardView3.setOnClickListener(null);
        mCardView4.setOnClickListener(null);
        mCardView5.setOnClickListener(null);
        mCardView6.setOnClickListener(null);
        mCardView7.setOnClickListener(null);
        mCardView8.setOnClickListener(null);
    }

}
