import java.net.UnknownHostException;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class QueryWithParamsDemo {

	// Xây dựng JSON:
	// { "dept_name" : "ACCOUNTING"}
	private static DBObject getWhereClause() {
		
		BasicDBObjectBuilder whereBuilder = BasicDBObjectBuilder.start();
		// Sử dụng method append (cũng giống với dùng add)
		whereBuilder.append("type", "student");
		
		//
		DBObject where = whereBuilder.get();
		System.out.println("Where: " + where.toString());
		return where;
		
	}
	
	
	public static void main(String[] args) throws UnknownHostException {
		// Kết nối tới MongoDB.
		MongoClient mongoClient = MongoUtils.getMongoClient();
		
		DB db = mongoClient.getDB(MyConstants.DB_NAME);
		
		DBCollection dept = db.getCollection("user");
		
		DBObject where = getWhereClause();
		
		// Truy vấn theo điều kiện.
		DBCursor cursor = dept.find(where);
		int i = 1;
		while ( cursor.hasNext() ) {
			System.out.println("Document: " + i);
	        System.out.println(cursor.next());
	        i++;
		}
		
		System.out.println("Done!");
	}

}
