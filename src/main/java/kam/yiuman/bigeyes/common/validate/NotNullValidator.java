package kam.yiuman.bigeyes.common.validate;

import kam.yiuman.bigeyes.common.validate.annotation.NotNull;
import org.springframework.stereotype.Component;

/**
 * @author yiuman
 * @date 2018/5/18
 */
@Component
public class NotNullValidator implements Validator<NotNull, Object> {

    @Override
    public boolean validate(NotNull annotation, Object beCheckObject, String parameterName) {

        return false;
    }
}
