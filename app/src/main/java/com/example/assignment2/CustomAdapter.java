package com.example.assignment2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.LayoutInflater;
public class CustomAdapter extends BaseAdapter {
Context context;
ArrayList<Product> singleRow;

    public CustomAdapter(Context context, ArrayList<Product> singleRow) {
        this.context = context;
        this.singleRow = singleRow;
    }

    @Override
    public int getCount() {
        return singleRow.size();
    }

    @Override
    public Object getItem(int position) {
        return singleRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.product_item_row,parent,false);

    TextView productTypeInRow = (TextView) convertView.findViewById(R.id.item_name_In_Row);
    TextView priceInRow =  convertView.findViewById(R.id.price_In_Row);
    TextView quantityInRow = (TextView) convertView.findViewById(R.id.quantity_in_row);

        productTypeInRow.setText(singleRow.get(position).getProductName());
        quantityInRow.setText(String.valueOf(singleRow.get(position).getQuantity()));
    //this is correct too//   quantityInRow.setText(singleRow.get(position).getQuantity()+"");
        priceInRow.setText(String.valueOf(singleRow.get(position).getPrice()));
    //this is correct too//  priceInRow.setText(singleRow.get(position).getPrice()+"");





        return convertView;
    }
}
