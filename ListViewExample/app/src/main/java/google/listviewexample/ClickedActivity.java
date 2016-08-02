package google.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClickedActivity extends AppCompatActivity {

    public static final String CLICKED = "CLICKED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);
        TextView textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        String countryName = (String) intent.getExtras().get(CLICKED);
        textView.setText(countryName);
    }

}
