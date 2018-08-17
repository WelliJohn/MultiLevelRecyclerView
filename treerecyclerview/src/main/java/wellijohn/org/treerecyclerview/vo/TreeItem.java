package wellijohn.org.treerecyclerview.vo;

/**
 * @author: WelliJohn
 * @time: 2018/8/13-15:49
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public abstract class TreeItem implements Tree {
    private boolean isOpen;

    public final boolean isOpen() {
        return isOpen;
    }

    public final void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public final boolean isExpand() {
        return isOpen;
    }
}
