# Guide
## Features
- [Traces]
- [Metrics]

## Tech
Project trên sử dụng các công nghệ như Java, framework Spring boot, Mysql, OpenTelemetry:
- [Java] - Java Programing!
- [Spring boot] - Framework of Java
- [Mysql] - Relational database.
- [OpenTelemetry] - OpenTelemetry is an Observability framework and toolkit designed to create and manage telemetry data such as traces, metrics, and logs

## Dependencies
Inject các dependency như trong file application.properties.

Tạo file configuration trong ứng dụng Java Spring boot.
Sau đó sử dụng Aspect trong Spring boot để theo dõi toàn bộ API trong phần controller. Trong [Aspect], sẽ có 2 phần đó là After và Before
- Before: Toàn bộ những gì cần cấu hình trước khi gọi request
- After: Toàn bộ những gì cần cấu hình sau khi request được gọi (statude_code, exception, ...)

## Installation

- Clone project from Gitlab

- Tạo Database và áp dụng vào file application.application.properties

- Run project

- Trong Table role, tạo 2 role đó là
    - ROLE_USER
    - ROLE_ADMIN

- Sử dụng Postman hoặc curl để gọi API kiểm tra các Trace và Metrics.

- Các thông số sẽ được hiển thị qua console và được lưu trữ trong folder logs. Ngoài ra, có thể kiểm tra các thông số thông qua bên thứ 3 như [Prometheus], [Jaeger], [Zipkin], ....

## License

[Java]: <https://docs.oracle.com/en/java/>
[Spring boot]: <https://spring.io/projects/spring-boot/>
[Mysql]: <https://www.mysql.com/>
[OpenTelemetry]: <https://opentelemetry.io/docs/instrumentation/java/>
[Jaeger]: <https://www.jaegertracing.io/>
[Zipkin]: <https://zipkin.io//>
[Prometheus]: <https://prometheus.io/>
[Aspect]: <https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html/>
[Traces]: <https://opentelemetry.io/docs/concepts/signals/traces//>
[Metrics]: <https://opentelemetry.io/docs/concepts/signals/metrics//>
