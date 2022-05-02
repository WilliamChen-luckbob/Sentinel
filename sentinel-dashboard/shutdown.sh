#bin/nash
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