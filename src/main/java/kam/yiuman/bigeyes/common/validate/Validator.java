package kam.yiuman.bigeyes.common.validate;

import java.lang.annotation.Annotation;

/**
 * 验证接口
 *
 * @author yiuman
 * @date 2018/5/18
 */
public interface Validator<A extends Annotation, T> {

    boolean validate(A annotation, T beCheckObject, String parameterName);
}
