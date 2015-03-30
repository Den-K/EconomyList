package economylist.valueobject;

import java.util.Date;

public class Purchase {

    private int id;
    private String name;
    private Date date;
    private int number;
    private float cost;

    public Purchase(){}

    public Purchase(int id, String name, Date date, int number, float cost) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.number = number;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
