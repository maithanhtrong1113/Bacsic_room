package com.example.bacsic_room;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private List<Person> persons;
    private int layout;


    public PersonAdapter(Context context, List<Person> persons, int layout) {
        this.context = context;
        this.persons = persons;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return persons.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);

        tvName.setText(persons.get(position).getName());

        return view;
    }
}

