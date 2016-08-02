package google.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText = (EditText)findViewById(R.id.input);
    }

    public void onRadioButtonClicked(View view){
        String inputString = this.editText.getText().toString();
        if(inputString.equals("")){
            Toast.makeText(this, "Input is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        double input = Double.parseDouble(inputString);
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()) {
            case R.id.radio_cToF:
                if(checked) {
                    result = celsiusToFahrenheit(input);
                }
                break;
            case R.id.radio_fToC:
                if (checked) {
                    result = fahrenheitToCelsius(input);
                }
                break;
        }
    }

    public void onButtonClicked(View view){
        Toast.makeText(this, "The temperature is " + result + "", Toast.LENGTH_SHORT).show();
    }

    public double celsiusToFahrenheit(double celsius){
        Log.d("C to F", result + "");
        return prettyDouble(celsius * 1.8 + 32);
    }

    public double fahrenheitToCelsius(double fahrenheit){
        Log.d("F to C", result + "");
        return prettyDouble((fahrenheit - 32) / 1.8);
    }

    public double prettyDouble(double d){
        return ((int)(d * 100) / 100d);
    }
}
