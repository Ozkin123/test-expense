package com.example.pruebaGastos.service;

import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class GoogleServiceImp implements IGoogleService {



    @Override
    public String uploadObject(
            String projectId, String bucketName, String objectName, InputStream inputStream) throws IOException {

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        Storage.BlobWriteOption precondition;
        boolean alreadyExists = (storage.get(bucketName, objectName) != null);

        if (!alreadyExists) {
            precondition = Storage.BlobWriteOption.doesNotExist();
        } else {
            precondition = Storage.BlobWriteOption.generationMatch(
                    storage.get(bucketName, objectName).getGeneration());
        }

        try {

            storage.createFrom(blobInfo, inputStream, precondition);
            return String.format("https://storage.googleapis.com/%s/%s", bucketName, objectName);
        } catch (StorageException e) {
            if (alreadyExists) {
                return String.format("https://storage.googleapis.com/%s/%s", bucketName, objectName);
            }
            return "no se subio imagen";
        }
    }
}
