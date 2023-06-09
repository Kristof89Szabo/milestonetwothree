## Design Patterns

<!-- TOC -->
  * [Design Patterns](#design-patterns)
    * [**Creational patterns:**](#creational-patterns)
      * [Singleton: Example](#singleton-example)
      * [Factory: Example](#factory-example)
      * [Builder: Example](#builder-example)
      * [Prototype: Example](#prototype-example)
    * [**Structural patterns:**](#structural-patterns)
      * [Decorator: Example](#decorator-example)
      * [Facade: Example](#facade-example)
      * [Flyweight: Example](#flyweight-example)
    * [**Behavioral patterns**:](#behavioral-patterns)
      * [Strategy: Example](#strategy-example)
      * [Observer: Example](#observer-example)
      * [Command: Example](#command-example)
<!-- TOC -->

Design patterns are reusable solutions to common software design problems that have been identified and documented by software developers. They are helpful in improving the overall software design, making it more modular, scalable, and maintainable. However, it is important to understand that design patterns are not a one-size-fits-all solution and should only be used when appropriate.

When to use design patterns:

- When a particular design problem has been identified and needs to be solved.
- When the software system is complex and needs to be structured in a more organized and maintainable way.
- When you want to improve the scalability and flexibility of the software system.
- When you want to improve the code reusability, reducing the overall development time and cost.
- When you want to follow best practices and well-established design principles to ensure software quality. 

When not to use design patterns:

- When the problem is simple and straightforward, and a design pattern would only add unnecessary complexity.
- When you are not familiar with the pattern and its implementation, leading to inefficient and buggy code.
- When you are blindly following a pattern without understanding its purpose and applicability to the specific problem at hand.
- When the pattern is already implemented in the programming language or framework being used.
- When the pattern creates performance overhead, leading to slower execution and increased resource consumption.


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

### **Creational patterns:**

#### Singleton: [Example](creational_design_patterns/d01singleton)

When to use it?

We have to control access to a shared resource(files, databases, thread pools, logging)

Not threadsafe but we can use synchronized keyword (slow solution) or use ENUM which compile time constants.

![img.png](../../../../resources/designpatterns/creational/img_1.png)

#### Factory: [Example](creational_design_patterns/d02factory)

- Help to create loosely coupled OOP design
- Fundamental prblem with the **new** keyword
    - "We should favor abstraction(supertypes) instead of concrete implementation"
- if we use **new** keyword - we violate this principle

![img.png](../../../../resources/designpatterns/creational/img_2.png)

![img.png](../../../../resources/designpatterns/creational/img_3.png)

#### Builder: [Example](creational_design_patterns/d03builder)

- We can use it when we have large number of variables for an entity.
- If we do not use it, maybe we have 3-4 constructor with different parameters.
- Last step is build(), after that object is immutable and it is thread safe.

![img.png](../../../../resources/designpatterns/creational/img_4.png)

![img.png](../../../../resources/designpatterns/creational/img_5.png)

#### Prototype: [Example](creational_design_patterns/d04prototype)

- Aim is to be able to copy existing object without depending on these given classes.

![img.png](../../../../resources/designpatterns/creational/img_6.png)

### **Structural patterns:**

#### Decorator: [Example](structural_design_patterns/d08decorator)

We would like to add one or more behaviors dynamically.

Problems:

- We can use inheritance to **change the behavior** of a given component.
  Problem is that inheritance is **static.**
- We can not change behaviors at **run-time.**

Solution with decorator:

- We can attach additional responsibilities to an object dynamically.
- **Flexible alternative** to subclassing and for extending functionality.
    - example: newLineNumberInputStream(new BufferedInputStream(new FileInputStream()))

#### Facade: [Example](structural_design_patterns/d06facade)

Problems:

- When we would like to deal with complicated library/framework
- Classes may become tightly coupled to the implementation of the framework or library.

Solution:

- Facade pattern can provide a relatively easy to understand interface to a rather complex system.

![img.png](../../../../resources/designpatterns/structural/img_1.png)

#### Flyweight: [Example](structural_design_patterns/d9flyweight)

We want to minimize memory usage -> sharing data with similar objects.

<u>Example:</u> in a **document** every character share the same : font, metrics etc.
We create a flyweight object and every single character refers to it.

### **Behavioral patterns**:

#### Strategy: [Example](behavioral_design_patterns/d10strategy)

- Enable selecting an algorithm at run-time.
- Define a family of algorithms, put them into a separate class, and make their objects **interchangeable**.
- We can achieve **open/close** and **dependency inversion** principles.

![img.png](../../../../resources/designpatterns/behavioral/img.png)

#### Observer: [Example](behavioral_design_patterns/d11observer)

We can achieve **loosely coupled** system. Objects can interact, but they have **little knowledge** of each other.

- Defines **one-to-many** dependency between given objects or entities.
- When object changes state all of its dependents are notified and updated automatically
- the **subject** is the object that is being monitored
- **observers**(listeners) are depending on the **subject**.

Benefits:

- We don't have to modify the subject to add new type of observers.
- We can **reuse** subjects and observers
- We can **change** the subject or observer independently.

#### Command: [Example](behavioral_design_patterns/d12command)

Interface component knows nothing about underlying **business logic** or model.
We are able to change the **sender's behavior** at run-time.

4 components of command pattern:

1. Command
2. Receiver
3. Invoker
4. Client

![img.png](../../../../resources/designpatterns/behavioral/img_1.png)

Advantages:

- Decouple classes that invoke the operations and the classes that will execute these operation.
  -> _Loosely coupled design + single responsibility._
- We can add further commands **without modifying** existing code -> _open/close principle_
- We do not have to **execute the commands immediately**. We can store these command
  in a data structure. -> _We can implement undo/redo operation_.(example: photoshop, intellij etc...)

