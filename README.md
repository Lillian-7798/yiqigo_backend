# 2022夏季小学期项目——一起购团购app
本文档为后端

## 技术亮点
redis缓存数据，凌晨负载压力小时写入，实时刷新查看团购热度  
简化版智能推荐算法，依据用户信息和用户画像推荐可能感兴趣的结构
设计秒杀的算法， 用户下单秒杀产品的时候先判断是否在秒杀时间段内，是则取号，如果秒杀产品超出限额则交易失败，反之秒杀成功
