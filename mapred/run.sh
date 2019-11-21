#!/bin/bash

$HADOOP_PREFIX/bin/hdfs dfs -copyFromLocal test_file.txt /input/

$HADOOP_PREFIX/bin/hadoop jar $JAR_FILEPATH $CLASS_TO_RUN $PARAMS 
