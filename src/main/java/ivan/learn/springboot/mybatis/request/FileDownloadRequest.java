package ivan.learn.springboot.mybatis.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FileDownloadRequest {

    private String fileName;

    private String fileKey;

    private String fileExt;

    public FileDownloadRequest(String fileName, String fileKey, String fileExt) {
        this.fileName = fileName;
        this.fileKey = fileKey;
        this.fileExt = fileExt;
    }
}
