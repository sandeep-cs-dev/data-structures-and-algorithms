package main

import "fmt"

func maxSumSubArray(nums []int) int {
	sum, maxSum := -1<<31, -1<<31
	for _, n := range nums {
		sum = max(sum+n, n)
		maxSum = max(maxSum, sum)
	}
	return maxSum
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {

	fmt.Println(maxSumSubArray([]int{1, -2, 3, -2, 4}))

}
