package book;

public class Book {
    private int resourceId;
    private String time, temp, speed;

    public Book(int resourceId, String time, String temp, String speed) {
        this.resourceId = resourceId;
        this.time = time;
        this.temp = temp;
        this.speed = speed;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
