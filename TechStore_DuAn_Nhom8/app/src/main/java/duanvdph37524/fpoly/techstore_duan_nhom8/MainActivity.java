package duanvdph37524.fpoly.techstore_duan_nhom8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import duanvdph37524.fpoly.techstore_duan_nhom8.Fragment.mainfragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              if(item.getItemId() == R.id.itHome){
                    replanceFragment(new mainfragment());
              }else if(item.getItemId() == R.id.itGioHang){
//                    startActivity(new Intent(MainActivity.this, GioHang.class));
              }else if(item.getItemId() == R.id.itUser){
//                  startActivity(new Intent(MainActivity.this, QuanLyTaiKhoan.class));
              }

                return false;
            }
        });
        if(savedInstanceState == null){
            replanceFragment(new mainfragment());
        }
    }

    private void replanceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}