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
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewdetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ViewdetailFragment extends Fragment {
TextView tv1;
  //  private OnFragmentInteractionListener mListener;



    public ViewdetailFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View  view =inflater.inflate(R.layout.fragment_viewdetail, container, false);
        String str2 = getArguments().getString("CID");
        Context c=getContext();
        tv1 = (TextView) view.findViewById(R.id.textView5);
        SQLiteDatabase db = c.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);
        String q2="select * from mydata where id='"+str2+"'";
        Toast.makeText(getActivity(), str2, Toast.LENGTH_LONG).show();
        Cursor e=db.rawQuery(q2,null);
        String data ="trip detail:\n------------\n";
        while (e.moveToNext())
        {
            data=data+"Tripid:"+e.getString(0)+"\nSource:"+e.getString(1)+"\nDestination:"+e.getString(2)+"\nStartdate:"+e.getString(3)+"\nenddate:"+e.getString(4)+"\nbudget:"+e.getString(5)+"\nbalance:"+e.getString(6);
        }
        tv1.setText(data);
        // Inflate the layout for this fragment
        return view;
    }


}
