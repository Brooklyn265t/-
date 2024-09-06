package com.example.converttemparturemenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter(@NonNull MainActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
//            case 0:
//                return new FragmentInput(); // Калькулятор
            case 1:
                return new FragmentAboutMe(); // Обо мне
            case 2:
                return new FragmentAboutPrograms(); // О программе
            default:
                return new FragmentInput(); // Возвращаем калькулятор по умолчанию
        }
    }

    @Override
    public int getItemCount() {
        // Возвращайте количество страниц
        return 3;
    }
}
