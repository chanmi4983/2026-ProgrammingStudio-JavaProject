public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String status;
    private int rating;

    public Book(int id, String title, String author, String publisher, String category, String status, int rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.status = status;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public int getRating() { return rating; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setCategory(String category) { this.category = category; }
    public void setStatus(String status) { this.status = status; }
    public void setRating(int rating) { this.rating = rating; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + category + " | " + status + " | " + rating;
    }
}