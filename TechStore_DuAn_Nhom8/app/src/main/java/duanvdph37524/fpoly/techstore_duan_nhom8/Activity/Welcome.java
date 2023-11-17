package duanvdph37524.fpoly.techstore_duan_nhom8.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import duanvdph37524.fpoly.techstore_duan_nhom8.MainActivity;
import duanvdph37524.fpoly.techstore_duan_nhom8.R;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Welcome.this, DangNhap.class));
            }
        },3000);
    }
}