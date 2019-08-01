package com.tz.dream.budejie.pro.essence.view.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.tz.dream.budejie.R;
import com.tz.dream.budejie.bean.PostsListBean;
import com.tz.dream.budejie.pro.essence.view.views.CircleNetworkImageImage;
import com.tz.dream.budejie.utils.DateUtils;
import com.tz.dream.budejie.utils.VolleyUtils;

import java.util.List;


/**
 * 显示和缓存数据
 *
 *created by Administrator
 */
public class EssenceVideoAdapter extends BaseRecyclerAdapter<EssenceVideoAdapter.VideoAdapterViewHolder> {

    private Context context;
    private List<PostsListBean.PostList> list;

    public EssenceVideoAdapter(List<PostsListBean.PostList> list, Context context) {
        this.context = context;
        this.list = list;
    }


    /**
     * 配置ViewHoder
     * @param view
     * @return
     */
    @Override
    public VideoAdapterViewHolder getViewHolder(View view) {
        return new VideoAdapterViewHolder(view, false);
    }

    //创建布局
    @Override
    public VideoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(context).inflate(
                R.layout.item_essence_video_layout, parent, false);
        VideoAdapterViewHolder holder = new VideoAdapterViewHolder(v, true);
        return holder;
    }

    //给我们的视图绑定数据
    @Override
    public void onBindViewHolder(VideoAdapterViewHolder holder, int position, boolean isItem) {
        PostsListBean.PostList postList = this.list.get(position);
        VolleyUtils.loadImage(context,holder.iv_header,postList.getProfile_image());
        holder.tv_name.setText(postList.getName());
        holder.tv_time.setText(DateUtils.parseDate(postList.getCreate_time()));
        holder.tv_content.setText(postList.getText());
        holder.tv_like.setText(postList.getDing());
        holder.tv_dislike.setText(postList.getCai());
        holder.tv_forword.setText(postList.getRepost());
        holder.tv_comment.setText(postList.getComment());
    }

    @Override
    public int getAdapterItemCount() {
        return this.list.size();
    }

    public class VideoAdapterViewHolder extends RecyclerView.ViewHolder {

        public CircleNetworkImageImage iv_header;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_content;
        public ImageView iv_video;

        public LinearLayout ll_like;
        public TextView tv_like;

        public LinearLayout ll_dislike;
        public TextView tv_dislike;

        public LinearLayout ll_forword;
        public TextView tv_forword;

        public LinearLayout ll_comment;
        public TextView tv_comment;

        public int position;

        public VideoAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                iv_header = (CircleNetworkImageImage) itemView
                        .findViewById(R.id.iv_header);
                tv_name = (TextView) itemView
                        .findViewById(R.id.tv_name);
                tv_time = (TextView) itemView
                        .findViewById(R.id.tv_time);
                tv_content = (TextView) itemView
                        .findViewById(R.id.tv_content);
                iv_video = (ImageView) itemView
                        .findViewById(R.id.iv_video);

                ll_like = (LinearLayout) itemView
                        .findViewById(R.id.ll_like);
                tv_like = (TextView) itemView
                        .findViewById(R.id.tv_like);

                ll_dislike = (LinearLayout) itemView
                        .findViewById(R.id.ll_dislike);
                tv_dislike = (TextView) itemView
                        .findViewById(R.id.tv_dislike);

                ll_forword = (LinearLayout) itemView
                        .findViewById(R.id.ll_forword);
                tv_forword = (TextView) itemView
                        .findViewById(R.id.tv_forword);

                ll_comment = (LinearLayout) itemView
                        .findViewById(R.id.ll_comment);
                tv_comment = (TextView) itemView
                        .findViewById(R.id.tv_comment);
            }

        }
    }
}
