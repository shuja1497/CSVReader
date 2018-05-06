package com.shuja1497.csvreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuilder s = new StringBuilder("");
        try {

            String csvfileString = this.getApplicationInfo().dataDir + File.separatorChar + "cropmonth.csv";
            Toast.makeText(this, csvfileString, Toast.LENGTH_LONG).show();

            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.cropmonth)) ;

            CSVReader csvReader = new CSVReader(inputStreamReader);
            String [] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                s.append(nextLine[0]).append(nextLine[1]).append(nextLine[2]).append(nextLine[3])
                        .append(nextLine[4]).append("\n");
//                System.out.println(nextLine[0] + nextLine[1] + "etc...");
            }

        } catch (IOException e) {
            Toast.makeText(this, "file not found", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        TextView tv = findViewById(R.id.tv);
        tv.setText(s.toString());

    }
}
