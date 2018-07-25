package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class description extends AppCompatActivity {

    TextView tvtitle, tvinfo, tvdes, tvdate, tvthe;
    ImageView imrated;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tvtitle = findViewById(R.id.textViewTitle);
        tvinfo=findViewById(R.id.textViewInfo);
        tvdes=findViewById(R.id.textViewDescription);
        tvdate=findViewById(R.id.textViewdate);
        tvthe=findViewById(R.id.textViewTheatre);
        imrated=findViewById(R.id.imageViewRated);
        ratingBar=findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String theatre = intentReceived.getStringExtra("theatre");
        String desc = intentReceived.getStringExtra("des");
        String date = intentReceived.getStringExtra("date");
        String rated = intentReceived.getStringExtra("rated");
        int rating = intentReceived.getIntExtra("rating",0);

        tvtitle.setText(title);
        tvinfo.setText(year+" - "+genre);
        tvdes.setText(desc);
        tvthe.setText("In theatre: " + theatre);
        tvdate.setText("Watch on: " + date);
        ratingBar.setRating(rating);

        if (rated == "g"){
            imrated.setImageResource(R.drawable.rating_g);
        } else if (rated == "pg"){
            imrated.setImageResource(R.drawable.rating_pg);
        } else if (rated == "pg13"){
            imrated.setImageResource(R.drawable.rating_pg13);
        } else if (rated == "nc16"){
            imrated.setImageResource(R.drawable.rating_nc16);
        } else if (rated == "m18"){
            imrated.setImageResource(R.drawable.rating_m18);
        } else if (rated == "r21"){
            imrated.setImageResource(R.drawable.rating_r21);
        }

    }
}