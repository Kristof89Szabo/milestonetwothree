## Design Patterns

<u>Design Principles</u>:

- high-level guidelines
- pure abstractions - without implementation
- any programming language
- platform independent

<u>Design Patterns</u>:

- Low-level solutions OOP related problems
- concrete implementation
- Several design principle can be **implemented by design patterns**

![img.png](../../../../resources/designpatterns/img.png)

### Creational patterns:

**Singleton**: [Example](creational_design_patterns/d01singleton/SingletonExample.java)

When to use it?

We have to control access to a shared resource(files, databases, thread pools, logging)

Not threadsafe but we can use synchronized keyword (slow solution) or use ENUM which compile time constants.

![img.png](../../../../resources/designpatterns/creational/img_1.png)

**Factory**: [Example](creational_design_patterns/d02factory/FactoryPatternExample.java)

- Help to create loosely coupled OOP design
- Fundamental prblem with the **new** keyword
    - "We should favor abstraction(supertypes) instead of concrete implementation"
- if we use **new** keyword - we violate this principle

![img.png](../../../../resources/designpatterns/creational/img_2.png)

![img.png](../../../../resources/designpatterns/creational/img_3.png)

**Builder**: [Example](creational_design_patterns/d03builder/BuilderPatternExample.java)

- We can use it when we have large number of variables for an entity.
- If we do not use it, maybe we have 3-4 constructor with different parameters.
- Last step is build(), after that object is immutable and it is thread safe.

![img.png](../../../../resources/designpatterns/creational/img_4.png)

![img.png](../../../../resources/designpatterns/creational/img_5.png)

**Prototype**: [Example](creational_design_patterns/d04prototype/PrototypePatternExample.java)

- Aim is to be able to copy existing object without depending on these given classes.

![img.png](../../../../resources/designpatterns/creational/img_6.png)

### Structural patterns:

**Decorator**: [Example](structural_design_patterns/d08decorator)

We would like to add one or more behaviors dynamically.

Problems:

- We can use inheritance to **change the behavior** of a given component.
  Problem is that inheritance is **static.**
- We can not change behaviors at **run-time.**

Solution with decorator:

- We can attach additional responsibilities to an object dynamically.
- **Flexible alternative** to subclassing and for extending functionality.
    - example: newLineNumberInputStream(new BufferedInputStream(new FileInputStream()))

**Facade**: [Example](structural_design_patterns/d06facade)

Problems:

- When we would like to deal with complicated library/framework
- Classes may become tightly coupled to the implementation of the framework or library.

Solution:

- Facade pattern can provide a relatively easy to understand interface to a rather complex system.

![img.png](../../../../resources/designpatterns/structural/img_1.png)


**Flyweight**: [Example](structural_design_patterns/d9flyweight)

We want to minimize memory usage -> sharing data with similar objects.

<u>Example:</u> in a **document** every character share the same : font, metrics etc.
We create a flyweight object and every single character refers to it.

