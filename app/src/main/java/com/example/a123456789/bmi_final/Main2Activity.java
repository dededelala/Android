package com.example.a123456789.bmi_final;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText heightView,weightView,bmiView;

    double height,weight,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        heightView = (EditText) findViewById(R.id.height_input);
        weightView = (EditText) findViewById(R.id.weight_input);
        bmiView = (EditText) findViewById(R.id.usrBMI);
        //TODO caculate bmi()
        caculate();
    }
    public void caculate(){
        heightView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(start>=2)
                {
                    if(heightView.getText().toString().length()!=0&&weightView.getText().toString().length()!=0
                            &&Double.parseDouble(heightView.getText().toString())<300&&Double.parseDouble(heightView.getText().toString())>0)
                    {
                        height=Double.parseDouble(heightView.getText().toString());
                        weight=Double.parseDouble(weightView.getText().toString());
                        bmi=weight/((height/100)*(height/100));
                        DecimalFormat df=new DecimalFormat("#.00");
                        bmiView.setText(""+df.format(bmi));
                    }
                    else if(Double.parseDouble(heightView.getText().toString())>300||Double.parseDouble(heightView.getText().toString())<0)
                    {
                        Toast.makeText(getApplicationContext(), "请输入正确的身高",Toast.LENGTH_SHORT).show();
                        bmiView.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        weightView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(start>=1)
                {
                    if(heightView.getText().toString().length()!=0&&weightView.getText().toString().length()!=0
                            &&Double.parseDouble(weightView.getText().toString())<250&&Double.parseDouble(weightView.getText().toString())>0)
                    {
                        height=Double.parseDouble(heightView.getText().toString());
                        weight=Double.parseDouble(weightView.getText().toString());
                        bmi=weight/((height/100)*(height/100));
                        DecimalFormat df=new DecimalFormat("#.00");
                        bmiView.setText(""+df.format(bmi));
                    }
                    else if(Double.parseDouble(weightView.getText().toString())>250||Double.parseDouble(weightView.getText().toString())<0)
                    {
                        Toast.makeText(getApplicationContext(), "请输入正确的体重",Toast.LENGTH_SHORT).show();
                        bmiView.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }

    public void back(View view) {
        super.finish();
    }
}
