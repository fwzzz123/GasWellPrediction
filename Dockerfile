# 使用包含 OpenJDK 8 的基础镜像
FROM openjdk:8-jdk-slim

# 设置工作目录
WORKDIR /app

# 将打包好的 JAR 文件复制到容器中
COPY MavenTest-1.0-SNAPSHOT.jar app.jar

# 暴露 Spring 应用的端口，根据实际情况修改
EXPOSE 8080

# 启动 Spring 应用
CMD ["java", "-jar", "app.jar"]