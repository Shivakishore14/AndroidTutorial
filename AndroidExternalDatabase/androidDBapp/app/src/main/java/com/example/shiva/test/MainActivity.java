package com.example.shiva.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etUserName);
        pass = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);
        signup = (Button) findViewById(R.id.btnSignUp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG).show();
                loginTask b = new loginTask();
                b.execute(name.getText().toString(),pass.getText().toString());
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupTask b = new signupTask();
                b.execute(name.getText().toString(),pass.getText().toString());
            }
        });
    }
    public class loginTask extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
            if ("valid".equals(s.trim())){
                Intent i = new Intent(MainActivity.this, Success.class);
                startActivity(i);
            }
        }

        @Override
        protected String doInBackground(String... params) {
            try{
                String username = params[0];
                String password = params[1];

                String data= URLEncoder.encode("username","UTF-8") + "=" +
                        URLEncoder.encode(username,"UTF-8") + "&" +
                        URLEncoder.encode("password","UTF-8") + "=" +
                        URLEncoder.encode(password,"UTF-8");
                URL url = new URL("http://192.168.42.100/login.php?"+data);
                URLConnection con = url.openConnection();
                con.setDoOutput(true);

                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder s = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    s.append(line + "\n");
                }
                String result = s.toString();
                return result;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
    public class signupTask extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String... params) {
            try{
                String username = params[0];
                String password = params[1];

                String data= URLEncoder.encode("username","UTF-8") + "=" +
                        URLEncoder.encode(username,"UTF-8") + "&" +
                        URLEncoder.encode("password","UTF-8") + "=" +
                        URLEncoder.encode(password,"UTF-8");
                URL url = new URL("http://192.168.42.100/signup.php?"+data);
                URLConnection con = url.openConnection();
                con.setDoOutput(true);

                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder s = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    s.append(line + "\n");
                }
                String result = s.toString();
                return result;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
