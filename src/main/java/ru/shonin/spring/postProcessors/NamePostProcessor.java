package ru.shonin.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
@Component
public class NamePostProcessor  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field field;
        try {
            field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            if (field.getType().equals(String.class) && field.get(bean) == null ){
                field.set(bean,"vasia");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return bean;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
