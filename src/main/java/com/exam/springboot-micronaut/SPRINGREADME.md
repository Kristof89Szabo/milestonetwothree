## Spring boot

Create spring boot application: www.start.spring.io

Dependency:

- spring-boot-starter-web (it includes: spring core, spring mvc, logging, tomcat, jackson etc...)

The class which holds the main method has a `@SpringbootApplication` annotation.
This is equals with `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan`.

Interfaces to look into it:

1. ApplicationContext
2. ConfigurableApplicationContext
3. ListableBeanFactory

### Bean

A bean is an object that is managed by the Spring Framework's inversion of control (IoC) container.
The IoC container is responsible for creating and managing objects (beans) in an application and injecting their
dependencies.

Beans in Spring Boot are typically defined as classes annotated
with `@Component`, `@Service`, `@Repository`, `@Controller` or `@RestController`.

These annotations indicate to the Spring IoC container that the class should be managed as a bean.

`@Bean` is another annotation in Spring Boot that is used to define a bean.
It is used to explicitly declare a bean in a configuration class. (@Configuration)

```java

@Configuration
public class MyWebConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

### Bean Life Cycle

In Spring Boot, beans have a lifecycle that goes through several phases: instantiation, initialization, and destruction.
The lifecycle is managed by the Spring container, and you can influence it by implementing specific interfaces or using
annotations.

![](../../../../resources/springboot/img.png)

Scopes:

- `Singleton` : This is the default scope. A singleton bean is created once and shared across the entire application
  context.
  Every subsequent request for the bean will receive the same instance. It is suitable for stateless or thread-safe
  beans that can be shared among multiple components.


- `Prototype` : A prototype bean is created every time it is requested from the container. Each request gets a new
  instance of the bean, allowing for independent state and behavior. It is useful for stateful beans or when you need a
  fresh instance of the bean for every request.


- `Request` : A request-scoped bean is created once per HTTP request. It ensures that each request receives its own
  instance of the bean, which is then discarded at the end of the request. This scope is typically used in web
  applications to
  maintain data specific to a particular user request.


- `Session` : A session-scoped bean is created once per user session. It ensures that each user session gets its own
  instance of the bean, maintaining state across multiple requests within the same session. This scope is commonly used
  in web
  applications that require user-specific data storage.

### ApplicationContextContainer

In the Spring Framework, an application context represents the central hub for managing the lifecycle of beans (
components) and handling their dependencies. It provides features like dependency injection, bean instantiation, and
lifecycle management.

The ApplicationContextContainer is a higher-level construct that serves as a container or holder for multiple
application context

```java
public class SpringApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringApp.class, args);

        String[] beans = context.getBeanDefinitonNames(); //Shows all beans in the container.
    }
}
```

### Dependency Injection (Inversion of Control)

Dependency injection is a core feature of the framework that allows objects to be created and wired together in a
loosely coupled manner, promoting modular design, testability, and maintainability of the codebase.

This is achieved
through the use of an inversion of control (IoC) container, which manages the creation and injection of dependencies at
runtime.

```java

@RestController
@RequestMapping("/api/content")
public class ContentController() {

    private final ContentRepository repository;

    @Autowired
    public ContentController(ContentRepository contentRepository) {
        this.repository = contentRepository;
    }

}
```

#### Types:

- `Constructor based Dependency Injection` : This is preferred. ensures that all required dependencies are provided when
  creating an object. It makes dependencies explicit and helps with easy testing and debugging.


- `Setter based Dependency Injection` : Null checks are required, because dependencies may not be set at the moment.


- `Field or Property-based Dependency Injection` : Field injection can make testing difficult since dependencies are not
  explicitly defined in the constructor or setters. It also creates tight coupling between classes, making the code less
  maintainable and harder to understand.

If we hava an injection (interface for example) with more than one implementation,
we can tell spring to use one of them with `@Qualifier`.

Example:

```java

public interface PaymentGateway {
    // ...
}

@Component
@Qualifier("paypal")
public class PaypalGateway implements PaymentGateway {
    // ...
}

@Component
@Qualifier("stripe")
public class StripeGateway implements PaymentGateway {
    // ...
}

@Component
public class PaymentService {
    private final PaymentGateway paymentGateway;

    @Autowired
    public PaymentService(@Qualifier("paypal") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // ...
}
```

### Richardson Maturity Model

The maturity of RESTful services based on their architectural constraints and level of adoption of REST principles.

- Level 0: The Swamp of POX (Plain Old XML)
  At this level, services are not designed following REST principles. They often use XML as the data format.
  Typically, uses one URI and one kind of method. (GET)


- Level 1: Resources
  Level 1 introduces the concept of resources, where each resource has a unique identifier (URI) and can be accessed
  using simple HTTP methods such as GET, POST, PUT, and DELETE.
  However, the communication style is still predominantly RPC-based, and the resources may not fully utilize the
  capabilities of the HTTP protocol.
  Still uses a single method (ie GET)

  Examples:

    - http://www.example.com/product/1234
    - http://www.example.com/product/5687


- Level 2: HTTP Verbs
  Level 2 focuses on leveraging the full power of HTTP by utilizing the appropriate HTTP methods (GET, POST, PUT,
  DELETE) for different operations on resources.
  It emphasizes the use of self-descriptive messages and hypermedia links (HATEOAS)
  to enable clients to discover and navigate the API dynamically.


- Level 3: Hypermedia Controls
  At Level 3, also known as "HATEOAS" (Hypermedia as the Engine of Application State), the API provides hypermedia
  controls in responses.
  These controls include links and other metadata that guide clients on how to interact with the
  API dynamically. Clients can navigate through the API by following these hypermedia links without prior knowledge of
  the API structure.

![](../../../../resources/springboot/img_1.png)

### Data Validation

Spring ha a build in validation framework (package `javax.validation`). Our goal to validate early as possible
(controller layer).

Validation annotation:

- @NotNull: Ensures that a field is not null.
- @NotEmpty: Checks that a string, collection, or array is not empty.
- @NotBlank: Validates that a string is not null, empty, or contains only whitespace characters.
- @Min: Specifies the minimum value for numeric fields.
- @Max: Specifies the maximum value for numeric fields.
- @Size: Defines the size constraints for a string, collection, or array.
- @Pattern: Matches a field value against a regular expression pattern.
- @Email: Validates that a string is a well-formed email address.
- @Valid: Triggers the validation of nested objects or collections.

To use data validation in Spring Boot, you need to enable it in your application configuration by adding the @Validated
annotation to your controller class or method.

When a validation error occurs, Spring Boot automatically generates a MethodArgumentNotValidException and sends a
response with an appropriate error message and status code. You can customize the error handling by defining an
exception handler method using the @ExceptionHandler annotation.

Example:

```java

@RestController
@Validated
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Process the user data
        return ResponseEntity.ok("User created successfully");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        // Handle validation errors and return a custom response
        return ResponseEntity.badRequest().body("Validation error: " + ex.getMessage());
    }
}

public class User {

    @NotNull
    private String name;

    @Email
    private String email;

    // Getters and setters
}
```

### Security

- `Basic Authentication` is a simple authentication mechanism where the client sends a username and
  password as part of the HTTP request headers. The server validates the credentials and grants or denies access to the
  protected resources based on the provided information.

  The header's value should be in the format Basic <base64-encoded-credentials>. For example, Authorization: Basic
  QWxhZGRpbjpPcGVuU2VzYW1l. The credentials are the username and password encoded in Base64 format.

  Do not use this with HTTP just only with HTTPS, but there is better and secured modes for security.

- `Role-based authentication` : is an approach to managing access control in computer systems and
  applications. It provides a way to restrict system resources and functionalities based on the roles assigned to
  individual users.

#### Cross-site request forgery

![](../../../../resources/springboot/img_2.png)

In a CSRF attack, the attacker crafts a malicious website or an email containing a link to a malicious website. When the
victim visits this website, it may contain hidden code or scripts that make requests to the targeted website on behalf
of the victim. These requests can be actions like changing account settings, making purchases, or even initiating
financial transactions, depending on the privileges of the victim's account.

To defend against CSRF attacks, web developers can implement various countermeasures:

Using `anti-CSRF tokens`: Developers can include unique, random tokens in each form or request that modifies data on the
website. These tokens are validated on the server side to ensure that the request originated from a legitimate source.

### Object-relational mapping : ORM

The idea behind it: We can convert an object to a row in a database.

The `JPA` (Java Persistence API) specification is a Java specification that defines a standard way to manage relational
data in Java applications. It provides a set of interfaces, classes, and annotations that outline the rules and
guidelines for Object-Relational Mapping (ORM) in Java.

`Hibernate` is an open-source object-relational mapping (ORM) framework that implements the JPA specification. It is one
of the most widely used implementations of JPA and provides additional features beyond what is specified by JPA.
Hibernate simplifies the development of database-driven applications by handling the mapping between Java objects and
database tables automatically.

Useful annotation:

- @Entity(name="something") :  The name attribute in the @Entity annotation is used to specify the name of the entity in
  the database.

  By default, Hibernate will use the name of the Java class as the entity name in the database.


- @GeneratedValue : s used in Hibernate to specify the strategy for generating primary key values for entities.


- @Column(length=1000) : length = 1000 means that the corresponding column can store up to 1000 characters or bytes (
  instead of 255 base length), depending on the underlying database's character encoding.


- @Column(columnDefinition = "TEXT") : Change the column definition from `VARCHAR` to `TEXT`. Text can hold any length
  of characters.

### SQL s JPQL

SQL is a powerful and flexible query language for interacting with relational databases at a low level, while JPQL is a
higher-level language specific to JPA and object-oriented models. JPQL provides a more object-oriented approach to
querying and works with entities and relationships defined in the ORM framework.

SQL:

- Syntax : SQL is a standard query language used to interact with relational databases. It has a specific syntax and set
  of
  keywords for performing operations like selecting, inserting, updating, and deleting data.

- Database vs. Object-Relational Mapping : SQL operates directly on the database tables, columns, and rows. It is a
  powerful and flexible language that allows
  you to perform complex operations and aggregations on the database level.

- Portability : SQL is a widely supported and standard query language that can be used with various databases. However,
  each database may have its own specific dialect and extensions, leading to some differences in syntax and behavior.

JPQL:

- Syntax : JPQL is a query language specific to Java Persistence API (JPA) and is designed to work with object-oriented
  models.
  JPQL syntax is similar to SQL but with some differences to accommodate object-oriented concepts.

- Database vs. Object-Relational Mapping : JPQL operates at a higher level of abstraction. It works with entities, their
  attributes, and relationships defined in the object-relational mapping (ORM) framework, such as Hibernate. JPQL
  queries are translated
  into SQL queries by the JPA provider, which handles the mapping between objects and the database.

- Portability: JPQL is specific to JPA and is designed to be database-agnostic. It allows you to
  write queries that can be executed on different databases without modification, as long as the underlying JPA provider
  supports the database.