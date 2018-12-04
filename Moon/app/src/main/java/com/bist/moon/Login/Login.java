package com.bist.moon.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bist.moon.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    
    FirebaseUser user;
    FirebaseAuth firebaseAuth;

    EditText editID, editPW;
    Button btnLogin, btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editID = findViewById(R.id.editID);
        editPW = findViewById(R.id.editPW);
        btnLogin = findViewById(R.id.btnLogin);
        btnReg = findViewById(R.id.btnReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
