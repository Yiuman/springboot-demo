package kam.yiuman.bigeyes.common.validate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiuman
 * @date 2018/5/19
 */
@Configuration
public class ValidateConfig {

    @Bean
    public ValidatorScan validatorScan(){
        return new ValidatorScan();
    }
}
