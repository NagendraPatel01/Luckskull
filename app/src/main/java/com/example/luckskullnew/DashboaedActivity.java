package com.example.luckskullnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luckskullnew.fragment.CreateidFragment;
import com.example.luckskullnew.fragment.HomeFragment;
import com.example.luckskullnew.fragment.IDsFragment;
import com.example.luckskullnew.fragment.OfferFragment;
import com.example.luckskullnew.fragment.PassbookFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboaedActivity extends AppCompatActivity {

    FrameLayout frame;
    DrawerLayout drawer;
    NavigationView navigation;
    BottomNavigationView bootom;
    TextView toolText,numbertext;
    ImageView img,img1,img2;
    //this is a temp comment
    // my name is nagendra patel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboaed);

        frame=findViewById(R.id.frame);
        drawer=findViewById(R.id.drawer);
        navigation=findViewById(R.id.navigation);
        bootom=findViewById(R.id.bootom);
        img=findViewById(R.id.img);
        img1=findViewById(R.id.img1);
        toolText=findViewById(R.id.toolText);
        img2=findViewById(R.id.img2);




        replace(new HomeFragment());

       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(Gravity.LEFT);

            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        String number=sharedPreferences.getString("numberte","");

        View header = navigation.getHeaderView(0);
        numbertext = (TextView) header.findViewById(R.id.numbertext);
        numbertext.setText(number);

        img1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(DashboaedActivity.this,NotificationActivity.class));
           }
       });


        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.profile:

                        startActivity(new Intent(DashboaedActivity.this,ProfileActivity.class));

                        break;

                    case R.id.howtouse:

                        startActivity(new Intent(DashboaedActivity.this,HowtouseActivity.class));

                        break;

                    case R.id.notification:

                        startActivity(new Intent(DashboaedActivity.this,NotificationActivity.class));
                        break;

                    case R.id.refer:

                        startActivity(new Intent(DashboaedActivity.this,ReferErnActivity.class));

                        break;



                    case R.id.withdrow:

                        startActivity(new Intent(DashboaedActivity.this,WithdraweldetailActivity.class));
                        break;


                    case R.id.help:

                        startActivity(new Intent(DashboaedActivity.this,HelpActivity.class));
                        break;

                    case R.id.term:

                        startActivity(new Intent(DashboaedActivity.this,TermsActivity.class));
                        break;

                    case R.id.createid:

                        replace(new IDsFragment());
                        break;

                    case R.id.logout:


                        AlertDialog.Builder alert=new AlertDialog.Builder(DashboaedActivity.this);

                        final View dialogView= LayoutInflater.from(DashboaedActivity.this).inflate(R.layout.akertdilog,null,false);
                        alert.setView(dialogView);

                        final AlertDialog alertDialog=alert.create();
                        alertDialog.show();

                        CardView card=dialogView.findViewById(R.id.card);
                        ///

                        card.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                startActivity(new Intent(DashboaedActivity.this,LoginActivity.class));
                                finish();
                            }
                        });

                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bootom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        toolText.setText("");
                        replace(new HomeFragment());

                        break;

                    case R.id.offer:
                        toolText.setText("Offer");
                        replace(new OfferFragment());
                        break;

                    case R.id.passbook:
                        toolText.setText("Passbook");
                        replace(new PassbookFragment());
                        break;

                    case R.id.ids:
                        toolText.setText("IDs");
                        replace(new IDsFragment());
                        break;
                }
                return true;
            }
        });
    }
    void replace(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout layout = (DrawerLayout)findViewById(R.id.drawer);
        if (layout.isDrawerOpen(GravityCompat.START)) {
            layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }
}