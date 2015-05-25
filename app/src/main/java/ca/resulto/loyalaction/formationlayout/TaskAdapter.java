package ca.resulto.loyalaction.formationlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ttauveron on 25/05/15.
 */
public class TaskAdapter extends ArrayAdapter<Task> {
    private LayoutInflater inflater;
    public TaskAdapter(Context context, int resource, List<Task> objects) {
        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.row_task, parent, false);
            holder = new ViewHolder();
            holder.tvName = (TextView) view.findViewById(R.id.tv_task_name);
            holder.tvPriority = (TextView) view.findViewById(R.id.tv_task_priority);
            holder.tvEstimatedTime = (TextView) view.findViewById(R.id.tv_task_estimated_time);;
            holder.relativeLayoutRow = (RelativeLayout) view.findViewById(R.id.rl_task_row);;
            view.setTag(holder);
        }

        Task task = getItem(position);

        holder.tvName.setText(task.getName());

        String estimatedTime = getContext().getString(R.string.estimated_time,task.getEstimatedTime());
        holder.tvEstimatedTime.setText(estimatedTime);

        
        switch (task.getPriority()){
            case TRIVIAL:
                holder.tvPriority.setText(R.string.trivial);
                holder.relativeLayoutRow.setBackgroundResource(R.color.green);
                break;
            case MINOR:
                holder.tvPriority.setText(R.string.minor);
                holder.relativeLayoutRow.setBackgroundResource(R.color.yellow);
                break;
            case MODERATE:
                holder.tvPriority.setText(R.string.moderate);
                holder.relativeLayoutRow.setBackgroundResource(R.color.orange);
                break;
            case MAJOR:
                holder.tvPriority.setText(R.string.major);
                holder.relativeLayoutRow.setBackgroundResource(R.color.red);
                break;
        }

        return view;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvEstimatedTime;
        TextView tvPriority;
        RelativeLayout relativeLayoutRow;

    }
}
