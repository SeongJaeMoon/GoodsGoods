package goods.cap.app.goodsgoods.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import java.util.List;

import goods.cap.app.goodsgoods.Activity.DetailItemActivity;
import goods.cap.app.goodsgoods.Activity.DetailTherapyActivity;
import goods.cap.app.goodsgoods.Model.Diet.Diet;
import goods.cap.app.goodsgoods.Model.Recent;
import goods.cap.app.goodsgoods.Model.Therapy.Therapy;
import goods.cap.app.goodsgoods.R;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder>{
    private Context context;
    private List<Recent> data;

    public RecentAdapter(Context context, List<Recent> data){
        super();
        this.context = context;
        this.data = data;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView recentImg;
        private TextView recentText;
        public ViewHolder(View itemView) {
            super(itemView);
            recentImg = (ImageView) itemView.findViewById(R.id.recentImg);
            recentText = (TextView) itemView.findViewById(R.id.recentText);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recent, parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        //data.get(position).getFlag(0 or 1 구분 필요)
        if (data != null) {
            Glide.with(context)
                    .load(data.get(position).getImgUrl())
                    .into(holder.recentImg);
            holder.recentText.setText(data.get(position).getSummary());
            holder.recentImg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Recent temp = data.get(holder.getAdapterPosition());
                            int flag = temp.getFlag();
                            Gson gson = new Gson();
                            String recent = "";
                            //Diet
                            if(flag == 0){
                                Diet diet = new Diet(temp.getCtnno(), temp.getImgUrl(), temp.getSummary(), temp.getCntnt());
                                Intent intent = new Intent(context, DetailItemActivity.class);
                                recent = gson.toJson(diet);
                                intent.putExtra("diet", recent);
                                context.startActivity(intent);
                            //Therapy
                            }else{
                                Therapy therapy = new Therapy(temp.getCtnno(), temp.getImgUrl(), temp.getSummary(), temp.getCntnt());
                                Intent intent = new Intent(context, DetailTherapyActivity.class);
                                recent = gson.toJson(therapy);
                                intent.putExtra("therapy", recent);
                                context.startActivity(intent);
                            }
                        }
                    });
                }else {
                    Glide.with(context)
                            .load(R.drawable.none)
                            .into(holder.recentImg);
                }
        }
        @Override
        public int getItemCount() {
            if (data == null) return 1;
            return data.size();
        }

    }

