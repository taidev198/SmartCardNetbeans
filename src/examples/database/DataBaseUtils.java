/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.database;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.SocketSettings;
import examples.data.Checkin;
import frame.SmartCardWord;
import examples.data.Rule;
import examples.data.RuleKey;
import examples.data.User;
import examples.data.UserKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.BSONObject;
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
    private MongoCollection<Rule> ruleCol;
    
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
      //  CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
//    CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
   // CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);
    
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
    
    public void setRuleCol(String name) {
        ruleCol = database.getCollection(name, Rule.class);
    }
    
    public void insert(User user) {
       
         col.insertOne(user);
        
    }
    
    public ArrayList<User> getAllUserOfDepartment(int id) {
        
        ArrayList<User> rerult = new ArrayList<>();
 
//        col.find().forEach((Block<User>) (User t) -> {
//            if(t.getId_department() == id){
//                System.out.println(t.toString());
//            }
//                //rerult.add(t);
//        });
        
         MongoCursor<User> cursor = col.find().iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toString());
//                User u = (User)cursor.next();
//                if(u.getId_department() == id)
//               rerult.add(u);
            }
        
        return rerult;
    }
    
   


    
    public User findUser(String id) {
        
        return col.find(eq("id", id)).first();
        
    }
    
    public User updateUser(String id, User user) {
        col.updateOne(eq("id", id), combine(set(UserKey.ADDRESS, user.getAddress()),
                                            set(UserKey.BIRTH, user.getBirth()),
                                            set(UserKey.FULLNAME, user.getFullname()),
                                            set(UserKey.GENDER, user.getGender()),
                                            set(UserKey.ID_DEPARTMENT, user.getId_department()),
                                            set(UserKey.IS_CHECKIN, user.isIsCheckin()),
                                            set(UserKey.IS_CHECKOUT, user.isIsCheckout())
                                            ));

        return user;
    }
    
    public void updateCheckinUser(String id, LocalDate now) {
        User user = findUser(id);
        List<LocalDate> dates = user.getLate_date();
        if (dates == null)
            dates = new ArrayList<>();
        else {
            dates.add(now);
        }
        col.updateOne(eq("id", id), combine(set(UserKey.LATE_DATE, dates)
                                            ));
    }
    public void deleteUser(String id) {
        
       DeleteResult deleteResult = col.deleteOne(eq("id", id));
        System.out.println(deleteResult.getDeletedCount()+"delete");
    }
    
    public void addRule(Rule rule) {
         ruleCol.insertOne(rule);
    }
    
    public Rule getRule() {
        return ruleCol.find(eq(RuleKey.ID, 1)).first();
    }
    
    public void updateRule(Checkin checkin) {
//        col.updateOne(eq("id", 1), combine(set(RuleKey.START_TIME, checkin.getmInTime()),
//                                            set(RuleKey.END_TIME, checkin.getmOutTime()),
//                                            set(RuleKey.END_TIME, checkin.getmOutTime()),
//                                            set(RuleKey.START_DATE, checkin.getmInDate()),
//                                            set(RuleKey.END_DATE, checkin.getmOutDate())
//                                            ));
    }
    
}
