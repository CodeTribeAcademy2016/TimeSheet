package example.com.timesheet.skillscordinator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import example.com.timesheet.R;
import example.com.timesheet.skillscordinator.adapter.CompanyAdapter;
import example.com.timesheet.skillscordinator.adapter.CompanyDataProvider;

public class CompanyList extends AppCompatActivity {

    ListView listView;
    int[] company_poster_resources = {R.drawable.telkom,R.drawable.innovation,R.drawable.mlab};
    String[] company_title;
    String[] company_rating;
    CompanyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        listView = (ListView)findViewById(R.id.company_list);
        company_title = getResources().getStringArray(R.array.company_title);
        company_rating = getResources().getStringArray(R.array.company_rating);

        int i = 0;
        adapter = new CompanyAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        for(String title: company_title)
        {

            CompanyDataProvider dataProvider = new CompanyDataProvider(company_poster_resources[i],
                    title, company_rating[i]);

            adapter.add(dataProvider);

            i++;



        }
    }
}
