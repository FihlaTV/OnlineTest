package com.gyf.onlinetest.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gyf.onlinetest.R;
import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.utils.DensityUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author geyifeng
 * @date 2017/10/25
 */

public class BusRvAdapter extends RecyclerView.Adapter<BusRvAdapter.BusViewHolder> {

    private Context mContext;
    private HashMap<String, ArrayList<BusBean>> mData;
    private ArrayList<String> mName;

    public BusRvAdapter(Context context) {
        this.mContext = context;
        mData = new LinkedHashMap<>();
    }

    public void setData(HashMap<String, ArrayList<BusBean>> busMap) {
        this.mData = busMap;
        mName = new ArrayList<>();
        Set<Map.Entry<String, ArrayList<BusBean>>> entries = mData.entrySet();
        for (Map.Entry<String, ArrayList<BusBean>> entry : entries) {
            String name = entry.getKey();
            mName.add(name);
        }
        notifyDataSetChanged();
    }

    @Override
    public BusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BusViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(BusViewHolder holder, int position) {

        final ArrayList<BusBean> busBeen = mData.get(mName.get(position));
        final ArrayList<View> views = initDot(holder.llContainer, busBeen.size());
        holder.vp.setAdapter(new BusVpAdapter(mContext, busBeen));
        holder.vp.setCurrentItem(0);
        holder.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < busBeen.size(); i++) {
                    views.get(i).setBackgroundResource(R.drawable.shape_dot_unselected);
                }
                views.get(position).setBackgroundResource(R.drawable.shape_dot_selected);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ArrayList<View> initDot(ViewGroup viewGroup, int size) {
        ArrayList<View> views = new ArrayList<>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(mContext, 5),
                DensityUtil.dip2px(mContext, 5));
        params.setMarginStart(DensityUtil.dip2px(mContext,3));
        for (int i = 0; i < size; i++) {
            View view = new View(mContext);
            view.setBackgroundResource(R.drawable.shape_dot_unselected);
            viewGroup.addView(view, params);
            views.add(view);
        }
        views.get(0).setBackgroundResource(R.drawable.shape_dot_selected);
        return views;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class BusViewHolder extends RecyclerView.ViewHolder {

        ViewPager vp;
        LinearLayout llContainer;

        private BusViewHolder(View view) {
            super(view);
            vp = view.findViewById(R.id.vp);
            llContainer = view.findViewById(R.id.ll_container);
        }
    }

}
