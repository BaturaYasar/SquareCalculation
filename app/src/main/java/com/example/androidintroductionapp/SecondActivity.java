package com.example.androidintroductionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // getting calculate button handle
        Button btnCalculate = findViewById(R.id.btnCalculate);
        // null pointer check
        if (btnCalculate != null) {
            // assigning on click event
            btnCalculate.setOnClickListener(view -> {

                // getting edit control handle
                EditText edtCalculation = findViewById(R.id.edtCalculation);
                // null pointer check
                if (edtCalculation == null) {
                    return;
                } //if
                // simple not-empty validation
                if (TextUtils.isEmpty(edtCalculation.getText())) {
                    Toast
                            .makeText(
                                    this,
                                    getString(R.string.calculation__no_number_provided),
                                    Toast.LENGTH_SHORT
                            )
                            .show();
                    return;
                } //if
                // edit control value to integer
                int providedNumber = Integer.parseInt(edtCalculation.getText().toString());
                // getting text control handle
                TextView txtCalculationResult = findViewById(R.id.txtCalculationResult);
                // null pointer check
                if (txtCalculationResult == null) {
                    return;
                } //if
                // making calculation and displaying result
                txtCalculationResult.setText(
                        String.format(
                                "Calculation result is: %s",
                                (providedNumber * providedNumber)
                        )
                );
            });
        } //if
    }

}