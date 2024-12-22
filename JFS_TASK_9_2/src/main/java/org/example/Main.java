package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import javax.swing.event.UndoableEditListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("Alex_Task");
            MongoCollection<Document> collection = database.getCollection("JDBC_Task");

            //Insert many employee
            List<Document> emp = Arrays.asList(new Document("empcode", 101)
                    .append("empname", "Jenny")
                    .append("empage", 25)
                    .append("esalary", 10000),

                    new Document("empcode", 102)
                            .append("empname", "Jacky")
                            .append("empage", 30)
                            .append("esalary", 20000),

                    new Document("empcode", 103)
                            .append("empname", "Joe")
                            .append("empage", 20)
                            .append("esalary", 40000),

                    new Document("empcode", 104)
                            .append("empname", "John")
                            .append("empage", 40)
                            .append("esalary", 80000),

                    new Document("empcode", 105)
                            .append("empname", "Shameer")
                            .append("empage", 25)
                            .append("esalary", 90000));
            collection.insertMany(emp);

            System.out.println("Employees Added Successfully");
        }
    }
}