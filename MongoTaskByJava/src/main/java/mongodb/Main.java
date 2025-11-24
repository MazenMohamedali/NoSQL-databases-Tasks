package mongodb;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.bson.Document;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static MongoClient mongoClient = null;
    static public void connectMongoDb(String uri) {
        if (mongoClient == null) mongoClient = MongoClients.create(uri);
    }

    static public List<Document> jsonToDocumets(String path) throws Exception {
        String jsonConetent = new String(Files.readAllBytes(Paths.get(path)));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode arrayNode = mapper.readTree(jsonConetent);
        
        if(!arrayNode.isArray()) {
            System.err.println("Error: JSON content is not a root array.");
            return Collections.emptyList();
        }
        
        List<Document> result = new ArrayList<>();
        for (JsonNode node : arrayNode) result.add(Document.parse(node.toString()));
        return result;
    }
    
    static public void printCollection(MongoCollection<Document> document) {
        for(Document doc : document.find()) System.out.println(doc.toJson());
        System.out.println();
    }

    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";
        String dataBaseName = "mongoTask";
        connectMongoDb(uri);
        MongoDatabase database = mongoClient.getDatabase(dataBaseName);
        if(database == null) return;
        database.createCollection("Emloyee");
        database.createCollection("Student");

        String studentDocumentPath = Main.class.getResource("/StudentCollection.json").getPath();
        String emloyeeDocumentPath = Main.class.getResource("/EmployeeCollection.json").getPath();

        MongoCollection<Document> StudentCollection = database.getCollection("Student");
        MongoCollection<Document> emloyeeCollection =  database.getCollection("Emloyee");

        try {
            StudentCollection.insertMany(jsonToDocumets(studentDocumentPath));
            emloyeeCollection.insertMany(jsonToDocumets(emloyeeDocumentPath));
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        printCollection(StudentCollection);
        printCollection(emloyeeCollection);
    }
}