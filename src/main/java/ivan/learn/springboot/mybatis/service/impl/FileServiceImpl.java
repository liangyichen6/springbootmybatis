package ivan.learn.springboot.mybatis.service.impl;

import ivan.learn.springboot.mybatis.request.FileDownloadRequest;
import ivan.learn.springboot.mybatis.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public ResponseEntity downloadSingleFile(FileDownloadRequest request) {
        return null;
    }

    @Override
    public ResponseEntity downloadMultipleFiles(List<FileDownloadRequest> requests) {
        return null;
    }
}
