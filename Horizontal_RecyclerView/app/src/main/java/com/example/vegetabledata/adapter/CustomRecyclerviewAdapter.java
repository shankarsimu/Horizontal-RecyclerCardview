package com.example.vegetabledata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vegetabledata.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomRecyclerviewAdapter extends RecyclerView.Adapter<CustomRecyclerviewAdapter.ViewHolder> {

    private ArrayList<HashMap<String, String>> vegetableList = new ArrayList<>();
    private Context mContext;

    public CustomRecyclerviewAdapter(Context context, ArrayList<HashMap<String, String>> names) {
        vegetableList = names;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HashMap<String, String> map = vegetableList.get(position);
        holder.name.setText(map.get("name"));
        holder.image.setImageResource(Integer.parseInt(map.get("image")));
    }

    @Override
    public int getItemCount() {
        return vegetableList.size();
    }

    public List<HashMap<String, String>> getList() {
        return this.vegetableList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name_widget);
            this.image = itemView.findViewById(R.id.imageview_widget);
        }
    }

}