package configuration;

import conditional.MagicConfig;
import jdbc.JdbcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import soundsystem.CDPlayerConfig;


/**
 * Created by donovan on 15/06/01.
 */
@Configuration
@Import({ CDPlayerConfig.class, MagicConfig.class, JdbcConfig.class})
public class Config {



}
