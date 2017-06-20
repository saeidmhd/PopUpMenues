package ir.toptechnica.popupmenues;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ir.toptechnica.popupmenues.data.Syndrome_Model;

public class DescriptionActivity extends AppCompatActivity {


    //view flipper
   // private ViewFlipper vFlipper;
    private float lastX;
    TextView description_text,title_text;
    int index;
    private Syndrome_Model mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fxs);
        mModel = new Syndrome_Model(getApplicationContext());

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.menu_collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.LEFT);
        collapsingToolbarLayout.setExpandedTitleMarginEnd(4);
        collapsingToolbarLayout.setExpandedTitleMarginBottom(172);



        description_text = (TextView) findViewById(R.id.description_text);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setTextSize(16);


        if (getIntent()!=null && getIntent().hasExtra(Intent.EXTRA_TEXT )) {
            index = getIntent().getIntExtra(Intent.EXTRA_TEXT,0);
            description_text.setText(mModel.getSyndrome_Description(index));
            title_text.setText(mModel.getSyndrome_Title(index));
            collapsingToolbarLayout.setTitle(mModel.getSyndrome_Title(index));

        }
        
        else{
            Toast.makeText(this, "no intent", Toast.LENGTH_SHORT).show();
        }

       // vFlipper=(ViewFlipper) findViewById(R.id.vFlipper);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


      //  vFlipper.setAutoStart(true);
      //  vFlipper.setFlipInterval(5000);
       // vFlipper.startFlipping();




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(DescriptionActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*public boolean onTouchEvent(MotionEvent touchEvent) {

        switch (touchEvent.getAction()){

            case MotionEvent.ACTION_DOWN:
                lastX = touchEvent.getX();
                break;

            case MotionEvent.ACTION_UP:
                float currentX = touchEvent.getX();
                // Handling left to right screen swap.
                if (lastX < currentX) {
                    // If there aren't any other children, just break.
                    if (vFlipper.getDisplayedChild() == 0)
                        break;
                    // Next screen comes in from left.
                    vFlipper.setInAnimation(this, R.anim.slide_in_left);
                    // Current screen goes out from right.
                    vFlipper.setOutAnimation(this, R.anim.slide_out_right);
                    // Display next screen.
                    vFlipper.showNext();

                }

                // Handling right to left screen swap.
                if (lastX > currentX) {
                    // If there is a child (to the left), break.
                    if (vFlipper.getDisplayedChild() == 1)
                        break;
                    // Next screen comes in from right.
                    vFlipper.setInAnimation(this, R.anim.slide_in_right);
                    // Current screen goes out from left.
                    vFlipper.setOutAnimation(this, R.anim.slide_out_left);
                    // Display previous screen.
                    vFlipper.showPrevious();
                }

                break;
        }
        return false;


    }*/

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        //Glide.with(this).load("https://unsplash.it/600/300/?random").centerCrop().into(imageView);
        imageView.setImageResource(R.drawable.gen7);
    }

    private void fillFab() {
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating_action_button);
        //fab.setImageDrawable(R.drawable.ic_favorite_border_black_48dp);
        fab.setImageResource(R.drawable.share);
    }




}
