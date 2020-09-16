package com.hong.project.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;

@Configuration
//1、读取外部配置
@PropertySource("classpath:db.properties")
//5、自动扫描对象关系映射
@MapperScan(basePackages = "com.hong.project.mapper", sqlSessionFactoryRef =
        "sqlSessionFactoryBean")
public class SpringMybatisConfig {
    @Value("${dataSource.driverClassName}")
    private String driverClassName;

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.username}")
    private String username;

    @Value("${dataSource.password}")
    private String password;

    //2、配置数据源
    @Bean("druidDataSource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //3、配置事务管理器
    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(
            @Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //4、配置会话工厂
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(
            @Qualifier("druidDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //指定数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定别名扫描
        sqlSessionFactoryBean.setTypeAliasesPackage("com.hong.project.pojo");
        //指定xml加载
        try {
            sqlSessionFactoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver()
                            .getResources("mapper/*Mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //指定高级配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //指定日志
        configuration.setLogImpl(Log4j2Impl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }
}
