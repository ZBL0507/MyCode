## 1. 字符串（String）
String的数据结构为简单动态字符串（Simple Dynamic String，缩写SDS）。是可以修改的字符串，内部结构实现上类似于java的ArrayList，
采用预分配冗余空间的方式来减少内存的频繁分配。
 <br>
 
![](.redis_数据类型_images/4efb83a2.png)
<br>

如图中所示，内部为当前字符串实际分配的空间capacity一般要高于实际字符串长度len。当字符串长度小于1M时，扩容时一次只会多扩1M的空间。
需要注意的是字符串最大长度为512M。


<br>
<br>
<br>

## 2. 列表（List）
单键多值

Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边）。

它的底层实际是个```双向链表```，对两端的操作性能很高，通过索引下标操作中间的节点性能会较差。<br>
![](.redis_数据类型_images/0e888252.png)
<br>

**数据结构：**

List的数据结构为快速链表quickList。

首先在列表元素较少的情况下会使用一块连续的内存存储，这个结构是ziplist，也即是压缩列表。

它将所有的元素紧挨着一起存储，分配的是一块连续的内存。

当数据量比较多的时候才会改成quicklist。

因为普通的链表需要附加指针空间太大，会比较浪费空间。比如这个列表里存的只是int类型的数据，结构上还需要两个额外的指针 prev 和 next。 <br>
![](.redis_数据类型_images/d43e3941.png)
<br>

Redis将链表和ziplist结合起来组成了quicklist。也就是将多个ziplis使用双向指针串起来使用。这样既满足了快速的插入删除性能，又不会出现太大的空间冗余。



<br>
<br>
<br>

## 3. 集合（set）
Redis set对外提供的功能与list类似是一个列表的功能，特殊之处在于set是可以自动排重的，当你需要存储一个列表数据，又不希望出现重复数据时，
set是一个很好的选择，并且set提供了判断某个成员是否在一个set集合内的重要接口，这个也是list所不能提供的。

Redis的set是string类型的无序集合。它底层其实是一个value为null的hash表，所以添加，删除，查找的复杂度都是O(1)。

一个算法，随着数据的增加，执行时间的长短，如果是O(1)，数据增加，查找数据的时间不变。


**数据结构：**

set数据结构是dict字典，字典是用哈希表实现的。

java中的HashSet的内部实现使用的是HashMap，只不过所有的value都指向同一个对象。<br>
Redis的set结构也是一样，它的内容也使用hash结构，所有的value都指向同一个内部值。



<br>
<br>
<br>

## 4. 哈希（hash）
redis hash是一个键值对集合。

redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。


**数据结构：**

hash类型对应的数据结构是两种：ziplist（压缩列表），hashtable（哈希表）。当field-value长度较短且个数较少时，使用ziplist，否则使用hashtable。




<br>
<br>
<br>

## 5. 有序集合Zset（sorted set）
redis 有序集合zset与普通集合set非常相似，是一个没有重复元素的字符串集合。

不同之处是有序集合的每个成员都关联了一个评分（score），这个评分（score）被用来按照从低到高的方式排序集合中的成员。集合的成员是唯一的，但是评分是可以重复的。

访问有序集合的中间元素也是非常快的，因此你能够使用有序集合作为一个没有重复成员的智能列表。


**数据结构：**

SortedSet(zset)是redis提供的一个非常特别的数据结构，一方面它等价于java的数据结构Map<String, Double>，可以给每个元素value赋予一个权重score，
另一方面它又类似于TreeSet, 内部的元素按照权重score进行排序，可以得到每个元素的名次，还可以通过score的范围来获取元素的列表。

zset底层使用了两个数据结构

1. hash，hash的作用就是关联value和权重score，保障元素value的唯一性，可以通过元素value找到相应的score值。
2. 跳跃表，跳跃表的目的在于给元素value排序，根据score的范围获取元素列表。























