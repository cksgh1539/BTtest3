/*
package com.example.hp.bttest3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class BackgroundWork2 extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog.Builder alertDialog;
    BackgroundWork2(Context ctx){
        context = ctx;
    }
    String NFC;
    TextView User;
    @Override
    protected String doInBackground(String... voids) {

        String type = voids[0];
        String Send_url = "http://220.67.230.12/web_147/change/Test_Send.php";
        if(type.equals("NFC")) {
            try {
                NFC = voids[1];

                Log.v("chanho", "NFC : "+ NFC);
                URL url = new URL(Send_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("uid","UTF-8")+"="+URLEncoder.encode(NFC,"UTF-8");
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

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onPostExecute(String result) {
        Log.v("chanho","postExecute");
        String name="";
        String deposit="";
        String minus="";
        String point="";
        String ex_total="";
        Log.v("chanho","str"+str);

        try{
            Log.v("chanho","post try시작");
            JSONObject root = new JSONObject(String.valueOf(str));
            Log.v("chanho","root"+root);
            JSONArray ja = root.getJSONArray("results");
            Log.v("chanho","array : "+ja);
            Log.v("chanho","array length : "+ja.length());
            for(int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);
                total = jo.getString("total");
                name = jo.getString("name");
                Log.v("chanho","total : "+total + " name : "+name );
                deposit = jo.getString("deposit");
                minus = jo.getString("minus");
                //  point = jo.getString("ins_point"); //적립포인트
                //  ex_total = jo.getString("point_total"); //남은 포인트

                minus_total += Integer.parseInt(minus);
                deposit_total += Integer.parseInt(deposit);
                //    point_total += Integer.parseInt(point); // 누적 포인트
                //   Log.v("chanho",total+name+deposit+minus+point+ex_total);
            }

        }catch(JSONException e){
            Log.v("chanho","오류");
            e.printStackTrace();
        }

        user_name.setText("안녕하세요!! " +name+"님 :D");
        user_total.setText(total +" 원");
        //  user_point.setText(ex_total + " 점"); //남은 포인트
      */
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
        }*//*

        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
*/
