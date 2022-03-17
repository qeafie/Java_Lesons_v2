package ru.shonin.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.shonin.annotations.Default;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class DefaultAnnotationPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Default.class)){
            Arrays.stream(bean.getClass().getDeclaredFields())
                    .forEach(x->{
                        Annotation annotation = x.getAnnotation(Default.class);
                        x.setAccessible(true);
                        try {
                            x.set(x,annotation.getClass().getDeclaredField("value").get(x));
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    });
        }
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(x-> x.isAnnotationPresent(Default.class))
                .forEach(x->{
                    Annotation annotation = x.getAnnotation(Default.class);
                    x.setAccessible(true);
                    try {
                        x.set(x,annotation.getClass().getDeclaredField("value").get(x));
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                });

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
