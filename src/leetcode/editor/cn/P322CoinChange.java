//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package leetcode.editor.cn;

//java:零钱兑换
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            findWay(coins, amount, 0);
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }

        private void findWay(int[] coins, int amount, int count) {
            if (amount < 0) {
                return;
            }
            if (amount == 0) {
                res = Math.min(res, count);
            }
            for (int i = 0; i < coins.length; i++) {
                findWay(coins, amount - coins[i], count + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}