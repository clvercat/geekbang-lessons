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
