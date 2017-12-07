#!/bin/sh  
echo ""  
echo "----------------------------------"  
echo "start at `date '+%Y-%m-%d %H:%M:%S'` ..."  
  
JAVA_HOME=/usr/local/tools/jdk1.8.0_151
MAIN_CLASS=com.chinasofti.mall.batch.job.CancelGoodsOrdersJob
SH_DIR=/chinasofti-mall-batch/bin

echo "=====JAVA_HOME路径======"
echo "${JAVA_HOME}"
  
cd $SH_DIR  
dir="."  
temp=""  
lib="../lib/*"  
  
append(){  
  temp=$temp":"$1  
}  
  
for file in $lib 
do  
  append $file  
done  
  
export CLASSPATH=$dir:../$temp  
  
echo $CLASSPATH  
  
${JAVA_HOME}/bin/java -classpath ${CLASSPATH} ${MAIN_CLASS}  
  
  
echo "finished at `date '+%Y-%m-%d %H:%M:%S'` ..."  
exit 0