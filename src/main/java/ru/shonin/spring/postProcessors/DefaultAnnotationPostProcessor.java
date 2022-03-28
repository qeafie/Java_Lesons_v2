package ru.shonin.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.shonin.annotations.Default;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class DefaultAnnotationPostProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(x-> x.isAnnotationPresent(Default.class))
                .forEach(x->{
                    Annotation annotation = x.getAnnotation(Default.class);
                    x.setAccessible(true);

                    try {
                        if (x.get(bean)==null){
                            x.set(bean,context.getBeansOfType(x.getType()));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                });
        return bean;
    }

}
