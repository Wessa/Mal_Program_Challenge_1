package com.example.android.challenge_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Country country = (Country) getIntent().getSerializableExtra("country");

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        TextView detailCapital = (TextView) findViewById(R.id.detail_capital);
        TextView detailText = (TextView) findViewById(R.id.detail_text);

        ImageView countryImage = (ImageView) findViewById(R.id.detail_image);

        detailName.setText(country.getName());
        detailCapital.setText(country.getCapital());
        detailText.setText(country.getDetails());

        int res = this.getResources().getIdentifier(country.getFlag(), "drawable", this.getPackageName());
        countryImage.setImageResource(res);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
