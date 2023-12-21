package com.example.xkatrina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText editTextWidth, editTextHeight, editTextPaintConsumption, editTextLayerCount, editTextPaintVolume;
    private RadioGroup radioGroupReserve;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWidth = findViewById(R.id.editTextWidth);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextPaintConsumption = findViewById(R.id.editTextPaintConsumption);
        editTextLayerCount = findViewById(R.id.editTextLayerCount);
        editTextPaintVolume = findViewById(R.id.editTextPaintVolume);
        radioGroupReserve = findViewById(R.id.radioGroupReserve);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void CalculateOut(View view) {
        // Получение данных
        double width = Double.parseDouble(editTextWidth.getText().toString());
        double height = Double.parseDouble(editTextHeight.getText().toString());
        double consumption = Double.parseDouble(editTextPaintConsumption.getText().toString());
        int layers = Integer.parseInt(editTextLayerCount.getText().toString());
        double volume = Double.parseDouble(editTextPaintVolume.getText().toString());

        // Выбор запаса
        int selectedRadioButtonId = radioGroupReserve.getCheckedRadioButtonId();
        double reserveFactor = 1.0;
        if (selectedRadioButtonId == R.id.radioButton10Percent) {
            reserveFactor = 1.1;
        } else if (selectedRadioButtonId == R.id.radioButton15Percent) {
            reserveFactor = 1.15;
        }

        // Расчет количества краски
        double Area = width * height * layers;
        double Required = (Area / consumption) * reserveFactor;
        Required = Math.round(Required * 100.0) / 100.0;
        textViewResult.setText("Необходимо " + Required + " краски");
    }
}