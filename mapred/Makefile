DOCKER_NETWORK = dockerhadoop
ENV_FILE = hadoop.env
VERSION = 2.0.0-hadoop2.7.4-java8

wordcount:
	cd .. && sbt mapred/assembly
	docker build -t hadoop-wordcount .
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -rmr /input || true
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -rmr /output || true
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -mkdir -p /input/
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} hadoop-wordcount
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -cat /output/*
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -rm -r /output
	docker run --network ${DOCKER_NETWORK} --env-file ${ENV_FILE} bde2020/hadoop-base:${VERSION} hdfs dfs -rm -r /input
