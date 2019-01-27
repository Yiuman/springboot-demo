package kam.yiuman.bigeyes.common.validate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author yiuman
 * @date 2018/5/18
 */

@Aspect
@Component
public class ValidateAOP {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void validatePointCut() {
    }

    @Before("validatePointCut()")
    public void beforeValidate(JoinPoint joinPoint) {
        //检查有没参数
        Object[] parameters = joinPoint.getArgs();


        if (parameters == null)
            return;
        //获取参数注解二维数组  1为参数 2为参数
        Annotation[][] parameterAnnotations = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations();
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                //根据注解匹配校验容器中的注解
                Validator validator = ValidatorContext.getValidator(annotation.annotationType());
                if (validator == null)
                    continue;
                validator.validate(annotation, parameters[i],parameterNames[i]);
            }
        }


    }
}
