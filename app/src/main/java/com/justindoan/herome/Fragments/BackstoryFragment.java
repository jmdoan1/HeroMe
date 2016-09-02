package com.justindoan.herome.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.justindoan.herome.Activities.MainActivity;
import com.justindoan.herome.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackstoryFragment.BackstoryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackstoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackstoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button primaryBtn;
    private Button secondaryBtn;
    private Button restartBtn;
    private ImageView superImg;
    private TextView descriptionText;
    private TextView superLbl;
    private ImageView blankImg;


    private BackstoryFragmentInteractionListener mListener;

    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        final MainActivity mainActivity = (MainActivity) getActivity();

        String powerPicked = mainActivity.POWER_PICKED;
        String powerHow = mainActivity.POWER_HOW;
        String powerActual = mainActivity.POWER_ACTUAL;
        String powerSecondary = mainActivity.POWER_SECONDARY;
        String heroName = mainActivity.HERO_NAME;
        int heroImg = mainActivity.HERO_IMG;
        int primarySRC = mainActivity.POWER_SRC;
        int secondarySRC = mainActivity.POWER_SRC_SECONDARY;


        primaryBtn = (Button)view.findViewById(R.id.primaryBtn);
        secondaryBtn = (Button)view.findViewById(R.id.secondaryBtn);
        restartBtn = (Button)view.findViewById(R.id.restartBtn);
        superLbl = (TextView)view.findViewById(R.id.superLbl);
        superImg = (ImageView)view.findViewById(R.id.superImg);
        descriptionText = (TextView)view.findViewById(R.id.descriptionTxt);
        blankImg = (ImageView)view.findViewById(R.id.blankImg);

        superLbl.setText(heroName);
        superImg.setImageResource(heroImg);

        //make the second image the same size and hide it in order to center "BACKSTORY"
        blankImg.setImageResource(heroImg);
        blankImg.setAlpha(0);

        descriptionText.setText("Your " + powerPicked + " " + powerHow +". Your secondary power was chosen by the developer at random because he has no idea how super powers work");

        primaryBtn.setText(powerActual);
        primaryBtn.setCompoundDrawablesWithIntrinsicBounds(primarySRC,0,0,0);

        secondaryBtn.setText(powerSecondary);
        secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(secondarySRC,0,0,0);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.loadMainScreen();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackstoryFragmentInteractionListener(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackstoryFragmentInteractionListener) {
            mListener = (BackstoryFragmentInteractionListener) context;
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
    public interface BackstoryFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBackstoryFragmentInteractionListener(Uri uri);
    }
}
