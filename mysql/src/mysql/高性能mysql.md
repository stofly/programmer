数据库（mysql）
	内连接
		关键字：inner join on
		语句：select * from a_table a inner join b_table bon a.a_id = b.b_id;
		意义：取交集部分（阴影部分）
	左连接（左外连接）
		关键字：left join on / left outer join on
		语句：select * from a_table a left join b_table bon a.a_id = b.b_id;
		意义：left join 是left outer join的简写，它的全称是左外连接，是外连接中的一种。左(外)连接，左表(a_table)的记录将会全部表示出来，而右表(b_table)只会显示符合搜索条件的记录。右表记录不足的地方均为NULL。
	右连接（右外连接）
		关键字：right join on / right outer join on
		语句：select * from a_table a right outer join b_table b on a.a_id = b.b_id;
		意义：right join是right outer join的简写，它的全称是右外连接，是外连接中的一种。与左(外)连接相反，右(外)连接，左表(a_table)只会显示符合搜索条件的记录，而右表(b_table)的记录将会全部表示出来。左表记录不足的地方均为NULL。
	查看mysql查询计划
		explain +sql语句
	mysql
		三层
			客户端：连接处理、认证、授权
			中间层（连接、线程处理、解析器、触发器、视图等）：解析、分析、优化、缓存
			存储引擎层：不会互相通信
		缓存机制：
			执行语句时，先看看有没有执行过，如果有就直接走缓存
		数据库锁：
			共享锁（读锁）：多人使用
			排他锁（写锁）：一人使用并防止其他用户读取正在写入的同一资源
			表锁：基本策略，开销最小，锁定整张表，一个user对表进行写操作会阻塞其他用户对的该表的所有读写操作，读的时候无此现象
		备注：
			1、锁少，并发程度高，锁需要修改的资源，但是加锁也消耗资源，一般在表上加行级锁
			2、每种mysql引擎都可以实现自己的锁策略和锁粒度
			3、特定场所表锁有良好的性能，写锁比读锁有更高的级别且写锁可以插到队列中读锁的前面
			4、存储引擎可以管理自己的锁，但是mysql本身还是会使用各种有效的表锁来实现自己的目的
		数据库事物
			ACID
			原子：一致：隔离：持久：
			死锁检测、死锁超时机制
			1、存储引擎检测死锁，返回错误
			2、查询等待超出锁等待时间放弃锁请求
			3、持有最少行级排他锁的事务进行回滚