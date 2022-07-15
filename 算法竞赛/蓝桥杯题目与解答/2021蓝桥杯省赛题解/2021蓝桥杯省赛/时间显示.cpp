#include <iostream>
#include <algorithm>
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
   ll x,miao,fen,shi,temp;
   cin>>x;
   miao=x/1000;
   fen=miao/60;
   miao=miao%60;
   shi=fen/60;
   fen=fen%60;
   shi=shi%24;
   if(shi<=9)
     cout<<'0'<<shi;
   else
    cout<<shi;
   cout<<':';
    if(fen<=9)
     cout<<'0'<<fen;
   else
    cout<<fen;
   cout<<':';
    if(miao<=9)
     cout<<'0'<<miao;
   else
    cout<<miao;
    return 0;
}
