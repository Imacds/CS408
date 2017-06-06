package com.googleworkshop.jakub.complexcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view){
        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        ComplexNum c1 = new ComplexNum(et1.getText().toString());
        ComplexNum c2 = new ComplexNum(et2.getText().toString());

        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText(c1.add(c2).toString());
    }

    public void subtract(View view){
        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        ComplexNum c1 = new ComplexNum(et1.getText().toString());
        ComplexNum c2 = new ComplexNum(et2.getText().toString());

        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText(c1.subtract(c2).toString());
    }

    public void multiply(View view){
        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        ComplexNum c1 = new ComplexNum(et1.getText().toString());
        ComplexNum c2 = new ComplexNum(et2.getText().toString());

        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText(c1.multiply(c2).toString());
    }

    public void divide(View view){
        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        ComplexNum c1 = new ComplexNum(et1.getText().toString());
        ComplexNum c2 = new ComplexNum(et2.getText().toString());

        TextView tv = (TextView)findViewById(R.id.textView5);
        tv.setText(c1.divide(c2).toString());
    }

}
