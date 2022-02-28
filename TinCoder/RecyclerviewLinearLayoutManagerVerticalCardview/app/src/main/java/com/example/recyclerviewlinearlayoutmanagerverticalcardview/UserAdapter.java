package com.example.recyclerviewlinearlayoutmanagerverticalcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context mContext;
    private List<User> mListUser;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData (List<User> list) {
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) {
            return;
        }

        holder.tvTime.setText(user.getTime());
        holder.tvTemp.setText(user.getTemp());
        holder.imgIcon.setImageResource(user.getResourceId());
        holder.tvSpeed.setText(user.getSpeed());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null) {
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        // Là nơi khai báo những thành phần view
        private ImageView imgIcon;
        private TextView tvTime, tvTemp, tvSpeed;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = (ImageView) itemView.findViewById(R.id.img_icon);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvTemp = (TextView) itemView.findViewById(R.id.tv_temp);
            tvSpeed = (TextView) itemView.findViewById(R.id.tv_speed);
        }
    }
}
