class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count_map = {}

        for num in nums:
            count_map[num] = count_map.get(num, 0) + 1
        
        major_elements = []
        number = int(len(nums) / 3)
        for key, value in count_map.items():
            if value > number:
                major_elements.append(key)

        return major_elements