package ivan.learn.springboot.mybatis.interceptors;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class SqlPerfomanceMonitor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlPerfomanceMonitor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long timestamp = System.currentTimeMillis();
        Object result = invocation.proceed();

        LOGGER.info("Sql: [{}], ConsumingTime: [{}]", invocation.getMethod(), System.currentTimeMillis() - timestamp);

        return result;
    }

    @Override
    public Object plugin(Object o) {

        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }



}
