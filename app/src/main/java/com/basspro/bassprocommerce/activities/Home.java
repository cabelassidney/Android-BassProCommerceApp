package com.basspro.bassprocommerce.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;


import com.basspro.bassprocommerce.R;
import com.basspro.bassprocommerce.ViewPagerAdapter;
import com.basspro.bassprocommerce.fragments.CartFragment;
import com.basspro.bassprocommerce.fragments.HomeFragment;
import com.basspro.bassprocommerce.fragments.MoreFragment;
import com.basspro.bassprocommerce.fragments.OffersFragment;
import com.basspro.bassprocommerce.fragments.StoreFragment;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.text.Line;

public class Home extends AppCompatActivity {

    private ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    String getid;
    MenuItem prevMenuItem;
    HomeFragment homeFragment;
    StoreFragment storeFragment;
    OffersFragment offersFragment;
    CartFragment cartFragment;
    MoreFragment moreFragment;
    boolean isSearch;
    LinearLayout searchlayout;
    private static final int SCAN_REQUEST = 400;

    private static final int REQUEST_CAMERA = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toptoolbar = findViewById(R.id.toptoolbar);
          searchlayout = (LinearLayout) findViewById(R.id.search_main);
        searchlayout.setVisibility(View.GONE);
       ImageView btnscan = findViewById(R.id.scanner);
       ImageView btnsearch =findViewById(R.id.searchmenu);
       btnscan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (ContextCompat.checkSelfPermission(Home.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                   ActivityCompat.requestPermissions(Home.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
               }
               else{
                   Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                   openScancer();
               }
           }
       });
       btnsearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (isSearch){
                   searchlayout.setVisibility(View.GONE);
                   isSearch = false;
               }
               else {
                   searchlayout.setVisibility(View.VISIBLE);
                   isSearch = true;
               }
               Toast.makeText(Home.this, "you clicked on search", Toast.LENGTH_SHORT).show();
           }
       });
       getid = getIntent().getStringExtra("Guest");
        //Initializing viewPager
        viewPager =  findViewById(R.id.viewpager);


        //Initializing the bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ViewPagerAdapter.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_store:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_offers:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_cart:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.action_more:
                        viewPager.setCurrentItem(4);
                        break;
                        default:
                }
                return false;
            }
                });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                searchlayout.setVisibility(View.GONE);
                isSearch = false;
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // from disabling wsipe option for fragment
        viewPager.beginFakeDrag();
        //To enable swipe option in fragments
        //mViewPager.endFakeDrag();
        setupViewPager(viewPager);
    }

    /*private void setSupportActionBar(Toolbar toolbar) {
    }*/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment =new HomeFragment();
        storeFragment=new StoreFragment();
        offersFragment=new OffersFragment();
        cartFragment = new CartFragment();
        moreFragment = new MoreFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(storeFragment);
        adapter.addFragment(cartFragment);
        adapter.addFragment(moreFragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toptoolbar, menu);

        return true;
    }

    @Override
    public void onBackPressed() {

        if (getid.equals("skipme")){
            Intent intent =  new Intent(Home.this,Login.class);
            startActivity(intent);
        }
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_scanner:
                Toast.makeText(this, "clicked scanner", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_search:
                Toast.makeText(this, "Selected search", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }
    public void isSearchTrue(){
        if (isSearch){
            searchlayout.setVisibility(View.GONE);
            isSearch = false;
        }
        else {
            searchlayout.setVisibility(View.VISIBLE);
            isSearch = true;
        }
        Toast.makeText(Home.this, "you clicked on search", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode == SCAN_REQUEST ){
           if (resultCode == CommonStatusCodes.SUCCESS){
               if (data!=null){
                   Barcode barcode = data.getParcelableExtra("barcode");
                   //mScanResult.setText(""+barcode.displayValue);
                   Toast.makeText(getApplicationContext(), barcode.displayValue, Toast.LENGTH_SHORT).show();

               }else {
                   //mScanResult.setText("Not found!");
                   Toast.makeText(getApplicationContext(), "not found", Toast.LENGTH_SHORT).show();
               }
           }
       }
    }

    /* ActionBar actionBar = getActionBar();
    actionBar.hide();
    // more stuff here...
    actionBar.show();*/
public  void openScancer(){
    Intent intent = new Intent(Home.this,MyBarCodeActivity.class);
    startActivityForResult(intent,SCAN_REQUEST);
}
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                openScancer();
                //start audio recording or whatever you planned to do
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(Home.this, Manifest.permission.CAMERA)) {
                    //Show an explanation to the user *asynchronously*
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("This permission is important to scan qr code.")
                            .setTitle("Important permission required");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ActivityCompat.requestPermissions(Home.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                        }
                    });
                    ActivityCompat.requestPermissions(Home.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                } else {
                    //Never ask again and handle your app without permission.
                }
            }
        }
    }
}

