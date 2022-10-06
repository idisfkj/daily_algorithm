package com.daily.algothrim.leetcode.medium

/**
 * 811. 子域名访问计数
 *
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。
 * 当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 *
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 *
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 *
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
 *
 * 输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
 * 而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。
 */
class SubdomainVisits {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SubdomainVisits().subdomainVisits(
                arrayOf(
                    "900 google.mail.com",
                    "50 yahoo.com",
                    "1 intel.mail.com",
                    "5 wiki.org"
                )
            ).forEach {
                println(it)
            }
        }

    }


    /**
     * "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
     */
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val result = arrayListOf<String>()
        val map = hashMapOf<CharSequence, Int>()

        for (item in cpdomains) {
            val split = item.split(" ")
            val count = split[0].toInt()
            val domains = split[1]
            map[domains] = map.getOrDefault(domains, 0) + count
            domains.forEachIndexed { index, c ->
                if (c == '.') {
                    domains.subSequence(index + 1, domains.length).let {
                        map[it] = map.getOrDefault(it, 0) + count
                    }
                }
            }
        }

        map.forEach {
            result.add("${it.value} ${it.key}")
        }

        return result
    }
}