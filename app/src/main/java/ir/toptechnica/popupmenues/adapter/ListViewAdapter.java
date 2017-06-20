package ir.toptechnica.popupmenues.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import ir.toptechnica.popupmenues.R;

/**
 * Created by Saeid.mhd-at-Gmail.com on 6/19/17.
 */

public class ListViewAdapter extends ArrayAdapter<String> implements Filterable{

    private final Context context;
    private final String[] values;
    private final TypedArray images;
    

    public ListViewAdapter(Context context, String[] values, TypedArray images) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView5);
        textView.setText(values[position]);
        imageView.setImageDrawable(images.getDrawable(position));
        return rowView;
    }
}
