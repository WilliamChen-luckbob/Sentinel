#bin/bash
if [ $# -lt 1 ]; then
  #如果选择test环境，需要指定运行端口
  echo "需要指定运行环境 dev test prod"
  exit 1
fi

#需要停止的app id
applicationId=$(ps axu | grep "sentinel-dashboard.jar" | grep -v "grep" | awk '{print $2}')

#关闭旧的服务
if [ ! -n "$applicationId" ]; then
  echo "Sentinel Dashboard is green to start..."
else
  echo "old Sentinel Dashboard applicationId="$applicationId" is going to shutdown"
  kill -15 $applicationId
  COUNT=$( (ps -e | grep $applicationId | grep -v "grep" | wc -l))
  while [ $COUNT -gt 0 ]; do
    COUNT=$( (ps -e | grep $applicationId | grep -v "grep" | wc -l))
    sleep 0.2s
  done
  echo "Sentinel Dashboard 已经停止运行"
  echo "new Sentinel Dashboard is green to start..."
fi

#创建目录路径
logDir="/data/code/logs/sentinel/"
if [ ! -d $logDir ]; then
  sudo mkdir -p $logDir
fi

#启动服务
nohup java -jar -Dspring.profiles.active="$1" /data/sentinel/sentinel-dashboard.jar >> /data/code/logs/sentinel/sentinel-console.log &