package com.example.sourabh.travelexpense;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TripwiseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TripwiseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripwiseFragment extends Fragment {
    Spinner s1;
    ArrayList screens;
    //private OnFragmentInteractionListener mListener;

    public TripwiseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TripwiseFragment.
     */
    // TODO: Rename and change types and number of parameters




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tripwise, container, false);

        s1 = (Spinner) view.findViewById(R.id.spinner2);
        Button button = (Button) view.findViewById(R.id.button);
        Context context=getContext();
        SQLiteDatabase db = context.openOrCreateDatabase("TravelexpenseDB",Context.MODE_APPEND, null);
        String q1 = "select * from  mydata ";
        Cursor e= db.rawQuery(q1,null);
        String name;
        screens=new ArrayList();
        while (e.moveToNext())
        {
            name=e.getString(0);
            screens.add(name);
        }

        ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,screens);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                Toast.makeText(getActivity(),"spinner"+ screens.get(j), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        db.close();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (String) s1.getSelectedItem().toString();
                 Bundle args = new Bundle();
                 args.putString("CID", a);
                ViewdetailFragment fre=new ViewdetailFragment();
                fre.setArguments(args);
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.relative1, fre);
                ft.commit();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }


}
