package com.freeman.exodusmaterial.exodus_material.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.freeman.exodusmaterial.exodus_material.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button engBtn, hebBtn, rusBtn, fraBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        engBtn = (Button) findViewById(R.id.eng_btn);
        hebBtn = (Button) findViewById(R.id.heb_btn);
        rusBtn = (Button) findViewById(R.id.rus_btn);
        fraBtn = (Button) findViewById(R.id.fra_btn);
        engBtn.setOnClickListener(this);
        hebBtn.setOnClickListener(this);
        rusBtn.setOnClickListener(this);
        fraBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FindActivity.class);
        startActivity(intent);
    }
}
