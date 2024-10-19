package com.cookandroid.project10_2;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView[] tv;
    private RatingBar[] rbar;
    private Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6,
            R.id.tv7, R.id.tv8, R.id.tv9};
    private Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6,
            R.id.rbar7, R.id.rbar8, R.id.rbar9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("投票结果");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        if (voteResult != null && imageName != null && voteResult.length == imageName.length) {
            initializeViews();
            displayVoteResults(voteResult, imageName);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Integer imageFile[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
                R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
    }

    private void initializeViews() {
        tv = new TextView[tvID.length];
        rbar = new RatingBar[rbarID.length];

        for (int i = 0; i < tvID.length; i++) {
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }
    }

    private void displayVoteResults(int[] voteResult, String[] imageName) {
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating(voteResult[i]);
        }
    }
}
