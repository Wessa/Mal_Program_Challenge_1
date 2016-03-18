package com.example.android.challenge_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Country> countries = new ArrayList <Country>();

        countries.add( new Country("Cairo", "egypt", "Egypt", getResources().getString(R.string.egypt_details) ) );
        countries.add( new Country("Rome", "italy", "Italy", getResources().getString(R.string.italy_details) ) );
        countries.add( new Country("London", "england", "England", getResources().getString(R.string.england_details) ) );
        countries.add( new Country("Paris", "france", "France", getResources().getString(R.string.france_details) ) );
        countries.add( new Country("Berlin", "germany", "Germany", getResources().getString(R.string.germany_details) ) );
        countries.add( new Country("Amsterdam", "netherlands", "Netherlands", getResources().getString(R.string.netherlands_details) ) );

        CountryAdapter adapter = new CountryAdapter(this, countries);

        RecyclerView countryList = (RecyclerView) findViewById(R.id.country_list);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setAdapter(adapter);

        countryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CountryAdapter.CountryViewHolder holder = (CountryAdapter.CountryViewHolder) view.getTag();
                holder.onClick(view);
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra("country", (Parcelable) countries.get(position));
//
//                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
