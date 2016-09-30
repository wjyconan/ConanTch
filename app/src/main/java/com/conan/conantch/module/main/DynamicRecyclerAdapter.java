package com.conan.conantch.module.main;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.conan.conantch.R;
import com.conan.conantch.app.BaseRecyclerAdapter;
import com.conan.conantch.app.BaseRecyclerViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by conan on 16/9/30.
 */
public class DynamicRecyclerAdapter extends BaseRecyclerAdapter<String> implements BaseRecyclerAdapter.OnItemClickListener {

    public DynamicRecyclerAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected void showViewHolder(BaseRecyclerViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        final String model = mDatas.get(position);
        viewHolder.txtLevel.setText(model);
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(viewHolder.itemView, position, model);
                }
            });

            // 长点击事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(viewHolder.itemView, position, model);
                    return true;
                }
            });

        }
    }

    @Override
    protected BaseRecyclerViewHolder createViewHoldeHolder(ViewGroup parent,
                                                           int viewType) {
        View mView = null;
        BaseRecyclerViewHolder mViewHolder = null;
        mView = mInflater.inflate(R.layout.item_recyclerview_dynamic, parent, false);
        mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onItemClick(View view, int position, Object model) {
        Log.e("TAG", "onItemClick: "+model);
    }

    @Override
    public void onItemLongClick(View view, int position, Object model) {
        Log.e("TAG", "onItemLongClick: "+model);
    }

    static class ViewHolder extends BaseRecyclerViewHolder {
        @Bind(R.id.img_item_face)
        ImageView imgItemFace;
        @Bind(R.id.txt_name)
        TextView txtName;
        @Bind(R.id.txt_level)
        TextView txtLevel;
        @Bind(R.id.txt_school)
        TextView txtSchool;
        @Bind(R.id.txt_time_ago)
        TextView txtTimeAgo;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
