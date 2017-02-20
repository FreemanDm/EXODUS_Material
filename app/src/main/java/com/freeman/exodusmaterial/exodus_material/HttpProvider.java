package com.freeman.exodusmaterial.exodus_material;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by Freeman on 12.02.2017.
 */

public class HttpProvider {
    private static final String BASE_URL = "http://188.166.79.122:8080/exodus";
    private static HttpProvider httpProvider;

    public HttpProvider() {
    }

    public static HttpProvider getHttpProvider(){
        if (httpProvider == null)
            httpProvider = new HttpProvider();
        return httpProvider;
    }

    public String get(String link) throws IOException {
        String result = "";
        URL url = new URL(BASE_URL + link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15000);
        connection.setConnectTimeout(15000);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();

        if (connection.getResponseCode() < 400){
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                result += line;
            }
            bufferedReader.close();
        }else {
            InputStreamReader errorInputStreamReader = new InputStreamReader(connection.getErrorStream());
            BufferedReader errorBufferedReader = new BufferedReader(errorInputStreamReader);
            String errorLine = "";
            while ((errorLine = errorBufferedReader.readLine()) != null){
                result += errorLine;
            }
            errorBufferedReader.close();
        }
        return result;
    }

    public String post(String link, String data) throws IOException {
        String result = "";
        URL url = new URL(BASE_URL + link);
        HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(15000);
        connection.setConnectTimeout(15000);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();

        BufferedReader bufferedReader;
        String line = "";
        if (connection.getResponseCode() < 400){
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }else {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }
        while ((line = bufferedReader.readLine()) != null){
            result += line;
        }
        bufferedReader.close();
        return result;
    }
}
