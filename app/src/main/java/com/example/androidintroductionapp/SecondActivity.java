package com.example.androidintroductionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidintroductionapp.fragment.CalculationFragment;
import com.example.androidintroductionapp.fragment.CalculationMadeFragment;

public class SecondActivity
        extends AppCompatActivity
        implements CalculationFragment.OnCalculationMadeListener,
        CalculationMadeFragment.OnCalculateAgainListener {
    private void replaceFragment(Fragment fragment, int containerResId) {
        if (fragment == null) {
            return;
        } //if
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerResId, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CalculationFragment calculationFragment = new CalculationFragment();
        calculationFragment.setOnCalculationMadeListener(this);
        replaceFragment(calculationFragment, R.id.fragmentContainer);
    }
    @Override
    public void onCalculationMade(int result) {
        CalculationMadeFragment calculationMadeFragment = new
                CalculationMadeFragment(result);
        calculationMadeFragment.setOnCalculateAgainListener(this);
        replaceFragment(calculationMadeFragment, R.id.fragmentContainer);
    }
    @Override
    public void onCalculateAgain() {
        CalculationFragment calculationFragment = new CalculationFragment();
        calculationFragment.setOnCalculationMadeListener(this);
        replaceFragment(calculationFragment, R.id.fragmentContainer);
    }
}

