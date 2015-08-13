package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donovan on 15/05/29.
 */
@Configuration
//@ComponentScan
public class CDPlayerConfig {

    @Bean
    public CompactDisc getCompactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer getMediaPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }
}
