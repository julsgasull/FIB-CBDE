import com.mongodb.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDB {

    public static void main(String[] args) {


        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB database = mongoClient.getDB("Prueba");
        DBCollection collection = database.getCollection("Luis");

        collection.insert(toDBObject());

        DBObject query = new BasicDBObject("_id", "1234");
        DBCursor cursor = collection.find(query);
        DBObject jo = cursor.one();
        String a = (String) cursor.one().get("name");

    }

    public static final DBObject toDBObject() {

        return new BasicDBObject("_id", "1234")
                .append("name", "Luis")
                .append("address", new BasicDBObject("street","psj a" )
                        .append("city", "BCN")
                        .append("phone", "699558855"))
                .append("books", "blaaaaaa");
    }

}
