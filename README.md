# geekbang-lessons
极客时间课程工程

## 第三次作业

```text
需求一（必须）
整合 https://jolokia.org/
实现一个自定义 JMX MBean，通过 Jolokia 做 Servlet 代理
需求二（选做）
继续完成 Microprofile config API 中的实现
扩展 org.eclipse.microprofile.config.spi.ConfigSource 实现，包括 OS 环境变量，以及本地配置文件
扩展 org.eclipse.microprofile.config.spi.Converter 实现，提供 String 类型到简单类型
通过 org.eclipse.microprofile.config.Config 读取当前应用名称
应用名称 property name = “application.name”
作业提交链接： https://jinshuju.net/f/EDwozM
作业提交截至日期：3 月 17 日（含）前
```

打包

```shell
mvn -f projects/stage-0/user-platform/pom.xml clean package -U
```

运行

```shell
java -jar projects/stage-0/user-platform/user-web/target/user-web-v1-SNAPSHOT-war-exec.jar
```

http://localhost:8080