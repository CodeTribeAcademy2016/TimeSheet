package example.com.timesheet.skillscordinator.adapter;

/**
 * Created by User on 5/17/2016.
 */
public class CompanyDataProvider {

    private int company_poster_resource;
    private String company_title;
    private String company_rating;

    public String getCompany_rating() {
        return company_rating;
    }

    public CompanyDataProvider(int company_poster_resource,String company_title,String company_rating)
    {
        this.setCompany_poster_resource(company_poster_resource);
        this.setCompany_title(company_title);
        this.setCompany_rating(company_rating);
    }
    public void setCompany_rating(String company_rating) {
        this.company_rating = company_rating;
    }

    public int getCompany_poster_resource() {
        return company_poster_resource;
    }

    public void setCompany_poster_resource(int company_poster_resource) {
        this.company_poster_resource = company_poster_resource;
    }

    public String getCompany_title() {
        return company_title;
    }

    public void setCompany_title(String company_title) {
        this.company_title = company_title;
    }
}
