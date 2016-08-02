package len_tyai.quotesreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    String url = "https://firebasestorage.googleapis.com/v0/b/bootcamp-5be0c.appspot.com/o/101Quotes.json?alt=media&token=b428d722-5cca-4400-a25a-c75502c79063";
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadPageTask task = new LoadPageTask(new Command<String>() {
            @Override
            public void execute(String result) {
                MainActivity.this.listViewAdapter.setText(result);
            }
        });
        task.execute(url);
    }
}
