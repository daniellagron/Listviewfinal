package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv1;
    ListView lv1;
    Button btn1;
    String getcont;
    String Africa[]= {"Nigeria","Kenya","morocco","Ghana","Algeria","Ethiopia","Sudan"};
    String America[]= {"United States" , "Canada" , "Mexico", "Brazil","Argentina","Colombia","Peru"};
    String Europe [] = {"Germany","Italy","United Kingdom","France","Spain","Netherlands","Sweden"};
    String Asia[] = {"Israel","India","Japan","China","Thailand","Iran","Iraq"};
    String Australia[] = {"New Zealand","Tonga","Fiji","Tuvalu","Palau","Kiribati","Vanuatu"};

    String capital [][] = {{"Abuja","Nairobi","Rabat","Accra","Algier","Addis Ababa","Hartum"},{"Washington","Ottawa","Mexico city","Brazilia","Buenos Aires","Bogota","Lima"},{"Berlin","Rome","London","Paris","Madrid","Amsterdam","stockholm"},{"Jerusalem","New dehli","Tokyo","Beijing","Bangkok","Tehran","Bagdad"},{"Wellington","Nokualofa","Suva","Funafuti","Melekeok","Tarawa","Port vila"}};
    String Population [][]= {{"776,298","4,556,381","577,827","30,096,970","41,929,421","3,384,569","1,974,647"},{"7,666,343","994,837","8,918,653","2,302,102","2,891,000","10,779,000","9,751,717"},{"3,580,188","2,850,239","8,787,892","12,089,098","3,324,854","854,000","965,232"},{"874,186","18,749,992","37,435,191","24,302,851","69,183,173","8,422,166","9,825,221"},{"418,500","108,020","920,938","6,152","381","118,016","299,882"}};

    TextView Cap,Pop;

    int cont;
    int country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent si = getIntent();
        getcont = si.getStringExtra("Cont");
        cont = si.getIntExtra("cont",9229);

        lv1 = findViewById(R.id.lv1);
        btn1 = findViewById(R.id.btn1);

        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        Cap = (TextView)findViewById(R.id.Cap);//capital
        Pop = (TextView)findViewById(R.id.Pop);//Population


        switch(getcont){
            case "Africa":{
                ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Africa);
                lv1.setAdapter(adp);
                break;
            }
            case "America":{
                ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, America);
                lv1.setAdapter(adp);

                break;
            }
            case "Europe":{
                ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Europe);
                lv1.setAdapter(adp);

                break;
            }
            case "Asia":{
                ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Asia);
                lv1.setAdapter(adp);

                break;
            }
            case "Australia":{
                ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Australia);
                lv1.setAdapter(adp);

                break;
            }
        }

        tv1 = findViewById(R.id.tv1);
        tv1.setText(getcont);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        country = (position);
        Cap.setText("Capital: "+capital[cont][country]);
        Pop.setText("Population: "+Population[cont][country]);

    }

    public void Back(View view){
        finish();
        Intent si2 = new Intent(this,MainActivity.class);
        startActivity(si2);
    }
}
