package wellijohn.org.multilevelrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wellijohn.org.multilevelrecyclerview.viewholder.DiscountFirstVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountSecondVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountThirdVH;
import wellijohn.org.treerecyclerview.adapter.BaseTreeRVAdapter;
import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * @author: WelliJohn
 * @time: 2018/8/17-16:42
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DemoRVAdapter extends BaseTreeRVAdapter<TreeItem> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_first, parent, false);
                vh = new DiscountFirstVH(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_second, parent, false);
                vh = new DiscountSecondVH(view);
                break;
            case 2:
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_third, parent, false);
                vh = new DiscountThirdVH(view);
                break;
        }
        return vh;
    }


    @Override
    public void onBindViewHolder(int type, final TreeItem itemCategoryListBean, RecyclerView.ViewHolder holder) {
        switch (type) {
            case 0:
                DiscountFirstVH FHolder = (DiscountFirstVH) holder;
                FHolder.tvName.setText("第一级数据");
                FHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemCategoryListBean.setOpen(!itemCategoryListBean.isExpand());
                        notifyDataSetChanged();
                    }
                });
                FHolder.iv.setImageResource(itemCategoryListBean.isExpand() ? R.drawable.down_arrow :
                        R.drawable.ic_arrow_right);
                break;
            case 1:
                DiscountSecondVH SHolder = (DiscountSecondVH) holder;
                SHolder.tvName.setText("第二级数据");
                SHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemCategoryListBean.setOpen(!itemCategoryListBean.isExpand());
                        notifyDataSetChanged();
                    }
                });
                SHolder.iv.setImageResource(itemCategoryListBean.isExpand() ? R.drawable.down_arrow :
                        R.drawable.ic_arrow_right);
                break;
            case 2:
                DiscountThirdVH THolder = (DiscountThirdVH) holder;
                THolder.tvName.setText("第三级数据");
                break;
        }
    }

}
