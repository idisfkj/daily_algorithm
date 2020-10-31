package com.daily.algothrim.backtracking

/**
 * 最少编辑次数
 * 求把一个字符串变成另一个字符串，需要的最少编辑次数
 * 编辑内容包含：增加、删除、修改
 */
class MinEdit {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MinEdit().apply {
                minEdit("mitcmu".toCharArray(), "mtacnu".toCharArray(), 0, 0, 0)
                println(mMinEdit)
            }
        }

    }

    private var mMinEdit = Int.MAX_VALUE

    fun minEdit(a: CharArray, b: CharArray, ap: Int, bp: Int, min: Int) {
        if (ap == a.size || bp == b.size) {
            var temp = min
            if (ap < a.size) temp += a.size - ap
            if (bp < b.size) temp += b.size - bp
            if (temp < mMinEdit) mMinEdit = temp
            return
        }

        // 1. 相同 a[ap+1]b[bp+1]
        // 2. 不相同
        // 2.1 a增/b 删 a[ap][bp+1]
        // 2.2 b增/a 删 a[ap+1][bp]
        // 2.3 ab修改成相同 a[ap+1][bp+1]
        if (a[ap] == b[ap]) { // 相同
            minEdit(a, b, ap + 1, bp + 1, min)
        } else { // 不相同
            minEdit(a, b, ap, bp + 1, min + 1) // a增/b 删 a[ap][bp+1]
            minEdit(a, b, ap + 1, bp, min + 1) // b增/a 删 a[ap+1][bp]
            minEdit(a, b, ap + 1, bp + 1, min + 1) // ab修改成相同a[ap+1][bp+1]
        }
    }
}