package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String cont[]={"Africa","America","Europe","Asia","Australia"};
    ListView lv1;
    TextView tv1;
    Button next;
    String Ncont;
    int lel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,cont);
        lv1.setAdapter(adp);
        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        next = (Button)findViewById(R.id.btn1);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setTextSize(70);
        Toast.makeText(MainActivity.this,cont[position],Toast.LENGTH_SHORT).show();
        tv1.setText(cont[position]);
        lel = (position);
    }

    public void next(View view) {
        if(tv1.getText().equals("Choose Continent"))
            Toast.makeText(MainActivity.this,"Please choose a continent first",Toast.LENGTH_SHORT).show();
        else {
            Ncont = tv1.getText().toString();
            Intent si = new Intent(this, Main2Activity.class);
            si.putExtra("Cont", Ncont);
            si.putExtra("cont",lel);
            startActivity(si);
        }
    }
}
