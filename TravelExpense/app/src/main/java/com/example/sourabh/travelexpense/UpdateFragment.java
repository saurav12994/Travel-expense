package com.example.sourabh.travelexpense;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UpdateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class UpdateFragment extends Fragment {



    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final int[] flag = new int[1];
        RadioGroup rg;
         View view = inflater.inflate(R.layout.fragment_update, container, false);
        rg=(RadioGroup)view.findViewById(R.id.radiogroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String str = "you have checked ";
                switch (i) {
                    case R.id.radioButton:
                        flag[0] =1;
                        break;
                    case R.id.radioButton2:
                        flag[0] =2;
                        break;
                    case R.id.radioButton3:
                        flag[0] =3;
                        break;


                }

            }
            });
        Button button = (Button) view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if(flag[0]==1) {
   MyFragment fr=new MyFragment();
    android.support.v4.app.FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.relative1, fr);
    ft.commit();
    Toast.makeText(getActivity(),"hi",Toast.LENGTH_LONG).show();
}
                if(flag[0]==2) {
               Update1Fragment fr=new Update1Fragment();
    android.support.v4.app.FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.relative1, fr);
    ft.commit();
                    Toast.makeText(getActivity(),"helllo",Toast.LENGTH_LONG).show();

                }
                if(flag[0]==3) {
                  UpdatedestFragment fr=new UpdatedestFragment();
    android.support.v4.app.FragmentManager fm=getFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.relative1, fr);
    ft.commit();
                    Toast.makeText(getActivity(),"hibro",Toast.LENGTH_LONG).show();
                }

            }});
        return view ;
    }


}
