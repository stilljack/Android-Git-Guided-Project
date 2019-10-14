package com.lambdaschool.readinglist

import org.junit.Test

public class MainText(){

    @Test
    fun test(){

        val sauce =MainActivity
        val ourArray = arrayOf<Array<Int>>(arrayOf<Int>(6, 6, 7, -10, 9, -3, 8, 9, -1),
                arrayOf<Int>(9, 7 , -10, 6 ,4, 1, 6, 1, 1),
                arrayOf<Int>(-1, -2,  4, -6, 1, -4, -6, 3, 9),
                arrayOf<Int>(-8, 7,6 -1, -6, -6, 6, -7, 2),
                arrayOf<Int>(-10, -4, 9, 1 ,-7, 8, -5, 3, -5),
                arrayOf<Int>(-8, -3, -4, 2 ,-3, 7, -5, 1, -5),
                arrayOf<Int>(-2, -7, -4, 8 ,3, -1, 8, 2, 3),
                arrayOf<Int>( -3, 4,6,-7, -7, -8, -3, 9, -6),
                arrayOf<Int>(-2, 0 ,5,4, 4 ,4, -3, 3, 0)
        )












        assert(sauce.diagonalDifference(ourArray) == 15)
    }


}