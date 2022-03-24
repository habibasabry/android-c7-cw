package com.example.android.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView itemName = findViewById(R.id.itemName);
        ImageView itemImg = findViewById(R.id.itemImg);


        Bundle bundle = getIntent().getExtras();
        Items theItem = (Items) bundle.getSerializable("item");

        itemName.setText(theItem.getItemName());
        itemImg.setImageResource(theItem.getItemImage());
    }
}