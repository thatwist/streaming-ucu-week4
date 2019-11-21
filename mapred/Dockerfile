FROM bde2020/hadoop-base:2.0.0-hadoop2.7.4-java8

COPY test_file.txt test_file.txt
COPY target/scala-2.12/mapred-assembly-0.1.jar /opt/hadoop/applications/WordCount.jar

ENV JAR_FILEPATH="/opt/hadoop/applications/WordCount.jar"
ENV CLASS_TO_RUN="ua.ucu.edu.WordCount"
ENV PARAMS="/input /output"

ADD run.sh /run.sh
RUN chmod a+x /run.sh

CMD ["/run.sh"]
