package com.example.daiverandresdoria.app_02.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private List<String> name;
    private GridView gridView;
    private MyAdapter myAdapter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);

        //lista de datos a mostrar
        name = new ArrayList<String>();
        name.add("Daiver");
        name.add("Jose");
        name.add("Sebastian");
        name.add("Miguel");

        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: "+name.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //enlasar MyAdapter con el ListView
        myAdapter = new MyAdapter(this,R.layout.grid_item,name);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);

    }

    //inflamos el layout del menu de opcion
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_item,menu);
        return true;
    }

    // Manejamos eventos click en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.add_item) {
            //añadimos un nuevo nombre
            this.name.add("added n°" + (++counter));
            //notificamos al adpatador de los nuevos cambios
            this.myAdapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    //inflamos el layout del context_menu de opcion
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(name.get(info.position));
        menuInflater.inflate(R.menu.contex_menu,menu);
    }

    //Manejamos eventos click en el context_menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int i = item.getItemId();
        if (i == R.id.delete_item) {
            //borramos un nuevo nombre
            this.name.remove(info.position);
            //notificamos al adpatador de los nuevos cambios
            this.myAdapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
