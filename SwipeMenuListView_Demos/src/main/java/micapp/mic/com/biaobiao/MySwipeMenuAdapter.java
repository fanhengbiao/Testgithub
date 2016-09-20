package micapp.mic.com.biaobiao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by ${xcc} on 2016/5/19 0019.
 * note:
 */
public class MySwipeMenuAdapter extends BaseAdapter {


    private String TAG = "MySwipeMenuAdapter";
    //    private List<GetTeacherClasses.DataBean> data;
    private Context context;
    Map<Integer, Boolean> map;
    public MySwipeMenuAdapter(Context context, Map<Integer, Boolean> map) {
        this.context = context;
        this.map = map;
    }

//    publicMap<Integer, Boolean> void refrush(List<GetTeacherClasses.DataBean> data) {
//        this.data = data;
//        this.notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
//        MsgUtil.d(TAG,"size="+data.size());
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

//
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            new ViewHolder(convertView);
//            AutoUtils.autoSize(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
//        GetTeacherClasses.DataBean dataBean = data.get(i);
//        int grade = dataBean.getGrade();
//        int classNo = dataBean.getClassNo();
//        String subjectName = dataBean.getSubjectName();
//        int level = dataBean.getLevel();
        holder.tvClass.setText(i+"");
//        holder.tvTeacher.setText(subjectName + "/" + Tool.getTeacherTypeByLeven(level));
        return convertView;
    }

    class ViewHolder {
        TextView tvClass;

        public ViewHolder(View view) {
            tvClass = (TextView) view.findViewById(R.id.textView);
            view.setTag(this);
        }
    }

//    @Override
    public boolean getSwipEnableByPosition(int position) {

        return map.get(position);
    }
}
