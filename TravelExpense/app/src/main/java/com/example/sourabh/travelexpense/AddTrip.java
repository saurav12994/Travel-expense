package com.example.sourabh.travelexpense;

import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddTrip.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AddTrip extends Fragment {
EditText et6,et5;
    private  String a;
    private  String b;

   // private OnFragmentInteractionListener mListener;

    public AddTrip() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


Context cw=getContext();

        View view = inflater.inflate(R.layout.fragment_add_trip, container, false);
        et6=(EditText)view.findViewById(R.id.editText2);
        et5=(EditText)view.findViewById(R.id.editText);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=et5.getText().toString();
                b=et6.getText().toString();
                Bundle args = new Bundle();
                args.putString("CID", a);
                args.putString("CBD", b);
                TripFragment fr=new TripFragment();

                fr.setArguments(args);


            //    android.support.v4.app.FragmentManager fm = getFragmentManager();
              //  fm.beginTransaction().replace(R.id.relative1, fr).commit();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.relative1, fr);
                ft.commit();


            }
        });


        // Inflate the layout for this fragment
        return view;
    }




}
