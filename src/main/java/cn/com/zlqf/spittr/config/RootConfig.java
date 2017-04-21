package cn.com.zlqf.spittr.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.pool.DruidDataSource;

import cn.com.zlqf.spittr.service.SpitterService;
import redis.clients.jedis.JedisPoolConfig;

import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = { "cn.com.zlqf.spittr.service"} )
public class RootConfig {
	
	@Bean
	public RmiProxyFactoryBean spitterService() {
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://localhost/SpitterService");
		rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
		return rmiProxyFactoryBean;
	}
}

