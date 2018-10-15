package ivan.learn.springboot.mybatis.configuration;

import com.github.pagehelper.PageInterceptor;
import ivan.learn.springboot.mybatis.interceptors.SqlPerformanceMonitor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MybatisPluginConfiguration {

    @Bean
    @Order(2)
    public Interceptor getSqlPerformanceMonitor() throws Exception {
        return new SqlPerformanceMonitor();
    }

    @Bean
    @Order(1)
    public Interceptor pageHelper() {
        return new PageInterceptor();
    }
}
