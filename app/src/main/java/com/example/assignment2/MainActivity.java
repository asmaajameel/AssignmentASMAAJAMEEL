package com.example.assignment2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import  android.widget.AdapterView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String QQQ="eee";
    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button clear;
    Button buy;
    ArrayList<HistoryProduct> historyArrayList1 = new ArrayList<>();
    TextView total_textview;
    TextView product_textview;
    TextView quantity_textview;
    ListView list_view;
    String btnText = "";
    int userQuantity;
    double priceForAllpurchase;
    //HistoryProduct historyProductobj;
    //StoreManager managerObj = new StoreManager();
    //CustomAdapter adapter;
    CustomAdapter customAdapter;
    int selectedItemPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num0 = findViewById(R.id.button_num0);
        num1 = findViewById(R.id.button_num1);
        num2 = findViewById(R.id.button2_num2);
        num3 = findViewById(R.id.button3_num3);
        num4 = findViewById(R.id.button4_num4);
        num5 = findViewById(R.id.button5_num5);
        num6 = findViewById(R.id.button6_num6);
        num7 = findViewById(R.id.button7_num7);
        num8 = findViewById(R.id.button8_num8);
        num9 = findViewById(R.id.button_num9);
        clear = findViewById(R.id.button_clear);
        buy=findViewById(R.id.buy_but);
        total_textview = findViewById(R.id.total_view);
        product_textview = findViewById(R.id.product_View);
        quantity_textview = findViewById(R.id.quantity_view);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        clear.setOnClickListener(this);
        buy.setOnClickListener(this);
        list_view = (ListView) findViewById(R.id.list_of_product);
        // list_view.setClickable(true);

        customAdapter = new CustomAdapter(MainActivity.this, ((MyApp)getApplication()).getManager().listOfProduct);
        list_view.setAdapter(customAdapter);


        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                product_textview.setText(((MyApp)getApplication()).getManager().listOfProduct.get(position).getProductName());
                selectedItemPosition = position;
                //managerObj.listOfProduct.get(position);
                //double price = managerObj.listOfProduct.get(selectedItemPosition).getPrice();
//total_textview.setText(String.valueOf(managerObj.listOfProduct.get(position).getPrice()));

            }
        });
    }

    public void managerBtnClick(View view){
       // String message = "HISTORY";
        Intent firstIntent = new Intent(this, ManagerPanel.class);
       // firstIntent.putExtra("getid",message);
      Bundle bundle = new Bundle();
      bundle.putParcelableArrayList("MyHistoryList",historyArrayList1);
        System.out.println("this is sending history"+historyArrayList1.toString());

        firstIntent.putExtras(bundle);
      startActivity(firstIntent);
    }

    public void resetTheView() {
        quantity_textview.setText(null);
        product_textview.setText(null);
        total_textview.setText(null);
        btnText = "";
        priceForAllpurchase = 0;}

        @Override
    public void onClick(View v) {
            Button button = (Button) v;
            String butNumberPressed = button.getText().toString();

            if(v == clear) {
                resetTheView();
//                quantity_textview.setText(null);
//                product_textview.setText(null);
//                total_textview.setText(null);
//                btnText = "";
//                priceForAllpurchase = 0;
            }else if(v == buy){

              if(!(product_textview.getText()==null) && !(userQuantity==0)){
                    int newQuantity = ((MyApp)getApplication()).getManager().listOfProduct.get(selectedItemPosition).getQuantity() - userQuantity;
                  ((MyApp)getApplication()).getManager().listOfProduct.get(selectedItemPosition).setQuantity(newQuantity);
                    customAdapter.notifyDataSetChanged();
String name = ((MyApp)getApplication()).getManager().listOfProduct.get(selectedItemPosition).getProductName();
double total = priceForAllpurchase;
            HistoryProduct historyProduct = new HistoryProduct(name,total,userQuantity,(new Date().toString()));
                   historyArrayList1.add(historyProduct);
                //  Log.d("QQQ", "onClick: this is my history"+historyArrayList1.toString());
                  System.out.println("this is my history"+historyArrayList1.toString());

                  AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(true);
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            resetTheView();


                        }
                    });
                    //********* for cancel button.
//               builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
                    builder.setMessage("Thank you for your purchase" + " 😘");
                    builder.show();}

                   else {    Toast.makeText(this, "all field are required!!", Toast.LENGTH_SHORT).show();
                    }

            }else {// all the numbers


//                if (product_textview == null) {//this is not working
//                    priceForAllpurchase = 0;
//                    Toast.makeText(this, "Please Choose one Product First", Toast.LENGTH_SHORT).show();
//                } else {
                    if(userQuantity>((MyApp)getApplication()).getManager().listOfProduct.get(selectedItemPosition).getQuantity()){
                        Toast.makeText(this, "No enough quantity in the stock!", Toast.LENGTH_SHORT).show();
                    resetTheView();
                    }else {

                        btnText += butNumberPressed;
                        quantity_textview.setText(btnText);
                        //Toast.makeText(this, "Number of product pressed", Toast.LENGTH_SHORT).show();
                        Log.d("quantity", "number of Product");
                        userQuantity = Integer.parseInt(btnText);
                        Toast.makeText(this, "userQuantity is" + userQuantity, Toast.LENGTH_SHORT).show();
                        System.out.println("myArray List 2 is" + userQuantity);

                        double price = ((MyApp)getApplication()).getManager().listOfProduct.get(selectedItemPosition).getPrice();
                        priceForAllpurchase = userQuantity * price;
                        total_textview.setText(String.valueOf(priceForAllpurchase));


//                    int currentQNT=(managerObj.listOfProduct.get(selectedItemPosition).getQuantity())-userQuantity;
//                   managerObj.listOfProduct.get(selectedItemPosition).setQuantity(currentQNT);
//                    Toast.makeText(this, "the current quantity is"+currentQNT, Toast.LENGTH_SHORT).show();

                    }
                }
            }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
        }
///}









//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button button = (Button)v; //   or just type this-->       String buttonTitle = ((Button)v).getText().toString();
//                String butNumberPressed = button.getText().toString();
//                if (button.getText().toString().isEmpty()){
//                    Toast.makeText(getApplicationContext(), "please select the number of items you want to purchase", Toast.LENGTH_SHORT).show();
//
//                   if(v == clear) {
//                    quantity_textview.setText(null);
//                }
//                   else {// all the numbers
//                       calcstr+=butNumberPressed;
//                       quantity_textview.setText(butNumberPressed);
//                       userQuantity=Integer.parseInt(calcstr);
//                   // Toast.makeText(this,"Number of product pressed", Toast.LENGTH_SHORT).show();
//                    Log.d("quantity","number of Product");
//
//                }
//                }
//            }
//        });
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                quantity_textview.setText(null);
//                product_textview.setText(null);
//                total_textview.setText(null);
//                btnText = "";
//            }
//        });

//    @Override
//    public void onClick(View v) {
//        Button button = (Button) v;
//        String butNumberPressed = button.getText().toString();
//        if (button.getText().toString().isEmpty()) {
//            Toast.makeText(getApplicationContext(), "please select the number of items you want to purchase", Toast.LENGTH_SHORT).show();
//
//        } else {// all the numbers
//            btnText += butNumberPressed;
//            quantity_textview.setText(btnText);
//            userQuantity = Integer.parseInt(btnText);
//
//            Toast.makeText(this, "Number of product pressed", Toast.LENGTH_SHORT).show();
//            Log.d("quantity", "number of Product");
//
//        }
//    }

