package com.example.hades.lab6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hades.lab6_1.Adapter.LophocAdapter;
import com.example.hades.lab6_1.SQLite.LophocDAO;
import com.example.hades.lab6_1.model.Lophoc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_id;
    EditText et_tenlop;
    Button bt_them,bt_sua;
    LophocDAO lophoc;
    ListView lvlophoc;
    ArrayList<Lophoc> dslophoc=new ArrayList<Lophoc>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            tv_id=findViewById(R.id.textViewid);
            et_tenlop=findViewById(R.id.editTexttenlop);
            bt_them=findViewById(R.id.buttonthem);
            bt_sua=findViewById(R.id.buttonsua);
            lvlophoc.findViewById(R.id.viewlophoc);
            lophoc=new LophocDAO(MainActivity.this);
            dslophoc=lophoc.xemLophoc();

            LophocAdapter adapterlophoc=new LophocAdapter(MainActivity.this,dslophoc);
            lvlophoc.setAdapter(adapterlophoc);

            bt_them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 String tenlop=et_tenlop.getText().toString();
                    Lophoc lh=new Lophoc(tenlop);
                    lophoc.themLopHoc(lh);
                    et_tenlop.setText("");
                    tv_id.setText("");
                }
            });
    }
}
