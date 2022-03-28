package ru.shonin.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.shonin.annotations.ToString;
import ru.shonin.spring.Entity;
import ru.shonin.spring.EntityInvocationHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;
@Component
public class ToStringPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return (Entity) Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new EntityInvocationHandler((Entity) bean,Arrays.stream(bean.getClass()
                        .getDeclaredFields()).
                        filter(x->x.isAnnotationPresent(ToString.class)).
                        collect(Collectors.toList())));
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
