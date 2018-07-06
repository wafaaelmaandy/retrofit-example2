package com.wafaaelm3andy.loginretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wafaaelm3andy.loginretrofit.model.User;
import com.wafaaelm3andy.loginretrofit.retrofit.ApiClient;
import com.wafaaelm3andy.loginretrofit.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText name , email,topics ,age ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.nameInput);
        email=(EditText)findViewById(R.id.emailInput);
        topics=(EditText)findViewById(R.id.topicsInput);
        age=(EditText)findViewById(R.id.ageInput);


    }

    public void CreatAccount(View view) {
        User user =new User(name.getText().toString(),email.getText().toString()
        ,topics.getText().toString().split(","),Integer.parseInt(age.getText().toString()));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

         Call<User> call = apiService.createAccount(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), "ya", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "oh", Toast.LENGTH_LONG).show();

            }


        });
}
}
