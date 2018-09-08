package ivan.learn.springboot.mybatis.configuration;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import ivan.learn.springboot.mybatis.interceptors.SqlPerformanceMonitor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MyBatisSessionFactoryConfiguration {

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
