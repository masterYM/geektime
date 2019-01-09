# geektime
#### 数组（Array）是一种线性表数据结构。它用一组**连续的内存空间**，来存储一组具有**相同类型**的数据
#### 除了数组，链表、队列、栈等也是线性表结构
#### 计算机会给每个内存单元分配一个地址 ，计算机通过地址来访问内存中的数据 。寻址公式：a[i]_address = base_address + i * data_type_size
#### 数组支持随机访问，根据**下标随机访问**的时间复杂度为O(1)
#### 数组为了保持内存数据的连续性，会导致插入、删除这两个操作比较低效
#### 删除a、b、c为了避免d、e、f、g、h这几个数据会被搬移三次，我们可以先记录已经删除的数据，每次删除操作并不是真正地搬移数据，只是记录数据已经被删除。
#### **当数组没有更多空间存储数据时，再触发执行一次真正的删除操作**
#### ArrayList优势：1、可以将很多数组操作的细节封装起来，插入，删除。。2、动态扩容
#### 扩容操作涉及内存申请和数据搬移，是比较耗时的。所以，如果事先能确定需要存储的数据大小，最好在创建ArrayList的时候事先指定数据大小