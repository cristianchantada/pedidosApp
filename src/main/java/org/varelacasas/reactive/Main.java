package org.varelacasas.reactive;

import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.FullDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String  url = "mongodb+srv://cristianchantada:cristian@cristian-instance.rrvjjrp.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(url);
        MongoDatabase database = mongoClient.getDatabase("pedidos_app");

        List<Bson> pipeline = Arrays.asList(
            Aggregates.match(
                Filters.in("operationType", Arrays.asList("insert", "update")
                )
            )
        );

        ChangeStreamIterable<Document> changeStream = database.watch(pipeline)
                .fullDocument(FullDocument.UPDATE_LOOKUP);

        final  int[] numberOfEvents = {0};

        changeStream.forEach( event -> {
            System.out.println("Received a change to the collection: " + event);
            if(++numberOfEvents[0] >= 2){
                System.exit(0);
            }
        });

    }
}

