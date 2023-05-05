## Spring boot

Create spring boot application: www.start.spring.io

Dependency:

- spring-boot-starter-web (it includes: spring core, spring mvc, logging, tomcat, jackson etc...)


Interfaces to look into it:
1. ApplicationContext
2. ConfigurableApplicationContext
3. ListableBeanFactory

### Bean

A bean is an object that is managed by the Spring Framework's inversion of control (IoC) container.
The IoC container is responsible for creating and managing objects (beans) in an application and injecting their
dependencies.

Beans in Spring Boot are typically defined as classes annotated with `@Component`, `@Service`, `@Repository`,
or `@Controller`.
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
        this.repository=contentRepository;
    }
    
}
```

 ### Useful Annotations

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PathVariable
- @RequestParam
- @RequestBody
- @ResponseStatus

### Cross Origin

//TODO


