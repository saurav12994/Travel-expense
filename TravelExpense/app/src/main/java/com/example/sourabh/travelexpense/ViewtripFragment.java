package com.example.sourabh.travelexpense;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewtripFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ViewtripFragment extends ListFragment{
    String s1[]={"saurav","ravi","somaya","Rishabh"};
    String s2[]={"he loves math","he is good","he has good coding skills","he love playing cs"};

   // private OnFragmentInteractionListener mListener;

    public ViewtripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add, container, false);
        ArrayAdapter adapt = null;
        ListView l1=(ListView)view.findViewById(android.R.id.list);
        adapt=new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, s1);
        setListAdapter(adapt);
        // Inflate the layout for this fragment
        return view;
    }



}
