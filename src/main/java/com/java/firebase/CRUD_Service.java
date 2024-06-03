package com.java.firebase;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUD_Service {


    public CRUD_operations getCRUD(String documentId) throws ExecutionException, InterruptedException{
        Firestore dbFirestore=FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Users").document(documentId);
        ApiFuture<DocumentSnapshot> future=documentReference.get();
        DocumentSnapshot document=future.get();
        CRUD_operations crud;
        if(document.exists()) {
            crud=document.toObject(CRUD_operations.class);
            return crud;
        }
        return null;
    }

    public String createCRUD(CRUD_operations crud) throws ExecutionException, InterruptedException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Users").document(crud.getName()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateCRUD(CRUD_operations crud) throws ExecutionException, InterruptedException{
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Users").document(crud.getName()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCRUD(String documentId) {
        Firestore dbFirestore=FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Users").document(documentId).delete();
        return "Successfully deleted" + documentId;
    }
}
