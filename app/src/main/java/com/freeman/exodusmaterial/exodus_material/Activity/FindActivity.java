package com.freeman.exodusmaterial.exodus_material.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.freeman.exodusmaterial.exodus_material.GetDataTask;
import com.freeman.exodusmaterial.exodus_material.R;

import static android.R.attr.checked;

public class FindActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTxtCategory, editTxtRegion, editTxtCity;
    private EditText editTxtAddress, editTxtOrganization, editTxtPhone;
    private CheckBox chkBoxCategory, chkBoxRegion, chkBoxCity;
    private CheckBox chkBoxAddress, chkBoxOrganization, chkBoxPhone;
    private Button btnFind;
//    private ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        editTxtCategory = (EditText) findViewById(R.id.edit_txt_category);
        editTxtRegion = (EditText) findViewById(R.id.edit_txt_region);
        editTxtCity = (EditText) findViewById(R.id.edit_txt_city);
        editTxtAddress = (EditText) findViewById(R.id.edit_txt_address);
        editTxtOrganization = (EditText) findViewById(R.id.edit_txt_organization);
        editTxtPhone = (EditText) findViewById(R.id.edit_txt_phone);
//        myProgressBar = (ProgressBar) findViewById(R.id.my_progress_bar);


//        chkBoxCategory = (CheckBox) findViewById(R.id.chk_box_category);
//        chkBoxRegion = (CheckBox) findViewById(R.id.chk_box_region);
//        chkBoxCity = (CheckBox) findViewById(R.id.chk_box_city);
//        chkBoxAddress = (CheckBox) findViewById(R.id.chk_box_address);
//        chkBoxOrganization = (CheckBox) findViewById(R.id.chk_box_organization);
//        chkBoxPhone = (CheckBox) findViewById(R.id.chk_box_phone);

        btnFind = (Button) findViewById(R.id.btn_find);

        editTxtCategory.setOnClickListener(this);
        editTxtRegion.setOnClickListener(this);
        editTxtCity.setOnClickListener(this);
        editTxtAddress.setOnClickListener(this);
        editTxtOrganization.setOnClickListener(this);
        editTxtPhone.setOnClickListener(this);

//        chkBoxCategory.setOnClickListener(this);
//        chkBoxRegion.setOnClickListener(this);
//        chkBoxCity.setOnClickListener(this);
//        chkBoxAddress.setOnClickListener(this);
//        chkBoxOrganization.setOnClickListener(this);
//        chkBoxPhone.setOnClickListener(this);

        btnFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_find){
            Intent intent = new Intent(this, FragmentsActivity.class);
            startActivity(intent);
            new GetDataTask(this, editTxtCategory, editTxtRegion,
                            editTxtCity, editTxtAddress, editTxtOrganization,
                            editTxtPhone, btnFind).execute();
        }
    }
}
