package com.katziio.collabwithkatz.service.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.katziio.collabwithkatz.config.firebase.FirebaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class FireBaseService {
    private final Storage storage;

    @Value("${firebase.storage.url}")
    private String DOWNLOAD_URL;

    @Value("${firebase.storage.bucket}")
    private String BUCKET;

    @Autowired
    public FireBaseService(){
        this.storage = FirebaseConfig.initializeFirebaseApp();
    }
    public String uploadFile(MultipartFile file, String fileName) throws IOException {
        BlobId blobId = BlobId.of(BUCKET, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        byte[] fileBytes = file.getBytes();
        storage.create(blobInfo, fileBytes);
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        String downloadUrl = String.format(DOWNLOAD_URL, encodedFileName);
        return downloadUrl;
    }
}
