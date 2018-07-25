package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class customAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public customAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvtitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvinfo = rowView.findViewById(R.id.textViewInfo);
        ImageView imrated = rowView.findViewById(R.id.imageViewRated);

        Movie currentItem = movieList.get(position);

        tvtitle.setText(currentItem.getTitle());
        tvinfo.setText(currentItem.getYear() + " - " + currentItem.getGenre());
        if (currentItem.getRated().equalsIgnoreCase("g")) {
            imrated.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRated().equalsIgnoreCase("pg")) {
            imrated.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRated().equalsIgnoreCase("pg13")) {
            imrated.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRated().equalsIgnoreCase("nc16")) {
            imrated.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRated().equalsIgnoreCase("m18")) {
            imrated.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRated().equalsIgnoreCase("r21")) {
            imrated.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}