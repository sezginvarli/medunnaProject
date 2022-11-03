package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CTestItem {
    /*
    createdBy	string
    createdDate	string($date-time)
    defaultValMax	string
    defaultValMin	string
    description	string
    id	integer($int64)
    name	string
    price*	number
        minimum: 0
        exclusiveMinimum: false
     */
    private String createdBy;
    private String createdDate;
    private String defaultValMax;
    private String defaultValMin;
    private String description;
    //private int id;
    private String name;
    private double price;//required

    public CTestItem(String createdBy, String createdDate, String defaultValMax, String defaultValMin, String description, int id, String name, double price) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.defaultValMax = defaultValMax;
        this.defaultValMin = defaultValMin;
        this.description = description;
        //this.id = id;
        this.name = name;
        this.price = price;
    }

    public CTestItem() {
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

    public String getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public String getDefaultValMin() {
        return defaultValMin;
    }

    public void setDefaultValMin(String defaultValMin) {
        this.defaultValMin = defaultValMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CTestItem{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                ", defaultValMin='" + defaultValMin + '\'' +
                ", description='" + description + '\'' +
              //  ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
