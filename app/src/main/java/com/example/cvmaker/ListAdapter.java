package com.example.cvmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context myContext;
    String[] listWords;
    int[] image;
    String check;

    public ListAdapter(Context myContext, String[] listWords, int[] image, String check) {
        this.myContext = myContext;
        this.listWords = listWords;
        this.image = image;
        this.check = check;
    }

    @Override
    public int getCount() {
        return listWords.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View myView;
        // LayoutInflater to delete default view in android from layout use getSystemService
        LayoutInflater f = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // this  line to add row of xml design in list view root null if sub group
        myView = f.inflate(R.layout.list_item,null);
        // calling
        ImageView im = myView.findViewById(R.id.imageV);
        TextView tv  =myView.findViewById(R.id.textV);
        //handel
        im.setImageResource(image[position]);
        tv.setText(listWords[position]);
        return myView;
    }
}
