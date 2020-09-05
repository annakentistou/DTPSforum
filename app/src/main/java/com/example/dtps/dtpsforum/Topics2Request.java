package com.example.dtps.dtpsforum;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anna_ on 10/9/2017.
 */

public class Topics2Request extends StringRequest {
    private static final String TOPICS_REQUEST_URL = "http://192.168.1.9/myforum/Topics2Values.php";
    private Map<String, String> params;

    public Topics2Request( String topic_title, Response.Listener<String> listener){
        super(Request.Method.POST, TOPICS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("topic_title",topic_title);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
