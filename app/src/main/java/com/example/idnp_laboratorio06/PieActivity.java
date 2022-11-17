package com.example.idnp_laboratorio06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.math.MathUtils;

import java.util.ArrayList;
import java.util.Collections;

import kotlin.jvm.internal.Intrinsics;

public class PieActivity extends AppCompatActivity {

    private TextView textView;
    private final int[] DEFAULT_COLOR_LIST = {
            Color.parseColor("#33B5E5"),
            Color.parseColor("#AA66CC"),
            Color.parseColor("#99CC00"),
            Color.parseColor("#FFBB33"),
            Color.parseColor("#FF4444"),
            Color.parseColor("#FF00FB"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        textView = (TextView) findViewById(R.id.textView);
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        randomSet(pieView);

    }
    private void randomSet(PieView pieView) {

        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();
        ArrayList<Integer> intList = new ArrayList<Integer>();

        ArrayList<String> test = new ArrayList<String>();
        test.add("Bolivia");
        test.add("Peru");
        test.add("Argentina");
        test.add("Colombia");
        test.add("Ecuador");
        test.add("Mexico");

        float totalInt = 0;

        intList.add(40);
        intList.add(50);
        intList.add(10);
        intList.add(30);
        intList.add(70);
        intList.add(80);
        for (int number : intList)
            totalInt += (float)number;

        int totalNum = intList.size();

        for (int i = 0; i < totalNum; i++) {
            pieHelperArrayList.add(new PieHelper(100 * intList.get(i) / totalInt,test.get(i),DEFAULT_COLOR_LIST[i]));
            textView.append((pieHelperArrayList.get(i).getTitle()+" - "+pieHelperArrayList.get(i).getPercentStr()+"\n"));
        }

        pieView.selectedPie(PieView.NO_SELECTED_INDEX);
        pieView.showPercentLabel(true);
        pieView.setDate(pieHelperArrayList);

        pieView.setOnPieClickListener(new PieView.OnPieClickListener() {
            @Override public void onPieClick(int index) {
                if (index != PieView.NO_SELECTED_INDEX) {
                    PieHelper aux = pieView.getPieHelperList().get(index);
                    textView.setText(aux.getTitle() +" - "+aux.getPercentStr() + " - ");
                }
            }
        });

    }
}