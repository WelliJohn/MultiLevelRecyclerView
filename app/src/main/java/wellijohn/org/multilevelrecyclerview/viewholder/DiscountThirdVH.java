package wellijohn.org.multilevelrecyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import wellijohn.org.multilevelrecyclerview.R;


/**
 * @author: WelliJohn
 * @time: 2018/8/7-10:04
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DiscountThirdVH extends RecyclerView.ViewHolder {
    public TextView tvName;
    public TextView tvZhe;
    public TextView tvNum;

    public DiscountThirdVH(View view) {
        super(view);
        initView();
    }

    private void initView() {
        tvName = itemView.findViewById(R.id.tv_name);
        tvZhe = itemView.findViewById(R.id.tv_zhe);
        tvNum = itemView.findViewById(R.id.tv_num);
    }
}
