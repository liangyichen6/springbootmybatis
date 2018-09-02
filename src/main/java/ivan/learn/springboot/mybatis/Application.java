package ivan.learn.springboot.mybatis;

import ivan.learn.springboot.mybatis.interceptors.SqlPerfomanceMonitor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).run(args);
    }

    @Bean
    public Interceptor getSqlPerformanceMonitor() throws Exception {
        return new SqlPerfomanceMonitor();
    }
}
