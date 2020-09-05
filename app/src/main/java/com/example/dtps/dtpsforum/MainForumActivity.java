package com.example.dtps.dtpsforum;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import static android.R.attr.checked;


public class MainForumActivity extends AppCompatActivity implements View.OnClickListener {

    // public Button but_topics;//button for topics//
   /* public void init() {
        but_topics = (Button) findViewById(R.id.but_topics);
        but_topics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent topics = new Intent(MainForumActivity.this, TopicsActivity.class);
                startActivity(topics);
            }
        });
    }*/

    private static RadioGroup radio_GR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_forum);
        //init();

        /* set text username in txv in Mainforum*/
        TextView txtUsername1 = (TextView) findViewById(R.id.txtUsername1);
        Intent mainforum = getIntent();
        String UserName = mainforum.getStringExtra("username");
        txtUsername1.setText(UserName);
        txtUsername1.setVisibility(txtUsername1.INVISIBLE);

        //Return to main page//
        ImageView image_main_page = (ImageView) findViewById(R.id.image_main_page);
        image_main_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainpage = new Intent(MainForumActivity.this, MainActivity.class);
                startActivity(mainpage);
            }
        });

        RadioButton radioButTutor = (RadioButton) findViewById(R.id.radioButTutor);
        RadioButton radioButExams = (RadioButton) findViewById(R.id.radioButExams);
        radio_GR = (RadioGroup) findViewById(R.id.radio_GR);

       /* Button but_topics = (Button) findViewById(R.id.but_topics);
        but_topics.setOnClickListener(this);*/
        radioButTutor.setOnClickListener(this);
        radioButExams.setOnClickListener(this);
    }
    public void onClick(View v) {
        TextView txtUsername1 = (TextView) findViewById(R.id.txtUsername1);
        String UserName = txtUsername1.getText().toString();
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId())
        {
            case R.id.radioButTutor:
                if (checked) {
                    Intent topics = new Intent(MainForumActivity.this, TopicsActivity.class);
                    topics.putExtra("username",UserName);
                    startActivity(topics);
                }
                break;
            case R.id.radioButExams:
                if (checked) {
                    Intent topics = new Intent(MainForumActivity.this, Topics2Activity.class);
                    topics.putExtra("username",UserName);
                    startActivity(topics);
                }
                break;
        }
    }
}

    /*Checked buttons*/
    /*public void onCheckedChangeListener(View v){

        radio_GR.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton radio_but = (RadioButton) radio_GR.findViewById(i);

                switch (i) {

                    case R.id.radioButTutor:
                        Intent topic1 = new Intent(MainForumActivity.this, TopicsActivity.class);
                        startActivity(topic1);
                        break;
                    case R.id.radioButExams:
                        Intent topic2 = new Intent(MainForumActivity.this, Topics2Activity.class);
                        startActivity(topic2);
                        break;
                }
            }
        });

    }*/