package example.com.timesheet.supervisor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import example.com.timesheet.R;
import example.com.timesheet.supervisor.Employee;

/**
 * Created by kgundula on 16/03/21.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>  {

    private LayoutInflater inflater;
    List<Employee> data = Collections.emptyList();

    public EmployeeAdapter (Context context, List<Employee> data ){

        inflater=  LayoutInflater.from(context);
        this.data = data;

    }

    List<Employee> employee_list;
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView icon;
        TextView email;
        TextView phone;


        public MyViewHolder(View itemView)
        {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.listText);
            icon =(ImageView) itemView.findViewById(R.id.listIcon);
            email = (TextView)itemView.findViewById(R.id.email);
            phone = (TextView) itemView.findViewById(R.id.phone);



        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.activity_custom__row, parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(EmployeeAdapter.MyViewHolder holder, int position)
    {

        Employee current = data.get(position);
        holder.title.setText(current.EmployeeName);
        holder.email.setText(current.email);
        holder.icon.setImageResource(current.iconid);
        holder.phone.setText(current.phone);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
