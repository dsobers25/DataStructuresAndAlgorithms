from typing import List

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        
        curr = 1
        ans = 0
        left = 0

        for right in range(len(nums)):
            curr*=nums[right]

            while curr >= k:
                curr//=nums[left]
                left+=1
            
            ans += right-left+1
        
        return ans
    
    # Test the solution
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums = [10, 5, 2, 6]
    k = 100
    result = solution.numSubarrayProductLessThanK(nums, k)
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {result}")
    print(f"Expected: 8")
    print()
    
    # Test case 2
    nums = [10,5,2,6]
    k = 100
    result = solution.numSubarrayProductLessThanK(nums, k)
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {result}")
    print(f"Expected: 0")