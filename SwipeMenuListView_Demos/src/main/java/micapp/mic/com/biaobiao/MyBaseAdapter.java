package micapp.mic.com.biaobiao;

import android.widget.BaseAdapter;

import java.util.Map;

/**
 * Created by ${xcc} on 2016/5/18 0018.
 * note:
 */
public abstract class MyBaseAdapter extends BaseAdapter {
    protected Map<Integer,Boolean> map ;
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public boolean getSwipEnableByPosition(int position) {
        return true;
    }
}
