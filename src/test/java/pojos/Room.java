package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
    /*
    {
        "createdBy": "string",
        "createdDate": "2022-10-16T10:10:24.428Z",
        "description": "string",
        "id": 0,
        "price": 0,
        "roomNumber": 0,
        "roomType": "TWIN",
        "status": true
      }
     */

    private String createdBy;
    private String createdDate;
    private String description;
    private int id;
    private double price;//required
    private int roomNumber;//required
    private String roomType;//required enum: [ TWIN, DELUXE, PREMIUM_DELUXE, SUITE, DAYCARE ]
    private boolean status;//required

    public Room(String createdBy, String createdDate, String description, int id, double price, int roomNumber, String roomType, boolean status) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.description = description;
        this.id = id;
        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }

    public Room() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                '}';
    }
}
