package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    AppCompatButton signUpBtn;
    EditText username, password, phone, reTypePass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        intentSignIn();
        AnhXa();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUpClick();
            }
        });
    }

    private void SignUpClick(){
        String email = username.getText().toString();
        String pass = password.getText().toString();
        String phoneNum = phone.getText().toString();
        String passRetype = reTypePass.getText().toString();

        if(TextUtils.isEmpty(phoneNum)){
            Toast.makeText(this,"Nhap So dien thoai !",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Nhap Email !",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Nhap Password !", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passRetype)){
            Toast.makeText(this,"Nhap lai Password !",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Dang ky thanh cong !", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUp.this, SignInActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Dang ky khong thanh cong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void AnhXa(){
        signUpBtn = (AppCompatButton) findViewById(R.id.signupbtn);
        phone = (EditText) findViewById(R.id.phonenumber);
        username = (EditText) findViewById(R.id.newusername);
        password = (EditText) findViewById(R.id.newpassword);
        reTypePass = (EditText) findViewById(R.id.repypepassword);
    }

    private void intentSignIn(){
        TextView signin = (TextView) findViewById(R.id.signinbtn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}