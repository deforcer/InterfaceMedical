package ru.deforce.interfacemedical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private ArrayList<String> list;

    private static final String TAG = "Мое здоровье";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        name = findViewById(R.id.inputName);
        age = findViewById(R.id.inputAge);

        list = new ArrayList();
    }

    public void onClickSaveBtn(View view) {

        Log.i(TAG,"Нажали кнопку сохранить");

        list.add(name.getText().toString());
        list.add(age.getText().toString());

        Log.i(TAG,"Добавлены значения " + name.getText().toString() + " " + age.getText().toString());

    }


    public void onClickPressureBtn(View view) {
        Intent intent = new Intent(MainActivity.this, PressureActivity.class);
        startActivity(intent);

        Log.i(TAG,"Нажали кнопку Давление");

    }

    public void onClickHealthBtn(View view) {
        Intent intent = new Intent(MainActivity.this, HealthActivity.class);
        startActivity(intent);

        Log.i(TAG,"Нажали кнопку Жизненные показатели");
    }
}
