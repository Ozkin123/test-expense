package com.example.pruebaGastos.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public interface IGoogleService {
    String uploadObject(String projectId, String bucketName, String objectName, InputStream inputStream) throws IOException;
}
