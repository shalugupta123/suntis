package com.example.ankita.testapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Model> empDetails;
    private EditText ed_name, ed_tel;
    private RadioButton rd_btn_male, rd_btn_female;
    private RadioButton radioButton;
    RadioGroup radioGroup;
    private Button btn_submit;
    private ListView lview;
    String name, tel, sex;
    Model model;
    TextView welcom, fb_uner_name, fb_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        /*to init all view ids*/
        getId();
        actionBar();
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "FuturaMediumBT.ttf");

        welcom.setTypeface(custom_font);


        Bundle bundle = getIntent().getExtras();
        if (!bundle.equals(null)) {
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            // textView.setText(" name : "+bundle.getString("name")+","+"email : " +bundle.getString("email"));
            fb_uner_name.setText(name);
            fb_uner_name.setTypeface(custom_font);
            fb_user_email.setText(email);
            fb_uner_name.setTypeface(custom_font);
        } else {
            fb_uner_name.setText("");
            fb_uner_name.setTypeface(custom_font);
            fb_user_email.setText("");
            fb_uner_name.setTypeface(custom_font);
        }





       /*redio button click*/

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                if (rd_btn_male.isChecked()) {
                    rd_btn_male.setTextColor(getResources().getColor(R.color.white));
                    rd_btn_female.setBackgroundResource(R.drawable.custom_radio_btn);
                    rd_btn_female.setTextColor(getResources().getColor(R.color.ragularStateColor));
                }
                if (rd_btn_female.isChecked()) {
                    rd_btn_female.setTextColor(getResources().getColor(R.color.white));
                    rd_btn_male.setBackgroundResource(R.drawable.custom_radio_btn);
                    rd_btn_male.setTextColor(getResources().getColor(R.color.ragularStateColor));

                }
            }
        });

        /*click on submit button*/
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean fieldsOK = validate(new EditText[]{ed_name, ed_tel});

                if (fieldsOK) {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);


                    if (radioButton != null) {
                        name = ed_name.getText().toString();
                        tel = ed_tel.getText().toString();
                        sex = radioButton.getText().toString();
                       /*must check null before inserting values*/
                        model = new Model(name, tel, sex);
                        empDetails.add(model);

                        listviewAdapter adapter = new listviewAdapter(MainActivity.this, empDetails);
                        lview.setAdapter(adapter);

                        //  populateList();
                        adapter.notifyDataSetChanged();

                        ed_name.setText("");
                        ed_tel.setText("");


                    } else {

                        Toast.makeText(MainActivity.this, "please select gender.", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, "please fill all the fields.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void actionBar() {
        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();
    }

    private boolean validate(EditText[] fields) {
        for (int i = 0; i < fields.length; i++) {
            EditText currentField = fields[i];
            if (currentField.getText().toString().length() <= 0) {
                return false;
            }
        }
        return true;
    }

    private void getId() {
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_tel = (EditText) findViewById(R.id.ed_tel);
        rd_btn_male = (RadioButton) findViewById(R.id.rd_btn_male);
        rd_btn_female = (RadioButton) findViewById(R.id.rd_btn_female);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        lview = (ListView) findViewById(R.id.listview);
        empDetails = new ArrayList<Model>();
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        welcom = (TextView) findViewById(R.id.tv_welcom);
        fb_uner_name = (TextView) findViewById(R.id.tv_user_name);
        fb_user_email = (TextView) findViewById(R.id.tv_user_email);
    }

}
