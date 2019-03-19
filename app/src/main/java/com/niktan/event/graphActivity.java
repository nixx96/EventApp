package com.niktan.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.AnyChart;

import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class graphActivity extends AppCompatActivity {
    public  ArrayList<Integer> graphtimes;
    public  ArrayList<String> graphevents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Bundle bundle = getIntent().getExtras();
        graphtimes = (ArrayList<Integer>) bundle.getIntegerArrayList("timesArrayList");
        graphevents = (ArrayList<String>) bundle.getStringArrayList("eventsArrayList");
        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();

        for(int i=0;i<graphevents.size();i++) {
            data.add(new ValueDataEntry(graphevents.get(i), graphtimes.get(i)));

        }
        pie.data(data);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
        anyChartView.setChart(pie);

    }
}
