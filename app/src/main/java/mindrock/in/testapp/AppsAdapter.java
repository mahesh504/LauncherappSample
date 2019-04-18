package mindrock.in.testapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    private Context mContext;
    private  List<Item> apps=new ArrayList<>();

    public AppsAdapter(Context mContext, List<Item> apps) {
        this.mContext = mContext;
        this.apps = apps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
      Item app= apps.get(i);
      viewHolder.txt_name.setText(app.name);
      viewHolder.imgLogo.setImageDrawable(app.icon);
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgLogo;
        TextView txt_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLogo = itemView.findViewById(R.id.icon);
            txt_name = itemView.findViewById(R.id.name);
        }
    }

}
