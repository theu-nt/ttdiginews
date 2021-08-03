package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttvnpt.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.website;

public class customadapter extends ArrayAdapter<website> {

    public customadapter(Context context, int resource, List<website> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.rsslistviewadapter, null);
        }
        website p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txt = (TextView) view.findViewById(R.id.tvmota);
            ImageView img=view.findViewById(R.id.img);
            txt.setText(p.title);
            Picasso.get().load(p.hinhanh).into(img);






        }
        return view;
    }

}
