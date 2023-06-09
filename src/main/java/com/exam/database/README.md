## Aspect to comparing database management systems

- Storage Architecture
    - Disk vs In-memory
    - Format and Model
- Data Model
    - Relational vs NoSQL
- Data Structure
    - Static vs Dynamic schemas
    - Normalizes vs Denormalized
- Scalability/Cost
- Availability and Resilience
- Level of skills developer required
    - Query language and/or APIs
- Runtime Performance
    - Latency for reads and writes
- Rapid Development
    - Predefined Schema or Schemaless
- Data Integrity
    - ACID vs BASE
- Dataset Size
- Developer community

## SQL

SQL, which stands for Structured Query Language, is a programming language specifically designed for managing and
manipulating relational databases. It is widely used in the field of database management systems (DBMS) and allows users
to define, manipulate, and control data stored in a relational database.

![](../../../../resources/database/img_1.png)

**PROS**:

- Standardized Schema
- Large User community
- Standardizes Query Language
- ACID

**CONS**:

- Difficult clustering / scale
- Data normalization : If we have more table it takes more time to connect and query.
- First schema : We have to plan ahead what data and datatype need.

**Join types**:

![](../../../../resources/database/img_6.png)

#### Functions

Functions is a stored program that you can pass parameters into to return
a value.

Basic functions:

- count(columName) : count the rows in the given column.

```mysql
SELECT count(firstname)
FROM people;
```

- max(columName)
- min(columName)
- avg(columName)
- sum(columName)
- concat(columName, columName)

```mysql
SELECT concat(first_name, " ", last_name) as full_name
FROM employees;
```

[MySql Functions](https://dev.mysql.com/doc/refman/8.0/en/built-in-function-reference.html)

[Interactive SQL learning page](https://sqlbolt.com/)

## NoSql

- Document based database.
- Developed 2007
- BSON documents : binary representation of Json.
- Flexible
- High scalability (horizontally)
- Cost Effectiveness

PROS:

- Continues availability : data is distributed across multiple service and regions. No single point of failure.
- Query speed
- Agility :
- Cost : easy cheap to scale up

CONS:

- No Standardized query language
- Smaller user community
- Learning curve : No enough to know SQL.
- Data retrieval inconsistency : **NO** ACID compliant.
  It is BASE: Basically Available, Soft state, Eventual consistency

Types:

![](../../../../resources/database/img_5.png)

- Wide-column database : optimize for performance

It is between Relation databases and Key-value databases.

![](../../../../resources/database/img_3.png)

In Apache Cassandra:

![](../../../../resources/database/img_4.png)

- Document database: Group of documents is called a collection. No structure at all.

![](../../../../resources/database/img.png)

- Key-value databases : Most simple NOSQL database type. Most of the time we use for cache.
- Graph database : Shows different entities in the database and how they connect in a graphical way.

#### Normalization vs Denormalization

Normalization - means that data is stored in multiple collections by referencing between them. Data is defined once and
makes it easier to update. When it comes to reading data, the disadvantage of normalization is obvious. If you want to
retrieve data from multiple collections, you need to perform multiple queries. As a result, the reading process is
slower.

Denormalization - Stores a large amount of nested data in a document. This model performs better reads but is slower for
inserts and updates. This method of data storage takes up more memory.

## ACID:

- Atomicity: Atomicity guarantees that a transaction is treated as a single, indivisible unit of work. Either all the
  operations within a transaction are successfully completed and permanently saved in the database, or if any part of
  the transaction fails, none of the changes are applied. In other words, it ensures that transactions are
  all-or-nothing operations.


- Consistency: Consistency ensures that a transaction brings the database from one consistent state to another. It
  enforces integrity constraints, domain rules, and relationships defined in the database schema. Transactions should
  only be committed if they leave the database in a valid and consistent state. If any transaction violates the
  database's integrity, the changes are rolled back, and the database remains unchanged.


- Isolation: Isolation ensures that concurrent transactions do not interfere with each other. Each transaction operates
  in isolation from other transactions, as if it were executed sequentially. This prevents issues such as dirty reads,
  non-repeatable reads, and phantom reads. Isolation levels, such as Read Uncommitted, Read Committed, Repeatable Read,
  and Serializable, define the degree of isolation provided by a database system.


- Durability: Durability guarantees that once a transaction is committed, its changes are permanently saved in the
  database, even in the event of system failures, crashes, or power outages. The changes are stored in non-volatile
  storage, such as hard disks or solid-state drives (SSDs), to ensure their persistence. This property ensures that the
  data remains intact and recoverable, maintaining the reliability of the database.

![](../../../../resources/database/img_2.png)

## CAP theorem

- Consistency : All nodes in a distributed system see the same data at the same time.
- Availability : The system should always respond to client requests, even in the presence of failures.
- Partition Tolerance : The system's ability to continue operating even if there are network failures or partitions
  between nodes.

![](../../../../resources/database/img_7.png)

The CAP theorem states that in the presence of a network partition, a distributed system can only achieve two out of the
three properties:

- CA

![](../../../../resources/database/img_8.png)

- CP

![](../../../../resources/database/img_10.png)

- AP

![](../../../../resources/database/img_9.png)

### Partitioning and Sharding

Sharding and partitioning are both about breaking up a large data set into smaller subsets.

The difference is that sharding implies the data is spread across multiple computers while partitioning does not.
Partitioning is about grouping subsets of data within a single database instance.

![](../../../../resources/database/img_12.png)

In many cases, the terms sharding and
partitioning are even used synonymously, especially when preceded by the terms “horizontal” and “vertical.” Thus,
“horizontal sharding” and “horizontal partitioning” can mean the same thing.

![](../../../../resources/database/img_11.png)

("Database server is `sharded` and data is `partitioned`")

**Advantage** of sharding:

- Handle large Reads and Writes
- Increase overall storage capacity
- higher availability

**Disadvantage** of sharding:

- operationally complex
- cross-shared quires expensive


