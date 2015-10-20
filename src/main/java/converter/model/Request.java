package converter.model;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

/**
 * Created by Vyacheslav Predantsev on 19.10.2015
 */
public class Request {

    @Id
    @ObjectId
    private String key;

    private String body;

    public Request() {
    }

    public Request(String body) {
        this.body = body;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
