package com.example.dtps.dtpsforum;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anna_ on 2/9/2017.
 */

public class TopicsRequest extends StringRequest {
    private static final String TOPICS_REQUEST_URL = "http://192.168.1.9/myforum/Topicsvalues.php";
    private Map<String, String> params;

    public TopicsRequest( String topic_title,String UserName,String last_poster_name, Response.Listener<String> listener){
        super(Request.Method.POST, TOPICS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("topic_title",topic_title);
        params.put("topic_first_poster_name",UserName);
        params.put("topic_last_poster_name",last_poster_name);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
