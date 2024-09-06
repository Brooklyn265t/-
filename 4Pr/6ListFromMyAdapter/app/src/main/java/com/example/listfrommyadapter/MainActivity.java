package com.example.listfrommyadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listfrommyadapter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //    ArrayList<Product> products = new ArrayList<Product>();
    //    BoxAdapter boxAdapter;
    //    private ActivityMainBinding binding;
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    View header1, header2, footer1, footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создаём Header и Footer
        header1 = createHeader("header1");
        header2 = createHeader("header2");
        footer1 = createFooter("footer1");
        footer2 = createFooter("footer2");

        //создаём адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        //настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.addHeaderView(header1);
        lvMain.addHeaderView(header2, "Yupie", false);
        lvMain.addFooterView(footer1);
        lvMain.addHeaderView(footer2, "OOOOO", false);
        lvMain.setAdapter(boxAdapter);
    }

    View createHeader(String text) {
        View view = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) view.findViewById(R.id.tvText)).setText(text);
        return view;
    }

    View createFooter(String text) {
        View view = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) view.findViewById(R.id.tvText)).setText(text);
        return view;
    }

    //генерируем данные для адаптера
    void fillData() {
//        for (int i = 1; i <= 20; i++) {
//            products.add(new Product("Product " + i, i * 1000,
//                    R.drawable.ic_launcher_foreground, false));
//        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине: ";
        for (Product p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        //создаём адаптер
//        fillData();
//        boxAdapter = new BoxAdapter(this, products);
//
//        //настраиваем список
//        ListView lvMain = (ListView) binding.lvMain;
//        lvMain.setAdapter(boxAdapter);
//    }
//
//    //генерируем данные для адаптера
//    void fillData(){
//        for (int i = 1; i <= 20; i++){
//            products.add(new Product("Product " + i, i * 1000,
//                    R.drawable.ic_launcher_foreground, false));
//        }
//    }
//
//    // выводим информацию о корзине
//    public void showResult(View v){
//        String result = "Товары в корзине: ";
//        for (Product p : boxAdapter.getBox()){
//            if(p.box)
//                result += "\n" + p.name;
//        }
//        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
//    }
//}