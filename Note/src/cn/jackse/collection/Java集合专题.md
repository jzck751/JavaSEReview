## List

1、List元素可重复

2、ArrayList是线程不安全的，在多线程情况下，不建议使用ArrayList，可以使用Vector

3、创建无参ArrayList，初始默认容量为10；ArrayList扩容机制（第一次并没有使用）：1.5倍

4、transient表示属性不可以被序列化

5、Vector与ArrayList的区别

![image-20211025014308469](https://gitee.com/jzy0101/image/raw/master/img/202110250143689.png)



6、LinkedList解释

​	LinkedList增加和删除效率高，但是查询效率低

![image-20211025140508018](https://gitee.com/jzy0101/image/raw/master/img/202110251405281.png)



双向链表添加元素

![image-20211025142813523](https://gitee.com/jzy0101/image/raw/master/img/202110251428598.png)



7、ArrayList和LinkedList的比较

![image-20211025151212928](https://gitee.com/jzy0101/image/raw/master/img/202110251512214.png)



## Set

1、Set接口基本介绍

![image-20211025151535251](https://gitee.com/jzy0101/image/raw/master/img/202110251515475.png)



2、Set取出的顺序是固定的，但是与添加顺序不同

### HashSet

#### HashSet扩容机制

1、结论

![image-20211026071742240](https://gitee.com/jzy0101/image/raw/master/img/202110260717377.png)



2、putVal

```java

    /**
     * Implements Map.put and related methods.
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        /**
        	定义辅助变量
        	tab就是HashMap的一个数组，类型是Node[]
        */
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        
        /**
        	if语句表示如果当前tab为null或者大小为0，那么就是第一次扩容，这时分配16个空间
        */
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        
        /**
        	1、根据key得到hash 去计算该key应该存放到table表的哪个索引位置并把这个位置的对象，赋给p
        	2、判断p是否为null
        		2.1、如果p为null，表示还没有存放元素，就创建一个Node(key="java",value=PRESENT)
        		2.2、然后存放在该位置 tab[i] = newNode(hash,key,value,null)
        */
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            
            /**
            	如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样，并且满足以下两个条件之一，则不能加入
            		1.准备加入的key 和 p 指向的Node 结点的key是同一个对象
            		2.p 指向的Node结点的key的equals() 和准备加入的key比较后相同
            */
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            
            /**
            	再判断p是不是一个红黑树
            	如果是，则调用putTreeVal方法，来进行添加
            */
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            
            /**
            	如果table对应索引位置，已经是一个链表，就是用for循环
            		1. 依次和该链表的每一个元素比较后，都不相同，则加入到该链表的最后
            			注意：1.在把元素添加到链表后，立即判断 该链表是否已经达到8个结点
            				     如果达到8，则调用treeifyBin 对当前这个链表进行树化（转为红黑树）
            				  2.在转化为红黑树时进行判断，判断条件
            				  	(tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)  //MIN_TREEIFY_CAPACITY:（64）
            				     如果上面条件成立，则先对table扩容
            				     只有上面条件不成立即table表长度大于等于64时，才将链表转化为红黑树
            				  
            		2.依次和该链表的每一个元素比较过程中，如果有相同情况，就直接break
            */
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        
        /**
        	size 就是我们每加入一个节点Node(k,v,hash,next)，size++
        */
        if (++size > threshold)
            resize();//扩容
        afterNodeInsertion(evict);
        return null;
    }
```



3、HashSet扩容机制

![image-20211026111218181](https://gitee.com/jzy0101/image/raw/master/img/202110261112285.png)





#### LinkedHashSet

1、

1. 有序（LinkedHashSet加入数据顺序和取出数据顺序一致）

2. LinkedHashSet底层维护的是一个LinkedHashMap（是HashMap的子类）

3. LinkedHashSet底层结构 （数组table+双向链表）

4. 添加第一次时，直接将数组table 扩容到16，存放的节点类型是LinkedHashMap$Entry

5. 数组是HashMap$Node[]，存放的元素/数据是 LinkedHashMap$Entry

    ```java
    static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
    ```

    

​	 

2、![image-20211026162712023](https://gitee.com/jzy0101/image/raw/master/img/202110261627255.png)



# Map

## HashMap

源码解读：



> HashMap有横着的和竖着的，竖着的是达到临界值之后进行扩容；如果横着的达到了8，那么以后每次添加元素都会进行扩容。



```java
public class MapSrc2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        for (int i = 1; i <= 12; i++) {
            hashMap.put(new A(i), "hello");
        }

        System.out.println("hashMap=" + hashMap);
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }


    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
```





## Hashtable

- Hashtable的键和值都不能为null，佛iu则会抛出NullPointerException
- Hashtable是线程安全的，HashMap是线程不安全的



### 底层逻辑

- 底层有数组 Hashtable$Entry[] 初始化大小为 11
- 临界值 threshold = 8  = 11*0.75
- 扩容：按照自己的扩容机制来进行即可
- 执行 方法 addEntry(hash,key,value,index); 添加 K-V 封装到 Entry





## Properties

- Properties 还可以用于 从xxx.properties 文件中，加载数据到Properties类对象，并进行读取和修改。





## 总结-开发中如何选择集合类（记住）

![image-20211028100911542](https://gitee.com/jzy0101/image/raw/master/img/202110281009851.png)



> 试分析HashSet和TreeSet分别是如何实现去重的

- HashSet的去重机制

    ```markdown
    hashCode() + equals(),底层先通过存入对象，进行运算得到一个hash值，通过hash值得到对应的索引，如果发现table索引所在的位置没有数据，就进行equals()比较【遍历比较】【哪些值相等可以由程序员控制】，如果比较后不相同，就加入；否则不加入
    ```

    

- TreeSet的去重机制

    ```markdown
    如果传入了一个Comparator匿名对象，就是用实现的compare去重，如果方法返回0，就认为试相同的元素/数据，就不再进行添加；如果没有传入一个Comparator匿名对象，则以添加的对象实现的Comparable接口的compareTo去重
    ```

    















