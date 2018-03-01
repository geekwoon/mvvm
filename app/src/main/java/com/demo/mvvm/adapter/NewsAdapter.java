package com.demo.mvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.demo.mvvm.BR;
import com.demo.mvvm.R;
import com.demo.mvvm.base.BaseAdapter;
import com.demo.mvvm.base.BaseViewHolder;
import com.demo.mvvm.bean.SimpleNewsBean;
import com.demo.mvvm.utils.ToastUtils;

public class NewsAdapter extends BaseAdapter<SimpleNewsBean, BaseViewHolder> {

    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_news, parent, false);
        return new BaseViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        ViewDataBinding binding = baseViewHolder.getBinding();
        binding.setVariable(BR.simpleNewsBean, mList.get(position));
        binding.setVariable(BR.position,position);
        binding.setVariable(BR.adapter,this);
        binding.executePendingBindings(); //防止闪烁
    }


    /**
     * 点赞
     * @param simpleNewsBean
     * @param position
     */
    public void clickDianZan(SimpleNewsBean simpleNewsBean, int position) {
        if (simpleNewsBean.isGood.get()) {
            simpleNewsBean.isGood.set(false);
            ToastUtils.show(mContext, "取消点赞 position=" + position);
        } else {
            simpleNewsBean.isGood.set(true);
            ToastUtils.show(mContext, "点赞成功 position=" + position);
        }
    }
}