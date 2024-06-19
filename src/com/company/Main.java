/* 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true


Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
*/


package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(isValid("()"));        // true
        System.out.println(isValid("[]"));        // true
        System.out.println(isValid("{}"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("{[()]}"));      // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("({])"));      // false

    }

    public static boolean isValid(String s) {

        //empty Stack to track the brackets
        Stack<Character> stack = new Stack<Character>();

        //loop throw every char in s
        for (char c : s.toCharArray()){
            //if the brackets is opining push it into the stack
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            else {
                //stack is empty
                if (stack.isEmpty()){
                    return false;
                }

                //get the top of the stack and compare it with with the current character(in this case the char is an closing brackets)
                //return the top element in the stack without removing it
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    //if there is matching then remove the opening brackets from the stack
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return  stack.isEmpty();
    }
}
