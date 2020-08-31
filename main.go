package main

func main() {

}

//func canFinish(numCourses int, prerequisites [][]int) bool {
//	flag := make([]int, numCourses)
//	adjacent:=make([][]int,numCourses*numCourses)
//	for _, prerequisite := range prerequisites {
//		adjacent[prerequisite[1]]=append(adjacent[prerequisite[1]], prerequisite[0])
//	}
//	for i := 0; i < numCourses; i++ {
//		if !DFS(i,adjacent,flag){
//			return false
//		}
//	}
//	return true
//}
//func DFS(i int, adjacent [][]int, flag []int) bool {
//	if flag[i] == -1 {
//		return true
//	}
//	if flag[i] ==1 {
//		return false
//	}
//	flag[i] = 1
//	for _, j := range adjacent[i] {
//		if !DFS(j,adjacent,flag){
//			return false
//		}
//	}
//	flag[i] = -1
//	return true
//}
/**
* Definition for a binary tree node.
* type TreeNode struct {
*     Val int
*     Left *TreeNode
*     Right *TreeNode
* }
 */
//type TreeNode struct {
//	Val   int
//	Left  *TreeNode
//	Right *TreeNode
//}
//func rob(root *TreeNode) int {
//	return max(GoRob(root))
//}
//
//func GoRob(root *TreeNode)(int,int){
//	if root==nil{
//		return 0,0
//	}
//	ls,ln:=GoRob(root.Left)
//	rs,rn:=GoRob(root.Right)
//	return ln+rn+root.Val, max(ls,ln)+max(rs,rn)
//}
//func max(a int, b int) int {
//	if a>b{
//		return a
//	}
//	return b
//}

//func numRescueBoats(people []int, limit int) int {
//	ans :=0
//	sort.Ints(people)
//	fmt.Println(people)
//	i,j:=0,len(people)-1
//	for i<=j {
//		if people[i]+people[j]<=limit{
//			ans+=1
//			i++
//			j--
//		}else if people[j]<=limit {
//			ans+=1
//			j--
//		} else {
//			return 0
//		}
//	}
//	return ans
//}

//func findNumberOfLIS(nums []int) int {
//	N:= len(nums)
//	lengths := make([]int,N)
//	count:= make([]int,N)
//	for i := 0; i < N; i++ {
//		count[i] = 1
//	}
//	for j := 0; j < N; j++ {
//		for i := 0; i < j; i++ {
//			if nums[i]<nums[j]{
//				if lengths[i]>=lengths[j]{
//					lengths[j] = lengths[i]+1
//					count[j] = count[i]
//				}else if lengths[i]+1==lengths[j] {
//					count[j] += count[i]
//				}
//			}
//		}
//	}
//	longest := 0
//	ans := 0
//	for i := 0; i < N; i++ {
//		if longest<lengths[i]{
//			longest = lengths[i]
//		}
//	}
//	for i := 0; i < N; i++ {
//		if longest== lengths[i]{
//			ans+=count[i]
//		}
//	}
//	return ans
//}
var (
	count int
	set   []bool
)

func canVisitAllRooms(rooms [][]int) bool {
     count = 0
     set = make([]bool,len(rooms))
     dfs(rooms,0)
     return count == len(rooms)
}
func dfs(rooms [][]int, node int) {
     set[node] = true
     count++
     for _, i := range rooms[node] {
          if !set[i]{
               dfs(rooms,i)
               set[i] = true
          }
     }
}
