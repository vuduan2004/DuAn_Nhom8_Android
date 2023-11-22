package duanvdph37524.fpoly.techstore_duan_nhom8.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_duan_nhom8.Model.DienThoai;
import duanvdph37524.fpoly.techstore_duan_nhom8.R;

public class DienThoaiAdapter extends RecyclerView.Adapter<DienThoaiAdapter.viewHolep> {
    Context context;
    ArrayList<DienThoai> list;
    FirebaseFirestore firestore;

    public DienThoaiAdapter(Context context, ArrayList<DienThoai> list) {
        this.context = context;
        this.list = list;
//        this.firestore = firestore;
    }

    @NonNull
    @Override
    public viewHolep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_list_dienthoai,null);
        return new viewHolep(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolep holder, int position) {
        firestore = FirebaseFirestore.getInstance();
        DienThoai dienThoai = list.get(position);
        Glide.with(context).load(dienThoai.getHinhAnh()).into(holder.imgAnh);
        holder.tvTen.setText(list.get(position).getTenDienThoai());
        holder.tvGiaKm.setText(String.valueOf(list.get(position).getGiaTienKM()));
        holder.tvGia.setText(String.valueOf(list.get(position).getGiaTien()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolep extends RecyclerView.ViewHolder {
        ImageView imgAnh;
        TextView tvTen, tvGiaKm, tvGia;

        public viewHolep(@NonNull View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.img_dienThoai);
            tvTen = itemView.findViewById(R.id.tv_tenDienThoai);
            tvGiaKm = itemView.findViewById(R.id.tv_giaTienKM);
            tvGia = itemView.findViewById(R.id.tv_giaTien);
            tvGia.setPaintFlags(tvGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
