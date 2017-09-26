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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpenseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ExpenseFragment extends Fragment {
 Spinner s1;
    TextView tv1;
    EditText et1,et2,et3,et4;
    String Category[]={"Shopping","Food","bills","Trnsportation","health","Fitness"};
 //   private OnFragmentInteractionListener mListener;

    public ExpenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_expense, container, false);
       s1 = (Spinner) view.findViewById(R.id.spinner);

        et2=(EditText)view.findViewById(R.id.editText6);
        et3=(EditText)view.findViewById(R.id.editText7);

        tv1=(TextView)view.findViewById(R.id.textView1);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Category);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                Toast.makeText(getActivity(),"spinner"+Category[j], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = getContext();

                String a2 = et2.getText().toString();
                String a3 = et3.getText().toString();
                int a6=Integer.parseInt(a2);
                String a4 = getArguments().getString("CID");

                String a5 = (String) s1.getSelectedItem().toString();
                // Inflate the layout for this fragment
                SQLiteDatabase db = c.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS mydataa(expenseid INTEGER PRIMARY KEY AUTOINCREMENT,category VARCHAR, expensedate DATE, amountexpense  INTEGER NOT NULL,tid  INTEGER NOT NULL , FOREIGN KEY(tid) REFERENCES mydata(id));");

               int flag=0;
                String q2="select * from mydataa where category='"+a5+"' and tid='"+a4+"'";
                Cursor e=db.rawQuery(q2,null);
                while (e.moveToNext())
                {
                    db.execSQL("update mydataa set amountexpense=amountexpense+'"+a6+"' where category='"+a5+"' and tid='"+a4+"'");
                    db.execSQL("update mydata set balance=balance-'"+a6+"' where id='"+a4+"'");
                    flag=1;

            }
                if(flag==0)
                {db.execSQL("insert into  mydataa(category,expensedate,amountexpense,tid) values('"+a5+"','"+a3+"','"+a6+"','"+a4+"')");
                    db.execSQL("update mydata set balance=balance-'"+a6+"' where id='"+a4+"'");
                }

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


}
