import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class SimpleQueryDemo {

	public static void main(String[] args) throws UnknownHostException {
		// Kết nối tới MongoDB.
		MongoClient mongoClient = MongoUtils.getMongoClient();
		
		DB db = mongoClient.getDB(MyConstants.DB_NAME);
		DBCollection dept = db.getCollection("user");
		
		// Truy vấn tất cả các object trong Collection.
		DBCursor cursor = dept.find();
		int i = 1;
		while ( cursor.hasNext() ) {
			System.out.println("Document: " + i);
			System.out.println(cursor.next());
			i++;
		}
	}

}
