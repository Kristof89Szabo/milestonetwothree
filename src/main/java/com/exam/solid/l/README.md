### LSP - Liskov Substitution Principle

Objects should be replaceable with their subtypes without affecting the correctness of the program.

![img.png](../../../../../resources/l/img.png)
Hidden problems here with the bird.
- Bird can fly but Ostrich can not fly. So LSP

Another example:

  ![img.png](../../../../../resources/solid/l/img_1.png)
- The third iteration will fail.

How we can fix this?
- Break the hierarchy.
- Introduce a new "parent"(vehicle).

  ![img.png](../../../../../resources/solid/l/img_2.png)

One more:

  ![img.png](../../../../../resources/solid/l/img_3.png)

How we can fix this?
- "Tell, do not ask".

![img.png](../../../../../resources/solid/l/img_4.png)

