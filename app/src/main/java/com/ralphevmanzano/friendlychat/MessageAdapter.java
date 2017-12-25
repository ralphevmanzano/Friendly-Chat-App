package com.ralphevmanzano.friendlychat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ralphemerson on 12/12/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private ArrayList<FriendlyMessage> friendlyMessages;
    private Context context;

    public MessageAdapter(ArrayList<FriendlyMessage> friendlyMessages) {
        this.friendlyMessages = friendlyMessages;
    }

    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_message, parent, false);

        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageViewHolder holder, int position) {
        FriendlyMessage message = friendlyMessages.get(position);

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            holder.tvMessage.setVisibility(View.GONE);
            holder.ivPhoto.setVisibility(View.VISIBLE);
            Glide.with(holder.ivPhoto.getContext()).load(message.getPhotoUrl()).into(holder.ivPhoto);
        } else {
            holder.tvMessage.setVisibility(View.VISIBLE);
            holder.ivPhoto.setVisibility(View.GONE);
            holder.tvMessage.setText(message.getText());
        }
        holder.tvAuthor.setText(message.getName());
    }

    @Override
    public int getItemCount() {
        return friendlyMessages.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMessage;
        private ImageView ivPhoto;
        private TextView tvAuthor;

        public MessageViewHolder(View itemView) {
            super(itemView);

            tvMessage = itemView.findViewById(R.id.tv_message);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
}
