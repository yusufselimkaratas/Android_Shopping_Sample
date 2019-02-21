package com.karatasyazilim.ecommence;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karatasyazilim.ecommence.Model.Users;
import com.karatasyazilim.ecommence.Prevalent.Prevalent;

import io.paperdb.Paper;


public class Login_Activity extends AppCompatActivity {
    private EditText InputNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private String parentDbName="Users";
    private CheckBox chkBoxRememberMe;
    private TextView AdminLink,NotAdminLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_ );

        LoginButton=(Button) findViewById( R.id.login_btn );
        InputNumber=(EditText) findViewById( R.id.login_phone_number_input );
        InputPassword=(EditText) findViewById( R.id.login_password_input );
        loadingBar=new ProgressDialog(this);
        chkBoxRememberMe=(CheckBox) findViewById( R.id.remember_me_chkcbox );
        AdminLink=(TextView) findViewById( R.id.admin_panel_link );
        NotAdminLink=(TextView)findViewById( R.id.not_admin_panel_link );


        LoginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        } );

        AdminLink.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText( "Yönetici Girişi" );
                AdminLink.setVisibility( View.INVISIBLE );
                NotAdminLink.setVisibility( View.VISIBLE );

                parentDbName="Admins";
            }
        } );
        NotAdminLink.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText( "Giriş" );
                NotAdminLink.setVisibility( View.INVISIBLE );
                AdminLink.setVisibility( View.VISIBLE );

                parentDbName="Users";

            }
        } );
    }

    private void LoginUser()
    {
        String phone=InputNumber.getText().toString();
        String password=InputPassword.getText().toString();

        if(TextUtils.isEmpty( phone ))
        {
            Toast.makeText( this,"Lütfen telefon numaranızı giriniz.",Toast.LENGTH_LONG ).show();
        }
        else if (TextUtils.isEmpty( password ))
        {
            Toast.makeText( this,"Lütfen parolanızı giriniz.",Toast.LENGTH_LONG ).show();
        }
        else
        {
            loadingBar.setTitle( "Giriş" );
            loadingBar.setMessage( "Giriş yapılıyor..." );
            loadingBar.setCanceledOnTouchOutside( false );
            loadingBar.show();

            AllowAccessToAccount(phone,password);
        }
    }

    private void AllowAccessToAccount(final String phone,final String password)
    {
        //JUST TO REMEMBER ME
        if(chkBoxRememberMe.isChecked())
        {
            Paper.book().write( Prevalent.UserPhoneKey,phone );
            Paper.book().write( Prevalent.UserPasswordKey,password );
        }
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child( parentDbName ).child( phone ).exists())
                {


                    Users usersData=dataSnapshot.child( parentDbName ).child( phone ).getValue(Users.class);

                    if(usersData.getPhone().equals( phone ))
                    {
                        if(usersData.getPassword().equals( password ))
                        {
                            if(parentDbName.equals( "Admins" ))
                            {
                                Toast.makeText(Login_Activity.this,"Yönetici Girişi Başarılı.",Toast.LENGTH_SHORT ).show();
                                loadingBar.dismiss();

                                Intent intent =new Intent( Login_Activity.this,AdminCategoryActivity.class );
                                startActivity( intent );
                            }
                            else if (parentDbName.equals("Users"))
                            {
                                Toast.makeText(Login_Activity.this,"Giriş Başarılı.",Toast.LENGTH_SHORT ).show();
                                loadingBar.dismiss();

                                Intent intent =new Intent( Login_Activity.this,HomeActivity.class );
                                Prevalent.currentOnlineUser=usersData;
                                startActivity( intent );
                            }

                        }
                    }
                }
                else
                {
                    Toast.makeText( Login_Activity.this,"Bu numara ("+phone+")ile hesap bulunamammıştır.",Toast.LENGTH_LONG ).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }


}
