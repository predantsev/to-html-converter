package converter.configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * Created by Vyacheslav Predantsev on 23.10.2015
 */
@Configuration
public class MongoDbConfiguration {

    @Autowired
    private MongoProperties mongoProperties;

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
