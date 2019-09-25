## Hashing
-   It is a techinque that is used to uniquely identify a specific objects from a group of similar objects.
-   It provides O(1) times on Average for Insert/Search/Delete

#### Hash Function
-   It maps a big number or string to a small integer that can be used as index in hash table
-   Large keys are converted into small keys 

#### Hash Table
Used to store key/value pairs.

## Collision Resolution Technique

####    Separate Chaining (Open Hashing)    ####
The idea is to make each cell of hash tables point to a linked list of records that have some hash function

####    Open Addresing (Close Hashing)  ####
All elements are stored in the hash table itself.

-   Linear Probing
    -   Easy to implement
    -   Best Cache Performance
    -   Suffers from Clustering
    -   **Hi(x) = ( Hash(x) + i ) % HashTableSize**

-   Quadratic Probing
    -   Average Cache Performance
    -   Suffers a lesser clustering than linear probing
    -   **Hi(x) = ( Hash(x) + i*i ) % HashTableSize**

-   Double Hashing
    -   Poor Cache Performance
    -   No Clustering
    -   Require more computation
    -   **Hi(x) = ( Hash1(x) + i*Hash2(x) ) % HashTableSize**
    -   Hash1(key) = Key % TableSize
    -   Hash2(key) = Prime - (key % Prime) 
        where Prime is a prime smaller than TableSize.

## Complexity

####    Separate Chaining
```
    m = No. of slots in HashTable
    n = No of keys to be inserted in HashTable
    
    Load Factor
        Alpha  = n / m 

    Time Complexity of Insert/Search/Delete 
        => O(1) if Alpha = O(1) 
        => (1 + Alpha)) if Alpha != O(1)
```


####    Open Addressing
```
    m = No. of slots in HashTable
    n = No of keys to be inserted in HashTable
    
    Load Factor
        Alpha  = n / m (< 1)

    Time Complexity of Insert/Search/Delete 
        => O(1 / (1 - Alpha)) times
```


##  Load Factor 
```
    n = No. of entries in array 
    b = size of the array
    
    LF = n/b    (default = 0.75)
```

##  Rehashing
When L.F > 0.75, Then Increase(doubled) the size of the Array and Hashed all the values and stored in new double size array 