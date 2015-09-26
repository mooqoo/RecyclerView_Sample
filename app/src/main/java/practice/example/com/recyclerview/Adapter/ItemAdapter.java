package practice.example.com.recyclerview.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import practice.example.com.recyclerview.Model.Item;
import practice.example.com.recyclerview.R;

/**
 * Created by mooqoo on 9/26/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    public List<Item> items;

    //Constructor
    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v, items);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.tv_title.setText(items.get(position).getTitle());
        holder.ll_item_container.setBackgroundColor(items.get(position).getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //ViewHolder Class
    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        List<Item> items;

        @Bind(R.id.tv_title) TextView tv_title;
        @Bind(R.id.ll_item_container) LinearLayout ll_item_container;

        //Constructor
        public ItemViewHolder(View view, List<Item> items) {
            super(view);
            ButterKnife.bind(this, view);
            this.items = items;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Click: item " + items.get(getPosition()).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}