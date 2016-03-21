package example.com.timesheet.skillscordinator.adapter;

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
import example.com.timesheet.skillscordinator.Company;

/**
 * Created by kgundula on 16/03/21.
 */
public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<Company> data = Collections.emptyList();

    public CompanyAdapter (Context context, List<Company> data ){

        inflater=  LayoutInflater.from(context);
        this.data = data;

    }

    List<Company> companyList;
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

        View view = inflater.inflate(R.layout.custom_row, parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CompanyAdapter.MyViewHolder holder, int position)
    {
        // Company company = companyList.get(position);
        Company current = data.get(position);
        holder.title.setText(current.companyName);
        holder.email.setText(current.email);
        holder.phone.setText(current.phone);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
