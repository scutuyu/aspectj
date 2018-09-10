# learn spring

learn spring aop

## @Aspect

使用@Aspect注解将一个类标识为一个切面，
使用@Before、@AfterReturning等注解设置增强类型，
使用Aspectj的切点表达式定义切点


## maven dependencies

```
   <!-- spring -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
    </dependency>

    <!-- aspectj -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjrt</artifactId>
      <version>${aspectj.version}</version>
    </dependency>
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
    </dependency>

```

## project structure
```
├── LICENSE
├── README.md
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       └── tuyu
        │           ├── Application.java
        │           ├── NaiveWaiter.java
        │           ├── Waiter.java
        │           └── aspectj
        │               └── PreAdvise.java
        └── resources
            ├── applicationContext.xml
            └── log4j2.properties

```

## build
```
1. git clone https://github.com/scutuyu/aspectj.git
2. mvn clean compile
3. run the java file: Application.java, and you will say the before advise: How do you do?
```

## 定义一个切面
```
// 使用@Aspect注解定义一个切面
@Component
@Aspect
public class PreAdvise {

    // 前置增强，切点表达式：* hello(..) 表示所有类的hello方法，不管hello方法的参数怎样
    @Before("execution(* hello(..))")
    public void naiveWord() {
        // 增强逻辑
        System.out.println("How do you do?");
    }
}
```

## 配置AOP自动代理
```
    <!-- 包扫描 -->
    <context:component-scan base-package="com.tuyu"/>

    <!-- AOP 自动代理 -->
    <aop:aspectj-autoproxy/>
```