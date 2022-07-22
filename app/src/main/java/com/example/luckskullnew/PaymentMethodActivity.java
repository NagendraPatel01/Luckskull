package com.example.luckskullnew;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.luckskullnew.utills.NewFileUtils;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadNotificationConfig;
import net.gotev.uploadservice.UploadStatusDelegate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PaymentMethodActivity extends AppCompatActivity {

    LinearLayout linear, linear1, linear2, linear3, linear4, linear5, linear6, linear7;
    ImageView img, img3, img4;
    CardView card1;
    TextView textamount;
    ProgressBar progress;

    String url = "https://luckskull.com/api/imageupload";
    String url1 = "https://luckskull.com/api/create-id";
    String url2 = "https://luckskull.com/api/add-coin-request";
    RequestQueue queue;
    StringRequest request;


    String editcoin, coin;
    String usrnme;
    String Deposit, cteateid;
    String wevurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        progress = findViewById(R.id.progress);
        // linear=findViewById(R.id.linear);
        linear1 = findViewById(R.id.linear1);
        // linear2=findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        //linear4=findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);
        linear6 = findViewById(R.id.linear6);
        // linear7=findViewById(R.id.linear7);
        card1 = findViewById(R.id.card1);
        img = findViewById(R.id.img);
        //img3=findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        textamount = findViewById(R.id.textamount);

        cteateid = getIntent().getStringExtra("createidone");
        Deposit = getIntent().getStringExtra("type");
        editcoin = getIntent().getStringExtra("editcoin");
        coin = getIntent().getStringExtra("editcoin");
        usrnme = getIntent().getStringExtra("username");
        wevurl = getIntent().getStringExtra("weburl");
        textamount.setText(editcoin);
        textamount.setText(coin);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* linear7.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
/////////////////////////
                    linear7.setVisibility(View.VISIBLE);
                    linear2.setVisibility(View.GONE);
                    linear3.setVisibility(View.GONE);*/

                BitmapDrawable drawable = (BitmapDrawable) img4.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                uploadBitmap(bitmap);

//                queue= Volley.newRequestQueue(PaymentMethodActivity.this);
//                request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG, "jgoirjhoir"+response);
//
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//
//                }){
//                    @Nullable
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String,String> params=new HashMap<>();
//                        params.put("image","");
//                        return super.getParams();
//                    }
//                };
//
//                queue.add(request);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // PaymentMethodActivity.this.finish();

                AlertDialog.Builder alert = new AlertDialog.Builder(PaymentMethodActivity.this);

                final View dialogView = LayoutInflater.from(PaymentMethodActivity.this).inflate(R.layout.transactioncancle, null, false);
                alert.setView(dialogView);

                final AlertDialog alertDialog = alert.create();
                alertDialog.show();

                CardView card = dialogView.findViewById(R.id.card);
                TextView text = dialogView.findViewById(R.id.text);
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });


            }
        });

     /*   linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear2.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.GONE);
            }
        });*/

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear3.setVisibility(View.VISIBLE);
                linear5.setVisibility(View.VISIBLE);
            }
        });

   /*    linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear5.setVisibility(View.VISIBLE);
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),100);

            }
        });*/


        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100);

            }
        });
    }

    private void uploadBitmap(final Bitmap bitmap) {
        linear5.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        SharedPreferences preferences = getSharedPreferences("accessToken", Context.MODE_PRIVATE);
        String token = preferences.getString("token", "null");
        //our custom volley request
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, "https://luckskull.com/api/imageupload\n",
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        progress.setVisibility(View.GONE);
                        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                        String phonenumber = sharedPreferences.getString("numberte", "0000000000");

                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(new String(response.data));
                            Log.d("MyData", obj.toString());

                            String urlimg = obj.getString("url");

                            if (Deposit.equalsIgnoreCase("deposit")) {

                                queue = Volley.newRequestQueue(PaymentMethodActivity.this);
                                request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.d("jshtijerhteur", "iusgiihuehg" + response);

                                        AlertDialog.Builder alert = new AlertDialog.Builder(PaymentMethodActivity.this);

                                        final View dialogView = LayoutInflater.from(PaymentMethodActivity.this).inflate(R.layout.requestplaceddilog, null, false);
                                        alert.setView(dialogView);

                                        final AlertDialog alertDialog = alert.create();
                                        alertDialog.show();

                                        CardView card = dialogView.findViewById(R.id.card);
                                        card.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(PaymentMethodActivity.this, DashboaedActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });

                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.d("oiehtiuerhg", "kjdhgiuehru" + error.getMessage());

                                    }
                                }) {
                                    @Nullable
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<>();
                                        params.put("phone", phonenumber);
                                        params.put("coins", editcoin);
                                        params.put("imageurl", urlimg);
                                        return params;
                                    }
                                };
                                queue.add(request);

                            }
                            else {

                                Log.d(TAG, "ohdg9iueroh" + urlimg);
                                JSONObject params = new JSONObject();
                                params.put("paymentgateway", "upi");
                                params.put("imagelink", urlimg);
                                params.put("siteurl", wevurl);
                                params.put("userphone", phonenumber);
                                params.put("userid", usrnme);
                                params.put("password", phonenumber);
                                params.put("amount", editcoin);


                                queue = Volley.newRequestQueue(PaymentMethodActivity.this);
                                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url1, params, listener -> {

                                    Log.d("ghfhg", "onResponse: "+listener);
                                    AlertDialog.Builder alert = new AlertDialog.Builder(PaymentMethodActivity.this);

                                    final View dialogView = LayoutInflater.from(PaymentMethodActivity.this).inflate(R.layout.requestplaceddilog, null, false);
                                    alert.setView(dialogView);

                                    final AlertDialog alertDialog = alert.create();
                                    alertDialog.show();

                                    CardView card = dialogView.findViewById(R.id.card);
                                    card.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(PaymentMethodActivity.this, DashboaedActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                }, error -> {
                                });
                                queue.add(request);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            /*
             * Here we are passing image by renaming it with a unique name
             * */
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String,String> map = new HashMap<>();
////                map.put();//token
//                map.put("Authorization","Bearer "+token);
//                return map;
//            }

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                params.put("image", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                return params;
            }
        };

        //adding the request to volley
        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100) {
            Uri imageUri = data.getData();
            img4.setImageURI(imageUri);

            Log.d("sdnbddnd", "onActivityResult: " + imageUri);
            String file_path = NewFileUtils.getPath(PaymentMethodActivity.this, imageUri);

            Log.d("File ka path aayega", "onActivityResult: " + file_path);
            // createMemory(file_path);
        }
    }


    public void createMemory(String filepath) {

        final String uploadId = UUID.randomUUID().toString();

        MultipartUploadRequest uploadRequest = null;
        try {
            uploadRequest = new MultipartUploadRequest(PaymentMethodActivity.this, uploadId, url)
                    .setMaxRetries(5)
                    .setMethod("POST")
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setDelegate(new UploadStatusDelegate() {
                        @Override
                        public void onProgress(Context context, UploadInfo onProgress) {

                        }

                        @Override
                        public void onError(Context context, UploadInfo uploadInfo, ServerResponse serverResponse, Exception exception) {

                            String body = serverResponse.getBodyAsString();
                            Log.d(TAG, "simpleVolleyRequestErrorER: " + body);

                        }

                        @Override
                        public void onCompleted(Context context, UploadInfo uploadInfo, ServerResponse serverResponse) {
                            Log.d(TAG, "onCompleted: " + serverResponse.getBodyAsString());
                            try {
                                JSONObject object = new JSONObject(serverResponse.getBodyAsString());

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onCancelled(Context context, UploadInfo uploadInfo) {
                        }
                    });
            uploadRequest.addFileToUpload(filepath, "image", "image", "UTF-8");
            uploadRequest.startUpload();
        } catch (MalformedURLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}
