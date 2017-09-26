package com.example.sourabh.travelexpense;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ViewFragment extends Fragment {

  //  private OnFragmentInteractionListener mListener;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        TableLayout t1=(TableLayout)view.findViewById(R.id.tableLayout1);
        TableRow tr;
        Context co=getContext();
        SQLiteDatabase db = co.openOrCreateDatabase("TravelexpenseDB", Context.MODE_APPEND, null);
        String q="select * from mydata ";
        Cursor c=db.rawQuery(q,null);
        String name,marks,name1,marks1;
        while (c.moveToNext())
        {

            name=c.getString(0);
            marks=c.getString(1);
            name1=c.getString(2);
            marks1=c.getString(3);

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


        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.travelexpense, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Context c1=getContext();
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            DeleteFragment fr=new DeleteFragment();
            android.support.v4.app.FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.relative1, fr);
            ft.commit();
            return true;
        }
        if (id == R.id.action_update) {
            UpdateFragment fr=new UpdateFragment();
            android.support.v4.app.FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.relative1, fr);
            ft.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
