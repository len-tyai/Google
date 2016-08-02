package google.listviewexample;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by demouser on 8/1/16.
 */

public class ListViewAdapter extends BaseAdapter {

    int color = Color.BLACK;

    private String[] countries = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola","Argentina"
            ,"Armenia","Austria","Bahamas","Bahrain", "Bangladesh","Barbados", "Belarus","Belgium",
            "Benin","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","Bulgaria",
            "Burkina Faso","Burma","Burundi","Cambodia","Cameroon","Canada", "China","Colombia",
            "Comoros","Congo","Croatia","Cuba","Cyprus","Czech Republic","Denmark", "Georgia",
            "Germany","Ghana","Great Britain","Greece","Hungary","Holland","India","Iran","Iraq",
            "Italy","Somalia", "Spain", "Sri Lanka", "Sudan","Suriname", "Swaziland","Sweden",
            "Switzerland", "Syria","Uganda","Ukraine","United Arab Emirates","United Kingdom",
            "United States","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam",
            "Yemen","Zaire","Zambia","Zimbabwe"};

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public String getItem(int i) {
        return countries[i];
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).hashCode();
    }

    public void setColor(int color){
        this.color = color;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setText(this.getItem(i));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setTextColor(color);
        return textView;
    }
}
