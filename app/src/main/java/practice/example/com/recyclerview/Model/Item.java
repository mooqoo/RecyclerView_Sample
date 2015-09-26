package practice.example.com.recyclerview.Model;

import android.graphics.Color;

/**
 * Created by mooqoo on 9/26/15.
 */
public class Item {

    private String title;
    private int backgroundColor;

    //Constructor
    public Item() {
        title = "Default";
        backgroundColor = Color.WHITE;
        //backgroundColor = Color.parseColor("#00FF00");      //"#000000"(black) ~ "#FFFFFF"(white)
    }

    //Constructor
    public Item(String title, int backgroundColor) {
        this.title = title;
        this.backgroundColor = backgroundColor;
    }


    public String toString() {
        return title;
    }

    //Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
