package len_tyai.quotesreader;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by demouser on 8/3/16.
 */
public class QuoteViewHolder {
    private TextView quote;

    private TextView author;

    private TextView date;

    private ImageView image;

    public TextView getQuote() {
        return quote;
    }

    public void setQuote(TextView quote) {
        this.quote = quote;
    }

    public TextView getAuthor() {
        return author;
    }

    public void setAuthor(TextView author) {
        this.author = author;
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

}
