package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ManagerPanel extends AppCompatActivity {
 Button history, restock;

 ArrayList<Product> restockProduct = new ArrayList<>();
 ArrayList<HistoryProduct> historyArrayList2 = new ArrayList<>();
 //ArrayList<HistoryProduct> abcd = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_history);
        history=findViewById(R.id.history_button);
        restock=findViewById(R.id.restock_button);
       // Intent mainIntent =
//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        Intent getFromMainActivity = getIntent();
        if(!(getFromMainActivity.getExtras().getParcelableArrayList("MyHistoryList")).isEmpty()) {
            historyArrayList2 = getFromMainActivity.getExtras().getParcelableArrayList("MyHistoryList");
         //   abcd = historyArrayList2;
            System.out.println("this is receiving history"+historyArrayList2.toString());


        }
        else {System.out.println("Empty History");
        }
    }

    public void History_but_click(View view) {
        Intent secondIntent = new Intent(this, HistoryRecycleViewActivity.class);
        Bundle bundle = new Bundle();
       // bundle.putParcelableArrayList("message from history activity to detail Activity",abcd);
        secondIntent.putExtras(bundle);
        startActivity(secondIntent);
    }



    public void restock_but_click(View view) {
        Intent thirdIntent = new Intent(this,Restock_Activity.class);
        startActivity(thirdIntent);
    }
}