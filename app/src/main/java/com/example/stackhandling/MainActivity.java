package com.example.stackhandling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.stackhandling.adapters.ViewPagerAdapter;
import com.example.stackhandling.fragments.FragmentFour;
import com.example.stackhandling.interfaces.AddFragmentsToStackListener;
import com.example.stackhandling.interfaces.FragmentNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements FragmentNavigation, BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener, AddFragmentsToStackListener {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    private Stack<Fragment> stackOne = new Stack<>();
    private Stack<Fragment> stackTwo = new Stack<>();
    private Stack<Fragment> stackThree = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        switch (viewPager.getCurrentItem()) {
            case 0:
                if (stackOne.size() > 1) {
                    Fragment fragment = stackOne.peek();
                    stackOne.pop();
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .show(stackOne.peek())
                            .commit();
                } else {
                    finish();
                }
                break;
            case 1:
                if (stackTwo.size() > 1) {
                    Fragment fragment = stackTwo.peek();
                    stackTwo.pop();
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .show(stackTwo.peek())
                            .commit();
                } else {
                    bottomNavigationView.setSelectedItemId(R.id.f1);
                }
                break;
            case 2:
                if (stackThree.size() > 1) {
                    Fragment fragment = stackThree.peek();
                    stackThree.pop();
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .show(stackThree.peek())
                            .commit();
                } else {
                    bottomNavigationView.setSelectedItemId(R.id.f1);
                }
                break;
        }
    }

    @Override
    public void navigateToFragmentFour() {
        FragmentFour fragmentFour = new FragmentFour();
        switch (viewPager.getCurrentItem()) {
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_one_root, fragmentFour, "frag_four1")
                        .show(fragmentFour)
                        .hide(stackOne.elementAt(stackOne.size() - 1))
                        .commit();
                stackOne.add(fragmentFour);
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_two_root, fragmentFour, "frag_four2")
                        .show(fragmentFour)
                        .hide(stackTwo.elementAt(stackTwo.size() - 1))
                        .commit();
                stackTwo.add(fragmentFour);
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_three_root, fragmentFour, "frag_four3")
                        .show(fragmentFour)
                        .hide(stackThree.elementAt(stackThree.size() - 1))
                        .commit();
                stackThree.add(fragmentFour);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.f1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.f2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.f3:
                viewPager.setCurrentItem(2);
                break;
        }
        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.f1:
                clearStack(stackOne);
                getSupportFragmentManager().beginTransaction().show(stackOne.peek()).commit();
                break;
            case R.id.f2:
                clearStack(stackTwo);
                getSupportFragmentManager().beginTransaction().show(stackTwo.peek()).commit();
                break;
            case R.id.f3:
                clearStack(stackThree);
                getSupportFragmentManager().beginTransaction().show(stackThree.peek()).commit();
                break;

        }
    }

    private void clearStack(Stack<Fragment> stack) {
        int stackSize = stack.size();
        for (int i = 1; i < stackSize; i++) {
            getSupportFragmentManager().beginTransaction().remove(stack.peek());
            stack.pop();
        }
    }

    @Override
    public void addFragmentsToStack() {
        if (!stackOne.contains(getSupportFragmentManager().findFragmentByTag("frag_one")))
            stackOne.add(getSupportFragmentManager().findFragmentByTag("frag_one"));
        if (!stackTwo.contains(getSupportFragmentManager().findFragmentByTag("frag_two")))
            stackTwo.add(getSupportFragmentManager().findFragmentByTag("frag_two"));
        if (!stackThree.contains(getSupportFragmentManager().findFragmentByTag("frag_three")))
            stackThree.add(getSupportFragmentManager().findFragmentByTag("frag_three"));
    }
}
