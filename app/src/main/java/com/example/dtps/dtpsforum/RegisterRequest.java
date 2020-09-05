package com.example.dtps.dtpsforum;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anna_ on 23/8/2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.1.9/myforum/Register.php";
    private Map<String, String> params;

    public RegisterRequest( String username, String password,String email, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("user_password",password);
        params.put("user_email",email);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
