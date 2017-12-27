package wangwn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wangwn.Model.Student;

public class ChooseRoom extends AppCompatActivity {
    ListView myinfolistview;
    Button btn_deal;
    Student student=new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseroom);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("办理住宿");
        student= (Student) getIntent().getSerializableExtra("student");
        myinfolistview= (ListView) findViewById(R.id.mylist);
        btn_deal= (Button) findViewById(R.id.deal_with_mybus);

        btn_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseRoom.this,ChooseNoofPerson.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("student",student);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        initlistview();//初始化Myinfo
    }

    private void initlistview() {
        List<String> myinfo=new ArrayList<>();
        myinfo.add("姓名:"+"                "+ student.getName());
        myinfo.add("学号:"+"                "+ student.getStudentid());
        myinfo.add("性别:"+"                "+ student.getGender() );
        myinfo.add("校验码:"+"                "+ student.getVcode() );
        ArrayAdapter myadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,myinfo);
        myinfolistview.setAdapter(myadapter);
    }
}
