package com.niktan.event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EventScreen extends AppCompatActivity  implements

        AdapterView.OnItemSelectedListener {
    String[] country = { " ", "Sleeping", "Eating", "Working", "Playing", "Other"};
    String[] hours = { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public Spinner spin;
    public Spinner spin1;
    public  ListView listView;
    public  ArrayList<String> listItems;
    public  ArrayList<Integer> times;
    public  ArrayList<String> events;
    public  ArrayAdapter<String> adapter;
    public Button graphButton;
    public Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_screen);

        spin = (Spinner) findViewById(R.id.spinner);


        spin1=(Spinner) findViewById(R.id.stime);
        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,hours);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(bb);


        listView = (ListView) findViewById(R.id.listView);
        addButton=(Button) findViewById(R.id.addButton);
        graphButton=(Button) findViewById(R.id.graph);
        listItems = new ArrayList<String>();
        times=new ArrayList<Integer>();
        events=new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int text1 = Integer.parseInt(spin1.getSelectedItem().toString());
                String text2 = spin.getSelectedItem().toString();
                times.add(text1);
                events.add(text2);

                listItems.add(text1+" hr        "+text2);
                adapter.notifyDataSetChanged();

            }
        });

        graphButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(EventScreen.this,graphActivity.class);
                intent.putExtra("timesArrayList", times);
                intent.putExtra("eventsArrayList",events);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
