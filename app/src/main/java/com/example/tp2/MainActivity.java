package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView resul;
    private Button nbr0,nbr1,nbr2,nbr3,nbr4,nbr5,nbr6,nbr7,nbr8,nbr9;
    private Button division,multi,moin,adision,point,eq,c;

    private String valuer=" ";


    public void displayMsg(String str){
        Toast.makeText(this,  str, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resul= findViewById(R.id.res);

        nbr0= findViewById(R.id.nbr0);
        nbr1= findViewById(R.id.nbr1);
        nbr2= findViewById(R.id.nbr2);
        nbr3= findViewById(R.id.nbr3);
        nbr4= findViewById(R.id.nbr4);
        nbr5= findViewById(R.id.nbr5);
        nbr6= findViewById(R.id.nbr6);
        nbr7= findViewById(R.id.nbr7);
        nbr8= findViewById(R.id.nbr8);
        nbr9= findViewById(R.id.nbr9);

        division= findViewById(R.id.division);
        multi= findViewById(R.id.multi);
        moin= findViewById(R.id.moin);
        adision= findViewById(R.id.adision);
        point= findViewById(R.id.point);
        eq= findViewById(R.id.eq);
        c= findViewById(R.id.c);
    }
    public void click(View V) {

        Button button = (Button) V;
        String val = button.getText().toString();


        if (val.equals("c")) {
            valuer = "";
            resul.setText(valuer);
        }
        if (!val.equals("=") && !val.equals("c")) {
            valuer += val;
            resul.setText(valuer);
        }
        if (val.equals("=")) {
            try {

                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initStandardObjects();
                String finall = context.evaluateString(scriptable, valuer, "Javascript", 1, null).toString();
                valuer = finall;
                resul.setText(finall);



            }catch (Exception e){
                resul.setText("ee");
            }
        }


    }
}
