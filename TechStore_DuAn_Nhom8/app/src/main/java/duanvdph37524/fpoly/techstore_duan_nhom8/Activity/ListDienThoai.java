package duanvdph37524.fpoly.techstore_duan_nhom8.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_duan_nhom8.Adapter.DienThoaiAdapter;
import duanvdph37524.fpoly.techstore_duan_nhom8.Model.DienThoai;
import duanvdph37524.fpoly.techstore_duan_nhom8.R;

public class ListDienThoai extends AppCompatActivity {
    RecyclerView recyclerView;
    DienThoaiAdapter dienThoaiAdapter;
    ArrayList<DienThoai> list = new ArrayList<>();
    Context context = this;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dien_thoai);
        Toolbar toolbar = findViewById(R.id.toolbarA);
        toolbar.setTitle("Danh sách điện thoại");
        setSupportActionBar(toolbar);
        firestore = FirebaseFirestore.getInstance();
        listenFireBase();
        dienThoaiAdapter = new DienThoaiAdapter(context, list);
        recyclerView = findViewById(R.id.rcv_listDienThoai);
        recyclerView.setAdapter(dienThoaiAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_icon,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void listenFireBase(){

        firestore.collection("dienThoai").orderBy("tenDienThoai").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    return;
                }
                if(value != null){
                    for (DocumentChange dc : value.getDocumentChanges()){
                        switch (dc.getType()){
                            case ADDED:
                                dc.getDocument().toObject(DienThoai.class);
                                list.add(dc.getDocument().toObject(DienThoai.class));
                                dienThoaiAdapter.notifyItemChanged(list.size());
                                break;
                            case MODIFIED:
                                DienThoai dienThoai = dc.getDocument().toObject(DienThoai.class);
                                if(dc.getOldIndex() == dc.getNewIndex()){
                                    list.set(dc.getOldIndex(), dienThoai);
                                    dienThoaiAdapter.notifyItemChanged(dc.getOldIndex());
                                }else{
                                    list.remove(dc.getOldIndex());
                                    list.add(dienThoai);
                                    dienThoaiAdapter.notifyItemChanged(dc.getOldIndex(), dc.getNewIndex());
                                }
                                break;
                            case REMOVED:
                                dc.getDocument().toObject(DienThoai.class);
                                list.remove(dc.getOldIndex());
                                dienThoaiAdapter.notifyItemChanged(dc.getOldIndex());
                                break;
                        }
                    }
                }
            }
        });
    }
}