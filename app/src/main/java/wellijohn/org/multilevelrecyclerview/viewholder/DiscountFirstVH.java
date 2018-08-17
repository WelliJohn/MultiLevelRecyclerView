package wellijohn.org.multilevelrecyclerview.viewholder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import wellijohn.org.multilevelrecyclerview.R;


/**
 * @author: WelliJohn
 * @time: 2018/8/7-10:03
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DiscountFirstVH extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvDes;
    public ImageView iv;
    public ConstraintLayout cl;
    public View viewLine;
    public TextView tvZhe;

    public DiscountFirstVH(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        tvName = itemView.findViewById(R.id.tv_name);
        tvZhe = itemView.findViewById(R.id.tv_zhe);
        tvDes = itemView.findViewById(R.id.tv_des);
        iv = itemView.findViewById(R.id.iv);
        cl = itemView.findViewById(R.id.cl);
        viewLine = itemView.findViewById(R.id.view_sp);
    }
}
