package com.example.internetshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;

import com.example.internetshop.databinding.ItemBinding;


public class BoxAdapter extends BaseAdapter {
    private ItemBinding binding;
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public BoxAdapter(Context context, ArrayList<Product> products){
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //кол-во элементов
    @Override
    public int getCount(){
        return objects.size();
    }

    //элемент по позиции
    @Override
    public Product getItem(int position){
        return objects.get(position);
    }

    // id о позиции
    @Override
    public long getItemId(int position){
        return position;
    }

    //пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemBinding) convertView.getTag();
        }

        Product product = getProduct(position);
        binding.Numbercode.setText(String.valueOf(product.id)); //TextView с id "Numbercode" в вашем макете
        binding.Name.setText(product.name); //TextView с id "Name" в вашем макете
        binding.Price.setText(String.valueOf(product.price)); //TextView с id "Price" в вашем макете
        binding.ivImage.setImageResource(product.imageResourceId); //ImageView с id "ivImage" в вашем макете

        CheckBox cbBuy = binding.cbBox; // Используйте binding для доступа к чекбоксу
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(product.box);

        return convertView;
    }

    //товар по позиции
    Product getProduct(int position){
        return ((Product) getItem(position));
    }

    //содержимое корзины
    ArrayList<Product> getBox(){
        ArrayList<Product> box = new ArrayList<Product>();
        for (Product p : objects){
            // если в корзине
            if (p.box)
                box.add(p);
        }
        return box;
    }

    //обработчик для чекбоксов
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            getProduct((Integer) buttonView.getTag()).box = isChecked;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(buttonView, isChecked);
            }
        }
    };

}
