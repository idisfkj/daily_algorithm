package com.daily.algothrim.leetcode

/**
 * 721. 账户合并
 *
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 */
class AccountsMerge {

    companion object {
        @JvmStatic

        // [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"]
        // ,["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
        fun main(args: Array<String>) {
//            AccountsMerge().solution(listOf(
//                    listOf("John", "johnsmith@mail.com", "john00@mail.com"),
//                    listOf("John", "johnnybravo@mail.com"),
//                    listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
//                    listOf("Mary", "mary@mail.com")
//            )).forEach { item ->
//                item.forEach {
//                    println(it)
//                }
//                println()
//            }
//
//            AccountsMerge().solution(listOf(
//                    listOf("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"),
//                    listOf("Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"),
//                    listOf("Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"),
//                    listOf("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"),
//                    listOf("Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co")
//            )).forEach { item ->
//                item.forEach {
//                    println(it)
//                }
//                println()
//            }
//
//            AccountsMerge().solution(listOf(
//                    listOf("David","David0@m.co","David4@m.co","David3@m.co"),
//                    listOf("David","David5@m.co","David5@m.co","David0@m.co"),
//                    listOf("David","David1@m.co","David4@m.co","David0@m.co"),
//                    listOf("David","David0@m.co","David1@m.co","David3@m.co"),
//                    listOf("David","David4@m.co","David1@m.co","David3@m.co")
//            )).forEach { item ->
//                item.forEach {
//                    println(it)
//                }
//                println()
//            }

            AccountsMerge().solution(listOf(
                    listOf("David", "David0@m.co", "David1@m.co"),
                    listOf("David", "David3@m.co", "David4@m.co"),
                    listOf("David", "David4@m.co", "David5@m.co"),
                    listOf("David", "David2@m.co", "David3@m.co"),
                    listOf("David", "David1@m.co", "David2@m.co")
            )).forEach { item ->
                item.forEach {
                    println(it)
                }
                println()
            }
        }
    }

    // [["David","David0@m.co","David1@m.co"],
    // ["David","David3@m.co","David4@m.co"],
    // ["David","David4@m.co","David5@m.co"],
    // ["David","David2@m.co","David3@m.co"],
    // ["David","David1@m.co","David2@m.co"]]

    // [["David","David0@m.co","David4@m.co","David3@m.co"],
    // ["David","David5@m.co","David5@m.co","David0@m.co"],
    // ["David","David1@m.co","David4@m.co","David0@m.co"],
    // ["David","David0@m.co","David1@m.co","David3@m.co"],
    // ["David","David4@m.co","David1@m.co","David3@m.co"]]

    // 输入：
    // accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
    // 输出：
    // [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
    // 解释：
    // 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
    // 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
    // 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
    // ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。

    // 利用一个字符串的映射存储并查集
    private var q: MutableMap<String, String> = hashMapOf()

    fun solution(accounts: List<List<String>>): List<List<String>> {
        // 这个映射存储每个邮箱对应账户的名字
        val names = hashMapOf<String, String>()


        // 遍历所有账户构建并查集
        for (a in accounts) {
            var i = 1
            while (i < a.size) {
                if (!q.containsKey(a[i])) {
                    // 如果并查集中没有这个邮箱，则添加邮箱，其根元素就是本身
                    q[a[i]] = a[i]
                    // 添加该邮箱对应的账户名
                    names[a[i]] = a[0]
                }

                if (i > 1) {
                    // 并查集的合并操作，合并一个账户中的所有邮箱
                    q[find(a[i])] = find(a[i - 1])
                }
                i++
            }
        }

        // 暂时存储答案中的邮箱列表，每个键值对的键就是每个并查集集合的根元素
        val temp = hashMapOf<String, MutableList<String>>()
        for (email in q.keys) {
            // 获取当前邮箱对应并查集的根元素
            val root = find(email)
            // 将当前邮箱放入根元素对应的列表中
            if (!temp.containsKey(root)) temp[root] = mutableListOf()
            temp[root]?.add(email);
        }

        val res = mutableListOf<List<String>>()
        // 将答案从映射中放到列表总
        for (root in temp.keys) {
            // 获取当前根元素对应的列表
            val layer = temp[root] ?: arrayListOf()
            // 题目要求的排序
            layer.sort()
            // 添加姓名
            layer.add(0, names[root] ?: "")
            // 将当前列表加入答案
            res.add(layer)
        }

        return res
    }

    // 并查集查找模板函数，这里用字符串替换了之前的整型
    private fun find(x: String): String {
        if (!q[x].equals(x)) {
            q[x] = find(q[x] ?: "")
        }

        return q[x] ?: ""
    }

}