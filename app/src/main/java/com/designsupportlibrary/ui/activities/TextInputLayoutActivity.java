package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.designsupportlibrary.R;

public class TextInputLayoutActivity extends AbstractActivity {

    private TextInputLayout mUsernameTextInputLayout;
    private TextInputLayout mPasswordTextInputLayout;
    private EditText mUserNameEditText;
    private EditText mPasswordEditText;

    @Override
    protected int getLayout() {
        return R.layout.activity_text_input_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUsernameTextInputLayout = (TextInputLayout) findViewById(R.id.usernameTextInputLayout);
        mPasswordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInputLayout);
        mUserNameEditText = (EditText) findViewById(R.id.usernameEditText);
        mPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
    }

    public void onSubmit(View view){
        String message;
        if(validate()){
            message = getString(R.string.success);
        }else{
            message = getString(R.string.errors);
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private boolean validate(){
        boolean isUserNameValidate = !TextUtils.isEmpty(mUserNameEditText.getText());
        if(isUserNameValidate){
            mUsernameTextInputLayout.setErrorEnabled(false);
        }else{

            mUsernameTextInputLayout.setErrorEnabled(true);
            mUsernameTextInputLayout.setError(getString(R.string.username_empty_not_allowed));

        }

        boolean isPasswordValidate = !TextUtils.isEmpty(mPasswordEditText.getText());

        if(isPasswordValidate){
            mPasswordTextInputLayout.setErrorEnabled(false);
        }else{
            mPasswordTextInputLayout.setErrorEnabled(true);
            mPasswordTextInputLayout.setError(getString(R.string.password_empty_not_allowed));
        }

        return isUserNameValidate && isPasswordValidate;
    }
}
