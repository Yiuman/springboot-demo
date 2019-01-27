package kam.yiuman.bigeyes.common.validate;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * 注解器上下文
 *
 * @author yiuman
 * @date 2018/5/18
 */
public class ValidatorContext {

    private static final Map<Class<? extends Annotation>, Validator> validators = new HashMap<>();

    public ValidatorContext() {
    }

    public static Validator getValidator(Class<? extends Annotation> annotationClass) {
        return validators.get(annotationClass);
    }

    public static void addValidator(Class<? extends Annotation> annotationClass, Validator validator) {
        validators.put(annotationClass, validator);
    }


}
