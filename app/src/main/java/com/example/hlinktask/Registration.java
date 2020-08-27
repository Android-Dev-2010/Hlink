package com.example.hlinktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Registration extends AppCompatActivity {

    EditText mFirst, mLast, mEmail, mPhone, mPass, mConfirm;
    Button regi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mFirst = findViewById(R.id.mFirst);
        mLast = findViewById(R.id.mLast);
        mEmail = findViewById(R.id.mEmail);
        mPhone = findViewById(R.id.mPhone);
        mPass = findViewById(R.id.mPass);
        mConfirm = findViewById(R.id.mConfirm);
        regi = findViewById(R.id.registration);


    }

    private boolean validateFirst() {
        String firstName = mFirst.getText().toString().trim();

        if (firstName.isEmpty()) {
            mFirst.setError("Field can't be empty");
            return false;
        } else {
            mFirst.setError(null);
            return true;
        }
    }

    private boolean validateLast() {
        String LastName = mLast.getText().toString().trim();

        if (LastName.isEmpty()) {
            mLast.setError("Field can't be empty");
            return false;
        } else {
            mLast.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = mEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            mEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            mEmail.setError("Please enter a valid email address like : xyz@gmail.com");
            return false;
        } else {
            mEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String phoneNum = mPhone.getText().toString().trim();

        if (phoneNum.isEmpty()) {
            mPhone.setError("Phone number can't be empty");
            return false;
        } else if (phoneNum.length() < 9 && phoneNum.length() > 11) {
            mEmail.setError("Please enter a valid email address like : xyz@gmail.com");
            return false;
        } else {
            mPhone.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String password = mPass.getText().toString().trim();

        if (password.isEmpty()) {
            mPass.setError("Field can't be empty");
            return false;
        } else if (!MainActivity.PASSWORD_PATTERN.matcher(password).matches()) {
            mPass.setError("Password must be like : Xy1@");
            return false;
        }
        else {
            mPass.setError(null);
            return true;
        }
    }

    private boolean validateConfirm() {
        String confirm = mConfirm.getText().toString().trim();
        String password = mPass.getText().toString().trim();

        if (confirm.equals(password)) {
            return true;
        } else
            return false;
    }



    public void onRegistration(View view) {

        if (!validateEmail() | !validatePassword() | !validateFirst() | !validateLast() | !validatePhone() | !validateConfirm()) {
            return;

        } else {
            BottomDialogFragment addBottomDialogFragment =
                    BottomDialogFragment.newInstance();
            addBottomDialogFragment.show(getSupportFragmentManager(),
                    "add__dialog_fragment");
        }
    }
}

//         regi.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            BottomDialogFragment addBottomDialogFragment =
//                    BottomDialogFragment.newInstance();
//            addBottomDialogFragment.show(getSupportFragmentManager(),
//                    "add__dialog_fragment");

//                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
//                        R.layout.fragment_bottom_dialog, (ViewGroup) findViewById(R.id.bottomDialog));

//                bottomSheetView.findViewById(R.id.btnsubmit).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(Registration.this,HomeActivity.class);
//                        startActivity(intent);
//                    }
//                });
//        }
//    });
//}