package touchmenot.com.touchmenot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouchRecyclerAdapter extends RecyclerView.Adapter<TouchRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<TouchBean> touchBeanList;
    TouchInterface touchInterface;

    public TouchRecyclerAdapter(Context context, List<TouchBean> touchBeanList, TouchInterface touchInterface) {
        this.context = context;
        this.touchBeanList = touchBeanList;
        this.touchInterface = touchInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        TouchBean touchBean = touchBeanList.get(holder.getAdapterPosition());

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;


       // final int no = touchBean.getBeanNo();
        holder.tvItem.setText(""+touchBean.getBeanNo());

        holder.llItemRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchInterface.onItemTouch(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return touchBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llItemRecycler)
        LinearLayout llItemRecycler;

        @BindView(R.id.tvItem)
        TextView tvItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
