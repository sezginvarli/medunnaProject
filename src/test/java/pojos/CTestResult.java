package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CTestResult {
    /*
        createdBy	string
        createdDate	string($date-time)
        ctest	CTest{...}Jump to definition
        ctestItem	CTestItem{...}Jump to definition
        date*	string($date-time)
        description	string
        id	integer($int64)
        result	string
     */
    private String createdBy;
    private String createdDate;
    private CTest ctest;
    private CTestItem ctestItem;
    private String date; //required
    private String description;
    private int id;
    private String result;

    public CTestResult(String createdBy, String createdDate, CTest ctest, CTestItem ctestItem, String date, String description, int id, String result) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctest = ctest;
        this.ctestItem = ctestItem;
        this.date = date;
        this.description = description;
        this.id = id;
        this.result = result;
    }

    public CTestResult() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public CTest getCtest() {
        return ctest;
    }

    public void setCtest(CTest ctest) {
        this.ctest = ctest;
    }

    public CTestItem getCtestItem() {
        return ctestItem;
    }

    public void setCtestItem(CTestItem ctestItem) {
        this.ctestItem = ctestItem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CTestResult{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctest=" + ctest +
                ", ctestItem=" + ctestItem +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", result='" + result + '\'' +
                '}';
    }
}
