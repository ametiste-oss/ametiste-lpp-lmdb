# Ametiste L-Platform LMDB Protocol

[>>> Ametiste L-Platform Protocols Hub <<<](https://github.com/ametiste-oss/ametiste-lpp)

### Overview

_Lmdb Protocol_ provide interface to interact with LMDB databases.

Default implementation uses JNI Library and contains precompiled versions for Linux (64-bit) and Mac OS X (64 bit). 

### Configuration

Protocol can be added using Starter module.
```java
dependencies {
   compile("org.ametiste.lpp:lpp-lmdb-starter:${protocolVersion}")
}
```

### Example of usage

```java
@RoutineTask
@SchemeMapping(schemeName = "someTask")
public class DummyTask {

    @Connect
    private LmdbConnectorProtocol protocol;

    @TaskOperation
    public void printData(@OperationParameter("path") String path) {
        try (LmdbIterator iter = protocol.iterate(path)) {
            iter.forEachRemaining(System.out::println);
        }
    }

}
```
