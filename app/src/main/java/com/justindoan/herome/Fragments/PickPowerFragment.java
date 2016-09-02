package com.justindoan.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.justindoan.herome.Activities.MainActivity;
import com.justindoan.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strengthBtn;
    private Button showBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightbtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        strengthBtn = (Button)view.findViewById(R.id.strengthBtn);
        showBtn = (Button)view.findViewById(R.id.showBtn);

        showBtn.setEnabled(false);
        showBtn.getBackground().setAlpha(128);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadBackstoryScreen();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

        showBtn.setEnabled(true);
        showBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

        Button btn = (Button)v;

        MainActivity mainActivity = (MainActivity) getActivity();

        if (btn == turtleBtn) {
            turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "powers of the turtle";
            mainActivity.POWER_ACTUAL = "TURTLE POWER";
            mainActivity.POWER_SECONDARY = "FLIGHT";
            mainActivity.HERO_NAME = "Shell Dude";
            mainActivity.HERO_IMG = R.drawable.turtle_power;
            mainActivity.POWER_SRC = R.drawable.turtle_power;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.super_man_crest;
        } else if (btn == lightningBtn) {
            lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "flashy flash ouchie powers";
            mainActivity.POWER_ACTUAL = "LIGHTNING";
            mainActivity.POWER_SECONDARY = "SUPER STRENGTH";
            mainActivity.HERO_NAME = "Electro Man";
            mainActivity.HERO_IMG = R.drawable.lightning;
            mainActivity.POWER_SRC = R.drawable.thors_hammer;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.super_strength;
        } else if (btn == flightBtn) {
            flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "long jumping skills";
            mainActivity.POWER_ACTUAL = "FLIGHT";
            mainActivity.POWER_SECONDARY = "LASER VISION";
            mainActivity.HERO_NAME = "Fly Guy";
            mainActivity.HERO_IMG = R.drawable.big_superman_logo;
            mainActivity.POWER_SRC = R.drawable.super_man_crest;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.laser_vision;
        } else if (btn == webBtn) {
            webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "consistently sticky hands";
            mainActivity.POWER_ACTUAL = "WEB SLINGING";
            mainActivity.POWER_SECONDARY = "TURTLE POWER";
            mainActivity.HERO_NAME = ".com Man";
            mainActivity.HERO_IMG = R.drawable.spider_web;
            mainActivity.POWER_SRC = R.drawable.spider_web;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.turtle_power;
        } else if (btn == laserBtn) {
            laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "countless hours of cat entertainment";
            mainActivity.POWER_ACTUAL = "LASER VISION";
            mainActivity.POWER_SECONDARY = "LIGHTNING";
            mainActivity.HERO_NAME = "Red Eye";
            mainActivity.HERO_IMG = R.drawable.laser_vision;
            mainActivity.POWER_SRC = R.drawable.laser_vision;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.thors_hammer;
        } else if (btn == strengthBtn) {
            strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,R.drawable.item_selected,0);
            mainActivity.POWER_PICKED = "uncanny thumb wrestling abilities";
            mainActivity.POWER_ACTUAL = "SUPER STRENGTH";
            mainActivity.POWER_SECONDARY = "WEB SLINGING";
            mainActivity.HERO_NAME = "Helpsyoumove Friend";
            mainActivity.HERO_IMG = R.drawable.super_strength;
            mainActivity.POWER_SRC = R.drawable.super_strength;
            mainActivity.POWER_SRC_SECONDARY = R.drawable.spider_web;
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerInteractionListener(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerInteractionListener(Uri uri);
    }
}
