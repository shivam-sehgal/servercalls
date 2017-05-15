package com.skeleton.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.model.Example;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.imagepicker.ImageChooser;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    private EditText etEmail;
    String email;
    private EditText etName;
    String name;
    private EditText etPassword;
    String password;
    private EditText etPhoneNumber;
    String phoneNumber;
    private EditText etDatreOfBirth;
    String dateOfBirth;
    private EditText etConfirmPassword;
    String confirmPassword;
    private TextView tvLongText;
    private Button btnSubmit;
    private ImageView imageView;
    private RadioButton rdMale;
    private RadioButton rdFemale;
    private RadioGroup rgMyGroup;
    private int gender;
    private View fragView;
    private ImageChooser imageChooser;
    private File imagefile;
    private String deviceToken;
    private String orientation="Straight";
    private String language="EN";
    private String deviceType="ANDROID";
    private String countryCode="+91";
    private String appVersion="1.0";

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signup, container, false);
        init(view);
        fragView=view;

        return view;
    }
    private void init(View view){
        etEmail=(EditText)view.findViewById(R.id.email_et);
        etName=(EditText)view.findViewById(R.id.name_et);
        etPassword=(EditText)view.findViewById(R.id.password_et);
        etConfirmPassword=(EditText)view.findViewById(R.id.confPass_et);
        etPhoneNumber=(EditText)view.findViewById(R.id.phn_et);
        etDatreOfBirth=(EditText)view.findViewById(R.id.dob_et);
        etConfirmPassword=(EditText)view.findViewById(R.id.confPass_et);
        tvLongText=(TextView)view.findViewById(R.id.long_tv);
        btnSubmit=(Button)view.findViewById(R.id.submit_btn);
        btnSubmit.setOnClickListener(this);
        imageView=(ImageView)view.findViewById(R.id.my_img);
        rdMale=(RadioButton)view.findViewById(R.id.male_btn);
        rdFemale=(RadioButton)view.findViewById(R.id.female_btn);
        rgMyGroup=(RadioGroup)view.findViewById(R.id.my_group);


        rgMyGroup.setOnCheckedChangeListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(final View v) {
        switch(v.getId()){
            case R.id.submit_btn:
                collectDataFromForm();
                break;
            case R.id.my_img:
                pickImage();
                break;

        }
    }

    /**
     *
     *  on pressing submit this method is called
     */
    private void collectDataFromForm(){

        if(ValidateEditText.checkEmail(etEmail)&& ValidateEditText
                .checkName(etName,true)&&ValidateEditText.checkPhoneNumber(etPhoneNumber)&&
                ValidateEditText.comparePassword(etPassword,etConfirmPassword)&&
                ValidateEditText.checkPassword(etPassword,true)&&!etDatreOfBirth.getText()
                .toString().isEmpty()){
            email=etEmail.getText().toString().trim();
            name=etName.getText().toString().trim();
            phoneNumber=etPhoneNumber.getText().toString().trim();
            dateOfBirth=etDatreOfBirth.getText().toString().trim();
            password=etPassword.getText().toString().trim();
            confirmPassword=etConfirmPassword.getText().toString().trim();
            String android_id= Settings.Secure.getString(getActivity().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            deviceToken=android_id;


            uploadData();
        }
        else{
            Toast.makeText(getActivity(),"please fill form properly",Toast.LENGTH_SHORT).show();
        }

    }

    private void uploadData(){
        ApiInterface api= RestClient.getApiInterface();
        RequestBody rname= RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody remail= RequestBody.create(MediaType.parse("text/plain"), email);
        RequestBody rphoneno= RequestBody.create(MediaType.parse("text/plain"), phoneNumber);
        RequestBody rpassword= RequestBody.create(MediaType.parse("text/plain"), password);
        RequestBody rdateofbirth= RequestBody.create(MediaType.parse("text/plain"), dateOfBirth);
        RequestBody rdeviceId= RequestBody.create(MediaType.parse("text/plain"), deviceToken);
        RequestBody rdevType= RequestBody.create(MediaType.parse("text/plain"), deviceType);
        RequestBody rlanguage= RequestBody.create(MediaType.parse("text/plain"), language);
        RequestBody rgender= RequestBody.create(MediaType.parse("text/plain"), String.valueOf(gender));
        RequestBody rcountrycODE= RequestBody.create(MediaType.parse("text/plain"), countryCode);
        RequestBody rappVersion= RequestBody.create(MediaType.parse("text/plain"), appVersion);
        RequestBody rorrientation= RequestBody.create(MediaType.parse("text/plain"), "Straight");
        RequestBody rimage= RequestBody.create(MediaType.parse("image/*"), imagefile);
        Map<String, RequestBody> hashMap=new HashMap<>();
        hashMap.put("firstName",rname);
        hashMap.put("dob",rdateofbirth);
        hashMap.put("countryCode",rcountrycODE);
        hashMap.put("phoneNo",rphoneno);
        hashMap.put("email",remail);
        hashMap.put("password",rpassword);
        hashMap.put("language",rlanguage);
        hashMap.put("deviceType",rdevType);
        hashMap.put("deviceToken",rdeviceId);
        hashMap.put("appVersion",rappVersion);
        hashMap.put("gender",rgender);
        hashMap.put("orientation",rorrientation);
        hashMap.put("profilePic",rimage);

        Call<Example> data=api.doSignUp(hashMap);
        data.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(final Call<Example> call, final Response<Example> response) {
                 Example example=response.body();
                Toast.makeText(getActivity(),example.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(final Call<Example> call, final Throwable t) {
                Toast.makeText(getActivity(),"its retro error",Toast.LENGTH_LONG).show();

            }
        });

    }


    private void pickImage(){
        imageChooser = new ImageChooser.Builder(this).setCropEnabled(false).build();
        imageChooser.selectImage(new ImageChooser.OnImageSelectListener() {
            @Override
            public void loadImage(final List<ChosenImage> list) throws URISyntaxException {
                imagefile = new File(list.get(0).getOriginalPath());

                Glide.with(getActivity()).load(imagefile).centerCrop().into(imageView);

            }

            @Override
            public void croppedImage(final File mCroppedImage) {

            }
        });


    }

    @Override
    public void onCheckedChanged(final RadioGroup group, @IdRes final int checkedId) {
        RadioButton rBtn=(RadioButton) fragView.findViewById(checkedId);
        String str=rBtn.getText().toString();
        if(str.equals("Male")){
            gender=0;
        }
        else{
            gender=1;
        }

    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageChooser.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imageChooser.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }


    public String getPath(Uri uri)
    {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index =             cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(column_index);
        cursor.close();
        return s;
    }
}
