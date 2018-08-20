先上效果图：
![](https://user-gold-cdn.xitu.io/2018/8/20/165560462c7326fe?w=282&h=500&f=gif&s=549336)
## 1.该多级列表的优势：
1. 支持无限级列表展开
2. 基于一个recyclerView实现
3. 可以自定义每一级item的样式，定制化更强

## 2.设计的思路
1. 数据结构List<ItemBean>,ItemBean类中有变量List<ItemBean>,构造整体RecyclerView的数据源
2. 因为RecyclerView.Adapter本来就支持多个type的item布局，不清楚的可以看下getItemViewType这个方法，所以我们可以利用这个类，来区分不同级用不同的Item。
3. 将Item必须具备的方法放在一个Tree接口里面，以后自定义的类只需要继承Tree接口就好了。

## 3.代码分析
```
public abstract class BaseTreeRVAdapter<T extends RecyclerView.ViewHolder, M extends Tree> extends BaseRVAdapterV2<T, M> {

    @Override
    public void onBindViewHolder(T holder, final int position) {
        try {
            getLevel(position, mDatas, new PosBean());
        } catch (StopMsgException ex) {
            int type = Integer.parseInt(ex.getMessage());
            M tree = ex.getTree();
            onBindViewHolder(type, tree, holder);
        }
    }


    @Override
    public int getItemViewType(int position) {
        try {
            getLevel(position, mDatas, new PosBean());
        } catch (StopMsgException ex) {
            return Integer.parseInt(ex.getMessage());
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return getTotal(mDatas);
    }

    protected abstract void onBindViewHolder(int type, M tree, T holder);

    public List<M> getDatas() {
        return mDatas;
    }

    public void setDatas(List<M> info) {
        if (info != null) {
            mDatas = info;
        } else {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }
}

```
注释1：主要是计算当前给的数据他的item个数，会根据是否展开的状态来统总个数
注释2：计算当前的postion对应的item层级，来显示对应的item布局
## 4.对于自己需要实现的地方
```
public class TreeListAdapter extends BaseTreeRVAdapter<RecyclerView.ViewHolder, T extends Tree> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 0:
                ......    
                break;
            case 1:
                ......
                break;
            case 2:
                ......
                break;
            case 3:
            case 4:
            ......
        }
        return vh;
    }


    @Override
    protected void onBindViewHolder(int type, final DiscountItem itemCategoryListBean, RecyclerView.ViewHolder holder) {
        switch (type) {
            case 0:
                ......
                break;
            case 1:
                ......
                break;
            case 2:
                ......
                break;
            case 3:
            case 4:
            ......
        }
    }
}
```
1. 上面的泛型T就是我们的Item的class类型，所以自定义的class要想用这个adapter的话，都需要实现Tree接口
2. onBindViewHolder方法中形参的的type就是层级，比如说第一级type就是0，第二级是1，以此类推

## 5.另外自定义的类如果不需要extends的话，那么需要继承wellijohn.org.treerecyclerview.vo.TreeItem，如果已经写了的话，那么就需要自己实现Tree接口。
必须实现的几个方法：
```
    int getLevel();//每个item的层级，比如一级就是0，二级就返回1，这里的0和1可以自己定义，后面就是根据这个来选择哪种样式的item

    List<T> getChilds();//返回的子列表，比如当前类是一级的话，那么这个方法返回的是二级的列表数据

    boolean isExpand();//是否展开，true展开，false不展开，一般就是点击下去修改这个值刷新adapter，就能达到展开还是折叠的目的了
```

## 6.引入方式
```
step 1.
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.WelliJohn:MultiLevelRecyclerView:0.0.1'
	}
```

## 7.demo示例
[多级列表示例](https://github.com/WelliJohn/MultiLevelRecyclerView),如果觉得有用，还请点个赞。