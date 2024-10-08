package com.example.listfrommyadapter;

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

import com.example.listfrommyadapter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;
    BoxAdapter(Context context, ArrayList<Product> products){
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
    public View getView(int position, View convetView, ViewGroup parent) {
        //используем созданные, но не используемые view
        View view = convetView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Product p = getProduct(position);

        // заполняем View  пункте списка данными из товаров: аименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
        ((TextView) view.findViewById(R.id.tvPrice)).setText(p.price + "");
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        // присвает чекбоксу обработчик
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        //пишем позицию
        cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
        cbBuy.setChecked(p.box);
        return view;
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
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked){
            // меняем данные товара (в корзине или нет)
            getProduct((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
