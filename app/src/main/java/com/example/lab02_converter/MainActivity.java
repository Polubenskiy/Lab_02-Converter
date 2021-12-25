package com.example.lab02_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {
    //Polubenskiy_Danya_393 Lab_02 - Converter
    Spinner spForm;
    Spinner spTo;

    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spForm = findViewById(R.id.spinnerFrom);
        spTo = findViewById(R.id.spinnerTo);

        etFrom = findViewById(R.id.editTextTextPersonNameFrom);
        tvTo = findViewById(R.id.textViewToConvert);

        ArrayAdapter<Unit> adapter = new <Unit> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adapter.add(new Unit( "mm", 1000.0f));
        adapter.add(new Unit( "cm", 100.0f));
        adapter.add(new Unit( "m", 1.0f));
        adapter.add(new Unit( "km", 0.001f));

        spForm.setAdapter(adapter);
        spTo.setAdapter((adapter));
    }

    public void on_convert(View v)
    {
        //Polubenskiy_Danya_393 Lab_02 - Converter
        String t_from = etFrom.getText().toString();
        if (t_from.isEmpty())
        {
            Toast.makeText(this, R.string.message_error, Toast.LENGTH_SHORT).show();
            return;
        }
        Float i_from = 0f;

        try
        {
            i_from = Float.parseFloat(t_from);
        }
        catch (Exception e)
        {
            Toast.makeText(this, R.string.message_error_overflow, Toast.LENGTH_SHORT).show();
        }


        Unit s_unit_from = (Unit) spForm.getSelectedItem();
        Unit s_unit_to = (Unit) spTo.getSelectedItem();


        float f_result = (float) i_from / s_unit_from.coeff * s_unit_to.coeff;

        if (Math.round(f_result) != 0)
        {
            f_result = Math.round(f_result);
        }
        else
        {
            f_result = (f_result);
        }

        String s_result = String.valueOf(f_result);
        tvTo.setText(s_result);
    }
}