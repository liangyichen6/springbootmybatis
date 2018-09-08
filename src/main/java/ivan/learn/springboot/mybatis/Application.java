package ivan.learn.springboot.mybatis;

import com.github.pagehelper.PageInterceptor;
import ivan.learn.springboot.mybatis.interceptors.SqlPerformanceMonitor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).run(args);
    }


}
