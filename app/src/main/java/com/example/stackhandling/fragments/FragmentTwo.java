package com.example.stackhandling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stackhandling.R;
import com.example.stackhandling.interfaces.FragmentNavigation;

public class FragmentTwo extends Fragment implements View.OnClickListener{

    private FragmentNavigation fragmentNavigation;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            fragmentNavigation = (FragmentNavigation) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);

        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        fragmentNavigation.navigateToFragmentFour();
    }
}
