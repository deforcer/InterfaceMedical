package ru.deforce.interfacemedical;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    private EditText weight;
    private EditText steps;
    private ArrayList<String> list;

    private static final String TAG = "Жизненные показатели";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        init();
    }

    public void init() {
        weight = findViewById(R.id.inputWeight);
        steps = findViewById(R.id.inputSteps);

        list = new ArrayList<>();
    }

    public void onClickSaveBtn(View view) {

        Log.i(TAG, "Нажали кнопку Сохранить");

        list.add(weight.getText().toString());
        list.add(steps.getText().toString());

        Log.i(TAG,"Добавлены значения " + weight.getText().toString() + " " + steps.getText().toString());

    }

}
