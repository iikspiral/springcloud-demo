## @EnableBinding
用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道（Channel）的绑定

访问应用的`/actuator/beans`端点，看看当前Spring上下文中有哪些Bean

## 死信队列

场景一：有些消息在业务上存在时效性，进入死信队列之后，过一段时间再处理已经没有意义，这个时候如何过滤这些消息呢？

只需要配置一个参数即可：

```
spring.cloud.stream.rabbit.bindings.example-topic-input.consumer.dlq-ttl=10000
```
该参数可以控制DLQ队列中消息的存活时间，当超过配置时间之后，该消息会自动的从DLQ队列中移除。

场景二：可能进入DLQ队列的消息存在各种不同的原因（不同异常造成的），此时如果在做补救措施的时候，还希望根据这些异常做不同的处理时候，我们如何区分这些消息进入DLQ的原因呢？

再来看看这个参数：
```
spring.cloud.stream.rabbit.bindings.example-topic-input.consumer.republish-to-dlq=true
```
该参数默认是false，如果设置了死信队列的时候，会将消息原封不动的发送到死信队列，
此时大家可以在RabbitMQ控制台中通过Get message(s)功能来看看队列中的消息，这样就可以
根据异常类型去处理不同的业务。