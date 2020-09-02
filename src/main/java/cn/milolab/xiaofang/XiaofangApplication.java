package cn.milolab.xiaofang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication

// DAO接口包名
@MapperScan("cn.milolab.xiaofang.dao")

// web filter扫描
@ServletComponentScan(basePackages = {"cn.milolab.xiaofang.filter"})

/**
 * 小芳便利店主类
 * @author milow
 */
public class XiaofangApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaofangApplication.class, args);
    }

}
