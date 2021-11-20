package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryRecycleViewActivity extends AppCompatActivity {

    ArrayList<HistoryProduct> historyArrayList3 = new ArrayList<>();
//HistoryRecycleAdapter recycleAdapter;
    RecyclerView historyOfProduct;
    TextView nodata_text;
    HistoryRecycleAdapter adapter;
//_____________________________________________

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_recycle_view);
//_____________________________________________

        nodata_text=findViewById(R.id.nodata_text);
        historyOfProduct=findViewById(R.id.history_recycle_view);
//_____________________________________________
        historyOfProduct.setLayoutManager(new LinearLayoutManager(this));
        Intent getFromMainActivity = getIntent();
        if(!(this.getIntent().getExtras().getParcelableArrayList("message from history activity to detail Activity")).isEmpty()) {
            historyArrayList3 = this.getIntent().getExtras().getParcelableArrayList("message from history activity to detail Activity");
            System.out.println("myArray List 3 is" + historyArrayList3);
//_____________________________________________
            Toast.makeText(this, "my list history is "+historyArrayList3, Toast.LENGTH_SHORT).show();
          //  adapter.listener = this;

            adapter = new HistoryRecycleAdapter(this,historyArrayList3);
//            list_view.setAdapter(customAdapter);
           // recycleAdapter = new HistoryRecycleAdapter(HistoryRecycleViewActivity.this,((MyApp)getApplication()).);
           // historyOfProduct.setLayoutManager(new LinearLayoutManager(this));
          historyOfProduct.setAdapter(adapter);
        }
        else {System.out.println("Empty History");
        }
    }

//    @Override
//    public void onHistorySelected(HistoryProduct selectedHistory) {
//        openDetailedHistory(selectedHistory);
//
//    }
//    private void openDetailedHistory(Historylist selectedHistory){
//        Intent detailedintent = new Intent(this,DetailedHistoryActivity.class);
//        detailedintent.putExtra("dethistory",selectedHistory);
//        startActivity(detailedintent);
//
//    }
}