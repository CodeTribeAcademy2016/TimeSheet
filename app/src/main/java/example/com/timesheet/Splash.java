package example.com.timesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        //final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        // final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);

        // Animation fadeIn = new AlphaAnimation(0,1);
        // fadeIn.setInterpolator(new DecelerateInterpolator());
        // fadeIn.setDuration(1000);

        //Animation fadeOut = new AlphaAnimation(1,0);
        // fadeIn.setInterpolator(new DecelerateInterpolator());
        // fadeOut.setStartOffset(1000);
        //fadeIn.setDuration(1000);

        // AnimationSet animation = new AnimationSet(false); //change to false
        // animation.addAnimation(fadeIn);
        // animation.addAnimation(fadeOut);
        //iv.setAnimation(animation);


        //ImageView myView = (ImageView)splashDaialog.findViewById(R.id.imageView);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(iv, "alpha", 1f, .3f);
        fadeOut.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(iv, "alpha", .3f, 1f);
        fadeIn.setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();

            }


        });
       // mAnimationSet.start();


    }
}
