package ivan.learn.springboot.mybatis.controller;

import ivan.learn.springboot.mybatis.request.FileDownloadRequest;
import ivan.learn.springboot.mybatis.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/download/single", method = RequestMethod.GET)
    public ResponseEntity downloadFile(@RequestParam("fileName") String fileName, @RequestParam("fileKey") String fileKey, @RequestParam("fileExt") String fileExt) {

        return fileService.downloadSingleFile(new FileDownloadRequest(fileName, fileKey, fileExt));
    }


    @RequestMapping(value = "/download/multiple", method = RequestMethod.GET)
    public ResponseEntity downloadMultiple() {

        return fileService.downloadMultipleFiles(new ArrayList<FileDownloadRequest>());
    }

}
