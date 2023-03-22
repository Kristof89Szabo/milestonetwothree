### OCP - Open-Close Principle

Software components should be close for modification, but open for extension.

**Closed for:**
New features getting added to the software component,
should NOT have to modify existing code.

**Open for:**
A component should be extendable to add a new feature or
to add a new behavior to it. 

![img.png](../../../../../resources/solid/o/img.png)
This is not good practise. If we want to add new insurance we have to modify the discount calculator.

![img.png](../../../../../resources/solid/o/img_1.png)
Better if we introduce an interface.

Benefits:
- Easier to add new features.
- Leads to minimal cost of developing and testing software.