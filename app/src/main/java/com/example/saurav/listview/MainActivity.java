package com.example.saurav.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  String[] months = {"Jan","Feb","Mar","April","May","June","July","Aug","Sep","oct","Nov","Dec"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listview);
        Button ListA = (Button) findViewById(R.id.lista);
        Button ListD = (Button) findViewById(R.id.listd);

        final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, months);

        list.setAdapter(adapter);

        ListA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortAscending();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Sorting in Ascending order",Toast.LENGTH_SHORT).show();

            }
        });

        ListD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortDescending();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Sorting in Descending order",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void sortAscending ()
    {
        List<String> sortedMonthsList = Arrays.asList(months);
        Collections.sort(sortedMonthsList);
        months = (String[]) sortedMonthsList.toArray();

    }

    public void sortDescending ()
    {
        List<String> dsortedMonthsList = Arrays.asList(months);
        Collections.sort(dsortedMonthsList,Collections.reverseOrder());
        months = (String[]) dsortedMonthsList.toArray();
    }
}
