### Reactive Programming

Simplify **Clean Coding** of **Asynchronous Event-Driven** programs.

Interactive site: https://rxmarbles.com/

![img](../../../../../main/resources/reactive/img.png)

<u>Examples analogy</u>:

- **Sync+blocking**:If I call a company, and it put me hold.
- **Async**: If I ask my friend to call the same company. They put him to hold, but I can work.
- **Non-blocking**: I call the company, they will know my phone number, and they will call me back, so I don't need to
  wait.
- **Non-blocking+async**: Ask a friend to call the company, but register for call back. So he does not need to wait as
  well.

Reactive programming gives us an abstraction to read and write like **sync+blocking** code but behind a *
*Non-blocking+async** happens.

#### Stream vs Reactive

The core difference is that Reactive is a push model, whereas the Java 8 Streams are a pull model. In a reactive approach,
events are pushed to the subscribers as they come in.


#### Terminologies

- Publisher
    - Source
    - Observable
    - Upstream
    - Producer
- Subscriber
    - Sink
    - Observer
    - Downstream
    - Consumer

Reactor Publisher has 2 implementation:

1. Mono
2. Flux

### Mono

- It emits **0 or 1** item
- Followed by an onComplete / onError.

#### Why use mono?

If we definitely know we are waiting 1 thing from publisher.

[Example basic codes](r01mono)

![](../../../../resources/reactive/img_1.png)

### Flux

It is a stream of **Objects**. And everything in the stream is a "message";

![](../../../../resources/reactive/img_3.png)

![](../../../../resources/reactive/img_4.png)

- It emits **0 or N** item
- Subscriber needs to be attached to the Flux through subscriber method.
- Followed by an onComplete / onError. (Terminal events)

````java

flux.subscribe(
        value->handleHappyPath(value),
        error->handleError(error),
        ()->handleCompletion()
)

````

**Cold Flux/Publisher:** For every subscriber, the items start from the beginning.

**Hot Flux/Publisher**: Does not publish from the beginning. Instead, the values keep on going independently.
Any subscriber joining will get the same value that all others do.

![](../../../../resources/reactive/img_2.png)

### Flux - Emitting Items Programmatically

- **create:**

  The create() method in Flux is used when we want to calculate multiple (0 to infinity) values that are not influenced by the application's state. This is because the underlying method of the Flux create() method keeps calculating the elements.
- **generate:** 

  The generate method calculates and emits the values on demand. It is preferred to use in cases where it is too expensive to calculate elements that may not be used downstream.

