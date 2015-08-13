package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donovan on 15/06/01.
 */
@Configuration
@ComponentScan("conditional")
public class MagicConfig {


    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean getMagicBean() {
        return new MagicBean();
    }
}
