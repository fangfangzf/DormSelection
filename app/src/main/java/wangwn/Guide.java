package wangwn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwn on 2017/11/29.
 */

public class Guide extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPagerAdapter vpAdapter;
    private ViewPager vp;
    private List<View> views;

    private Button into_btn;

    private ImageView[] dots;
    private int[] ids = {R.id.iv1, R.id.iv2, R.id.iv3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        initDots();
        //初始化INTO_BTN，使用views里面的第三个视图即get（2）
        into_btn = (Button)views.get(2).findViewById(R.id.into_btn);
                into_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Guide.this,MainActivity.class);
                        startActivity(i);
                        finish();
            }
        });
    }

    //定义一个方法，将3个小圆点控件对象存入dots数组中
    void initDots(){
        dots = new ImageView[views.size()];
        for(int i=0; i<views.size(); i++){
            dots[i]=(ImageView)findViewById(ids[i]);
        }
    }
    //定义一个初始化ViewPager中视图的方法，主要用于动态的加载要在ViewPager中显示的视图
    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);//获取LayoutInflater对象
        views = new ArrayList<View>();
        //需要创建三个布局文件，用于加载到ViewPager中的视图
        views.add(inflater.inflate(R.layout.guide_page1, null));
        views.add(inflater.inflate(R.layout.guide_page2, null));
        views.add(inflater.inflate(R.layout.guide_page3, null));
        //实例化一个vpAdapter对象，传入相应的参数
        vpAdapter = new ViewPagerAdapter(views,this);
        vp = (ViewPager)findViewById(R.id.viewpager);
        //进行类型转换
        vp.setAdapter(vpAdapter);
        //为ViewPager控件设置页面变化的监听事件
        vp.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int i) {
        for(int a=0;a<ids.length;a++){
            if(a == i){
                dots[a].setImageResource(R.drawable.focused);
            }else{
                dots[a].setImageResource(R.drawable.unfocused);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
