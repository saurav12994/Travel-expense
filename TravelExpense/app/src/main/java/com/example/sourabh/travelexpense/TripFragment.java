package com.example.sourabh.travelexpense;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TripFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TripFragment extends Fragment implements View.OnClickListener {

    //private OnFragmentInteractionListener mListener;
    EditText et1, et2, et3, et4;
    TextView tv1;
    //private String str1;
    //private String str2;

//TextView tv1;


    public TripFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trip, container, false);


        //  et1=(EditText)view.findViewById(R.id.editText1);
        tv1 = (TextView) view.findViewById(R.id.textView8);
        et2 = (EditText) view.findViewById(R.id.editText2);
        et3 = (EditText) view.findViewById(R.id.editText3);
        et4 = (EditText) view.findViewById(R.id.editText4);
        Button button1 = (Button) view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = getContext();
                //        String a1=et1.getText().toString();
                String a2 = et2.getText().toString();
                String a3 = et3.getText().toString();
                String a4 = et4.getText().toString();
                String str2 = getArguments().getString("CBD");
                String str1 = getArguments().getString("CID");
                Toast.makeText(getActivity(), str1, Toast.LENGTH_LONG).show();

                SQLiteDatabase db = c.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);

                db.execSQL("CREATE TABLE IF NOT EXISTS mydata(id INTEGER PRIMARY KEY  AUTOINCREMENT,source VARCHAR, dest VARCHAR ,start DATE,end DATE,budget INTEGER NOT NULL,balance  INTEGER NOT NULL);");
                Toast.makeText(getActivity(), "HIBRO", Toast.LENGTH_LONG).show();
                db.execSQL("insert into  mydata(source , dest , start , end , budget , balance ) values('"+str2+"','"+str1+"','"+a3+"','"+a4+"','"+a2+"','"+a2+"')");

                db.close();
                ViewFragment fr=new ViewFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.relative1, fr);
                ft.commit();

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}


