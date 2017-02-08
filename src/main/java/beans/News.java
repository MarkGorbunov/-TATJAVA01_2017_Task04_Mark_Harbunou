package beans;

/**
 * Created by Mark_Harbunou on 1/30/2017.
 */
public class News {
    private Category category;
    private String title;
    private String author;


    public News(Category category, String genre, String author) {
        this.category = category;
        this.title = genre;
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
