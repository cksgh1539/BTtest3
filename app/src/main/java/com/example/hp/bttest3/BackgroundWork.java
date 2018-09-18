package com.example.hp.bttest3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ContextThemeWrapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWork extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog.Builder alertDialog;
    BackgroundWork (Context ctx){
        context = ctx;
    }
    String UID,Deposit;

    @Override
    protected String doInBackground(String... voids) {
        String type = voids[0];
        String Send_url = "http://220.67.230.12/web_147/change/Test_Send.php";
        if(type.equals("Send")) {
            try {
                UID = voids[1];
                Deposit = voids[2];
                Log.v("chanho", "UID : "+ UID+" Deposit : "+ Deposit);
                URL url = new URL(Send_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("uid","UTF-8")+"="+URLEncoder.encode(UID,"UTF-8")+"&"+
                        URLEncoder.encode("deposit","UTF-8")+"="+URLEncoder.encode(Deposit,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String result = "";
                String line;

                while((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        // alertDialog = new AlertDialog.Builder(context).create();
      //  ContextThemeWrapper cw = new ContextThemeWrapper(context,R.style.MyAlertDialogStyle);
      //  alertDialog = new AlertDialog.Builder(cw);
        //  alertDialog.setTitle("Login Status");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onPostExecute(String result) {

        alertDialog = new AlertDialog.Builder(context);
        alertDialog.setPositiveButton("확인", null);
        Log.v("chanho","if전"+result);
        alertDialog.setMessage(result);
        if(result.equals("적립완료")) {


            Log.v("chanho", "result" + result);
        }

      /*  if(result.equals("적립되었습니다!")) {
            //   alertDialog.setMessage("확인되었습니다");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(context,Login_menu.class);
                    intent.putExtra("ID",user_id);
                    intent.putExtra("password",user_password);
                    context.startActivity(intent);
                }
            },1000);
        }*/
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
