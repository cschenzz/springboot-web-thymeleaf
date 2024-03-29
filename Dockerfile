# 这里是引用的docker镜像, 我是maven项目所以是maven, 其他项目需要的镜像可以在dockerhub上找到
FROM maven
MAINTAINER chenzz<cs.chenzz@qq.com>

ENV CODE /code
ENV WORK /code/work
RUN mkdir -p $CODE \
    && mkdir -p $WORK

WORKDIR $WORK

# 这里将项目中./target/*.jar 复制到了 镜像里并命名为app.jar,  为什么是 ./target/*.jar , 因为 maven 打包后的文件就是在该路径, 如果是其他项目,填写对应路径 和名称就行了
COPY ./target/*.jar app.jar
# 暴露出项目的 8060端口, 填你项目端口即可 (没有端口可忽略)
EXPOSE 8060
# 这是运行jar的命令,  如果是其他项目, 填写对应命令就行了
CMD java -jar app.jar
