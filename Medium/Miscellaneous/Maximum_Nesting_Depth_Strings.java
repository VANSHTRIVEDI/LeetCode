package Medium.Miscellaneous;

//https://www.naukri.com/code360/problems/maximum-nesting-depth-of-two-valid-parentheses-strings_1461222?leftPanelTabValue=PROBLEM
public class Maximum_Nesting_Depth_Strings {

}
// #include <bits/stdc++.h>
// vector<int> maxDepth(string &vpsSeq, int n)

// {

// //GREEDY APPROACH

// //va and vb store indices of respective parenthesis

// vector<int> va;

// vector<int> vb;

// //da=depth of a

// //db=depth of b

// int da=0, db=0;

// for(int i=0; i<vpsSeq.size(); i++) {

// if(vpsSeq[i] == '(') {

// if(da <= db) {

// va.push_back(i);

// da++;

// } else {

// vb.push_back(i);

// db++;

// }

// } else if(vpsSeq[i] == ')'){

// if(da >= db) {

// va.push_back(i);

// da--;

// } else {

// vb.push_back(i);

// db--;

// }

// }

// }

// //initialize answer vector

// vector<int> ans(vpsSeq.size(), 0);

// for(int i=0; i<va.size(); i++) {

// ans[va[i]]=1;

// }

// return ans;

// }