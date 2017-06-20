package ir.toptechnica.popupmenues;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import ir.toptechnica.popupmenues.data.Syndrome_Model;

public class InheritanceActivity extends AppCompatActivity {

    TextView menu_description_text,menu_title_text;
    int index;
    private Syndrome_Model mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        mModel = new Syndrome_Model(getApplicationContext());

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.menu_collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.LEFT);
        collapsingToolbarLayout.setExpandedTitleMarginEnd(4);
        collapsingToolbarLayout.setExpandedTitleMarginBottom(172);

        menu_description_text = (TextView) findViewById(R.id.menu_description_text);
        menu_title_text = (TextView) findViewById(R.id.menu_title_text);
        menu_title_text.setTextSize(16);

        if (getIntent()!=null && getIntent().hasExtra(Intent.EXTRA_TEXT )) {
            index = getIntent().getIntExtra(Intent.EXTRA_TEXT,0);
            switch(index){

                case 0:
                    menu_description_text.setText(mModel.getSyndrome_Inheritance(index));
                    menu_title_text.setText(mModel.getSyndrome_Menu_title(1));
                    collapsingToolbarLayout.setTitle(mModel.getSyndrome_Title(index));
                    break;
                case 1:
                    menu_description_text.setText(mModel.getSyndrome_Inheritance(index));
                    menu_title_text.setText(mModel.getSyndrome_Menu_title(1));
                    collapsingToolbarLayout.setTitle(mModel.getSyndrome_Title(index));
                    break;
                case 2:
                    menu_description_text.setText(mModel.getSyndrome_Inheritance(index));
                    menu_title_text.setText(mModel.getSyndrome_Menu_title(1));
                    collapsingToolbarLayout.setTitle(mModel.getSyndrome_Title(index));
                    break;


            }


        }

        else{
            Toast.makeText(this, "no intent", Toast.LENGTH_SHORT).show();
        }




    }
}
