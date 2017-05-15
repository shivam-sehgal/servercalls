package com.skeleton.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.model.Example;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignInFragment extends Fragment implements View.OnClickListener {
 private EditText etLoginId;
    private EditText etPassword;
    private Button btnLogin;
    public SignInFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        etLoginId=(EditText)view.findViewById(R.id.log_id);
        etPassword=(EditText)view.findViewById(R.id.password_et);
        btnLogin=(Button)view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(final View v) {
        switch(v.getId()){
            case R.id.btn_login:
                doSignIn();
                break;
        }
    }
    public void doSignIn(){
        if(ValidateEditText.checkEmail(etLoginId)&&ValidateEditText.checkPassword(etPassword,true)){
            RequestBody remail= RequestBody.create(MediaType.parse("text/plain"), etLoginId.getText().toString().trim());
            RequestBody rpassword= RequestBody.create(MediaType.parse("text/plain"), etPassword.getText().toString().trim());
            RequestBody rdeviceType= RequestBody.create(MediaType.parse("text/plain"), "ANDROID");
            RequestBody rlanguage= RequestBody.create(MediaType.parse("text/plain"), "EN");
            RequestBody rdeviceToken= RequestBody.create(MediaType.parse("text/plain"), Settings.Secure.getString(getActivity().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            RequestBody rflushPreviousSessions= RequestBody.create(MediaType.parse("text/plain"), "true");
            RequestBody rappversion= RequestBody.create(MediaType.parse("text/plain"), "1.0");


            Map map=new HashMap<String,RequestBody>();
            map.put("email",remail);
            map.put("password",rpassword);
            map.put("deviceType",rdeviceType);
            map.put("language",rlanguage);
            map.put("deviceToken", rdeviceToken);
            map.put("flushPreviousSessions",rflushPreviousSessions);
            map.put("appVersion",rappversion);

            ApiInterface apiInterface= RestClient.getApiInterface();
            Call<Example> data=apiInterface.logInUser(map);
            data.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(final Call<Example> call, final Response<Example> response) {
                    Example example=response.body();
                    Toast.makeText(getActivity(),example.getMessage(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(final Call<Example> call, final Throwable t) {
                    Toast.makeText(getActivity(), "retro error", Toast.LENGTH_SHORT).show();

                }
            });


        }
    }
}
