#!/bin/bash

BASE_DIR=~/btrace
BASH=/bin/bash
UNIQ_LINE=$BASE_DIR/uniq-line.jar
PID=`ps -ef | grep 'jboss.Main' | grep -v 'grep' | awk '{print $2}'`
echo $PID
BTRACE_SCRIPT=$BASE_DIR/VmClean.java

echo "java -jar $UNIQ_LINE  /bin/bash  $BASE_DIR/bin/btrace $PID $BTRACE_SCRIPT | tee log"

java -jar $UNIQ_LINE  /bin/bash  $BASE_DIR/bin/btrace $PID $BTRACE_SCRIPT | tee log