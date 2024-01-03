package com.itheima.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

public class MyBatisConfig {
    /*
    定义MyBatis的核心连接工厂bean，
    等同于<bean class="org.mybatis.spring.SqlSessionFactoryBean">
     参数使用自动装配的形式加载dataSource，
    为set注入提供数据源，dataSource来源于JdbcConfig中的配置
     */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(
            @Autowired DataSource dataSource,@Autowired PageInterceptor pageIntercptor) throws Exception{
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        Interceptor[] plugins={pageIntercptor};
        ssfb.setPlugins(plugins);
        //等同于<property name="dataSource" ref="dataSource"/>
        ssfb.setDataSource(dataSource);
        ssfb.setTypeAliasesPackage("com.itheima.domain");
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        ssfb.setMapperLocations(resourcePatternResolver.getResources("classpath:com/itheima/dao/*.xml"));
        return ssfb;
    }
    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(
            @Autowired SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        return  new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(
            @Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    /*
    定义MyBatis的映射扫描，
    等同于<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //等同于<property name="basePackage" value="com.itheima.dao"/>
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
    /**配置PageInterceptor分页插件*/
    @Bean
    public PageInterceptor getPageInterceptor() {
        PageInterceptor pageIntercptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("value", "true");
        properties.setProperty("reasonable", "true");
        pageIntercptor.setProperties(properties);
        return pageIntercptor;
    }
}

