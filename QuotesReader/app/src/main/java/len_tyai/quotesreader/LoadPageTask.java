package len_tyai.quotesreader;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by demouser on 8/2/16.
 */
public class LoadPageTask extends AsyncTask<String, Void, String>{

    private final Command<String> onFinished;

    public LoadPageTask(Command<String> onFinished){
        this.onFinished = onFinished;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            return this.fetchWebSiteUsingHttpUrlConnection(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result){
        this.onFinished.execute(result);
    }

    private String fetchWebSiteUsingHttpUrlConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        String result = "";
        try{
            InputStream stream = connection.getInputStream();
            result = this.readStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
        return result;
    }

    private String readStream(InputStream stream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line = "";
        StringBuilder builder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
