1、这是一版纯含有配置文件的springboot集成、操作redis的干净架子
2、这个版本内含对项目整体异常的处理，自定全据异常拦截，并以
{
     "resultCode": "100",
     "resultMsg": "参数校验错误"
}   
上述格式向前端输出


主流应用
    应用层---缓存层---数据库层
    穿透--缓存层没有数据，穿过缓存层到数据库层查询
    熔断技术--如果数据库挂掉，那么应用层的请求都打在redis缓存上，无论有没有数据，都返回应用层
缓存中间件
    Memcache和redis
    Memcache：支持简单数据类型，不支持数据持久存储，不支持主从、分片--简单选择
    redis：丰富、主从、持久、分片
redis
    QPS==100000+   每秒内查询的次数   
    完全基于内存，纯粹得内存操作
    数据结构简单  hashmap==操作和查找都是O（1）
    单线程--处理高并发，也可以启动多实例
    多路复用I/O，非阻塞I/O
    根据不同环境选择不同函数
        epoll/kqueque/evport/select,保底是select
        因地制宜，优先选择时间复杂度为O（1）得I/O多路复用得函数作为底层实现。以select保底==O（n）
redis数据类型
    string：key/value键值对，最大存储512M  
        底层动态字符串sdshdr==len已占用空间 free空闲空间  buf数据空间 
    hash：string元素组成得字典，适用于存储对象    
        hmset 类名   字段  字段值      hget   hset 
    list:列表，按照String元素插入得顺序排序
        lpush 列表名 值    lpop 列表名 值 后进先出 40亿
    set:不允许重复，无序
        sadd setname 值   遍历members setname  
海量数据取一固定前缀
    数据规模==边界 
    scan curson [Match pattern] [Count count]
        返回得数据量不一定跟count指定得一样， 有可能返回得数据其实游标会相同 
分布式锁
    
        
 
    
    
