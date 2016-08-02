package google.listviewexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ClickedFragment extends Fragment{

    TextView textView;

    public ClickedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clicked, null);
        this.textView = (TextView)view.findViewById(R.id.textView);
        return view;
    }

    public void showItem(String item) {
        this.textView.setText(item);
        this.textView.invalidate();
    }
}
