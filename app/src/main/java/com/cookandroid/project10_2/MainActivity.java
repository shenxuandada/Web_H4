package com.cookandroid.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i < voteCount.length; i++) {
            voteCount[i] = 0;
        }

        ImageView image[] = new ImageView[9];
        final String imgName[] = {"예술1", "예술2", "예술3", "예술4", "예술5",
                "예술6", "예술7", "예술8", "예술9"};

        for (int i = 0; i < image.length; i++) {
            final int index = i;
            image[index] = findViewById(getResources().getIdentifier("iv" + (index + 1), "id", getPackageName()));
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ":총수" + voteCount[index] + "표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });

    }
}