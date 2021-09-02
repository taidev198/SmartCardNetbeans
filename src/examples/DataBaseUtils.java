/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.SocketSettings;
import examples.data.User;
import examples.data.UserKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
/**
 *
 * @author traig
 */
public class DataBaseUtils {
    
    private static DataBaseUtils sInstance;
    private MongoDatabase database;
    private com.mongodb.client.MongoClient mongoClient;
    private MongoCollection<User> col;
    
    private DataBaseUtils() {
       
         ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
         
          ConnectionPoolSettings connectionPoolSettings = ConnectionPoolSettings.builder()
            .minSize(2)
            .maxSize(20)
            .maxWaitQueueSize(100)
            .maxConnectionIdleTime(60, TimeUnit.SECONDS)
            .maxConnectionLifeTime(300, TimeUnit.SECONDS)
            .build();

    SocketSettings socketSettings = SocketSettings.builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build();

    MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .applyToConnectionPoolSettings(builder -> builder.applySettings(connectionPoolSettings))
            .applyToSocketSettings(builder -> builder.applySettings(socketSettings))
            .build();

   mongoClient =  MongoClients.create(clientSettings);
        // mongoClient = new MongoClient(connectionString);
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
    CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);
    
         database = mongoClient.getDatabase("smartcardapi").withCodecRegistry(pojoCodecRegistry);
    }
    
    
    public static DataBaseUtils getInstance() {
        if(sInstance == null)
            sInstance = new DataBaseUtils();
        return sInstance;
    }
    
    
    public  MongoCollection<User> getCol(String name) {
        col = database.getCollection(name, User.class);
        return col;
    }
    
    public void insert(User user) {
        
        Document doc = new Document(UserKey.ID, user.getId())
                .append(UserKey.FULLNAME, user.getFullname())
                .append(UserKey.BIRTH, user.getBirth())
                .append(UserKey.GENDER, user.getGender())
                .append(UserKey.ADDRESS, user.getAddress())
                .append(UserKey.ID_DEPARTMENT, user.getId_department())
                .append(UserKey.LATE_DATE, user.getLate_date())
                .append(UserKey.PASSWORD, user.getPassword());//PIN
         col.insertOne(user);
        
    }
    
    public void printAll() {
        MongoCursor<User> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()) {
                
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }
    
    public User findUser(String id) {
        
        return col.find(eq(UserKey.ID, id)).first();
        
    }
    
    public User updateUser(String id, User user) {
        
        col.replaceOne(eq(UserKey.ID, id), user);

        return user;
    }
}
