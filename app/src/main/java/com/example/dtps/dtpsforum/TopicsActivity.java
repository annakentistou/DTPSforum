package com.example.dtps.dtpsforum;

import android.content.Intent;
import android.graphics.Paint;
import android.support.transition.TransitionManager;
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

public class TopicsActivity extends AppCompatActivity  {      /*mplements View.OnClickListener*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        /* set text username in txv in Mainforum*/
        final TextView txvUsername2 = (TextView) findViewById(R.id.txvUsername2);
        Intent topics = getIntent();
        String UserName = topics.getStringExtra("username");
        txvUsername2.setText(UserName);
        txvUsername2.setVisibility(txvUsername2.INVISIBLE);

        final TextView AndroidLink = (TextView) findViewById(R.id.tvAndroidTut);
        AndroidLink.setPaintFlags(AndroidLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        final TextView NetworksLink = (TextView) findViewById(R.id.tvNetTut);
        NetworksLink.setPaintFlags(NetworksLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        final TextView NameOfNewTopic = (TextView) findViewById(R.id.NameOfNewTopic);
        NameOfNewTopic.setPaintFlags(NameOfNewTopic.getPaintFlags() |Paint.UNDERLINE_TEXT_FLAG);

        final ImageView imv3 =(ImageView) findViewById(R.id.imv3);
        imv3.setVisibility(imv3.INVISIBLE);

        final Button newTopic = (Button) findViewById(R.id.newTopic);
       /* AndroidLink.setOnClickListener(this);
        NetworksLink.setOnClickListener(this);*/

        /*new topic with invisible EditText*/
        final EditText new_topic_name = (EditText) findViewById(R.id.new_topic_name);
        new_topic_name.setVisibility(new_topic_name.INVISIBLE);

        /*create new topic*/
        newTopic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    new_topic_name.setVisibility(new_topic_name.VISIBLE);
                 /*Edit name of new topic in textview*/
                    String st = new_topic_name.getText().toString();
                    NameOfNewTopic.setText(st);
                    imv3.setVisibility(imv3.VISIBLE);
            }
        });
        /*go to PostsActivity*/
        NameOfNewTopic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                newTopic.setVisibility(newTopic.INVISIBLE);
                new_topic_name.setVisibility(new_topic_name.INVISIBLE);
                Intent posts = new Intent (TopicsActivity.this, PostsActivity.class);
                TextView txvUsername2 = (TextView) findViewById(R.id.txvUsername2);
                String UserName = txvUsername2.getText().toString();
                posts.putExtra("username",UserName);

                String last_poster_name = txvUsername2.getText().toString();
                posts.putExtra("username",last_poster_name);
                String topic_title = NameOfNewTopic.getText().toString();
                posts.putExtra("topic_title",topic_title);

                startActivity(posts);
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
                TopicsRequest topicsRequest = new TopicsRequest(topic_title,UserName,last_poster_name,responseListener);
                RequestQueue queue = Volley.newRequestQueue(TopicsActivity.this);
                queue.add(topicsRequest);
            }
        });

        /*ANDROID TUTORIALS*/
        AndroidLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                TextView txvUsername2 = (TextView) findViewById(R.id.txvUsername2);
                String UserName = txvUsername2.getText().toString();
                Intent AndroidPosts = new Intent (TopicsActivity.this, PostsActivity.class);
                AndroidPosts.putExtra("username",UserName);
                String last_poster_name = txvUsername2.getText().toString();
                AndroidPosts.putExtra("username",last_poster_name);

                String topic_title = AndroidLink.getText().toString();
                AndroidPosts.putExtra("topic_title",topic_title);
                startActivity(AndroidPosts);

                 /*Call TopicsRequest*/
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
                TopicsRequest topicsRequest = new TopicsRequest(topic_title,UserName,last_poster_name, responseListener);
                RequestQueue queue = Volley.newRequestQueue(TopicsActivity.this);
                queue.add(topicsRequest);
            }
        });

        /*Cellular Networks*/
        NetworksLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                TextView txvUsername2 = (TextView) findViewById(R.id.txvUsername2);
                String UserName = txvUsername2.getText().toString();
                Intent NetPosts = new Intent (TopicsActivity.this, PostsActivity.class);
                NetPosts.putExtra("username",UserName);
                String last_poster_name = txvUsername2.getText().toString();
                NetPosts.putExtra("username",last_poster_name);

                String topic_title = NetworksLink.getText().toString();
                NetPosts.putExtra("topic_title",topic_title);
                startActivity(NetPosts);

                 /*Call TopicsRequest*/
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
                TopicsRequest topicsRequest = new TopicsRequest(topic_title,UserName,last_poster_name, responseListener);
                RequestQueue queue = Volley.newRequestQueue(TopicsActivity.this);
                queue.add(topicsRequest);
            }
        });
    }
  /*  @Override
    public void onClick(View v) {
        TextView txvUsername2 = (TextView) findViewById(R.id.txvUsername2);
        String UserName = txvUsername2.getText().toString();

        switch (v.getId()){
            case R.id.tvAndroidTut:
                Intent AndroidPosts = new Intent (TopicsActivity.this, PostsActivity.class);
                AndroidPosts.putExtra("username",UserName);

                startActivity(AndroidPosts);
                break;
            case R.id.tvNetTut:
                Intent NetPosts = new Intent (TopicsActivity.this, PostsActivity.class);
                NetPosts.putExtra("username",UserName);
                startActivity(NetPosts);
                break;
        }
    }*/
}
