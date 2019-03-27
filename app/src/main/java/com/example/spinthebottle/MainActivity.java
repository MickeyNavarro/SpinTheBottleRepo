package com.example.spinthebottle;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_spin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_spin = (Button) findViewById(R.id.b_spin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        b_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  int spinDegrees;

                Random r = new Random();

                spinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0, spinDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);
                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                iv_bottle.startAnimation(rotateBottle);

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (spinDegrees % 360 > 0 && spinDegrees % 360 < 90) {
                            //northeast quad has been chosen
                            Toast.makeText(MainActivity.this, "The person to the northeast has been chosen", Toast.LENGTH_SHORT).show();
                        } else if (spinDegrees % 360 > 90 && spinDegrees % 360 < 180) {
                            //southeast quad has been chosen
                            Toast.makeText(MainActivity.this, "The person to the southeast has been chosen", Toast.LENGTH_SHORT).show();
                        } else if (spinDegrees % 360 > 180 && spinDegrees % 360 < 270) {
                            //southwest quad has been chosen
                            Toast.makeText(MainActivity.this, "The person in the southwest quadrant has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //northwest quad has been chosen
                            Toast.makeText(MainActivity.this, "The person in the northwest quadrant has been chosen", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

    }
}
