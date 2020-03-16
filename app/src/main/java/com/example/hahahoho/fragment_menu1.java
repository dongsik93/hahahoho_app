package com.example.hahahoho;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class fragment_menu1 extends Fragment {
    InputStream source = null;
    String str = null;
    ArrayList<JSONObject> list = new ArrayList<JSONObject>();
    JSONObject arr = null;
    int cnt = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parsingData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu1, container, false);
        ListView listview = view.findViewById(R.id.listView);
        MyAdapter listViewAdatper = new MyAdapter();

        String img;
        int r;
        for (int i = 0; i < cnt; i++) {
            try {
                Class<R.drawable> drawable = R.drawable.class;
                String imgState = list.get(i).getString("img");
                // img가 없으면 기본 이미지로 표시
                if (imgState != "null") {
                    img = list.get(i).getString("img");
                } else {
                    img = "logo";
                }
                // R.drawable.""를 해주기 위해서
                Field field = drawable.getField(img);
                r = field.getInt(null);
                listViewAdatper.addItem(
                        ContextCompat.getDrawable(getActivity(), r),
                        list.get(i).getString("title"),
                        list.get(i).getString("subTitle"));
            } catch (JSONException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        listview.setAdapter(listViewAdatper);
        cnt = 0;
        return view;
    }

    public void parsingData() {
        // assets 장치검색
        AssetManager assetManager = getResources().getAssets();

        try {
            // assets 폴더에서 해당 json을 가저옴
            source = assetManager.open("hobby.json");
            int i;
            StringBuffer buffer = new StringBuffer();
            byte[] b = new byte[4096];
            while ((i = source.read(b)) != -1) {
                buffer.append(new String(b, 0, i));
            }
            str = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            arr = new JSONObject(str);
            JSONArray jsonArray = arr.getJSONArray("Hobbies");
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getJSONObject(i));
                cnt++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

