package com.eleganzit.vkcofficial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.eleganzit.vkcofficial.api.RetrofitAPI;
import com.eleganzit.vkcofficial.api.RetrofitInterface;
import com.eleganzit.vkcofficial.model.OTPResponse;

import me.philio.pinentry.PinEntryView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {
LinearLayout submit;
PinEntryView pinEntryView;
String pinentered,email;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        submit=findViewById(R.id.submit);
        pinEntryView=findViewById(R.id.vr_code);
        progressDialog = new ProgressDialog(OTPActivity.this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        email=getIntent().getStringExtra("email");
        pinEntryView.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
           @Override
           public void onPinEntered(String pin) {
               pinentered=pin;

           }
       });

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (pinentered.equals("")) {

                   Toast.makeText(OTPActivity.this, "Please Enter Pin", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   matchOtp();
               }
           }
       });
    }

    private void matchOtp() {
        progressDialog.show();
        RetrofitInterface myInterface = RetrofitAPI.getRetrofit().create(RetrofitInterface.class);
        Call<OTPResponse> call=myInterface.checkCodeOfficial(pinentered,email);
        call.enqueue(new Callback<OTPResponse>() {
            @Override
            public void onResponse(Call<OTPResponse> call, Response<OTPResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful())
                {
                    Toast.makeText(OTPActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(OTPActivity.this, ChangePasswordActivity.class)
                            .putExtra("email",email));
                    finish();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }

            @Override
            public void onFailure(Call<OTPResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(OTPActivity.this, "Server or Internet Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
