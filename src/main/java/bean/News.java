package bean;

import java.io.Serializable;

/**
 * Class that contain information about one news,have  setters and getters
 *
 * Created by Mark_Harbunou on 1/30/2017.
 */
public class News implements Serializable{
    private Category category;
    private String title;
    private String author;


    public News(Category category, String title, String author) {
        this.category = category;
        this.title = title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        if (category != news.category) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        return author != null ? author.equals(news.author) : news.author == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
