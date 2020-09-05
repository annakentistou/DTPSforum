package com.example.dtps.dtpsforum;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anna_ on 31/8/2017.
 */

public class PostRequest extends StringRequest {
    private static final String POSTS_REQUEST_URL = "http://192.168.1.9/myforum/Posts.php";
    private Map<String, String> params;

    public PostRequest(String username,String topic_title,String post_text, Response.Listener<String> listener){
        super(Request.Method.POST, POSTS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("post_subject",topic_title);
        params.put("post_text",post_text);

    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
