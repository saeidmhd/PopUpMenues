package ir.toptechnica.popupmenues;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import ir.toptechnica.popupmenues.adapter.RecyclerAdapter;

public class SyndromeList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] Syndrome_ITEMS ;
    TypedArray imgs;
    TextView matchText;
    int RowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syndrome_list);

        Syndrome_ITEMS = getResources().getStringArray(R.array.Syndrome_item);
        imgs = getResources().obtainTypedArray(R.array.frag_imgs);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(Syndrome_ITEMS,imgs);
        mRecyclerView.setAdapter(mAdapter);
    }
}
