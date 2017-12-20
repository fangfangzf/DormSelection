package wangwn;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangwn on 2017/11/29.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views, Context context){
        this.views = views;
        this.context = context;
    }

    @Override
    //返回要滑动的视图个数
    public int getCount() {
        return views.size();
    }

    @Override
    //添加position位置的视图，并返回这个视图对象
    public Object instantiateItem(ViewGroup container, int position){
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    //用于删除position位置所指定的视图
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    //isViewFromObject函数用于判断instantiateItem返回的对象是否与当前View代表的是同一个对象
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
