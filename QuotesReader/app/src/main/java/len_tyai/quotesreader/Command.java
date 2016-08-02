package len_tyai.quotesreader;

/**
 * Created by demouser on 8/2/16.
 */
public interface Command<T> {

    void execute(T result);
}
