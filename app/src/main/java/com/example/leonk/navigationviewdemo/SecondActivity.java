package com.example.leonk.navigationviewdemo;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {

    TextInputLayout mEmailLayout,mPasswordLayout;
    EditText emailEditText,passwordEditText;
    RelativeLayout mRoot;  //root layout needed for the snackBar

    //listener for the snackBar displayed when fields are empty

    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mEmailLayout=(TextInputLayout) findViewById(R.id.email_input_layout);
        mPasswordLayout=(TextInputLayout) findViewById(R.id.password_input_layou2);

        emailEditText=(EditText) findViewById(R.id.email_input);
        passwordEditText=(EditText) findViewById(R.id.password_input);

        mRoot=(RelativeLayout) findViewById(R.id.root_layout);




//        //setting error messages
//        mEmailLayout.setError("Email cannot be blank");
//        mPasswordLayout.setError("Password cannot be blank");

    }

    public void submit(View view){  //for login

        boolean isEmptyEmail = isEmptyEmail();
        boolean isEmptyPassword = isEmptyPassword();

        if (isEmptyEmail && isEmptyPassword) {

            Snackbar.make(mRoot, "One Or More Fields Are Blank", Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();

        } else if (isEmptyEmail && !isEmptyPassword) {

            mEmailLayout.setError("Email Cannot Be Empty");
            mPasswordLayout.setError(null);

        } else if (!isEmptyEmail && isEmptyPassword) {

            mPasswordLayout.setError("Password Cannot Be Empty");
            mEmailLayout.setError(null);

        } else {
            //All Good Here
        }

    }

    private boolean isEmptyEmail() {  //checking all possible ways if the edit text is empty
        return emailEditText.getText() == null
                || emailEditText.getText().toString() == null
                || emailEditText.getText().toString().isEmpty();

    }

    private boolean isEmptyPassword() {
        return passwordEditText.getText() == null
                || passwordEditText.getText().toString() == null
                || passwordEditText.getText().toString().isEmpty();

    }


}
