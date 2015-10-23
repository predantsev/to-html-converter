package converter.handler;

/**
 * Created by Vyacheslav Predantsev on 22.10.2015
 */
public interface Handler<T> {

    String handle(T handledParam);
}
