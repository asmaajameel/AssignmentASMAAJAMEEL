package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecycleAdapter extends RecyclerView.Adapter<HistoryRecycleAdapter.ViewHolder> {
    Context a_context;
    ArrayList<HistoryProduct> list3;
    AdapterView.OnItemClickListener listener;

//   public interface ProductClickListener{
//       public void onToDoSelected(ToDo selectedToDo);
  //  }
   public HistoryRecycleAdapter(Context context, ArrayList<HistoryProduct> listOfH){
    a_context=context;
    list3=listOfH;
}

//    public interface listClickListener {
//        void onHistorySelected(HistoryProduct selectedHistory);
//
//    }

   //  public HistoryRecycleAdapter listener;
    public static class ViewHolder extends RecyclerView.ViewHolder{
//      private final TextView productName;
//      private  final ImageView fruitImage;
        private  final TextView purchaseName;
        private  final TextView purchaseQuantity;
        private  final  TextView purchaseTotal;


         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             purchaseName = itemView.findViewById(R.id.purchase_name);
             purchaseQuantity = itemView.findViewById(R.id.quantity_id);
             purchaseTotal = itemView.findViewById(R.id.price);
         }

        public TextView getPurchaseName() {
            return purchaseName;
        }

        public TextView getPurchaseQuantity() {
            return purchaseQuantity;
        }

        public TextView getPurchaseTotal() {
            return purchaseTotal;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(a_context).inflate(R.layout.history_row_recycle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.getPurchaseName().setText(list3.get(position).getProductName());
holder.getPurchaseQuantity().setText(String.valueOf(list3.get(position).getQuantity()));
holder.getPurchaseTotal().setText(String.valueOf(list3.get(position).getPrice()));
//holder.itemView.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        //listener.(list.get(holder.getAdapterPosition()));
//       // listener.onHistorySelected(list3.get(position));
//    }
//});
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }
}
