package com.config;

import com.entity.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Class used for connectivity with mongo
 */
public class MongoConfig {

    public static MongoCollection<Student> getConnection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //System.out.println("Created Mongo Connection successfully");

        CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase db = mongoClient.getDatabase("test").withCodecRegistry(codecRegistry);

        return db.getCollection("emp", Student.class);
    }
}
