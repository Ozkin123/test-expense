package com.example.pruebaGastos.service;

import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
public class GoogleServiceImp implements IGoogleService {

    private String projectId = "bocataexpense";
    private String bucketName = "gasto_img";


    @Override
    public String uploadObject(
            String objectName, MultipartFile file) throws IOException {
        if(file==null||file.isEmpty()){
            return "no se subio imagen";
        }
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

            storage.createFrom(blobInfo, file.getInputStream(), precondition);
            return String.format("https://storage.googleapis.com/%s/%s", bucketName, objectName);
        } catch (StorageException e) {
            if (alreadyExists) {
                return String.format("https://storage.googleapis.com/%s/%s", bucketName, objectName);
            }
            return "no se subio imagen";
        }
    }
}
