package com.example.week_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox red,blue,green;
        Button button;
        Spinner spinner;
        TextView textView1,textView2;
        SeekBar seekBar;

        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        green = findViewById(R.id.green);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        seekBar = findViewById(R.id.seekBar);


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int seek_value = (seekBar.getThumbOffset()*i)/22;
                textView2.setText(Integer.toString(seek_value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(spinner.getSelectedItem().toString());

                int seek_value = seekBar.getProgress();
                textView2.setText(Integer.toString(seek_value));



                if (red.isChecked() && !blue.isChecked() && !green.isChecked()) {
                    Toast.makeText(MainActivity.this, "red", Toast.LENGTH_SHORT).show();
                }
                else if (!red.isChecked() && blue.isChecked() && !green.isChecked()) {
                    Toast.makeText(MainActivity.this, "blue", Toast.LENGTH_SHORT).show();
                }
                else if (!red.isChecked() && !blue.isChecked() && green.isChecked()) {
                    Toast.makeText(MainActivity.this, "green", Toast.LENGTH_SHORT).show();
                }
                else if (!red.isChecked() && !blue.isChecked() && !green.isChecked()) {
                    Toast.makeText(MainActivity.this, "None Select", Toast.LENGTH_SHORT).show();
                }
                else if (red.isChecked() && blue.isChecked() && green.isChecked()) {
                    Toast.makeText(MainActivity.this, "U R select All", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}