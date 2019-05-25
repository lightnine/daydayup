package com.leon.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Author leon
 * @Date 2019/5/25 17:26
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 解题思路：
 * 本来是验证每一行每一列，和每个单元格。在for循环中验证每个单元格时，无法找到有效的方法
 * 看到网上的解决方案，对于一个元素，对其在一行，一列和每个单元格分别编码。首先是对元素两边加括号
 * 行编码是对元素后加上行号，列编码是对元素前加上列号，而单元格编码是对前面分别加上单元格号，
 * 因为单元格横纵都是3，所以行号和列号除以3.最后用Set来判断是否遇到过
 * 注释代码是自己的方法，无法解决单元格内的验证
 */
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            Set<Character> rowSet = new HashSet<>(9);
//            Set<Character> columnSet = new HashSet<>(9);
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    if (!rowSet.add(board[i][j])) {
//                        return false;
//                    }
//                }
//                if (board[j][i] != '.') {
//                    if (!columnSet.add(board[j][i])) {
//                        return false;
//                    }
//                }
//            }
//        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}
