package com.example.pruebaGastos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public interface IGoogleService {
    String uploadObject(String objectName, MultipartFile file) throws IOException;
}
