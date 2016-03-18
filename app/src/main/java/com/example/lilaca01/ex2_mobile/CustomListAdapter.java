package com.example.lilaca01.ex2_mobile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lilaca01 on 09/03/2016.
 */
class CustomListAdapter extends ArrayAdapter {

    private Context mContext;
    private int id;
    private List<ListItem> items ;
    //private String item;

    public CustomListAdapter(Context context, int textViewResourceId , List<ListItem> list )
    {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list ;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View mView = v ;
        if(mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }

        Object p = getItem(position);

        TextView taskText = (TextView) mView.findViewById(R.id.txtTodoTitle);
        TextView taskDate = (TextView) mView.findViewById(R.id.txtTodoDueDate);
        String pos = String.valueOf(items.get(position));

        if(pos != null)
        {
            //TODO change to only date

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //get current date time with Date()
            Date date = new Date();


           if(dateFormat.format(date).compareTo(items.get(position).getStringDate()) > 0){
               taskText.setTextColor(Color.RED);
               taskDate.setTextColor(Color.RED);

               taskText.setText(items.get(position).getTask());
               taskDate.setText(items.get(position).getStringDate());
           }else{
               taskText.setTextColor(Color.BLUE);
               taskDate.setTextColor(Color.BLUE);
               taskText.setText(items.get(position).getTask());
               taskDate.setText(items.get(position).getStringDate());
           }
        }
        return mView;
    }

}