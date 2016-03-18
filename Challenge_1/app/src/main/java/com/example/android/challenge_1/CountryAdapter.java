package com.example.android.challenge_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MW on 3/18/2016.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countries;
    private Context context;

    public CountryAdapter(Context context, List<Country> countries) {

        this.countries = countries;
        this.context = context;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        protected ImageView countryImage;
        protected TextView countryName;
        protected TextView countryCapital;

        public CountryViewHolder(View view) {

            super(view);

            view.setOnClickListener(this);

            this.countryImage = (ImageView) view.findViewById(R.id.country_image);
            this.countryName = (TextView) view.findViewById(R.id.country_name);
            this.countryCapital = (TextView) view.findViewById(R.id.country_capital);
        }

        public void onClick(View view) {

            Intent i = new Intent(context, DetailActivity.class);
            Country country = countries.get(getPosition());

            i.putExtra("country", country);
            context.startActivity(i);
        }
    }

    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.country_item, null);

        CountryViewHolder holder = new CountryViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {

        Country country = countries.get(position);

        holder.countryName.setText(country.getName());

        holder.countryCapital.setText(country.getCapital());

        int res = context.getResources().getIdentifier(country.getFlag(), "drawable", context.getPackageName());
        holder.countryImage.setImageResource(res);
    }

    @Override
    public int getItemCount(){

        return countries.size();
    }
}
