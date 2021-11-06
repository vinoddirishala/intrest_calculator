package com.vd.intrestcalculator.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vd.intrestcalculator.R;
import com.vd.intrestcalculator.utils.ICEntity;
import java.util.List;

/**
 * Created by Vinod Dirishala on 06-11-2021 22:03
 **/
public class ICListAdapter extends RecyclerView.Adapter<ICListAdapter.ViewHolder> {

    private Context mContext;
    private List<ICEntity> listOfIItems;

    public ICListAdapter(Context mContext, List<ICEntity> listOfIItems) {
        this.mContext = mContext;
        this.listOfIItems = listOfIItems;
        Log.d("hai","hello"+listOfIItems.size());
    }

    @NonNull
    @Override
    public ICListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View parentView= LayoutInflater.from(mContext).inflate(R.layout.interest_items_adapter,parent,false);
        return new ViewHolder(parentView);
    }

    @Override
    public void onBindViewHolder(@NonNull ICListAdapter.ViewHolder holder, int position) {
        Log.d("hey","hello"+position);
        ICEntity icEntity  = listOfIItems.get(position);
        holder.textViewIC.setText(icEntity.getName());
    }

    @Override
    public int getItemCount() {
        return listOfIItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewIC;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIC = (TextView) itemView.findViewById(R.id.textViewIC);

        }
    }
}
