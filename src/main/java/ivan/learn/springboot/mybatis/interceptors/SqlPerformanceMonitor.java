package ivan.learn.springboot.mybatis.interceptors;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class SqlPerformanceMonitor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlPerformanceMonitor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long timestamp = System.currentTimeMillis();
        Object result = invocation.proceed();

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlSource sqlSource = (RawSqlSource) mappedStatement.getSqlSource();
        String sql = sqlSource.getBoundSql(mappedStatement.getConfiguration()).getSql();
        LOGGER.info("Sql: [{}], ConsumingTime: [{}]", sql, System.currentTimeMillis() - timestamp);

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
