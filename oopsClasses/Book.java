package oopsClasses;/*
* Create a `Book` class with:

- Fields: title, author, ISBN, price, available (boolean)
- Constructor with validation (no null/empty values, price > 0)
- Getters and setters with proper validation
- Method: `applyDiscount(double percentage)` - reduces price
- Method: `toString()` - returns formatted book info
*
* */


public class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private boolean available;

    public Book(String title, String author, String ISBN, double price, boolean available){
        //validations
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("title cannot be null or empty");
        }

        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("author cannot be null or empty");
        }

        if(ISBN == null || ISBN.isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }

        if(price <= 0) {
            throw new IllegalArgumentException(("Price cannot be 0"));
        }

        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("author cannot be null or empty");
        }
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if(ISBN == null || ISBN.isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException(("Price cannot be 0"));
        }
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double applyDiscount(double percentage){
        if(percentage < 0 || percentage > 100){
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }

        price = price - (price * (percentage / 100));
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}