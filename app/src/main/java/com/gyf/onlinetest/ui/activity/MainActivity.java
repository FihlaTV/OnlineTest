package com.gyf.onlinetest.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.onlinetest.R;
import com.gyf.onlinetest.RecycleViewDivider;
import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.presenter.BusPresenter;
import com.gyf.onlinetest.ui.adapter.BusRvAdapter;
import com.gyf.onlinetest.ui.fragment.SplashFragment;
import com.gyf.onlinetest.ui.view.BusView;
import com.gyf.onlinetest.utils.RxTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author geyifeng
 */
public class MainActivity extends BaseActivity<BusView, BusPresenter> implements BusView, Observer<Long> {

    @BindView(R.id.content_vs)
    ViewStub contentVs;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    private Disposable mDisposable;

    /**
     * 倒计时时间
     */
    private static final int MAX_COUNT_TIME = 5;

    private SplashFragment mSplashFragment;
    private BusRvAdapter mBusRvAdapter;

    @Override
    protected BusPresenter initPresenter() {
        return new BusPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.load();
    }

    @Override
    protected void initView() {
        showSplash();
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                RxTimer.countDown(MAX_COUNT_TIME)
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                mSplashFragment.btnSkip.setText("跳过(" + MAX_COUNT_TIME + "s)");
                            }
                        })
                        .subscribe(MainActivity.this);
                initAdapter();
                mSplashFragment.btnSkip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDisposable.dispose();
                        closeSplash();
                    }
                });
            }
        });
    }

    /**
     * 展示splash欢迎页
     */
    private void showSplash() {
        mSplashFragment = new SplashFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, mSplashFragment).commit();
    }

    /**
     * 关闭splash欢迎页
     */
    private void closeSplash() {
        if (mSplashFragment == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(mSplashFragment);
        transaction.commit();
    }

    private void initAdapter() {
        contentVs.inflate();
        ImmersionBar.setTitleBar(this, findViewById(R.id.toolbar));
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        mBusRvAdapter = new BusRvAdapter(this);
        rv.setAdapter(mBusRvAdapter);
        rv.addItemDecoration(new RecycleViewDivider(MainActivity.this, LinearLayoutManager.HORIZONTAL));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(@NonNull Long aLong) {
        mSplashFragment.btnSkip.setText("跳过(" + aLong + "s)");
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {
        closeSplash();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onLoadSuccess(final HashMap<String, ArrayList<BusBean>> busMap) {
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                mBusRvAdapter.setData(busMap);
            }
        });
    }

    @Override
    public void onLoadFail() {

    }

}
