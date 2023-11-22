package duanvdph37524.fpoly.techstore_duan_nhom8.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import duanvdph37524.fpoly.techstore_duan_nhom8.Activity.ListDienThoai;
import duanvdph37524.fpoly.techstore_duan_nhom8.MainActivity;
import duanvdph37524.fpoly.techstore_duan_nhom8.R;

public class mainfragment extends Fragment {




    ImageView imgDienThoai;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);
        imgDienThoai = view.findViewById(R.id.imgDienThoai);
        imgDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDienThoai.class));
            }
        });
        return view;

    }
}