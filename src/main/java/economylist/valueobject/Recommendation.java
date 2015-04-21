package economylist.valueobject;

import java.util.Date;

/**
 * Created by Den on 11.03.2015.
 */
public class Recommendation {
    private int id;
    private String text;

    public Recommendation(){}

    public Recommendation(int id, String text) {
        this.id = id;
        this.text = text;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
