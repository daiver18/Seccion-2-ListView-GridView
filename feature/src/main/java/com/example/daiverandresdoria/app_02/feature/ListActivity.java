package com.example.daiverandresdoria.app_02.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        listView = findViewById(R.id.ListView);

        //lista de datos a mostrar
        name = new ArrayList<String>();
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");

        //Adaptador de listView (forma en que se deben mostrar los datos)
       // ArrayAdapter<String>Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);

        //Enlasamos listView con Adaptador
       // listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Clicked: "+name.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //enlasar MyAdapter con el ListView

        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,name);
        listView.setAdapter(myAdapter);
    }
}

