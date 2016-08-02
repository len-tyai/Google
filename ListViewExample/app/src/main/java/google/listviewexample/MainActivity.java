package google.listviewexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements NotifyItemClicked{

    private ListViewFragment listFragment;
    private ClickedFragment clickedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.listFragment = (ListViewFragment)(getSupportFragmentManager().findFragmentById(R.id.listFragment));
        this.clickedFragment = (ClickedFragment)getSupportFragmentManager().findFragmentById(R.id.clickedFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int color = 0;
        switch (menuItem.getItemId()){
            case R.id.blue:
                color = getResources().getColor(R.color.blue);
                break;
            case R.id.red:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.green:
                color = getResources().getColor(R.color.green);
                break;
            default:
                onOptionsItemSelected(menuItem);
                break;
        }
//        this.adapter.setColor(color);
//        this.listview.invalidateViews();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d("MAIN ACTIVITY", "On create options menu");
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.change_colours, menu);
        return true;
    }

    @Override
    public void itemClicked(String item) {
        this.clickedFragment.showItem(item);
    }
}
