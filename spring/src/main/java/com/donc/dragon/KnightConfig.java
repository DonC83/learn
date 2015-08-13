package com.donc.dragon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donovan on 15/05/22.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new DragonKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }
}
