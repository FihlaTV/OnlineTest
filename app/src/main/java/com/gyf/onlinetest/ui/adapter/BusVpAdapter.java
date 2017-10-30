package com.gyf.onlinetest.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.onlinetest.R;
import com.gyf.onlinetest.model.bean.BusBean;

import java.util.ArrayList;

/**
 * @author geyifeng
 * @date 2017/10/25
 */

class BusVpAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<BusBean> busBeen = new ArrayList<>();

    BusVpAdapter(Context context, ArrayList<BusBean> busBeen) {
        this.mContext = context;
        this.busBeen = busBeen;
    }

    @Override
    public int getCount() {
        return busBeen.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_vp, container, false);
        container.addView(view);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvTerminal = view.findViewById(R.id.tv_terminal);
        TextView tvCurrStop = view.findViewById(R.id.tv_curr_stop);
        TextView tvDirection = view.findViewById(R.id.tv_direction);
        TextView tvStationIndex = view.findViewById(R.id.tv_station_index);
        TextView tvBusType = view.findViewById(R.id.tv_bus_type);

        tvName.setText(busBeen.get(position).getName());
        tvTerminal.setText(busBeen.get(position).getTerminal());
        tvCurrStop.setText(busBeen.get(position).getCurr_stop());
        tvDirection.setText(busBeen.get(position).getDirection() + "分钟");
        tvStationIndex.setText(busBeen.get(position).getStation_index() + "分钟");
        tvBusType.setText(busBeen.get(position).getBus_type());
        return view;
    }
}
