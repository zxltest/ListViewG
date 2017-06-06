package com.zxl.listviewg;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewGAct extends Activity {
    private ListView listview;
    private List<GalleryItem> galleryitem = new ArrayList<>();
    private ArrayList<String> titlenamearraylist = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_listviewg);
        listview = (ListView) findViewById(R.id.listview);
        for (int i = 0; i < 7; i++) {
            titlenamearraylist.add("List" + i);
        }

        initItems();
        setlistview();
    }

    private void initItems() {
        GalleryItem item = null;
        for (int i = 0; i < titlenamearraylist.size(); i++) {
            item = new GalleryItem(this);
            item.arraylist = titlenamearraylist;
            item.initAdapter(this, new int[]{R.id.tv2});
            galleryitem.add(item);
        }
    }

    private void setlistview() {
        SpecialAdapter mAdapter = new SpecialAdapter(this, galleryitem, titlenamearraylist, new int[]{R.id.tv1});
        listview.setAdapter(mAdapter);
    }

    public class SpecialAdapter extends BaseAdapter {
        private ArrayList<String> titlenamearraylist;
        Context context;
        private int[] item;
        private List<GalleryItem> galleryitems;

        public SpecialAdapter(Context context, List<GalleryItem> galleryitems, ArrayList<String> dataObjects, int[] item) {
            this.context = context;
            this.titlenamearraylist = dataObjects;
            this.item = item;
            this.galleryitems = galleryitems;
        }

        @Override
        public int getCount() {
            return titlenamearraylist.size();
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
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.allvideo_layout_item, null);
            for (int i = 0; i < item.length; i++) {
                TextView title = (TextView) retval.findViewById(item[i]);
                title.setText(titlenamearraylist.get(position));
            }
            GalleryItem items = this.galleryitems.get(position);
            GalleryItem gallery = (GalleryItem) retval.findViewById(R.id.item_gallery);
            gallery.setAdapter(items.adapter);
            gallery.setSelection(1);
            return retval;
        }

    }
}