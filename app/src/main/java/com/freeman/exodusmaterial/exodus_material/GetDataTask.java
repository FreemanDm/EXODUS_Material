package com.freeman.exodusmaterial.exodus_material;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

/**
 * Created by Freeman on 14.02.2017.
 */

public class GetDataTask extends AsyncTask<Void, Void, Response> {

    private Context context;
    private EditText editTxtCategory, editTxtRegion, editTxtCity;
    private EditText editTxtAddress, editTxtOrganization, editTxtPhone;
    private Button btnFind;
//    private ProgressBar myProgressBar;

    public GetDataTask(Context context, EditText editTxtCategory, EditText editTxtRegion,
                       EditText editTxtCity, EditText editTxtAddress, EditText editTxtOrganization,
                       EditText editTxtPhone, Button btnFind) {
        this.context = context;
        this.editTxtCategory = editTxtCategory;
        this.editTxtRegion = editTxtRegion;
        this.editTxtCity = editTxtCity;
        this.editTxtAddress = editTxtAddress;
        this.editTxtOrganization = editTxtOrganization;
        this.editTxtPhone = editTxtPhone;
        this.btnFind = btnFind;
//        this.myProgressBar = myProgressBar;
    }

    @Override
    protected void onPreExecute() {
        btnFind.setEnabled(false);
//        myProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Response doInBackground(Void... params) {
        Response response = null;
        String result = null;
        try {
            result = HttpProvider.getHttpProvider().get("/company/count");
            Gson gson = new Gson();
            response = gson.fromJson(result, Response.class);
        } catch (IOException |JsonSyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
//        myProgressBar.setVisibility(View.INVISIBLE);
        btnFind.setEnabled(true);
        if (response == null){
            Toast.makeText(context, "Server was down!", Toast.LENGTH_SHORT).show();
        }else {
            Log.d("DATA_FROM_BASE", response.toString());
        }
    }
}
