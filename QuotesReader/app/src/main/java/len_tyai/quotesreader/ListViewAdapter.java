package len_tyai.quotesreader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demouser on 8/2/16.
 */
public class ListViewAdapter extends BaseAdapter {


    private String text;
    private ArrayList<Quote> quotes = new ArrayList<>();

    @Override
    public int getCount() {
        return quotes.size();
    }

    @Override
    public Quote getItem(int i) {
        return quotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).hashCode();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        if(convertView != null){
           view = convertView;
        }else{
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.listview_item, null);
            QuoteViewHolder holder = new QuoteViewHolder();
            holder.setQuote((TextView)view.findViewById(R.id.quoteView));
            holder.setAuthor((TextView)view.findViewById(R.id.authorView));
            holder.setDate((TextView)view.findViewById(R.id.dateView));
            holder.setImage((ImageView) view.findViewById(R.id.imageView));
            view.setTag(holder);
        }
        QuoteViewHolder holder = (QuoteViewHolder)view.getTag();
        Quote quote = getItem(i);
        holder.getQuote().setText(quote.getQuote());
        holder.getAuthor().setText(quote.getAuthor());
        holder.getDate().setText(quote.getDate());
        Picasso.with(context).load(quote.getImage()).into(holder.getImage());
        return view;
    }

    public void setText(String text) {
        this.text = text;
        parse(text);
        notifyDataSetChanged();
    }

    private void parse(String text) {
        quotes = new ArrayList<>();
        try {
            JSONObject arrayObject = new JSONObject(text);
            String quotesString = arrayObject.getString("quotes");
            JSONArray array = new JSONArray(quotesString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonobject = array.getJSONObject(i);
                String quote = jsonobject.getString("quote");
                String author = jsonobject.getString("author");
                String date = jsonobject.getString("date");
                String pic = jsonobject.getString("pic");
                quotes.add(new Quote(quote, author, date, pic));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
