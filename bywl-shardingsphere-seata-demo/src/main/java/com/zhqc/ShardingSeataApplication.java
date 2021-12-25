package com.zhqc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.zaxxer.hikari.HikariDataSource;
import com.zhqc.framerwork.common.annotation.*;
//import lombok.SneakyThrows;
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableZhqcSwagger
@EnableZhqcDozer
@EnableZhqcRedis
@MapperScan("com.zhqc.**.dao")
@ComponentScan({"com.zhqc"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ShardingSeataApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(ShardingSeataApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ShardingSeataApplication.class);
	}

//	@SneakyThrows
//	@Bean
//	public DataSource dataSource() {
//		DataSource dataSource =  YamlShardingSphereDataSourceFactory.
//				createDataSource(ResourceUtils.getFile("D:\\study\\shardingsphere\\demo\\bywl-shardingsphere-seata-demo\\src\\main\\resources\\config-sharding.yaml"));
//		return dataSource;
//	}

//	@Bean
//	public DataSource dataSource() {
//		// 配置真实数据源
//		Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//		// 配置第 1 个写入数据源
//		HikariDataSource dataSource1 = new HikariDataSource();
//		dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource1.setJdbcUrl(" jdbc:mysql://172.17.30.210:3306/write_ds_0?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
//		dataSource1.setUsername("root");
//		dataSource1.setPassword("Zhqc_123!");
//		dataSourceMap.put("write-ds-0", dataSource1);
//
//		// 配置第 2 个写入数据源
//		HikariDataSource dataSource2 = new HikariDataSource();
//		dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource2.setJdbcUrl("jdbc:mysql://172.17.30.210:3306/write_ds_1?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
//		dataSource1.setUsername("root");
//		dataSource1.setPassword("Zhqc_123!");
//		dataSourceMap.put("write-ds-1", dataSource2);
//
//		// 配置第 1 个读取数据源
//		HikariDataSource readDataSource1 = new HikariDataSource();
//		readDataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		readDataSource1.setJdbcUrl(" jdbc:mysql://172.17.30.210:3306/read_ds_0?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
//		readDataSource1.setUsername("root");
//		readDataSource1.setPassword("Zhqc_123!");
//		dataSourceMap.put("read-ds-0", readDataSource1);
//
//		// 配置第 2 个读取数据源
//		HikariDataSource readDataSource2 = new HikariDataSource();
//		readDataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		readDataSource2.setJdbcUrl(" jdbc:mysql://172.17.30.210:3306/read_ds_1?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
//		readDataSource2.setUsername("root");
//		readDataSource2.setPassword("Zhqc_123!");
//		dataSourceMap.put("read-ds-1", readDataSource2);
//
//		// 配置 t_order 表规则
//		ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order", "write-ds-${0..1}.t_order_${0..1}");
//
//		// 配置分库策略
//		orderTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "dbShardingAlgorithm"));
//
//		// 配置分表策略
//		orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "tableShardingAlgorithm"));
//
//		// 省略配置 t_order_item 表规则...
//		// ...
//
//		// 配置分片规则
//		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//		shardingRuleConfig.getTables().add(orderTableRuleConfig);
//
//		// 配置分库算法
//		Properties dbShardingAlgorithmrProps = new Properties();
//		dbShardingAlgorithmrProps.setProperty("algorithm-expression", "write-ds-$->{order_id % 2}");
//		shardingRuleConfig.getShardingAlgorithms().put("dbShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", dbShardingAlgorithmrProps));
//
//		// 配置分表算法
//		Properties tableShardingAlgorithmrProps = new Properties();
//		tableShardingAlgorithmrProps.setProperty("algorithm-expression", "t_order_$->{order_id % 2}");
//		shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tableShardingAlgorithmrProps));
//
//		DataSource dataSource = null;
//		try {
//			dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton(shardingRuleConfig), new Properties());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//logger.info("datasource : {}", dataSource);
//		return dataSource;
//	}
}
