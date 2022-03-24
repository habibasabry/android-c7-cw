package com.example.android.listviewproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class ItemAdapter extends ArrayAdapter<Items> {

    List<Items> items;//Arraylist

    final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        this.items = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {



        //
        view = LayoutInflater.from(getContext()).inflate(R.layout.list_item1, parent, false);
        //
        Items currentItem = items.get(position);
        //
        TextView shapeNameTextView = view.findViewById(R.id.item1_name);
        shapeNameTextView.setText(currentItem.getItemName());

        //
        ImageView shapeImageTextView = view.findViewById(R.id.item1_image);
        shapeImageTextView.setImageResource(currentItem.getItemImage());

        //
        TextView price = view.findViewById(R.id.item1_price);
        price.setText(currentItem.getItemPrice() + "");


        ImageView remove = view.findViewById(R.id.remove);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                       .setTitle("Are you sure you want to delete this item?")
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               items.remove(position);
                               notifyDataSetChanged();

                           }
                       }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.dismiss();
                           }
                       }).show();
               alertDialog.create();
;            }
        });

        return view;
    }

}
