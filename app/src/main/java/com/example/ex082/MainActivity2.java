package com.example.ex082;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv1;
    TextView tv,tv1,tv2,tv3,tv4;
    int seriesType;
    double y, num, sum;
    String[] arr= new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initialize();

        if(seriesType==0) {
            tv.setText("d = ");
            for (int i = 1; i < arr.length; i++)
                arr[i] = (num + y * (i)) + "";
        }
        else{
            tv.setText("q = ");
            for (int i = 1; i < arr.length; i++)
                arr[i] = String.format("%s", (num * Math.pow(y,i)));
        }
        ArrayAdapter<String> adp= new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        lv1.setAdapter(adp);
    }

    @SuppressLint("SetTextI18n")
    public void initialize(){
        lv1= findViewById(R.id.lv1);
        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        Intent gi= getIntent();
        seriesType=gi.getIntExtra("seriesType", -1);
        y=gi.getDoubleExtra("y", 0);
        num=gi.getDoubleExtra("num", -1);
        arr[0] = num + "";
        tv1.setText(num+" ");
        tv2.setText(y+" ");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv3.setText(i + 1+ " ");
        if (seriesType==0){
            sum = ((2*num +i*y)*(i+1))/2;
        }
        else{
            sum= num* (((Math.pow(y,i+1))-1)/(y-1));
        }
        tv4.setText(String.format("%s", sum));
    }
}