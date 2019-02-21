package com.karatasyazilim.ecommence;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tShirts,sportTshirts,femaleDresses,sweaters;
    private ImageView glasses, hatsCaps,bags,shoes;
    private ImageView headPhones, Laptops, Watches, mobilePhones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin_category );

        tShirts=(ImageView) findViewById( R.id.t_shirts );
        sportTshirts=(ImageView)findViewById( R.id.sports );
        femaleDresses=(ImageView)findViewById( R.id.female_dresses );
        sweaters=(ImageView)findViewById( R.id.sweather );
        glasses=(ImageView)findViewById( R.id.glasses );
        hatsCaps=(ImageView)findViewById( R.id.hats );
        bags=(ImageView)findViewById( R.id.purses_bags );
        shoes=(ImageView)findViewById( R.id.shoess );
        headPhones=(ImageView) findViewById( R.id.headphones );
        Laptops=(ImageView) findViewById( R.id.laptops );
        Watches=(ImageView)findViewById( R.id.watches );
        mobilePhones=(ImageView) findViewById( R.id.mobiles );

        tShirts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","tShirts" );
                startActivity( intent );
            }
        } );

        sportTshirts.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","SportTshirts" );
                startActivity( intent );

            }
        } );

        femaleDresses.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","femaledresses" );
                startActivity( intent );
            }
        } );

        sweaters.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Sweathers" );
                startActivity( intent );
            }

        } );

        glasses.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Glasses" );
                startActivity( intent );
            }
        } );
        hatsCaps.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Hats Caps" );
                startActivity( intent );
            }
        } );
        bags.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Bags" );
                startActivity( intent );
            }
        } );
        shoes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Shoes" );
                startActivity( intent );
            }
        } );

        headPhones.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","HeadPhones" );
                startActivity( intent );
            }
        } );

        Laptops.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Laptops" );
                startActivity( intent );
            }
        } );

        mobilePhones.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","MobilePhones" );
                startActivity( intent );
            }
        } );

        Watches.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra( "Category","Watches" );
                startActivity( intent );
            }
        } );
    }
}
