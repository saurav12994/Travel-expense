package com.example.sourabh.travelexpense;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DayFragment extends Fragment {



    public DayFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_day, container, false);
        TableLayout t1=(TableLayout)view.findViewById(R.id.tableLayout1);
        TableRow tr;
        Context c=getContext();
        SQLiteDatabase db = c.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);
        String q="select id ,dest,expensedate,amountexpense from mydata join mydataa where mydata.id=mydataa.tid group by expensedate" ;
        Cursor c1 =db.rawQuery(q,null);
        String name,marks,name1,marks1;
        while (c1.moveToNext())
        {

            name=c1.getString(0);
            marks=c1.getString(1);
            name1=c1.getString(2);
            marks1=c1.getString(3);

            tr=new TableRow(getContext());
            TextView tv1=new TextView(getActivity());
            tv1.setText(name);
            TextView tv2=new TextView(getActivity());
            tv2.setText(marks);
            TextView tv3=new TextView(getActivity());
            tv3.setText(name1);
            TextView tv4=new TextView(getActivity());
            tv4.setText(marks1);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            t1.addView(tr);
        }

db.close();
        // Inflate the layout for this fragment
        return  view;
    }


}
