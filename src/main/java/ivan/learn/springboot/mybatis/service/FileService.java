package ivan.learn.springboot.mybatis.service;

import ivan.learn.springboot.mybatis.request.FileDownloadRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FileService {

    /**
     * 下载单个文件
     * @param request 文件下载请求参数
     * @return 返回
     */
    ResponseEntity downloadSingleFile(FileDownloadRequest request);

    /**
     * 下载多个文件，并且以zip形式返回
     * @param requests 多个文件下载请求参数
     * @return 返回
     */
    ResponseEntity downloadMultipleFiles(List<FileDownloadRequest> requests);

}
