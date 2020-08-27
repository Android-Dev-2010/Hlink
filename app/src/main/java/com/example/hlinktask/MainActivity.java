package com.example.hlinktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail,mPass;
    Button btn;

    public static final Pattern EMAIL_ADDRESS =Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+
                                                                "\\@"+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+
                                                                "("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+")+");

    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.mEmaill);
        mPass = findViewById(R.id.mPasswordd);
        btn = findViewById(R.id.reg);

    }

    private boolean validateEmail(){
        String emailInput = mEmail.getText().toString().trim();

        if(emailInput.isEmpty()){
            mEmail.setError("Field can't be empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            mEmail.setError("Please enter a valid email address like : xyz@gmail.com");
            return false;
        }else{
            mEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String password = mPass.getText().toString().trim();

        if(password.isEmpty()){
            mPass.setError("Field can't be empty");
            return false;
        }else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            mPass.setError("Password must be like : Xy1@");
            return false;
        }else{
            mPass.setError(null);
            return true;
        }
    }

    public void RegistrationClick(View view) {

        if (!validateEmail() | !validatePassword()){
            return;
        }

        Intent intent = new Intent(this,Registration.class);
        startActivity(intent);

    }
}

// btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            String mail = mEmail.getText().toString();
//            String pass = mPass.getText().toString();
//
//            validationPass(pass);
//            validationEmail(mail);
//
//            if(true)
//            {
//                Intent intent = new Intent(MainActivity.this, Registration.class);
//                startActivity(intent);
//            }
//
//        }
//    });
//
//}
//
//
//
//public boolean validationEmail(String str) {
//
//        if(str!="") {
//        Pattern EMAIL = Pattern.compile("[a-zA-Z0-9+._%-+]" + "@" + "[a-zA-Z+.]");
//        Matcher matcher = EMAIL.matcher(str);
//        return matcher.matches();
//        }
//        else
//        {
//        Toast.makeText(MainActivity.this,"please enter something in password",Toast.LENGTH_SHORT).show();
//        }
//        return false;
//        }
//
//
//public boolean validationPass(String str){
//
//        if(str!=""){
//        return true;
//        }
//        else{
//        Toast.makeText(MainActivity.this,"please enter something in password",Toast.LENGTH_SHORT).show();
//        }
//        return false;
//        }