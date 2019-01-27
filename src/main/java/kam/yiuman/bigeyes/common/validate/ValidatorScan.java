package kam.yiuman.bigeyes.common.validate;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author yiuman
 * @date 2018/5/19
 */
public class ValidatorScan implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Map<String, Object> beansWithAnnotation = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(Component.class);
        Set<Map.Entry<String, Object>> entries = beansWithAnnotation.entrySet();//遍历Bean
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> map = iterator.next();
            Object bean = map.getValue();
            Class<?> beanClass = bean.getClass();
            if (Validator.class.isAssignableFrom(beanClass)) {
                Type[] genericInterfaces = beanClass.getGenericInterfaces();
                Type type = genericInterfaces[0];
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    Class typeClass = (Class)actualTypeArguments[0];
                    ValidatorContext.addValidator(typeClass, (Validator) bean);
                }

            }
        }
    }
}
