"""
collections.namedtuple()
Basically, namedtuples are easy to create, lightweight object types. 
They turn tuples into convenient containers for simple tasks. 
With namedtuples, you don’t have to use integer indices for accessing members of a tuple.

Example:
>>> from collections import namedtuple
>>> Point = namedtuple('Point','x,y')
>>> pt1 = Point(1,2)
>>> pt2 = Point(3,4)
>>> dot_product = ( pt1.x * pt2.x ) +( pt1.y * pt2.y )
>>> print dot_product
11

Problem:
Sample Input:
5
ID         MARKS      NAME       CLASS     
1          97         Raymond    7         
2          50         Steven     4         
3          91         Adrian     9         
4          72         Stewart    5         
5          80         Peter      6  

Sample Output:
81.00           # Average = (97+50+91+72+80)/5
"""
from collections import namedtuple

n = int(input())
Student = namedtuple('Student', 'ID, Marks, Name, Class')
