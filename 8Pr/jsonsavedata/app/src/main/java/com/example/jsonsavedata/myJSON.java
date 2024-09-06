package com.example.jsonsavedata;

import android.content.Context;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class myJSON {
    private static final String FILE_NAME = "cat.json";
    static boolean exportToJSON(Context context, List<Cat> dataList){
        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setCats(dataList);
        String jsonString = gson.toJson(dataItems);
        try(FileOutputStream fileOutputStream =
                context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)){
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    static List<Cat> importFromJSON(Context context){
        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME)) {
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);
            return dataItems.getCats();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private static class DataItems{
        private List<Cat> cats;
        List<Cat> getCats(){ return cats; }
        void setCats(List<Cat> cats) { this.cats = cats; }
    }
}
