package com.example.dtps.dtpsforum;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Topics2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics2);


        final TextView ExamsFebLink = (TextView) findViewById(R.id.tvExFeb);
        ExamsFebLink.setPaintFlags(ExamsFebLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        final TextView ExamsJuneLink = (TextView) findViewById(R.id.tvExJune);
        ExamsJuneLink.setPaintFlags(ExamsJuneLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        final TextView tvOfNewTopic = (TextView) findViewById(R.id.tvOfNewTopic);
        tvOfNewTopic.setPaintFlags(tvOfNewTopic.getPaintFlags() |Paint.UNDERLINE_TEXT_FLAG);

        final ImageView imvExams = (ImageView) findViewById(R.id.imvExams);
        imvExams.setVisibility(imvExams.INVISIBLE);

        final Button btnNewTopic = (Button) findViewById(R.id.btnNewTopic);

        ExamsFebLink.setOnClickListener(this);
        ExamsJuneLink.setOnClickListener(this);

         /*new topic with invisible EditText*/
        final EditText edtnewNameofTopic = (EditText) findViewById(R.id.edtnewNameofTopic);
        edtnewNameofTopic.setVisibility(edtnewNameofTopic.INVISIBLE);

        /*create new topic*/
        btnNewTopic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                edtnewNameofTopic.setVisibility(edtnewNameofTopic.VISIBLE);
                 /*Edit name of new topic in textview*/
                String st = edtnewNameofTopic.getText().toString();
                tvOfNewTopic.setText(st);
                imvExams.setVisibility(imvExams.VISIBLE);
            }
        });

          /*go to PostsActivity*/
        tvOfNewTopic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnNewTopic.setVisibility(btnNewTopic.INVISIBLE);
                edtnewNameofTopic.setVisibility(edtnewNameofTopic.INVISIBLE);
                Intent posts = new Intent (Topics2Activity.this, PostsActivity.class);
                startActivity(posts);

                String topic_title = tvOfNewTopic.getText().toString();

                /* Call TopicsRequest*/
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Topics2Request topicsRequest = new Topics2Request(topic_title, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Topics2Activity.this);
                queue.add(topicsRequest);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvExFeb:
                Intent FebPosts = new Intent (Topics2Activity.this, PostsActivity.class);
                startActivity(FebPosts);
                break;
            case R.id.tvExJune:
                Intent JunePosts = new Intent (Topics2Activity.this, PostsActivity.class);
                startActivity(JunePosts);
                break;


        }
    }
}
