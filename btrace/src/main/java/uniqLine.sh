#!/bin/bash

java -classpath . UniqLine  ~/btrace/bin/btrace  `ps -ef | grep jboss.Main | awk '{print $2}'` com/taobao/wireless/VmClean.java | tee log
