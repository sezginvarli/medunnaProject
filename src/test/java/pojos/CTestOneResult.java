package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CTestOneResult {
    /*
    [
  {
    "date": "2022-10-30T08:06:04.377Z",
    "description": "string",
    "id": 0,
    "maxValue": "string",
    "minValue": "string",
    "name": "string",
    "price": 0,
    "result": "string",
    "testId": 0
  }
]
     */
    private String date;
    private String description;
    private Integer id;
    private String maxValue;
    private String minValue;
    private String name;
    private Integer price;
    private String result;
    private Integer testId;

    public CTestOneResult(String date, String description, Integer id, String maxValue, String minValue, String name, Integer price, String result, Integer testId) {
        this.date = date;
        this.description = description;
        this.id = id;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.name = name;
        this.price = price;
        this.result = result;
        this.testId = testId;
    }

    public CTestOneResult() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "CTestOneResult{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", maxValue='" + maxValue + '\'' +
                ", minValue='" + minValue + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", result='" + result + '\'' +
                ", testId=" + testId +
                '}';
    }
}
