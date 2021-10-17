package lesson07;


public class Book {
    private final String ISBN;
    private final String title;
    private final String authorName;

    private Book(Builder builder){
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.authorName = builder.authorName;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    //Inner class
    public static class Builder{
        private String ISBN;
        private String title;
        private String authorName;
        Builder(){}

        public Builder ISBN(String ISBN){
            this.ISBN = ISBN;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder authorName(String authorName){
            this.authorName = authorName;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }




}
