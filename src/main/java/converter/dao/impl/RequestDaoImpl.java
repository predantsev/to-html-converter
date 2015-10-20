package converter.dao.impl;

import converter.dao.api.RequestDao;
import converter.model.Request;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vyacheslav Predantsev on 20.10.2015
 */
@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private MongoCollection requests;

    @Override
    public void saveRequest(String handledBody) {
        Request request = new Request(handledBody);
        requests.save(request);
    }
}
