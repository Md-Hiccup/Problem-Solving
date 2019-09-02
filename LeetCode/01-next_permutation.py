"""     PROBLEM: NEXT PERMUTATION
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


SOLUTION:

Approach 1: Brute Force

In this approach, we find out every possible permutation of list formed by the elements of the given array and find out the permutation which is just larger than the given one. But this one will be a very naive approach, since it requires us to find out every possible permutation which will take really long time and the implementation is complex. Thus, this approach is not acceptable at all. Hence, we move on directly to the correct approach.

Complexity Analysis:
    Time complexity : O(n!)O(n!)O(n!). Total possible permutations is n!n!n!.
    Space complexity : O(n)O(n)O(n). Since an array will be used to store the permutations. 



Approach 2: Single Pass Approach

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. For example, no next permutation is possible for the following array:

[9, 5, 4, 3, 1]

We need to find the first pair of two successive numbers a[i] and a[i−1], from the right, which satisfy a[i] > a[i-1]. Now, no rearrangements to the right of a[i−1] can create a larger permutation since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i−1] including itself.

Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one. Therefore, we need to replace the number a[i−1] with the number which is just larger than itself among the numbers lying to its right section, say a[j].

Next Permutation

We swap the numbers a[i−1] and a[j]. We now have the correct number at index i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.

But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i] and a[i−1] where, a[i] > a[i-1]. Thus, all numbers to the right of a[i−1] were already sorted in descending order. Furthermore, swapping a[i−1] and a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i−1]a[i-1]a[i−1] to get the next smallest lexicographic permutation.


Complexity Analysis:
    Time complexity : O(n). In worst case, only two scans of the whole array are needed.
    Space complexity : O(1). No extra space is used. In place replacements are done.

"""

class Solution:
    def nextPermutation(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums)-2
        while(i>=0 and nums[i+1]<=nums[i]):
            i-=1
        if i>=0:
            j = len(nums)-1
            while(j>=0 and nums[j] <= nums[i]):
                j-=1
            self.swap(nums, i, j)
        self.reverse(nums, i + 1)
        return nums
        
    def reverse(self, nums, start):
        i = start
        j = len(nums)-1
        while(i<j):
            self.swap(nums, i, j)
            i+=1
            j-=1
        
    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]

# test 1
nums1 = [1, 2, 3]

# test 2
nums2 = [3, 2, 1]

# test 3
nums3 = [1, 1, 5]

# test 4
nums4 = [1, 5, 8, 4, 7, 6, 5, 3, 1]

quest = Solution()
prob1 = quest.nextPermutation(nums1)
prob2 = quest.nextPermutation(nums2)
prob3 = quest.nextPermutation(nums3)
prob4 = quest.nextPermutation(nums4)
print(prob1, prob2, prob3, prob4, sep='\n')

