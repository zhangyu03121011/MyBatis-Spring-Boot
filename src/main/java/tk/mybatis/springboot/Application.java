package tk.mybatis.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.springboot.mapper")
public class Application extends WebMvcConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
    	long currentTimeMillis = System.currentTimeMillis();
        SpringApplication.run(Application.class, args);
        long currentTimeMillis2 = System.currentTimeMillis();
        logger.info("容器启动结束耗时{}秒",currentTimeMillis2-currentTimeMillis);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:countries";
    }
}
