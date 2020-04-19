package ru.deforce.interfacemedical;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PressureActivity extends AppCompatActivity {

    private EditText upperPressure;
    private EditText lowerPressure;
    private EditText pulse;
    private CheckBox tachycardia;

    private int DIALOG_DATE = 1;
    private int myYear = 2020;
    private int myMonth = 4;
    private int myDay = 19;
    private EditText date;


    private ArrayList<String> list;

    private static final String TAG = "Давление";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        init();
    }

    public void init() {
        upperPressure = findViewById(R.id.inputUpperPressure);
        lowerPressure = findViewById(R.id.inputLowePressure);
        pulse = findViewById(R.id.inputPulse);
        tachycardia = findViewById(R.id.checkboxTachycardia);
        date = findViewById(R.id.inputDate);

        list = new ArrayList<>();
    }

    public void onDateclick(View view) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            date.setText(myDay + "." + myMonth + "." + myYear);
            date.clearFocus();
        }
    };

    public void onClickSaveBtn(View view) {

        Log.i(TAG, "Нажали кнопку Сохранить");

        list.add(upperPressure.getText().toString());
        list.add(lowerPressure.getText().toString());
        list.add(pulse.getText().toString());
        if (tachycardia.isChecked()) {
            list.add("1");
        } else {
            list.add("0");
        }
        list.add(date.getText().toString());

        Log.i(TAG, "Добавлены значения "
                + upperPressure.getText().toString()
                + " "
                + lowerPressure.getText().toString()
                + " "
                + pulse.getText().toString()
                + " "
                + tachycardia.isChecked()
                + " "
                + date.getText().toString()
        );

    }
}
