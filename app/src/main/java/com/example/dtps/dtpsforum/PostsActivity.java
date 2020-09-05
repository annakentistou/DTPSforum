package com.example.dtps.dtpsforum;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
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
import org.w3c.dom.Text;

public class PostsActivity extends AppCompatActivity  {  /*implements View.OnClickListener*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        /*old GUI for postsActivity*/
        final EditText tvPost1 = (EditText) findViewById(R.id.tvPost1);
        final EditText tvPost2 = (EditText) findViewById(R.id.tvPost2);
        final EditText tvPost3 = (EditText) findViewById(R.id.tvPost3);
        final TextView tvMember1 = (TextView) findViewById(R.id.tvMember1);
        final TextView tvMember2 = (TextView) findViewById(R.id.tvMember2);
        final TextView tvMember3 = (TextView) findViewById(R.id.tvMember3);
       /* final TextView tpc_name = (TextView) findViewById(R.id.tpc_name);*/
       final TextView top_tlt = (TextView)findViewById(R.id.top_tlt);

         /* set text username in txv in posted by*/
         /*For Topic Android Tutorial get username and topic_title*/
        Intent  AndroidPosts= getIntent();
        String UserName = AndroidPosts.getStringExtra("username");
        String message =  "Posted by " + UserName;
        tvMember1.setText(message);
        tvMember1.setPaintFlags(tvMember1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember1.setVisibility(tvMember1.INVISIBLE);
        tvMember2.setText(message);
        tvMember2.setPaintFlags(tvMember2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember2.setVisibility(tvMember2.INVISIBLE);
        tvMember3.setText(UserName);
        tvMember3.setVisibility(tvMember3.INVISIBLE);

        String tpc_nm = AndroidPosts.getStringExtra("topic_title");
        top_tlt.setText(tpc_nm);


        /*For topic Cellular Networks*/
        Intent  NetPosts= getIntent();
        String UrName = NetPosts.getStringExtra("username");
        String msg =  "Posted by " + UrName;
        tvMember1.setText(msg);
        tvMember1.setPaintFlags(tvMember1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember1.setVisibility(tvMember1.INVISIBLE);
        tvMember2.setText(msg);
        tvMember2.setPaintFlags(tvMember2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember2.setVisibility(tvMember2.INVISIBLE);

        String tpc_name = NetPosts.getStringExtra("topic_title");
        top_tlt.setText(tpc_name);

        /*For new topic*/
        Intent  posts= getIntent();
        final String UsrNm = posts.getStringExtra("username");
        String mesag =  "Posted by " + UsrNm;
        tvMember1.setText(mesag);
        tvMember1.setPaintFlags(tvMember1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember1.setVisibility(tvMember1.INVISIBLE);
        tvMember2.setText(mesag);
        tvMember2.setPaintFlags(tvMember2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvMember2.setVisibility(tvMember2.INVISIBLE);

        /*Get newtopicTitle from topicActivity*/
        String Topic_name = posts.getStringExtra("topic_title");
        top_tlt.setText(Topic_name);
        top_tlt.setVisibility(top_tlt.INVISIBLE);

        ImageView return_to_mainpage = (ImageView) findViewById(R.id.return_to_mainpage);
        return_to_mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent return_to_main = new Intent(PostsActivity.this, MainActivity.class);
                startActivity(return_to_main);
            }
        });

        Button post1But = (Button) findViewById(R.id.post1But);
        post1But.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String username = tvMember3.getText().toString();
                String topic_title = top_tlt.getText().toString();
                String post_text = tvPost1.getText().toString();
                tvMember1.setVisibility(tvMember1.VISIBLE);

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {

                                String topic_title = jsonResponse.getString("post_subject");
                                String post_text = jsonResponse.getString("post_text");

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                PostRequest postRequest = new PostRequest(username,topic_title,post_text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostsActivity.this);
                queue.add(postRequest);

            }
        });

        /*Button post2But = (Button) findViewById(R.id.post2But);
        post2But.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String post_text = tvPost2.getText().toString();
                tvMember2.setVisibility(tvMember2.VISIBLE);

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {

                                String post_text = jsonResponse.getString("post_text");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                PostRequest postRequest = new PostRequest(topic_title,post_text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostsActivity.this);
                queue.add(postRequest);

            }
        });

        Button post3But = (Button) findViewById(R.id.post3But);
        post3But.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String post_text = tvPost3.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String post_text = jsonResponse.getString("post_text");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                PostRequest postRequest = new PostRequest(topic_title,post_text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostsActivity.this);
                queue.add(postRequest);

            }
        });
*/
    }
}
