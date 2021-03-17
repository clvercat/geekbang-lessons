# geekbang-lessons

极客时间课程工程

## 打包

```shell
mvn -f projects/stage-0/user-platform/pom.xml clean package -U
```

## 运行

```shell
java -jar projects/stage-0/user-platform/user-web/target/user-web-v1-SNAPSHOT-war-exec.jar
```

## 第三次作业

### 实现一个自定义 JMX MBean，通过 Jolokia 做 Servlet 代理

#### 添加依赖

```xml
<dependency>
    <groupId>org.jolokia</groupId>
    <artifactId>jolokia-core</artifactId>
    <version>1.6.2</version>
</dependency>
```

#### 添加 servlet 配置

```xml
<servlet>
    <servlet-name>jolokia-agent</servlet-name>
    <servlet-class>org.jolokia.http.AgentServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>jolokia-agent</servlet-name>
    <url-pattern>/jolokia/*</url-pattern>
</servlet-mapping>
```

#### 自定义 MBean

`org.geektimes.projects.user.jmx.Custom`

#### 注册

```java
try {
    ObjectName objectName=new ObjectName(
    "org.geektimes.projects.user.jmx:type=test,name=custom");
    MBeanServer server=ManagementFactory.getPlatformMBeanServer();
    Custom custom=new Custom();
    custom.setName("Jack");
    custom.setAge(10);
    custom.setNote("hello world");
    server.registerMBean(custom,objectName);
} catch(Exception e) {
  // todo
  e.printStackTrace();
}
```

#### 查看自定义 MBean 所有属性

```shell
curl -XGET http://localhost:8080/jolokia/read/org.geektimes.projects.user.jmx:name=custom,type=test
```

返回

```json
{
  "request": {
    "mbean": "org.geektimes.projects.user.jmx:name=custom,type=test",
    "type": "read"
  },
  "value": {
    "Note": "hello world",
    "Age": 10,
    "Name": "Jack"
  },
  "timestamp": 1615972985,
  "status": 200
}
```

#### 修改 MBean name 属性

```shell
curl -XGET 'http://localhost:8080/jolokia/write/org.geektimes.projects.user.jmx:name=custom,type=test/Name/James'
```

返回

```json
{
  "request": {
    "mbean": "org.geektimes.projects.user.jmx:name=custom,type=test",
    "attribute": "Name",
    "type": "write",
    "value": "James"
  },
  "value": "Jack",
  "timestamp": 1615973045,
  "status": 200
}
```
