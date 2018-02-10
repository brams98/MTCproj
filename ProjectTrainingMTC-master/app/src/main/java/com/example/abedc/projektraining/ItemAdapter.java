package com.example.abedc.projektraining;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abedc on 05/12/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<AppModel> appModels = new ArrayList<>();

    Context context;

    public ItemAdapter(List<AppModel> listModel, Context context) {
        appModels = listModel;
        this.context = context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.listview, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.bind(appModels.get(position));
    }

    @Override
    public int getItemCount() {
        return appModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvDesc;
        private Button btnPlayStore;

        public ViewHolder(View itemView) {
            super(itemView);
            btnPlayStore = (Button) itemView.findViewById(R.id.btnPlayStore_ListView);
            tvName = (TextView) itemView.findViewById(R.id.tvNameApplication_ListView);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDeskripsiSingkat_ListView);

        }

        public void bind(final AppModel appModel) {
            tvName.setText(appModel.name);
            tvDesc.setText(appModel.desc);
            btnPlayStore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(appModel.link))); // itu nanti kasih linknya
                }
            });
        }
    }
}
