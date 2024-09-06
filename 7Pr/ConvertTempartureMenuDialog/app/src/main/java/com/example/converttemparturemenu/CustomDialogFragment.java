package com.example.converttemparturemenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CustomDialogFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CustomDialogFragment", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CustomDialogFragment", "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CustomDialogFragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CustomDialogFragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("CustomDialogFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("CustomDialogFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("CustomDialogFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CustomDialogFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("CustomDialogFragment", "onDetach");
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("Диалоговое окно")
                .setMessage("Для закрытия нажмите ОК")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialog)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Activity activity = getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                })
                .setNegativeButton("Отмена", null)
                .create();
    }
}
