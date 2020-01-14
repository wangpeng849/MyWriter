package com.wangp.myaop.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.Data;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/1/13
 * @Version 1.0
 */
@Data
public class MongoDBJDBC {


    private String dataBaseName;
    private String collectionName;
    private MongoCollection<Document> collection;

    public MongoDBJDBC(String dataBaseName, String collectionName) {
        this.dataBaseName = dataBaseName;
        this.collectionName = collectionName;
        this.collection = getCollection();
    }
 //    @Value("${mongoDB.name}")
//    private String dataBaseName;
//    @Value("${mongoDB.url}")
//    private String url;
//    @Value("${mongoDB.port}")
//    private int port;

    public MongoDatabase connectMongoDB(){
        //连接mongodb服务
        MongoClient mongoClient = new MongoClient("localhost",27017);
        //连接数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBaseName);
        System.out.println("Connection...   \nsuccessful..");
        return mongoDatabase;
    }

    //创建集合  获取集合会自动创建所以没什么用
    @Deprecated
    public void createCollection(){
        MongoDatabase mongoDatabase = connectMongoDB();
        mongoDatabase.createCollection(collectionName);
        System.out.println("创建集合" + collectionName + "成功！");
    }

    //进一步封装获取collection方式
//    public void setCollection(){
//        MongoDatabase mongoDatabase = connectMongoDB();
//        this.collection =  mongoDatabase.getCollection(collectionName);
//        System.out.println(collectionName + "集合选择成功！\n内容为：" + collection.find());
//    }

    //获取到集合
    public MongoCollection<Document> getCollection(){
        MongoDatabase mongoDatabase = connectMongoDB();
        MongoCollection<Document> collection =  mongoDatabase.getCollection(collectionName);
        System.out.println(collectionName + "集合选择成功！\n内容为：" + collection.find());
        return collection;
    }


    //插入数据
    public void insertData(List<Document> insertData){
        collection.insertMany(insertData);
        System.out.println("数据插入成功");
    }

    //获取所有文档
    public List<Document> findAllDocument(){
        List<Document> documentList = new ArrayList<>();
        FindIterable<Document> findIterable = collection.find();
        MongoCursor iterator = findIterable.iterator();
        while(iterator.hasNext()){
            Document document = (Document) iterator.next();
            documentList.add(document);
        }
        return documentList;
    }

    //更新文档
    public void updateDocument(String key,Object oldValue,Object newValue){
        collection.updateMany(Filters.eq(key,oldValue),new Document("$set",new Document(key,newValue)));
        System.out.println("更新成功");
    }

    //删除文档
    public void deleteOneDocument(String key,Object oldValue){
        collection.deleteOne(Filters.eq(key,oldValue));
        System.out.println("删除单个成功");
    }
    //删除文档
    public void deleteManyDocument(String key,Object oldValue){
        collection.deleteMany(Filters.eq(key,oldValue));
        System.out.println("删除多个成功");
    }

    public static void main(String[] args) {
        MongoDBJDBC mongo = new MongoDBJDBC("newMongoDB","dataBaseCreateByJava2");
        //创建集合
//        mongo.createCollection("dataBaseCreateByJava");
        //获取到集合
//        MongoCollection<Document> collection = mongo.getCollection();
        Document document = new Document("title","mysql");
        document.append("description","database,too");
        document.append("like",150);
        document.append("author","god");
        List<Document> documents = Arrays.asList(document);
        mongo.insertData(documents);
//        mongo.updateDocument("like",100,150);
//        mongo.deleteOneDocument("like",150);
//        mongo.deleteManyDocument("like",150);
        List<Document> allDocument = mongo.findAllDocument();
        System.out.println("findAllDocument:" + allDocument);
    }
}
