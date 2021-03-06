package com.example.hahahoho.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hahahoho.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    // 아이템을 세트로 담기 위한 어레이
    private ArrayList<MyItem> myItems = new ArrayList<>();

    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public MyItem getItem(int position) {
        return myItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        // list_item Layout을 inflate하여 convertView 참조 획득
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // list_item에 정의된 위젯에 대한 참조 획득
        ImageView iv_img = convertView.findViewById(R.id.imageView) ;
        TextView tv_name =  convertView.findViewById(R.id.textView1) ;
        TextView tv_contents = convertView.findViewById(R.id.textView2) ;

        // 각 리스트에 뿌려줄 아이템을 받아오는데 myItem 재활용
        MyItem myItem = getItem(position);

        // 각 위젯에 세팅된 아이템을 뿌려준다
        iv_img.setImageDrawable(myItem.getImg());
        tv_name.setText(myItem.getTitle());
        tv_contents.setText(myItem.getSubTitle());

        // 위젯 이벤트 리스너

        return convertView;
    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(Drawable img, String title, String subTitle) {

        MyItem item = new MyItem();

        // MyItem에 아이템을 setting한다.
        item.setImg(img);
        item.setTitle(title);
        item.setSubTitle(subTitle);

        // myItems item 추가한다.
        myItems.add(item);

    }
}