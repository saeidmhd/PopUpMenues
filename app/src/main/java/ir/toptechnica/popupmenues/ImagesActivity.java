package ir.toptechnica.popupmenues;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.toptechnica.popupmenues.adapter.CustomPagerAdapter;

public class ImagesActivity extends AppCompatActivity {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    int index;

    int[] FXS = {
            R.drawable.fragx1,
            R.drawable.fragx2
    };

    int[] DOWN = {
            R.drawable.drill,
            R.drawable.boy_with_down_syndrome
    };
    int[] Asperger = {
            R.drawable.autism_stacking,
            R.drawable.riboflavin_penicillinamide
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);



        mViewPager = (ViewPager) findViewById(R.id.pager);


        if (getIntent()!=null && getIntent().hasExtra(Intent.EXTRA_TEXT )) {
            index = getIntent().getIntExtra(Intent.EXTRA_TEXT,0);
            switch(index){

                case 0:

                    mCustomPagerAdapter = new CustomPagerAdapter(this,FXS);
                    mViewPager.setAdapter(mCustomPagerAdapter);
                    break;
                case 1:

                    mCustomPagerAdapter = new CustomPagerAdapter(this,DOWN);
                    mViewPager.setAdapter(mCustomPagerAdapter);
                    break;
                case 2:

                    mCustomPagerAdapter = new CustomPagerAdapter(this,Asperger);
                    mViewPager.setAdapter(mCustomPagerAdapter);
                    break;


            }


        }

    }
}
