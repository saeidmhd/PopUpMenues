package ir.toptechnica.popupmenues;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.toptechnica.popupmenues.adapter.ListViewAdapter;


public class MainActivity extends AppCompatActivity  {

    private String[] Syndrome_ITEMS ;
    private ListView mList;
    ArrayAdapter<String> adapter;
    ListViewAdapter mListViewAdapter;
    TypedArray imgs;
    TextView matchText;
    int RowCount;

    private static final String index = "position";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Register a button for context events

        setContentView(R.layout.activity_main);

        imgs = getResources().obtainTypedArray(R.array.frag_imgs);

        Syndrome_ITEMS = getResources().getStringArray(R.array.Syndrome_item);
        int i  = Syndrome_ITEMS.length;

        mList = (ListView)findViewById(R.id.mList);
        matchText = (TextView) findViewById(R.id.text);

        /*adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.list_item, R.id.text, Syndrome_ITEMS);
        mList.setAdapter(adapter);*/


        showList();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //MainActivity.this.adapter.getFilter().filter(newText);


                for (RowCount = 0;RowCount<3;RowCount++)
                {

                    int i = Syndrome_ITEMS[RowCount].indexOf(newText);
                    if (i > 0) {
                        // found a match to "newText" at offset i
                        //Toast.makeText(MainActivity.this, "found " + newText , Toast.LENGTH_SHORT).show();
                        if (newText!=" "){

                            ArrayList<String> ar = new ArrayList<String>();
                            ar.add(Syndrome_ITEMS[RowCount]);
                            adapter = new ArrayAdapter<String>(MainActivity.this,
                                    R.layout.list_item, R.id.text, ar);
                            mList.setAdapter(adapter);

                            /*mListViewAdapter = new ListViewAdapter(MainActivity.this,Syndrome_ITEMS,imgs);
                            mList.setAdapter(mListViewAdapter);*/


                            mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    switch (RowCount){
                                        case 0 :
                                            Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                                            intent.putExtra(Intent.EXTRA_TEXT,RowCount);
                                            startActivity(intent);
                                            break;
                                        case 1 :
                                            Intent intent1 = new Intent(MainActivity.this,DescriptionActivity.class);
                                            intent1.putExtra(Intent.EXTRA_TEXT,RowCount);
                                            startActivity(intent1);
                                            break;
                                        case 2 :
                                            Intent intent2 = new Intent(MainActivity.this,DescriptionActivity.class);
                                            intent2.putExtra(Intent.EXTRA_TEXT,RowCount);
                                            startActivity(intent2);
                                            break;
                                        default:break;

                                    }
                                }
                            });
                        }

                        return true;
                    }

                }

                showList();
                return false;
            }
        });


        return true;
    }

    public void showList(){

        mListViewAdapter = new ListViewAdapter(MainActivity.this,Syndrome_ITEMS,imgs);
        mList.setAdapter(mListViewAdapter);

        /*adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.list_item, R.id.text, Syndrome_ITEMS);
        mList.setAdapter(adapter);*/
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                        intent.putExtra(Intent.EXTRA_TEXT,position);
                        startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(MainActivity.this,DescriptionActivity.class);
                        intent1.putExtra(Intent.EXTRA_TEXT,position);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(MainActivity.this,DescriptionActivity.class);
                        intent2.putExtra(Intent.EXTRA_TEXT,position);
                        startActivity(intent2);
                        break;

                    default:break;
                }
            }
        });


    }


}

