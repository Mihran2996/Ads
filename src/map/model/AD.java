package map.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AD implements Comparable<AD> {
    private String title;
    private String text;
    private int price;
    private Date date;
    private String category;
    private User outher;
    private SimpleDateFormat sdf = new SimpleDateFormat("d-m-y h:m:s");


    public AD(String title, String text, int price, Date date, String category, User outher) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.date = date;
        this.outher = outher;
        this.category = category;
    }

    public AD() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getOuther() {
        return outher;
    }

    public void setOuther(User outher) {
        this.outher = outher;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AD ad = (AD) o;
        return price == ad.price &&
                Objects.equals(title, ad.title) &&
                Objects.equals(text, ad.text) &&
                Objects.equals(date, ad.date) &&
                Objects.equals(category, ad.category) &&
                Objects.equals(outher, ad.outher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, price, date, category, outher);
    }

    @Override
    public String toString() {
        String result = "title:" + title;
        result += "\ntext:" + text;
        result += "\nprice:" + price;
        result += "\ncategory:" + category;
        result += "\nother:" + outher;
        result += "\ndate:" + sdf.format(date) + "\n";
        return result + "\n";
    }


    @Override
    public int compareTo(AD ad) {
        return this.getTitle().compareTo(ad.getTitle());
    }
}
