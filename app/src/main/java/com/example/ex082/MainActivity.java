package com.example.ex082;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton rB1,rB2;
    EditText eT1,eT2;
    Button btn1;
    double num,y;
    int seriesType=-1;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        si=new Intent(this, MainActivity2.class);
        rB1 = (findViewById(R.id.rB1));
        rB2 = (findViewById(R.id.rB2));
        eT1 = (findViewById(R.id.eT1));
        eT2 = (findViewById(R.id.eT2));
        btn1 = (findViewById(R.id.btn1));
        eT1.setHint("Enter the first number of the series");
        eT2.setHint("Enter the multiplier/difference of the series");

        btn1.setOnClickListener(view -> {
            if (rB1.isChecked()) seriesType=0;
            else if (rB2.isChecked()) seriesType=1;
            if (seriesType==-1)
                Toast.makeText(MainActivity.this, "You must chose the series type", Toast.LENGTH_LONG).show();
            else if(inputIsOk()){
                si.putExtra("y", y);
                si.putExtra("num",num);
                si.putExtra("seriesType", seriesType);
                startActivity(si);
            }
        });

    }
    public boolean inputIsOk() {
        String st = eT1.getText().toString();
        if (st.matches("-?\\d+(\\.\\d+)?")) {
            num = Double.parseDouble(st);
            st = eT2.getText().toString();
            if (st.matches("-?\\d+(\\.\\d+)?")) {
                y = Double.parseDouble(st);
                return true;
            } else {
                eT2.setText("");
                Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        else {
            eT1.setText("");
            Toast.makeText(MainActivity.this, "You must enter a number", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
