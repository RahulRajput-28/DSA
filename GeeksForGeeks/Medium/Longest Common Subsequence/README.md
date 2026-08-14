# Longest Common Subsequence

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1)

## Solved On
14 Aug 2026 at 10:04 am

<h2><a href="https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1">Longest Common Subsequence</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 18.6667px;">Given two strings<strong> s1</strong> and <strong>s2</strong>, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.</span></p>
<p><span style="font-size: 18.6667px;">A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "ABCDGH", s2 = "AEDFHR"
<strong>Output: </strong>3<strong>
Explanation: </strong>The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "ABC", s2 = "AC"
<strong>Output: </strong>2<strong>
Explanation: </strong>The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "XYZW", s2 = "XYWZ"
<strong>Output: </strong>3<strong>
Explanation: </strong>The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1&lt;= s1.size(), s2.size() &lt;=10<sup>3<br></sup>Both strings s1 and s2 contain only uppercase English letters.</span></p>