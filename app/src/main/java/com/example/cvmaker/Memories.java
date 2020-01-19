package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Memories extends AppCompatActivity {
AdapterViewFlipper viewFlipperImage;
GridView gridViewImage;
public int [] image = {R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);
        calling();
        handling();
    }

    private void calling() {
    viewFlipperImage=findViewById(R.id.viewFlipperImage);
    gridViewImage=findViewById(R.id.gridViewImage);
    }

    private void handling() {

        showFlipper();
        showGrid();
    }
    public void showFlipper(){
        FlipperImage flipperImage = new FlipperImage(this,image);
        viewFlipperImage.setAdapter(flipperImage);
        viewFlipperImage.setAutoStart(true);

    }
    public void showGrid(){
        GridImages gridImages = new GridImages(this,image);
        gridViewImage.setAdapter(gridImages);
    }

    public class FlipperImage extends BaseAdapter {
        Context myContext;
        int[] image;

        public FlipperImage(Context myContext, int[] image) {
            this.myContext = myContext;
            this.image = image;

        }

        @Override
        public int getCount() {
            return image.length;
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
            LayoutInflater f = LayoutInflater.from(myContext);
            // this  line to add row of xml design in list view root null if sub group
            myView = f.inflate(R.layout.flipper_items,null);
            // calling
            ImageView im = myView.findViewById(R.id.imageFilp);

            //handel
            im.setImageResource(image[position]);

            return myView;
        }
    }
    public class GridImages extends BaseAdapter {
        Context myContext;
        int[] image;

        public GridImages(Context myContext, int[] image) {
            this.myContext = myContext;
            this.image = image;

        }

        @Override
        public int getCount() {
            return image.length;
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
            LayoutInflater f = LayoutInflater.from(myContext);
            // this  line to add row of xml design in list view root null if sub group
            myView = f.inflate(R.layout.flipper_items,null);
            // calling
            ImageView im = myView.findViewById(R.id.imageFilp);

            //handel
            im.setImageResource(image[position]);

            return myView;
        }
    }
}
