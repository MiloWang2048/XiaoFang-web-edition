package cn.milolab.xiaofang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author milow
 */
@SpringBootApplication
@MapperScan("cn.milolab.xiaofang.dao")
@ServletComponentScan(basePackages = {"cn.milolab.xiaofang.filter"})
public class XiaofangApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaofangApplication.class, args);
    }

}
