// 1.A + B 问题
class Solution {
    public int aplusb(int a, int b) {
        // 主要利用异或运算来完成 
        // 异或运算有一个别名叫做：不进位加法
        // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
        // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
        // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
        // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
        // 令a' = a ^ b, b' = (a & b) << 1
        // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
        // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
        // 求得a + b的值。
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }
};



// 2.尾部的零
class Solution {
    public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
};



// 6.合并排序数组 II
public class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {

    	int len = A.length + B.length;
    	int[] result = new int[len];
    	int i=0,j=0,k=0;
    	
    	//有空数组
    	if(A == null){
    		return B;
    	}else if(B == null){
    		return A;
    	}
    		
    	//一般情况
    	i = 0;
    	j = 0;
    	k = 0;

    	while(i < A.length && j < B.length){
        	if(A[i] <= B[j]){
    			result[k++] =  A[i++];
    		}else if(A[i]>B[j]){
    			result[k++] =  B[j++];
    		}	
    	}

    	while(i < A.length){
    		result[k++]=A[i++];
    	}
    	
    	while(j < B.length){
    		result[k++]=B[j++];
    	}
    
    	return result;
    }
}





// 8. 旋转字符串
public class Solution {
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length==0){
            return;
        }

        offset %= str.length;
        for(int i = 0; i < offset; i++){
            char temp = str[str.length-1];
        	for(int j = str.length-1; j > 0; j--){
        		str[j] = str[j-1];
        	}
        	str[0] = temp;
        }
    }
	
	/*
	
	public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0)
            return;
            
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
	
	*/
}





// 9. Fizz Buzz 问题
public class Solution {
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            if((i % 3 == 0) && (i % 5 != 0)){
                result.add("fizz");
            }else if((i % 3 != 0) && (i % 5 == 0)){
                result.add("buzz");
            }else if((i % 3 == 0) && (i % 5 == 0)){
                result.add("fizz buzz");
            }else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}



// 13. 字符串查找
public class Solution {
    public int strStr(String source, String target) {
        // Write your code here
        
        if(target.length() == 0){
            return 0;
        }
        
        char[] sArray = source.toCharArray();
        char[] tArray = target.toCharArray();        
       
    	boolean flag;
    	for(int i = 0; i < sArray.length;i++){
    		flag = true;
    		for(int j = 0; j <tArray.length ; j++ ){
    			if((i+j>=sArray.length) ||(sArray[i+j] != tArray[j]) ) {
    				flag = false;
    				break;
    			}
    		}
    		if(flag == true){
    			return i;
    		}
    	}
    	return -1;
    }
}





// 14. 二分查找
class Solution {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or end = mid - 1
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
		
		
		/*解法二
		public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        return -1;
		*/
    }
}




// 22. 列表扁平化
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
	
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        //递归
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
		
		
		//非递归
		/*
		boolean isFlat = true;
        List<NestedInteger> ls = nestedList;
        while (isFlat) {
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<>();
            for (NestedInteger ni : ls) {
                if (ni.isInteger()) {
                    newLs.add(ni);
                } else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }
        List<Integer> r = new ArrayList<>();
        for (NestedInteger ni : ls) {
            r.add(ni.getInteger());
        }
        return r;
		*/
    }
}


	


// 28. 搜索二维矩阵
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		/*
		//空数组
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		//超过数组范围
		int outLen = matrix.length;
		int inLen = matrix[0].length;
		if(matrix[0][0] > target || matrix[outLen-1][inLen-1] < target){
			return false;
		}
		
		//找到外数组
        int outStart = 0;
		int outEnd = outLen-1;
		int outMid;
		int outFlag;
		while(outStart +1 < outEnd){
			outMid = (outStart+outEnd)/2;
			if(matrix[outMid][0] == target ){
				return true;
			}else if(matrix[outMid][0] < target){
				outStart = outMid+1;
			}else{
				outEnd = outMid-1;
			}
		}
		if(matrix[outEnd][0] <= target){
			outFlag = outEnd;
		}else if(matrix[outStart][0] <= target){
			outFlag = outStart;
		}else{
			return false;
		}
		//找内数组
		int inStart = 0;
		int inEnd = inLen-1;
		int inMid;
		while(inStart +1 < inEnd){
			inMid = (inStart+inEnd)/2;
			if(matrix[outFlag][inMid] == target ){
				return true;
			}else if(matrix[outFlag][inMid] < target){
				inStart = inMid+1;
			}else{
				inEnd = inMid-1;
			}
		}
		if(matrix[outFlag][inStart] == target || matrix[outFlag][inEnd] == target){
			return true;
		}
		return false;
		*/
		
		//解法二
		//空数组
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		//超过数组范围
		int outLen = matrix.length;
		int inLen = matrix[0].length;
		if(matrix[0][0] > target || matrix[outLen-1][inLen-1] < target){
			return false;
		}
		
		int start = 0;
		int end = outLen*inLen-1;
		int mid;
		while(start <= end){
			mid = (start + end)/2;
			if(matrix[mid/inLen][mid%inLen] == target){
				return true;
			}else if(matrix[mid/inLen][mid%inLen] > target){
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return false;
	
    }
}



// 35. 翻转链表
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode reverse(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		//1->2->3->4->null
  //null<-1<-2<-3<-4
		//prev表示前继节点
        ListNode prev = null;
		ListNode next = null;
		while(head != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return head;

    }
}









// 37. 反转一个3位整数
public class Solution {
    public int reverseInteger(int number) {
        // write your code here
    //解法一
    /*
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(number);
        result = Integer.parseInt( stringBuilder.reverse().toString());
        return result; 
    */
    
    //解法二
        int result = 0; 
        int bai = number / 100;
        int shi = (number / 10 ) % 10;
        int ge = number % 10;
        
        return bai+shi*10+ge*100;
        
    }
}







// 39. 恢复旋转排序数组
public class Solution {
    public void recoverRotatedSortedArray(List<Integer> nums) {
       // write your code here
		// [3,4,1,2],
		// [1,2,3,4]
		int i = 0;
		if(nums == null || nums.size() == 0 ){
			return ;
		}
		for(i = 0; i < nums.size()-1; i++){
			if(nums.get(i) > nums.get(i+1) ){
				break;
			}
		}
		if(i == nums.size()-1){
			return ;
		}
		reverse(nums,0,i);
		reverse(nums,i+1,nums.size()-1);
		reverse(nums,0,nums.size()-1);
		
		
		
    }
	
	public void reverse(List<Integer> nums, int start, int end) {
		int temp=0;
		int i=start;
		int j=end;
		while(i < j){
			temp = nums.get(i);
			nums.set(i,nums.get(j));
			nums.set(j,temp);
			i++;
			j--;
		}
	
    }
	
}



// 41. 最大子数组
public class Solution {
    public int maxSubArray(int[] nums) {
        // write your code here
		//[?2,2,?3,4,?1,2,1,?5,3]
		//[4,?1,2,1]
		
		if(nums == null || nums.length ==0){
			return 0;
		}
		
		int sum=0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; i++){
			sum = sum+nums[i];
			max = Math.max(max,sum);
			sum = Math.max(sum,0);
		}
		
		return max;
		
    }
}



// 44. 最小子数组
public class Solution {
    public int minSubArray(List<Integer> nums) {
		if(nums == null || nums.size()==0){
			return 0;
		}
		
		int sum=0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i < nums.size(); i++){
			sum = sum + nums.get(i);
			min = Math.min(sum,min);
			sum = Math.min(sum,0);
		}
		
		return min;
    }
}







// 46. 主元素
public class Solution {
    public int majorityNumber(List<Integer> nums) {
        // write your code here
		
		
		int count = 1;
		int now = nums.get(0);
		for(int i=1; i<nums.size(); i++){
			if(nums.get(i) != now){
				count--;
				if(count == 0){
					now = nums.get(i);
					count = 1;
				}
			}else{
				count++;
			}
		}
		return now;
    }
}





// 50. 数组剔除元素后的乘积
public class Solution {
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
		//        1     2     3     4
		//left    1     2     6     24
		//right   24	24	  12	4
						
		if(nums == null ||nums.size() == 0){
			return null;
		}
		if(nums.size()==1){
			List<Long> result = new ArrayList<Long>();
			result.add(0);
			return result;
		}
		
		int len = nums.size();
		long[] left = new long[len];
		long[] right = new long[len];
		
		
		left[0] = nums.get(0);
		for(int i=1; i<len; i++){
			left[i] = left[i-1]*nums.get(i);
		}
		
		right[len-1] = nums.get(len-1);
		for(int i=len-2; i>=0; i--){
			right[i] = right[i+1]*nums.get(i);
		}
		
		List<Long> result = new ArrayList<Long>();
		result.add(right[1]);
		for(int i=1; i<len-1; i++){
			result.add(left[i-1]*right[i+1]);
		}
		result.add(left[len-2]);
		
		return result;
    }
}





// 53. 翻转字符串中的单词
public class Solution {
    public String reverseWords(String s) {
        // write your code here
		String result = "";
		s = s.trim();
		String[] array = s.split("\\s+");
		for(int i=array.length-1; i>=0; i--){
			result+=array[i];
			if(i!=0){
				result+=" ";
			}
			
		}
		return result;
    }
}






// 55. 比较字符串
public class Solution {

    public boolean compareStrings(String A, String B) {
        // write your code here
		int[] ACode = new int[256];
		int[] ANum = new int[256];
		int[] BNum = new int[256];
		for(int i=0; i<A.length(); i++){
			ACode[A.charAt(i)]=1;
			ANum[A.charAt(i)]+=1;
		}
		
		for(int i=0; i<B.length(); i++){
			BNum[B.charAt(i)]+=1;
			if(ACode[B.charAt(i)] == 0 || ANum[B.charAt(i)] < BNum[B.charAt(i)]){
				return false;
			}
		}
		return true;
    }
}






// 56. 两数之和
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0; i<numbers.length; i++){
			if(map.get(numbers[i]) != null){
				int[] result =  {map.get(numbers[i]),i};
				return result;
			}
			map.put(target - numbers[i],i);
			
			
		}
		
		int[] result={};
		return result;
		
    }
}





// 60. 搜索插入位置
public class Solution {
    public int searchInsert(int[] A, int target) {
        // write your code here
		//  0,1,2,3,4,5
		// [1,3,5,6,8,9]  6 
		//(0,5,2--5<6)(3,5,4--8>6)(3,3,3--6)
		if(A==null || A.length==0 || target <= A[0]){
			return 0;
		}else if(target == A[A.length-1]){
			return A.length-1;
		}else if(target > A[A.length-1]){
			return A.length;
		}
		
		
		int start=0;
		int end=A.length-1;
		int mid;
		while(start + 1 < end){
			mid = (start+end)/2;
			if(A[mid] > target){
				end = mid;
			}else if(A[mid] < target){
				start=mid;
			}else{
				return mid;	
			}
		}
		if(A[start]>=target){
			return start;
		}else if(A[end]>=target){
			return end;
		}else{
			return end+1;
		}
		return end;
		
    }
}








// 64. 合并排序数组
public class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
		int[] tempA = new int[m];
		for(int i=0; i<m; i++){
			tempA[i] = A[i];
		}
		
		int i=0,j=0,k=0;
		while(i<m && j<n){
			if(tempA[i] <= B[j]){
				A[k++] = tempA[i++];
			}else{
				A[k++] = B[j++];
			}
		}
		while(i<m){
			A[k++] = tempA[i++];
		}
		while(j<n){
			A[k++] = B[j++];
		}
		
    }
}






// 66. 二叉树的前序遍历
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 非递归
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null){
			return list;
		}
		
		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		
		return list;
    }
}
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //递归
		List<Integer> list = new ArrayList<Integer>();
		traversal(root,list);
		return list;
    }
	private void traversal(TreeNode root, List<Integer> list){
		if(root == null){
			return ;
		}
		
		list.add(root.val);
		traversal(root.left,list);
		traversal(root.right,list);
	}
	
}





// 67. 二叉树的中序遍历
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 非递归版
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null){
			return list;
		}
		
		while(!stack.empty() || root!=null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
    }
}
// 递归版
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		traversal(root,list);
		return list;
		
    }
	
	private void traversal(TreeNode root,List list){
		if(root == null){
			return;
		}
		
		traversal(root.left,list);
		list.add(root.val);
		traversal(root.right,list);
	}
}






// 68. 二叉树的后序遍历
public class Solution {
	//非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
		
		Stack<TreeNode> A = new Stack<TreeNode>();
		Stack<TreeNode> B = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();

		if(root == null){
			return list;
		}
		
		A.push(root);
		while(!A.empty()){
			root = A.pop();
			B.push(root);
			if(root.left != null){
				A.push(root.left);
			}
			if(root.right != null){
				A.push(root.right);
			}
		}
		while(!B.empty()){
			list.add(B.pop().val);
		}
		return list;
		
    }
}
//递归
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
		List<Integer> list = new ArrayList<Integer>();
		traversal(root,list);
		return list;
    }
	private void traversal (TreeNode root,List<Integer> list){
		if(root == null){
			return;
		}
		
		traversal(root.left,list);
		traversal(root.right,list);
		list.add(root.val);
	}
}




// 69. 二叉树的层次遍历
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for(int i=0; i<size; i++){
				root  = queue.poll();
				list.add(root.val);
				if(root.left != null){
					queue.offer(root.left);
				}
				if(root.right != null){
					queue.offer(root.right);
				}
			}
			result.add(list);
		}
		return result;
		
    }
}





// 80. 中位数
public class Solution {
    public int median(int[] nums) {
        // write your code here
		quickSort(nums,0,nums.length-1);
		return nums[(nums.length-1)/2];
    }
	
	private void quickSort(int[] nums,int start, int end){
		if(start < end){
			int i=start;
			int j=end;
			int key=nums[start];
			while(i < j){
				while(i<j && nums[j]>=key){
					j--;
				}
				while(i<j && nums[i]<=key){
					i++;
				}
				if(i<j){
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
			
			int temp = nums[start];
			nums[start]=nums[i];
			nums[i] = temp;
			
			quickSort(nums,start,i-1);
			quickSort(nums,i+1,end);
		}
	}
}






// 82. 落单的数
public class Solution {
    public int singleNumber(int[] A) {
        // write your code here
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<A.length; i++){
			if(map.get(A[i]) == null){
				map.put(A[i],1);
			}else if(map.get(A[i]) == 1){
				map.remove(A[i]);
			}
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet()){
			return entry.getKey();
		}
		return 0;

    }
}






// 85. 在二叉查找树中插入节点
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// 非递归
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
		
		if(root == null){
			return node;
		}
		
		TreeNode pt = root;
		TreeNode pre = null;
		while(pt != null){
			pre = pt;
			if(pt.val < node.val){
				pt = pt.right;
			}else if(pt.val > node.val){
				pt = pt.left;
			}
		}
		
		if(pre.val > node.val){
			pre.left = node;
		}else if(pre.val < node.val){
			pre.right = node;
		}
		
		return root;
    }
}
// 递归
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
		
		if(root == null){
			return node;
		}
		
		if(root.val > node.val){
			root.left = insertNode(root.left,node);
		}else{
			root.right = insertNode(root.right,node);
		}
		
		return root;
    }
}



// 93. 平衡二叉树
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // write your code here
		if(root == null){
			return true;
		}
		
		if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <=1){
			return true;
		}
		
		return false;
		
    }
	
	public int height(TreeNode root){
		if(root==null){
			return 0;
		}
		
		return Math.max(height(root.left),height(root.right))+1;
	}
}






// 96. 链表划分
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        // write your code here
		if(head == null){
			return head;
		}
		ListNode left = new ListNode(0);
		ListNode leftHead = left;
		ListNode right = new ListNode(0);
		ListNode rightHead = right;
		
		while(head != null){
			if(head.val < x){
				left.next = head;
				left = head;
			}else{
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		
		right.next = null;
		leftHead.next = rightHead.next;
		return leftHead.next;
    }
}





// 97. 二叉树的最大深度
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        // write your code here
		if(root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}




// 100. 删除排序数组中的重复数字
public class Solution {

    public int removeDuplicates(int[] nums) {
        // write your code here
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int ptr = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[ptr] != nums[i]){
				ptr++;
				nums[ptr]=nums[i];
			}
		}
		return ptr+1;
    }
}





// 101. 删除排序数组中的重复数字 II
public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int ptr=0;
		int count=1;
		for(int i=1; i<nums.length; i++){
			//System.out.println("i="+i+"  ,ptr="+ptr);
			//System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, ptr)));
			if(nums[ptr] != nums[i]){
				ptr++;
				nums[ptr]=nums[i];
				count = 1;
			}
			else {
				count++;
				if(count <= 2){
					ptr++;
					nums[ptr] = nums[i];
				}
			}
			
		}
		
		return ptr+1;
    }
}





// 110. 最小路径和
public class Solution {
    public int minPathSum(int[][] grid) {
        // write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
			
		dp[0][0] = grid[0][0];
		
		for(int i = 1; i < n; i++){
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		for(int i = 1; i < m; i++){
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		
		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		
		return dp[n-1][m-1];
    }
}


// 111. 爬楼梯
//递归
public class Solution {
    public int climbStairs(int n) {
        // write your code here
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		return climbStairs(n-1)+climbStairs(n-2);
    }
}
//非递归
public class Solution {
    public int climbStairs(int n) {
        // write your code here
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<=n; i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
    }
}




// 112. 删除排序链表中的重复元素
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
			return head;
		}
		
		ListNode root = head;
		ListNode pre = head;
		head = head.next;
		
		while(head != null){
		    
			if(pre.val == head.val){
				pre.next = head.next;
				head = pre.next;
			}else{
			    
			    head = head.next;
			    pre = pre.next;
			}
		}
		return root;
    }
}




// 114. 不同的路径
public class Solution {
    public int uniquePaths(int m, int n) {
        // write your code here
		if(m==0 || n==0){
			return 0;
		}
		
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			dp[i][0] = 1;
		}
		for(int i=0; i<n; i++){
			dp[0][i] = 1;
		}
		
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
		
    }
}






// 115. 不同的路径 II
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
		if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0){
			return 0;
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] dp = new int[m][n];
		
		for(int i=0; i<m; i++){
			if(obstacleGrid[i][0] == 0){
				dp[i][0] = 1;
			}else{
				break;
			}
		}
		
		for(int i=0; i<n; i++){
			if(obstacleGrid[0][i] == 0){
				dp[0][i] = 1;
			}else{
				break;
			}
		}
		
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(obstacleGrid[i][j] == 0){
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}else{
					dp[i][j] = 0;
				}
			}
		}
		
		return dp[m-1][n-1];
		
		
    }
}





// 128. 哈希函数
public class Solution {
	//(a * b ) % MOD = ((a % MOD) * (b % MOD)) % MOD
	// (9 * 8) % 20 = (9+9+9+9+9+9+9+9)%20 
	//= (9%20+9%20+9%20+9%20+9%20+9%20+9%20+9%20)%20 = (8*(9%20))%20
	//hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33^1 + ascii(d))*33^0 % HASH_SIZE 
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
		log result = 0;
		for(int i=0; i<key.length; i++){
			result = (result*33 + (int)(key[i])) % HASH_SIZE;
		}
		return (int)ans;
    }
}





// 133. 最长单词
public class Solution {
    public List<String> longestWords(String[] dictionary) {
        // write your code here
		List<String> result = new ArrayList<String>();
        if(dictionary == null ||dictionary.length==0){
            return result;
        }
        int maxLen = 0;
        for(int i=0; i<dictionary.length; i++){
            if(dictionary[i].length() > maxLen){
                maxLen = dictionary[i].length();
            }
        }
        
        for(int i=0; i<dictionary.length; i++){
            if(dictionary[i].length() == maxLen){
                result.add(dictionary[i]);
            }
        }
        
        return result;
    }
}





// 138. 子数组之和
public class Solution {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
		int len = nums.length;
		
		List<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(0,-1);
		int sum = 0;
		for(int i=0; i<len; i++){
			sum += nums[i];
			
			if(map.containsKey(sum)){
				ans.add(map.get(sum) + 1);
				ans.add(i);
				return ans;
			}
			
			map.put(sum,i);
		}
		
		return ans;
    }
}




// 141. x的平方根
public class Solution {
    public int sqrt(int x) {
        // write your code here
		if(x == 0 || x == 1){
			return x;
		}
		
		long left = 1;
		long right = x;
		long mid;
		while(left + 1 < right){
			mid = left + (right-left)/2;
			if(mid*mid < x){
				left = mid;
			}else if(mid*mid > x){
				right = mid;
			}else{
				return mid;
			}
		}
		
		if(right*right <= x){
			return (int)right;
		}
		return (int)left;
		
    }
}




// 142. O(1)时间检测2的幂次
public class Solution {
    public boolean checkPowerOf2(int n) {
        // write your code here
		if( n <= 0){
            return true;
        }
        if((n & (n-1)) != 0){
			return false;
		}
		return true;
    }
}



// 145. 大小写转换
public class Solution {
    /**
     * @param character: a character
     * @return: a character
     */
    public char lowercaseToUppercase(char character) {
        // write your code here
        
        return Character.toUpperCase(character);
    }
}




// 155. 二叉树的最小深度
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    public int minDepth(TreeNode root) {
        // write your code here
		if (root == null) {
            return 0;
        }
		
		
		return getMin(root);
    }
	
	public int getMin(TreeNode root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		
		return Math.min(getMin(root.left),getMin(root.right))+1
	}

}





// 156. 合并区间
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
		if(intervals == null || intervals.size() <= 1){
			return intervals;
		}
		
		List<Interval> result = new ArrayList<Interval>();		
		Collections.sort(intervals, new IntervalComparator());
		Interval last = interval.get(0);
		for(int i=1; i<intervals.size(); i++){
			Interval curt = intervals.get(i);
			if(curt.start > last.end){
				result.add(last);
				last = curt;
			}else{
				if(curt.end > last.end){
					last.end = curt.end;
				}
			}
		}
		
		result.add(last);
		return result;
    }
	
	
	private class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval a, Interval b){
			return a.start - b.start;
		}
	}
}



// 157. 判断字符串是否没有重复字符
public class Solution {
    public boolean isUnique(String str) {
        // write your code here
		int[] chars = new int[256];
		for(int i=0; i<str.length(); i++){
			char curt = str.charAt(i);
			chars[curt]++;
			if(  chars[curt] == 2){
				return false;
			}
		}
		return true;
    }
}




// 158. 两个字符串是变位词
public class Solution {
    public boolean anagram(String s, String t) {
        // write your code here
		if(s==null || t==null || s.length()!=t.length()){
			return false;
		}
		int len = t.length();
		int[] ss = new int[256];
		int[] tt = new int[256];
		for(int i=0; i<len; i++){
			ss[s.charAt(i)]++;
			tt[t.charAt(i)]++;
		}
		for(int i=0; i<256; i++){
			if(ss[i] != tt[i]){
				return false;
			}
		}
		return true;
    }
}



// 165. 合并两个排序链表
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		ListNode result = new ListNode(0);
		ListNode resultHead = result;
		while(l1 != null || l2 != null){
			if(l2==null || (l1!=null && l1.val<=l2.val)){
				result.next = l1;
				result = result.next;
				l1 = l1.next;
			}else if(l1==null || (l2!=null && l1.val>l2.val)){
				result.next = l2;
				result = result.next;
				l2 = l2.next;
			}
		}
		result.next=null;
		return resultHead.next;
    }
}



// 166. 链表倒数第n个节点
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode nthToLast(ListNode head, int n) {
		if(head == null){
			return head;
		}
		
		int cnt = 0;
		ListNode temp = head;
		while(temp != null){
			cnt++;
			temp = temp.next;
		}
		int index = cnt-n;
		while(index > 0){
			head = head.next;
			index--;
		}
		return head;
    }
}



// 167. 链表求和
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
                if(l1 == null && l2 == null) {
            return null;
        }else if(l1 == null) {
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode point = result;
        int carry = 0;
        while(l1!=null || l2!=null){
            if(l1==null && l2!=null){
                l1 = new ListNode(0);
            }else if(l1!=null && l2==null){
                l2 = new ListNode(0);
            }
            int sum  = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
    if(carry == 1){
            point.next = new ListNode(1);
        }
        
        return result.next;
    }
}



// 283. 三数之中的最大值
public class Solution {
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        
        int max = num1;
        if(max < num2) max = num2;
        if(max < num3) max = num3;
        return max;
    }
}




// 366. 斐波纳契数列
public class Solution {
    public int fibonacci(int n) {
        // write your code here
        int num=100;
		int[] fib = new int[num];
		fib[0]=0;
		fib[1]=1;
		for(int i = 2; i < num; i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib[n-1];
    }
}




// 454. 矩阵面积
public class Rectangle {

    static int height = 0;
    static int width = 0;
	
     public Rectangle(int height, int width){
        Rectangle.height = height;
        Rectangle.width = width;
    }

    public int  getArea (){
        return Rectangle.height * Rectangle.width;
    }
}






// 463. 整数排序
public class Solution 
{
	public void sortIntegers(int[] A) {

		//冒泡排序
		/*
		int temp = 0;
		for(int i = 0; i < A.length-1; i++){
			for(int j = 0 ; j < A.length-i-1 ; j++){
			if(A[j] > A[j+1]){
				temp = A[j];
				A[j] = A[j+1];
				A[j+1] = temp;
			    }
			}
		}
		*/
		
		//选择排序
		/*
        int minIdx  = 0;
        int temp = 0;
        for(int i = 0; i < A.length-1; i++){
        	minIdx = i;
        	for(int j = i; j < A.length; j++){
        		if(A[minIdx] > A[j])
        		{
        			minIdx = j;
        		}
        	}
        	if(i != minIdx){
        		temp = A[i];
        		A[i] = A[minIdx];
        		A[minIdx] = temp;
        	}
        }
        */
        
        //插入排序
        int temp = 0;
        int i,j;
        for ( i = 1; i < A.length; i++) {
            temp = A[i];
            for (j = i - 1; j >= 0 ; j--) {
                if(A[j] > temp){
                    A[j + 1] = A[j];
                }else{
                    break;//注意跳出
                }
            }
            A[j + 1] = temp;
        }
	}
}




// 466. 链表节点计数
public class Solution {

    public int countNodes(ListNode head) {
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}




// 484. 交换数组两个元素
public class Solution {
    public void swapIntegers(int[] A, int index1, int index2) {
        int temp = A[index1] ;
        A[index1] =  A[index2]; 
        A[index2] = temp;
    }
}




// 632. 二叉树的最大节点
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {

    public TreeNode maxNode(TreeNode root) {
        // write your code here
        if( root == null){
    		return null;
    	}
    	TreeNode left = root;
    	TreeNode right = root;
    	if(root.left != null){
    		left = maxNode(root.left);
    	}
    	if(root.right  != null){
    		right = maxNode(root.right );
    	}	
    	if(root.val < left.val){
    		root.val = left.val;
    	}
    	if(root.val < right.val){
    		root.val = right.val;
    	}
    	return root;
    }
}