package com.wzh.tools.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据库配置
 */
@Configuration
@MapperScan(basePackages = {"com.wzh.tools.springboot.dao"}, sqlSessionFactoryRef = "toolsSqlSessionFactory")
public class ToolsDataSouseConfig {

    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    public static final String toolsDataSourceTransactionManager = "toolsDataSourceTransactionManager";

    @Bean(name = "toolsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource toolsDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "toolsDataSourceTransactionManager")
    public DataSourceTransactionManager toolsDataSourceTransactionManager() {
        return new DataSourceTransactionManager(toolsDataSource());
    }

    @Bean(name = "toolsSqlSessionFactory")
    public SqlSessionFactory toolsSqlSessionFactory(@Qualifier("toolsDataSource") DataSource toolsDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(toolsDataSource);

        // 因为重写了SqlSessionFactoryBean，所以要在SqlSessionFactoryBean里面注入分页插件，其次只用maven注入依赖就可以使用分页插件
        Interceptor[] plugins =  new Interceptor[]{(Interceptor) new PageHelper()};
        sessionFactory.setPlugins(plugins);

        sessionFactory.setVfs(SpringBootVFS.class);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "toolsJdbcTemplate")
    public JdbcTemplate toolsJdbcTemplate(@Qualifier("toolsDataSource") DataSource toolsDataSource) {
        return new JdbcTemplate(toolsDataSource);
    }
}
