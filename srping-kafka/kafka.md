#### 配置文件
配置文件在com.fankf.springkafka.properties中

## 配置文件经常需要修改
* broker.id #每台机器必须唯一
* zookeeper.connect #根据实际情况配置，多个zookeeper必须全部加进去，用,隔开
* listeners #在配置集群的时候必须设置，不然以后的操作会报找不到leader的错误

## 集群
broker.id #每台机器必须唯一即可

#### 集群配置
集群配置只需要在每台机器上安装上面broker配置对应的server.properties文件，必须保证broker.id 唯一。

#### 操作系统调优
主要涉及到Kafka的操作系统参数包括：虚拟内存、网络子系统和磁盘挂载点。这些参数一般配置在 /etc/sysctl.conf 文件里。

#### 虚拟内存
对于大多数依赖吞吐量的应用而言，应该尽量避免内存交换。内存页和磁盘之间的交换对Kafka各方面性能都有影响。

> vi /etc/sysctl.conf

>vm.swappiness=1 #标识内存使用到99%的时候再进行交换分区。应该尽可能使用内存，而不是磁盘
vm.dirty_background_ratio=5 #当内存中的“脏数据”超过5%时，就写入磁盘
vm.dirty_ratio=60 #如果内存中的“脏数据”超过60%，新的IO将会被阻止，引起阻塞



>sysctl -p

#### 通过如下命令查看脏数据

>cat /proc/vmstat|egrep "dirty|writeback"

#### 网络优化
>vi /etc/sysctl.conf

#### socket读写缓冲区
>net.core.wmem_default=131072
net.core.rmem_default=131072
net.core.wmem_max=2097152
net.core.rmem_max=2097152

#### TCP socket读写缓冲区
>net.ipv4.tcp_wmem=4096 65536 2048000
net.ipv4.tcp_rmem=4096 65536 2048000
net.ipv4.tcp_window_scaling=1
net.ipv4.tcp_max_syn_backlog=65536
net.core.netdev_max_backlog=65536


> sysctl -p

#### 启动Kafka
> cd bin
./kafka-server-start.sh -daemon ../config/server.properties &

#### 创建Topic
> ./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ncqueue

* 上述脚本创建了1个副本（replication-factor）的topic，如果要创建3个，可以使用--replication-factor 3 。创建的副本数不能大于broker的数量。

* 分区 partitions 的数量一般是broker的数量的整数倍。

* 验证Topic是否创建成功
> ./kafka-topics.sh --list --zookeeper localhost:2181

#### Topic描述
> ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic ncqueue

* leader：负责处理消息的读和写，leader是从所有节点中随机选择的
* replicas：列出所有的副本节点，不管节点是否在服务中
* isr：列出正在服务中的副本节点

#### 发送消息
> ./kafka-console-producer.sh --broker-list localhost:9092 --topic test

执行完后，进入输入界面，输入数据即可。

#### 接收消息
> ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test

上面的命令只能获取以后的消息，如果要获取之前的消息，需要使用下面的语句：

>./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning