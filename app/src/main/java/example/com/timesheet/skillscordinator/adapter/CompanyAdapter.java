package example.com.timesheet.skillscordinator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import example.com.timesheet.R;
import example.com.timesheet.skillscordinator.Company;

/**
 * Created by kgundula on 16/03/21.
 */
public class CompanyAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public CompanyAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler
    {
        ImageView Poster;
        TextView title;
        TextView rating;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return  this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return  this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;

        if(convertView == null)

        {

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, null);
            handler = new DataHandler();
            handler.Poster = (ImageView) row.findViewById(R.id.company_poster);
            handler.title = (TextView) row.findViewById(R.id.company_title);
            handler.rating = (TextView) row.findViewById(R.id.company_rating);
            row.setTag(handler);
        }
        else{
            handler = (DataHandler)row.getTag();

        }
        CompanyDataProvider dataProvider;
        dataProvider = (CompanyDataProvider) this.getItem(position);
        handler.Poster.setImageResource(dataProvider.getCompany_poster_resource());
        handler.title.setText(dataProvider.getCompany_title());
        handler.rating.setText(dataProvider.getCompany_rating());


        return row;
    }


}
