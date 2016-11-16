package by.vasilevich.navigation.bean;

/**
 * Created by sam on 12.11.2016.
 */
public class NewsBean {
    private int newsID;
    private String title;
    private String shortText;

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }
}
