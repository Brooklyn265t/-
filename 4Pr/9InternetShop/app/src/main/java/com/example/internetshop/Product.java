package com.example.internetshop;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {
    public boolean box;
    // Ваши поля класса Product
    int id;
    String name;
    int price;
    public int imageResourceId;
    private boolean inCart;

    // Конструктор
    public Product(int id, String name, int price, int imageResourceId, boolean inCart) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.inCart = inCart;
    }

    // Конструктор для Parcelable
    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
        imageResourceId = in.readInt();
        inCart = in.readByte() != 0;
    }

    // Методы Parcelable
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(imageResourceId);
        dest.writeByte((byte) (inCart ? 1 : 0));
    }

    public void setChecked(boolean isChecked) {
        this.box = isChecked;
    }

    // Метод для получения состояния чекбокса
    public boolean isChecked() {
        return this.box;
    }
}