package com.example.sourabh.travelexpense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Update1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Update1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdatedestFragment extends Fragment {
    EditText et6,et5;
    private  String a;
    private  String b;
    public UpdatedestFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view =inflater.inflate(R.layout.fragment_updatedest, container, false);
        et6=(EditText)view.findViewById(R.id.editText5);
        et5=(EditText)view.findViewById(R.id.editText8);
        Button button = (Button) view.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            Context c=getContext();
            @Override
            public void onClick(View view) {
                a=et6.getText().toString();
                b=et5.getText().toString();
                SQLiteDatabase db = c.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);
                db.execSQL("update mydata set budget='"+b+"' where id='"+a+"' ");
                ViewFragment fr=new ViewFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.relative1, fr);
                ft.commit();}});

        // Inflate the layout for this fragment
        return  view ;
    }


}
