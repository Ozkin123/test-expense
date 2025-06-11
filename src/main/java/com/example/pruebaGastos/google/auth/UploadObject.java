package com.example.pruebaGastos.google.auth;




import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@Service
public class UploadObject {
    public void uploadObject(
            String projectId, String bucketName, String objectName, InputStream inputStream) throws IOException {


        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();


        Storage.BlobWriteOption precondition;
        if (storage.get(bucketName, objectName) == null) {

            precondition = Storage.BlobWriteOption.doesNotExist();
        } else {

            precondition =
                    Storage.BlobWriteOption.generationMatch(
                            storage.get(bucketName, objectName).getGeneration());
        }
        storage.createFrom(blobInfo, inputStream, precondition);
    }
}