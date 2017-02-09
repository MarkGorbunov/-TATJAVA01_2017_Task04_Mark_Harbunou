package beans;

/**
 * Class that contain information about one news,have  setters and getters
 *
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

    /**
     * @return category of one news
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set category
     *
     * @param category of one news
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return title of one news
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     *
     * @param title of one news
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return author of one news
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author
     *
     * @param author of one news
     */
    public void setAuthor(String author) {
        this.author = author;
    }


}
