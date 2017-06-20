package ir.toptechnica.popupmenues;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

import ir.toptechnica.popupmenues.data.Syndrome_Model;

/**
 * Created by admin1 on 3/29/17.
 */

public class ContextListItem extends LinearLayout implements
        PopupMenu.OnMenuItemClickListener,
        View.OnClickListener {

    private PopupMenu mPopupMenu;
    private TextView mTextView;
    private Syndrome_Model mModel = new Syndrome_Model(getContext());

    public ContextListItem(Context context) {
        super(context);
    }

    public ContextListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContextListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTextView = (TextView) findViewById(R.id.text);

        //Attach click handlers
        View contextButton = findViewById(R.id.context);
        contextButton.setOnClickListener(this);

        //Create the context menu
        mPopupMenu = new PopupMenu(getContext(), contextButton);
        mPopupMenu.setOnMenuItemClickListener(this);
        mPopupMenu.inflate(R.menu.contextmenu);
    }

    @Override
    public void onClick(View v) {
        //Handle context button click to show the menu
        mPopupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String itemText = mTextView.getText().toString();

        int index  = Arrays.asList((getResources().getStringArray(R.array.Syndrome_item))).indexOf(itemText);

        switch (item.getItemId()) {
            case R.id.incidence:
                Intent intent = new Intent(getContext(),IncidenceActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,index);
                getContext().startActivity(intent);
                break;
            case R.id.inheritance:
                Intent intent2 = new Intent(getContext(),InheritanceActivity.class);
                intent2.putExtra(Intent.EXTRA_TEXT,index);
                getContext().startActivity(intent2);
                break;

            case R.id.DDX:
                Intent intent3 = new Intent(getContext(),DDXActivity.class);
                intent3.putExtra(Intent.EXTRA_TEXT,index);
                getContext().startActivity(intent3);
                break;

            case R.id.Images:
                Intent intent4 = new Intent(getContext(),ImagesActivity.class);
                intent4.putExtra(Intent.EXTRA_TEXT,index);
                getContext().startActivity(intent4);
                break;

        }
        return true;
    }


}
