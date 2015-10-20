package converter;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;

@SpringBootApplication
public class ToHtmlConverterApplication {

    @Autowired
    private MongoProperties mongoProperties;

    public static void main(String[] args) {
        SpringApplication.run(ToHtmlConverterApplication.class, args);
    }

    @Bean
    public Jongo jongo() {
        DB db;
        try {
            db = new MongoClient(mongoProperties.getHost(), mongoProperties.getPort()).getDB(mongoProperties.getDatabase());
        } catch (UnknownHostException e) {
            throw new MongoException("DB connection error occurred: ", e);
        }
        return new Jongo(db);
    }

    @Bean
    public MongoCollection requests() {
        return jongo().getCollection("requests");
    }
}
