package com.ss.examplemvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ss.examplemvvm.R;
import com.ss.examplemvvm.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
   private List<NicePlace> mNicePlace = new ArrayList<>();
   private Context mContext;

    public RecyAdapter(List<NicePlace> mNicePlace, Context mContext) {
        this.mNicePlace = mNicePlace;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder_view,parent,false);
        return new RecyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NicePlace m = mNicePlace.get(position);
        holder.title_text.setText(m.getTitle());
        Glide.with(mContext).load(m.getImageUrl()).into(holder.img_00);
    }

    @Override
    public int getItemCount() {
        return mNicePlace.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_text;
        private ImageView img_00;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_text);
            img_00 = itemView.findViewById(R.id.img_00);

        }
    }
}
