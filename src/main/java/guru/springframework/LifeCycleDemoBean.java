package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// There is no setting of properties
@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean,
        BeanNameAware, BeanFactoryAware, ApplicationContextAware{

    // #1 initialization
    public LifeCycleDemoBean(){
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    // #3 BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    // #2 BeanNameAware
    @Override
    public void setBeanName(String s) {
        System.out.println("## My Bean Name is: " + s);
    }

    // # destory of DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle bean has been terminated");
    }

    // #7 afterPropertiesSet of InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");
    }

    // #4 ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    // #6 post construct
    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    // #9 Pre destroy
    @PreDestroy
    public void preDestroy(){
        System.out.println("## The Predestroy annotated method has been called");
    }

    // #5 BeanPostProcessor Pre-initialization
    public void beforeInit(){
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    // #8 BeanPostProcessor Post-initialization
    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor");
    }
}
