### ７.４、使用注解实现自动装配

jdk1.5的支持的注解，Spring2.5就支持注解了！

The introduction of annotation-based configuration raised the question of whether this approach is “better” than XML.

要使用注解须知:  
1.导入约束：context约束  
2.配置注解的支持 <context:annotation-config/>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

**@Autowire**  
直接在属性上使用即可！也可以在set方法上使用！  
使用Autowire 我们可以不用编写Set方法了，前提是你这个自动装配在 IOC（Spring）容器中存在，且符合byType！

科普：

```xml
@Nullable 字段标记了这个注解，说明这个字段可以为null
```

```java
public @interface Autowired {
    /**
     * Declares whether the annotated dependency is required.
     * <p>Defaults to {@code true}.
     */
    boolean required() default true;
}

```

如果@Autowire自动装配的环境比较复杂，比如xml文件里配置了多个类型相同id不同的bean，自动装配无法通过一个注解【@Autowire】完成的时候，我们可以使用@Qualifier(value='xxx')
去配合@Autowire的使用，通过byName指定一个唯一的bean对象！

**@Resource**

```java
public class People {

    @Resource(name = 'cat2')
    private Cat cat;

    @Resource
    private Dog dog;
}
```

小结：  
@Resource和@Autowire的区别：

* 都是用来自动装配的，都可以放在属性字段上
* @Autowire 通过byType的方式实现，类型相同的话再通过byName，而且必须要求这个对象存在 【常用】
* @Resource 默认通过byname的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错！【常用】
* 执行顺序不同：@Autowire 默认通过byType的方式实现，@Resource 默认通过byname的方式实现

## 常用依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.5.RELEASE</version>
</dependency>

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```