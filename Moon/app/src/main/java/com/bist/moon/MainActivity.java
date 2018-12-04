package com.bist.moon;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bist.moon.Login.Login;
import com.gun0912.tedpermission.PermissionListener;

import java.sql.Time;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    long now = 0;
    int cnt = 0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.testview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(now == 0) {
                    now = System.currentTimeMillis();
                }
                else if(System.currentTimeMillis()- now <= 500){
                    now = System.currentTimeMillis();
                    cnt++;
                }
                else{
                    now = 0;
                    cnt = 0;
                }

                switch (cnt){
                    case 3 : Toast.makeText(MainActivity.this,"3!",Toast.LENGTH_SHORT).show();
                    break;
                    case 4 : Toast.makeText(MainActivity.this,"2!",Toast.LENGTH_SHORT).show();
                    break;
                    case 5 : Toast.makeText(MainActivity.this,"1!",Toast.LENGTH_SHORT).show();
                    break;
                    case 6 :
                        Intent i = new Intent(MainActivity.this,Login.class);
                        startActivity(i);
                }
            }
        });

    }

    /*
    TedPermission.with(this)
            .setPermissionListener(permissionlistener)
            .setRationaleMessage("구글 로그인을 하기 위해서는 주소록 접근 권한이 필요해요")
    .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
    .setPermissions(Manifest.permission.READ_CONTACTS)
    .check();
    */
    PermissionListener permissionlistener;

    {
        permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "권한 허가", LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "권한 거부\n" + deniedPermissions.toString(), LENGTH_SHORT).show();
            }
        };
    }
}
