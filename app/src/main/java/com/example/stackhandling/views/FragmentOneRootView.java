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
import com.example.stackhandling.fragments.FragmentOne;

public class FragmentOneRootView extends Fragment {

    public static FragmentOneRootView newInstance() {

        Bundle args = new Bundle();

        FragmentOneRootView fragment = new FragmentOneRootView();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_root_view, container, false);
        prepareFragmentStack();
        return view;
    }

    private void prepareFragmentStack() {
        if (getFragmentManager() != null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_one_root, new FragmentOne(), "frag_one");
            fragmentTransaction.commit();
        }
    }
}
