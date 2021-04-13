

package com.operations;

import com.entity.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.Iterator;
import java.util.Scanner;


public class MongoImp {
    Scanner sc = new Scanner(System.in);
    public void insert(MongoCollection<Student> collection){


        Student obj = new Student();
        System.out.println("Enter Id");
        int id = sc.nextInt();
        obj.setId(id);

        System.out.println("Enter Salary");
        int salary = sc.nextInt();
        obj.setSalary(salary);

        Document doc=new Document("Id",id).append("salary",salary);

        collection.insertOne(obj);
        System.out.println("Insertion Complete");
    }

    public void viewAll (MongoCollection<Student> collection)
    {

        FindIterable<Student> iterDoc = collection.find();

        Iterator it =iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
    }

    public void view(MongoCollection<Student> collection){
        BasicDBObject searchQuery = new BasicDBObject();
        System.out.println("Enter Id to search:");
        int vid = sc.nextInt();
        searchQuery.put("_id",vid);
        MongoCursor<Student> cursor = collection.find(searchQuery).iterator();
        while(cursor.hasNext()){

            System.out.println(cursor.next());
        }
    }

    public void delete(MongoCollection<Student> collection){
        System.out.println("Enter Id to delete:");
        int did = sc.nextInt();
        collection.deleteOne(Filters.eq("_id", did));
        System.out.println("Document deleted successfully...");
    }

    public void update(MongoCollection<Student> collection){
        System.out.println("Enter Id to update:");
        int uid = sc.nextInt();
        System.out.println("update your salary");
        int salary = sc.nextInt();
        collection.updateOne(Filters.eq("_id", uid), Updates.set("salary", salary));
        System.out.println("Document updated successfully...");




    }

}
