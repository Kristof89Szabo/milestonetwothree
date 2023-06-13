## Micronaut

Micronaut is a modern, lightweight, and full-stack framework for building microservices and serverless applications in
Java, Kotlin, and Groovy.

Features:

- Dependency Injection
- Ahead-of-Time : AoT analyzes the application's code and dependencies at compile time.
- Reactive Support
- Cloud-Native Capabilities

### Bean

A bean is an object whose lifecycle is managed by the Micronaut IoC container. That lifecycle may include creation,
execution, and destruction.

`@PostConstruct` and `@PreDestroy ` are used to define lifecycle callbacks for beans. These annotations allow you to
execute specific code after its initialization (@PostConstruct) or before the destruction of a bean (@PreDestroy).

TheBeanContext abstraction which allows for dependency injection of classes annotated with `@Inject`.

To look up the beans you can use:

```java
final BeanContext context=BeanContext.run();
        CLAZZ clazz=context.getBean(CLAZZ);
```

If a class implements an interface, other class can choose to either inject the interface or the concrete
implementation.

To avoid this, we can use `@Bean(typed = CLAZZ)` annotation to limit the exposed types.

```java

@Singleton
@Bean(typed = Engine.class)
public class V8Engine implements Engine {
    @Override
    public String start() {
        return "Starting V8";
    }

    @Override
    public int getCylinders() {
        return 8;
    }
}
```

(If we try to create a `V8Engine` it will throw NoSuchBeanException exception)

Scopes:

- `Singleton` : singleton pattern for bean
- `Prototype` : a new instance of the bean is created each time it is injected. It is a synonym for `@Bean` because the
  default scope is prototype.
- `ThreadLocal` : is a custom scope that associates a bean per thread via a ThreadLocal
- `Context` : a bean is created at the same time as the ApplicationContext
- `Infrastructure` : the @Context bean cannot be replaced
- `Refreshable` : a custom scope that allows a bean’s state to be refreshed via the /refresh endpoint

[Documentation](https://docs.micronaut.io/latest/guide/#scopes)
[BLOG](https://piotrminkowski.com/2019/04/15/micronaut-tutorial-beans-and-scopes/)

Extra:

The ApplicationContext extends a BeanContext and adds the concepts of configuration, environments.
The entry point for IoC is the Application context interface, which includes a run method.

### Micronaut Configuration

By default, Netty runs on 8080. We can configure it in `application.yml`

```yaml
micronaut:
  server:
    port: 8100
```

### Micronaut Validation

To be able to perform HTTP requests validation we should first include the following dependencies to our `pom.xml`:

```xml

<dependency>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-validation</artifactId>
</dependency>
<dependency>
<groupId>io.micronaut.configuration</groupId>
<artifactId>micronaut-hibernate-validator</artifactId>
</dependency>
```

- @Validated will validate parameters on class level.

- @Valid on method level.

```java

@Validated
@Controller("/email")
public class EmailController {

    @Post("/send")
    public HttpResponse send(@Body @Valid Email email) {
        return HttpResponse.ok(Collections.singletonMap("msg", "OK"));
    }
}

```

Extra: We may configure validation using URI templates. The annotation @Get("/{id:4}") indicates that a variable can
contain 4 characters max (is lower than 10000).

Most common micronaut validation annotations:
Micronaut is a modern JVM-based framework for building microservices and serverless applications. When it comes to
validation, Micronaut provides support for data validation using annotations from the `javax.validation` package. Here
are some of the most common Micronaut validation annotations:

- `@NotNull`: This annotation is used to mark a field or parameter as not nullable.


- `@NotBlank`: It is used to validate that a string field or parameter is not null or empty and contains at least one
  non-whitespace character.


- `@Size`: This annotation is used to validate the size of a collection, array, or string field or parameter. It can
  specify the minimum and maximum size allowed.


- `@Min` and `@Max`: These annotations are used to validate that a numeric field or parameter is greater than or equal
  to a minimum value (`@Min`) or less than or equal to a maximum value (`@Max`).


- `@Pattern`: This annotation is used to validate that a string field or parameter matches a specific regular expression
  pattern.


- `@Email`: It is used to validate that a string field or parameter represents a valid email address.

These are some of the commonly used validation annotations in Micronaut. There may be other annotations available
depending on the specific needs and dependencies of your application.

## Security

We have to include dependency for security:

```xml

<dependency>
    <groupId>io.micronaut</groupId>
    <artifactId>micronaut-security</artifactId>
</dependency>
```

and enable in application yml:

```yaml
micronaut:
  security:
    enabled: true
```

Once you enable Micronaut security, Basic Auth is enabled by default.

Rules:

- ` @Secured(SecurityRule.IS_ANONYMOUS)`
- `@Secured(SecurityRule.IS_AUTHENTICATED)` : If we put this to class level, the whole controller it is available only
  for
  succesfully authenticated users. This can be overriden by method level (`@Secured(ADMIN)`).

### HTTPS

Micronaut by default starts the server with disabled SSL. However, it supports HTTPS out of the box.

[Documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/)
[BLOG](https://piotrminkowski.com/2019/04/25/micronaut-tutorial-security/)

### Test

`@MicronautTest` is running your REAL application and starts the application context and injects all the beans.

@MicronautTest annotation will replace this kind of repetitive code.

```java
@Test
public void testHelloEndpoint(){
        EmbeddedServer server=ApplicationContext.run(EmbeddedServer.class);
        HttpClientConfiguration configuration=server.getApplicationContext().getBean(HttpClientConfiguration.class);
        HttpClient client=RxHttpClient.create(server.getURL(),configuration);

        HttpRequest<?> request=HttpRequest.GET("/hello");
        String response=client.toBlocking().retrieve(request);
        assertEquals("Hello World",response);
        }
```

Pros:

- Automatic start/stop EmbeddedServer (refers to the server that was started up for this test suite) and
  ApplicationContext.
- Automatic Bean Injection
- @MockBean : his annotation tells Micronaut to replace the bean of type `CLAZZ` with a mock implementation.
- TestPropertyProvider
- @Property

Cons:

- Everything is automatic -> Less Control.
