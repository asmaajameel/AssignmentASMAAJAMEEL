package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Restock_Activity extends AppCompatActivity {
    Button ok;
    int selectedPosition;
    Button cancel;
    int addNewQuantity;
    int oldQuantity;
    int newQuantity;
    ListView restockList;
    EditText addQuantity_text;
    CustomAdapter customAdapter2;
ArrayList<Product> restockArrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        ok=findViewById(R.id.OK_id);
        cancel = findViewById(R.id.restock_button);
        restockList = findViewById(R.id.list_ofRestock_product);
        addQuantity_text = findViewById(R.id.NewQuantityRestock);
        restockArrayList=((MyApp)getApplication()).getManager().listOfProduct;
        customAdapter2 = new CustomAdapter(this,restockArrayList);
        restockList.setAdapter(customAdapter2);
        restockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
            }
        });
    }

    public void CANCEL(View view) {
       finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void OK(View view) {
        if(addQuantity_text.getText().toString().isEmpty()){
            Toast.makeText(this, "All Field are Required", Toast.LENGTH_SHORT).show();
        }else {
addNewQuantity=Integer.parseInt(addQuantity_text.getText().toString());
 oldQuantity = restockArrayList.get(selectedPosition).getQuantity();
newQuantity = addNewQuantity+oldQuantity;
restockArrayList.get(selectedPosition).setQuantity(newQuantity);
            customAdapter2.notifyDataSetChanged();
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
