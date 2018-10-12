package com.example.tridung.sample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SighInActivity extends AppCompatActivity {
    private EditText mEdt_name;
    private EditText mEdt_email;
    private EditText mEdt_pass;
    private EditText mEdt_phone;
    private TextView mTv_haveAcout;
    private Button btn;
    public static final String SIGHIN = "sighin";
    public static final String EMAIL = "email";
    public static final String PASSWORLD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigh_in);
        mEdt_name = findViewById(R.id.edt_name);
        mEdt_email = findViewById(R.id.edt_email);
        mEdt_pass = findViewById(R.id.edt_pass);
        mEdt_phone = findViewById(R.id.edt_phone);
        mTv_haveAcout = findViewById(R.id.tv_have_accout);
        btn = findViewById(R.id.btndangky);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEdt_name.getText().toString().trim();
                String mail = mEdt_email.getText().toString().trim();
                String pass = mEdt_pass.getText().toString().trim();
                String phone = mEdt_phone.getText().toString().trim();
                if (name.equals("") || mail.equals("") || pass.equals("") || phone.equals("")) {
                    Toast.makeText(SighInActivity.this, "Mời nhập đầy đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SighInActivity.this, "Đăng ký thành công",
                            Toast.LENGTH_SHORT).show();
                    sharePreferent(mail, pass);
                    finish();
                }
            }
        });

        mTv_haveAcout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void sharePreferent(String email, String pass) {
            SharedPreferences sharedPreferences = getSharedPreferences(SIGHIN, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(EMAIL, email);
            editor.putString(PASSWORLD, pass);
            editor.apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
