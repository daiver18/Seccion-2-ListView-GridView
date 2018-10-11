package com.example.daiverandresdoria.app_02.feature;

import android.content.Context;
import android.support.v7.app.AppCompatViewInflater;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int  layout;
    private List<String>name;

    //metodo contructor
    public MyAdapter(Context context,int layout,List<String>name){
        this.context = context;
        this.layout = layout;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View holder pattern
        ViewHolder holder;

       if (convertView == null){
           //inflamos la vista con nustro layout personalisado
           LayoutInflater layoutInflater = LayoutInflater.from(context);
           convertView = layoutInflater.inflate(this.layout,null);

           //rellenamos el text de nuestro layout con los datos optenidos
           holder = new ViewHolder();
           holder.textView = (TextView)convertView.findViewById(R.id.textView);
           convertView.setTag(holder);
       }else{
           holder = (ViewHolder) convertView.getTag();
       }

        //optenemos cada valor de las posiciones (nombre, datos etc...)
        String currentName = name.get(position);

        //rellenamos el text de nuestro layout con los datos optenidos
        holder.textView.setText(currentName);

        //devolvemos la lista inflada y modificada con nustros datos
        return convertView;
    }

    static class ViewHolder{
        private TextView textView;
    }
}
