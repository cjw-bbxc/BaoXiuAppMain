package xyz.bbxc.estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auth: 白白小草
 * @Desc: 在线报修APP后台管理-springBoot引导类
 */
@SpringBootApplication
@MapperScan(basePackages = {"xyz.bbxc.estate.dao"}) //扫描继承了TKMapper Mapper<T>接口的接口
public class EstateBgManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstateBgManageApplication.class, args);
    }
}
