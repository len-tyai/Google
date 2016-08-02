package google.intentsforeverything;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final int MY_PERMISSIONS_REQUEST_WEB = 2;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 3;
    private Intent callIntent;
    private Intent webIntent;
    private Intent homeIntent;
    private Intent takePictureIntent;
    private int REQUEST_IMAGE_CAPTURE = 3;
    private ImageView mImageView;
    private Intent contactsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mImageView = (ImageView)findViewById(R.id.imageView);
    }

    public void call(View v) {
        callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+4917647325546"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            return;
        }
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent);
                } else {
                    Toast.makeText(MainActivity.this, "No permission to read contacts", Toast.LENGTH_SHORT);
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_WEB: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(webIntent);
                } else {
                    Toast.makeText(MainActivity.this, "No permission to open browser", Toast.LENGTH_SHORT);
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(takePictureIntent);
                } else {
                    Toast.makeText(MainActivity.this, "No permission to take picture", Toast.LENGTH_SHORT);
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void web(View v){
        webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.theuselessweb.com/"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_WEB);
            return;
        }
        startActivity(webIntent);
    }

    public void home(View v){
        Uri gmmIntentUri = Uri.parse("geo:42.4340814,25.6266774");
        homeIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        homeIntent.setPackage("com.google.android.apps.maps");
        startActivity(homeIntent);
    }

    public void camera(View v){
        takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
            return;
        }
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void contacts(View v){
        contactsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_WEB);
            return;
        }
        startActivity(contactsIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
}
