package com.example.idnp_laboratorio06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class BarraActivity extends AppCompatActivity {
    BarView barView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);
        barView = (BarView)findViewById(R.id.bar_view);

        randomSet(barView);
    }
    private void randomSet(BarView barView){
        ArrayList<String> test = new ArrayList<String>();
        test.add("Bolivia");
        test.add("Peru");
        test.add("Argentina");
        test.add("Colombia");
        test.add("Ecuador");
        test.add("Mexico");

        barView.setBottomTextList(test);

        ArrayList<Integer> barDataList = new ArrayList<Integer>();

        barDataList.add(40);
        barDataList.add(50);
        barDataList.add(10);
        barDataList.add(30);
        barDataList.add(70);
        barDataList.add(80);


        int limite = Collections.max(barDataList);

        barView.setDataList(barDataList, limite+(limite/4));
    }
}