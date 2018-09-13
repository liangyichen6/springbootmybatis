package ivan.learn.springboot.mybatis.controller;

import ivan.learn.springboot.mybatis.service.CustomerService;
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

            ClassPathResource resource = new ClassPathResource("shell脚本学习手册.docx");


            String filename = resource.getFilename();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream");
            // 设置response的Header
            String realName = filename;
            //判断浏览器是否为火狐
            if ("FF".equals(getBrowser(request))) {
                // 火狐浏览器 设置编码new String(realName.getBytes("GB2312"), "ISO-8859-1");
                realName = new String(filename.getBytes("GB2312"), "ISO-8859-1");
            } else {
                realName = URLEncoder.encode(realName, "UTF-8");//encode编码UTF-8 解决大多数中文乱码
                realName = realName.replace("+", "%20");//encode后替换空格  解决空格问题
            }

            response.addHeader("Content-Disposition", "attachment; filename=\"" + realName + "\"");

            OutputStream out = response.getOutputStream();
            InputStream inputStream = resource.getInputStream();

            byte[] buf = new byte[1024];

            int len;

            while (!((len=inputStream.read(buf)) == -1)) {
                out.write(buf,0,len);
            }

            out.close();
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
