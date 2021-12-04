/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.database;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.FindIterable;
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
import frame.SmartCardWord;
import examples.data.Checkin;
import examples.data.Departments;
import examples.data.DepartmentsKey;
import examples.data.Rule;
import examples.data.RuleKey;
import examples.data.User;
import examples.data.UserKey;
import examples.utils.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.json.JSONException;

/**
 *
 * @author traig
 */
public class RuleDbHelper {
    
    private static RuleDbHelper sInstance;
    private MongoDatabase database;
    private com.mongodb.client.MongoClient mongoClient;
    private MongoCollection<Document> ruleCol;
    private MongoCollection<Document> departmentCol;
    private MongoCollection<Document> userCol;
    
    private RuleDbHelper() {
       
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
    
         database = mongoClient.getDatabase("smartcardapi");
    }
    
    public void setRuleCol(String name) {
        ruleCol = database.getCollection(name);
    }
    
    public void setDepartmentCol(String name) {
        departmentCol = database.getCollection(name);
    }
    
    public static RuleDbHelper getInstance() {
        if(sInstance == null)
            sInstance = new RuleDbHelper();
        return sInstance;
    }
    
    public void addRule(Rule rule) {
        
        Document d = new Document();
        d.append("id", 1)
                .append(RuleKey.START_DATE, rule.getmInDate())
                .append(RuleKey.END_DATE, rule.getmOutDate())
                .append(RuleKey.FINES, rule.getmFines())
                .append(RuleKey.START_TIME, rule.getmInTime().toString())
                .append(RuleKey.END_TIME, rule.getmOutTime().toString());
         ruleCol.insertOne(d);
    }
    
    public Document getRule() {
        return ruleCol.find(eq(RuleKey.ID, 1)).first();
    }
    
    public void updateRule(Rule rule) {
        ruleCol.updateOne(eq("id", 1), combine(set(RuleKey.START_TIME, rule.getmInTime().toString()),
                                            set(RuleKey.END_TIME, rule.getmOutTime().toString()),
                                            set(RuleKey.FINES, rule.getmFines()),
                                            set(RuleKey.START_DATE, rule.getmInDate()),
                                            set(RuleKey.END_DATE, rule.getmOutDate())
                                            ));
    }
    
    public void addDepartment(Departments departments) {
        
        Document d = new Document();
        d.append(DepartmentsKey.ID, departments.getmId())
                .append(DepartmentsKey.NAME, departments.getmName())
                .append(DepartmentsKey.QUANLITY, departments.getmQuanlity());
         departmentCol.insertOne(d);
         
    }
    
    public List<Document> getDepartments() {
        List<Document> sr = new ArrayList<>();
        
        MongoCursor<Document> cursor = departmentCol.find().iterator();
        while (cursor.hasNext()) {
           // System.out.println("collection is " +cursor.next() );
            sr.add(cursor.next());
        }
      return sr;
    }
    
    public ArrayList<User> getAllUserOfDepartment(int id) {
        
        ArrayList<User> rerult = new ArrayList<>();
        userCol = database.getCollection("users");
//        userCol.find().forEach(new Block<Document> () {
//            @Override
//            public void apply(Document t) {
//                User u;
//                try {
//                    u = JsonParser.jsonToUser(t.toJson());
//                     if(u.getId_department() == id)
//                        rerult.add(u);
//                } catch (JSONException ex) {
//                    Logger.getLogger(RuleDbHelper.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//        });
        
         MongoCursor<Document> cursor = userCol.find().iterator();
            while (cursor.hasNext()) {
                System.out.println("hello");
                      
                      Runnable r1 = new Runnable(){
                        public void run(){
                            User u;
                            try { 
                                u = JsonParser.jsonToUser(cursor.next().toJson());
                                if(u.getId_department() == id)
                                      rerult.add(u);
                            } catch (JSONException ex) {
                                Logger.getLogger(RuleDbHelper.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                        

                        }
                    };
                      r1.run();
            }
        return rerult;
    }
    
    
    public ArrayList<User> getAllUser() {
        
        ArrayList<User> rerult = new ArrayList<>();
        userCol = database.getCollection("users");
         MongoCursor<Document> cursor = userCol.find().iterator();
            while (cursor.hasNext()) {
                      Runnable r1 = () -> {
                          User u;
                          try {
                              u = JsonParser.jsonToUser(cursor.next().toJson());
                              rerult.add(u);
                          } catch (JSONException ex) {
                              Logger.getLogger(RuleDbHelper.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      };
                      r1.run();
            }
        return rerult;
    }
    
    
    public void updateDepartment(Departments departments) {
        ruleCol.updateOne(eq(DepartmentsKey.ID, departments.getmId()),
                                            combine(set(DepartmentsKey.NAME, departments.getmName()),
                                            set(DepartmentsKey.QUANLITY, departments.getmQuanlity())
                                            ));
    }
    
    SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
    @Override
    public void onResult(final Void result, final Throwable t) {
        System.out.println("Operation Finished!");
    }
    };
    
    Block<Document> printBlock = new Block<Document>() {
    @Override
    public void apply(final Document document) {
        System.out.println(document.toJson());
    }
};
    
}