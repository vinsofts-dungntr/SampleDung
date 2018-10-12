package com.example.tridung.sample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.tridung.sample.SighInActivity.SIGHIN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String EMAIL="email";
    private static final String PASSWORLD = "password";
    private static final String USERNAME="username";
    private static final String PASS="matkhau";
    private static final String LOGIN="login";
    private EditText mEdt_emailAdress;
    private EditText mEdt_passWord;
    private Button mBtn_login;
    private Button mBtn_sighIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtn_sighIn.setOnClickListener(this);
        mBtn_login.setOnClickListener(this);
        getData();
    }

    private void initView() {
        mEdt_emailAdress = findViewById(R.id.edt_username);
        mEdt_passWord = findViewById(R.id.edt_passworld);
        mBtn_login = findViewById(R.id.btn_login);
        mBtn_sighIn = findViewById(R.id.btn_sighin);

    }

    public void takeData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SIGHIN, Context.MODE_PRIVATE);
        String mail = sharedPreferences.getString(EMAIL, "");
        String pass = sharedPreferences.getString(PASSWORLD, "");
        if(!mail.equals("")||!pass.equals("")){
            mEdt_emailAdress.setText(mail);
            mEdt_passWord.setText(pass);
        }
        mEdt_emailAdress.setSelection(mEdt_emailAdress.getText().length());
        mEdt_passWord.setSelection(mEdt_passWord.getText().length());
    }

    public void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,
                Context.MODE_PRIVATE);
        String use = sharedPreferences.getString(USERNAME, "");
        String pass = sharedPreferences.getString(PASS, "");
        if(!use.equals("")||!pass.equals("")){
            mEdt_emailAdress.setText(use);
            mEdt_passWord.setText(pass);
        }
        mEdt_emailAdress.setSelection(mEdt_emailAdress.getText().length());
        mEdt_passWord.setSelection(mEdt_passWord.getText().length());


    }

    protected void sharePreferent() {
        String email = mEdt_emailAdress.getText().toString().trim();
        String pass = mEdt_passWord.getText().toString().trim();
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, email);
        editor.putString(PASS, pass);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        takeData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String user = mEdt_emailAdress.getText().toString().trim();
                String pass = mEdt_passWord.getText().toString().trim();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "Mời nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    sharePreferent();
                }
                break;
            case R.id.btn_sighin:
                Intent intent = new Intent(MainActivity.this, SighInActivity.class);
                startActivity(intent);
                break;

        }

    }
}
