package len_tyai.quotesreader;

import android.graphics.Bitmap;

/**
 * Created by demouser on 8/3/16.
 */
public class Quote {
    private String quote;

    private String author;

    private String date;

    private String image;

    public Quote(String quote, String author, String date, String pic) {
        this.quote = quote;
        this.author = author;
        this.date = date;
        this.image = pic;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(quote);
//        builder.append("\n");
//        builder.append(author);
//        builder.append("\n");
//        builder.append(date);
        return builder.toString();
    }
}
