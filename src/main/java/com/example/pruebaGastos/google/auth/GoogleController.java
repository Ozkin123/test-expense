package com.example.pruebaGastos.google.auth;

import com.example.pruebaGastos.dtos.request.ExpenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class GoogleController {


    @Autowired
    UploadObject uploadObject;

    private String projectId = "bocataexpense";
    private String bucketName = "gasto_img";

    @PostMapping(value = "/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public void uploadIMG(@RequestPart("file") MultipartFile file, @RequestPart("dto") ExpenseDto dto) throws IOException {
        uploadObject.uploadObject(projectId,bucketName,"img-gastos",file.getInputStream());
        System.out.println(dto);

    }


}
