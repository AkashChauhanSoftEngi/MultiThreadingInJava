# MultiThreadingInJava

* This Directory includes main and Important features of Multithreading in Java
* Also includes respective examples with proper java code
* Ref: https://www.youtube.com/watch?v=hlK-ca64VI4&list=PLzS3AYzXBoj8jq5o5qolE4Kki19j1UrS8&index=1

## Ways to create thread safety
* Use predefined thread safe Classes like
  - The only two legacy collections are thread-safe
    - Vector {List}
    - Hashtable {Map}
  - Classes inside java.util.concurrent; package
    - ConcurrentHashMap {ConcurrentMap}
    - ConcurrentNavigableMap {ConcurrentMap}
    - ....
    
* Variable
  - Mark it final
  - Mark it voletile
  - Use Atomic wrapper classes {Inside java.util.concurrent.atomic... package}
  
* Methods
  - Mark it as synchronized

* Class
  - Make it truly immutable {use private fields only}
  - Make fields number volatile
  - Use a synchronized block
  - use Concurrent classes for conversion, if relevant classes exist
    - {Inside java.util.concurrent... package}
