package com.example.hlinktask;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**

 */
public class BottomDialogFragment extends BottomSheetDialogFragment {

    Button btnsubmit;
    EditText otp1, otp2, otp3, otp4;

    public static BottomDialogFragment newInstance() {
        return new BottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom_dialog, container,
                false);

        btnsubmit = view.findViewById(R.id.btnsubmit);

        otp1 = view.findViewById(R.id.otp1);
        otp2 = view.findViewById(R.id.otp2);
        otp3 = view.findViewById(R.id.otp3);
        otp4 = view.findViewById(R.id.otp4);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateOtp1() | !validateOtp2() | !validateOtp3() | !validateOtp4()){
                    return;
                }
                else {

                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        // get the views and attach the listener

        return view;

    }

    private boolean validateOtp1() {
        String Otp1 = otp1.getText().toString().trim();

        if (Otp1.isEmpty()) {
            otp1.setError("Field can't be empty");
            return false;
        } else {
            otp1.setError(null);
            return true;
        }
    }

    private boolean validateOtp2() {
        String Otp2 = otp2.getText().toString().trim();

        if (Otp2.isEmpty()) {
            otp2.setError("Field can't be empty");
            return false;
        } else {
            otp2.setError(null);
            return true;
        }
    }

    private boolean validateOtp3() {
        String Otp3 = otp3.getText().toString().trim();

        if (Otp3.isEmpty()) {
            otp3.setError("Field can't be empty");
            return false;
        } else {
            otp3.setError(null);
            return true;
        }
    }

    private boolean validateOtp4() {
        String Otp4 = otp4.getText().toString().trim();

        if (Otp4.isEmpty()) {
            otp4.setError("Field can't be empty");
            return false;
        } else {
            otp4.setError(null);
            return true;
        }
    }
}
