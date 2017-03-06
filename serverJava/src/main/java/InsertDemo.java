import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class InsertDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		// Kết nối tới MongoDB.
		MongoClient mongoClient = MongoUtils.getMongoClient();
		
		// Kết nối tới Database
	    // (Không nhất thiết DB này phải tồn tại sẵn
	    // nó sẽ được tự động tạo ra nếu chưa tồn tại).
		DB db = mongoClient.getDB(MyConstants.DB_NAME);
		
		// Lấy ra Collection với tên Department.
	    // Không nhất thiết Collection này phải tồn tại trong DB.
		DBCollection dept = db.getCollection("user");
		
		// Insert Document 1
		BasicDBObject doc1 = new BasicDBObject();
		doc1.append("first_name", "hoang");
		doc1.append("last_name", "anh");
		doc1.append("sex", "khac");
		doc1.append("date_of_birth", "01/01/1993");
		doc1.append("address", "ha nam");
		doc1.append("friend_id", 2);
		doc1.append("type", "student");
		doc1.append("lever", 3);
		doc1.append("skill", "base");
		doc1.append("rank", 1);
		doc1.append("status", "good");
		doc1.append("phone", "0123456789");
		dept.insert(doc1);
		
		// Insert Document 2
		BasicDBObject doc2 = new BasicDBObject();
		doc2.append("first_name", "hiệp");
		doc2.append("last_name", "hững hờ");
		doc2.append("sex", "khac");
		doc2.append("date_of_birth", "02/02/1993");
		doc2.append("address", "ninh bình");
		doc2.append("friend_id", 3);
		doc2.append("type", "student");
		doc2.append("lever", 2);
		doc2.append("skill", "base");
		doc2.append("rank", 1);
		doc2.append("status", "good");
		doc2.append("phone", "0123456789");
		dept.insert(doc2);
		
		System.out.println("Done!");
	}

}
