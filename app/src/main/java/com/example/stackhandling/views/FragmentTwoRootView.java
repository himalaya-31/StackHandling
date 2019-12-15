package com.example.stackhandling.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.stackhandling.R;
import com.example.stackhandling.fragments.FragmentTwo;

public class FragmentTwoRootView extends Fragment {
    public static FragmentTwoRootView newInstance() {

        Bundle args = new Bundle();

        FragmentTwoRootView fragment = new FragmentTwoRootView();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_root_view, container, false);
        prepareFragmentStack();
        return view;
    }

    private void prepareFragmentStack() {
        if (getFragmentManager() != null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_two_root, new FragmentTwo(), "frag_two");
            fragmentTransaction.commit();
        }
    }
}
