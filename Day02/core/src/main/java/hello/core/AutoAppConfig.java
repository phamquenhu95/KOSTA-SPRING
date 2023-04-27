package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
// guswo AutoAppConfig 파일  등록되어 있는 패키지와 하위 패키지 클래스을 스캔해서 @Component 가
// 붙어 있는 클래스 찾아서 스프링 컨텐이터에   Bean
// AppConfig에
@ComponentScan(
    excludeFilters = @Filter(type= FilterType.ANNOTATION,
    classes = Configuration.class))
public class AutoAppConfig {

}
