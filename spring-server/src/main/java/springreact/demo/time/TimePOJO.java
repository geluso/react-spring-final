package springreact.demo.time;

import jakarta.persistence.Entity;

public class TimePOJO {
    public int hour;
    public int minute;
    public int dayOfWeek;
    public int month;

    public String toString() {
        return "{hour: " + hour + ", minute: " + minute + ", dayOfWeek: " + dayOfWeek + ", month: " + month + "}";
    }
}
