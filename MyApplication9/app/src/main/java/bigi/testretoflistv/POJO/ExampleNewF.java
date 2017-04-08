
package bigi.testretoflistv.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import bigi.testretoflistv.AndroidVersion;

public class ExampleNewF {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<ResultNewF> results = null;
    @SerializedName("dates")
    @Expose
    private DatesNewF dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    public List<ResultNewF> getAndroid() {
        return results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultNewF> getResults() {
        return results;
    }

    public void setResults(List<ResultNewF> results) {
        this.results = results;
    }

    public DatesNewF getDates() {
        return dates;
    }

    public void setDates(DatesNewF dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}
