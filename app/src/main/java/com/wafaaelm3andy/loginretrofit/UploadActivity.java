package com.wafaaelm3andy.loginretrofit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wafaaelm3andy.loginretrofit.retrofit.ApiClient;
import com.wafaaelm3andy.loginretrofit.retrofit.ApiInterface;

import java.io.File;
import java.util.jar.Manifest;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadActivity extends AppCompatActivity {
 final static  int permessionRequest = 100;
 private int GetImageFromGallery =1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        if(ContextCompat.checkSelfPermission(UploadActivity.this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(UploadActivity.this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},permessionRequest);
        }

    }

    public void upload(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select picture"),GetImageFromGallery);
    }
    @Override
    protected void onActivityResult(int requesrCode ,int resultCode,Intent data){
        super.onActivityResult(requesrCode,resultCode,data);
        if(requesrCode==GetImageFromGallery&&requesrCode==RESULT_OK &&data.getData()!=null){
            Uri uri =data.getData();
            uploadFile(uri);
        }
    }

     //@Override
    public void onRequestPermissionsResult(int requestCode ,String permession ,int []grantResults){
        switch (requestCode){
            case permessionRequest :{
                 if (grantResults.length>0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){

                 }
            }
        }
    }

    private void uploadFile(Uri uri) {
        EditText editText = (EditText)findViewById(R.id.des);
        RequestBody descriptionPart =RequestBody.create(MultipartBody.FORM,editText.getText().toString() );
    File orignalfile = FileUtils.getFile(this,uri);
        RequestBody filePart =RequestBody.create(MediaType.parse
                (getContentResolver().getType(uri)),FileUtils.getFile(this,uri));
        MultipartBody.Part file = MultipartBody.Part.createFormData("photo",orignalfile.getName(),filePart);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody > call= apiService.uploadPhoto(descriptionPart,file);


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getApplicationContext(), "ya", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "oh", Toast.LENGTH_LONG).show();

            }
        });


    }
}
