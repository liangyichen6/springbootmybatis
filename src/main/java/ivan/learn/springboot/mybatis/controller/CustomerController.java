package ivan.learn.springboot.mybatis.controller;

import ivan.learn.springboot.mybatis.service.CustomerService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getCustomers(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        return ResponseEntity.ok(customerService.getCustomers(pageNum, pageSize));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/download")
    public ResponseEntity downloadFile(HttpServletRequest request, HttpServletResponse response) {
        try {

            ClassPathResource resource = new ClassPathResource("新建 Microsoft Word 文档.docx");


            String filename = resource.getFilename();
            filename = "2.docx";
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition","attachment; filename=UTF-8''"+ URLEncoder.encode(filename,"UTF-8"));

            OutputStream out = response.getOutputStream();
            InputStream inputStream = resource.getInputStream();
            IOUtils.copy(inputStream,out);

            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    /**
     * @return String
     * @Title: getBrowser
     * @Description: 判断客户端浏览器
     * @author
     * @date
     */
    private static String getBrowser(HttpServletRequest request) {
        String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (UserAgent != null) {
            if (UserAgent.indexOf("msie") != -1)
                return "IE";
            if (UserAgent.indexOf("firefox") != -1)
                return "FF";
            if (UserAgent.indexOf("safari") != -1)
                return "SF";
        }
        return null;
    }
}
