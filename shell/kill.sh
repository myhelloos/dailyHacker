#!bin/bash
PID=$(lsof -i:9001 | tail -1 | awk '{print$2}')
if [ -n ${PID+x} ] ; then 
    kill -9 $PID;
fi


