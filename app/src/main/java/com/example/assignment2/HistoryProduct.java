package com.example.assignment2;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryProduct extends Product implements Parcelable{
    String date;
    public HistoryProduct(String productName, double price, int quantity,String date) {
        super(productName, price, quantity);
        this.date = date;

    }

    protected HistoryProduct(Parcel in) {
        super(in);
        date = in.readString();
    }

    public static final Creator<HistoryProduct> CREATOR = new Creator<HistoryProduct>() {
        @Override
        public HistoryProduct createFromParcel(Parcel in) {
            return new HistoryProduct(in);
        }

        @Override
        public HistoryProduct[] newArray(int size) {
            return new HistoryProduct[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
    }

    @Override
    public String toString() {
        return super.toString() +
                "date='" + date + '\'' +
                '}';
    }
}
