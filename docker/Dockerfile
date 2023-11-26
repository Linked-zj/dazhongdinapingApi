FROM arm64v8/openjdk:8

MAINTAINER Linked

# 挂载目录
VOLUME /home/dazhongdianping
# 创建目录
RUN mkdir -p /home/dazhongdianping
# 指定路径
WORKDIR /home/dazhongdianping

COPY ./jar/dazhongdianping.jar /home/dazhongdianping/dazhongdianping.jar

CMD ["--server.port=8090"]

EXPOSE 8090

ENTRYPOINT ["java","-jar","dazhongdianping.jar"]