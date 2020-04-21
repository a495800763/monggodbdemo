package com.tensquare.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @program: mongodbdemo
 * @author: liumq
 * @create: 2020-04-21 22:17
 **/
public class MongoTest {
    public static void main(String[] args) {
        findData();
    }


    public static void findData()
    {
        //连接mongo服务器
        MongoClient mongoClient = new MongoClient("192.168.1.110");
        //得到要操作的数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        //得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        BasicDBObject bson = new BasicDBObject("userid","1013");

        //得到集合中所有的文档（数据）
        FindIterable<Document> documents = spit.find(bson);
        //遍历数据
        for (Document document : documents) {
            System.out.println(document.toString());
        }

        mongoClient.close();
    }
}
