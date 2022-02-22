#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

const int N = 100005;
pair<int,int> s[N];
int ret[N];
int n,m;

int main(){
    cin>>n>>m;
    int top=0;
    int k=n;
    for(int i=0;i<m;i++){
        int p,q;
        cin>>p>>q;
        //0 ÊÇ 1->q½µÐòÅÅÁÐ
        if(!p){
            while(top&&s[top].first==0)
                q=max(q,s[top--].second);
            while(top>=2&&s[top-1].second<=q)
                top-=2;
            s[++top]={0,q};
        }
        else if(top){
            while(top&&s[top].first==1)
                q=min(q,s[top--].second);
            while(top>=2&&s[top-1].second>=q)
                top-=2;
            s[++top]={1,q};
        }
    }
    int l=1,r=n;
    for(int i=1;i<=top;i++){
        if(s[i].first==0)
            while(l<=r&&r>s[i].second)
                ret[r--]=k--;
        else
            while(l<=r&&l<s[i].second)
                ret[l++]=k--;
        if(l>r)
            break;
    }
    if(top%2)
        while(l<=r)
            ret[l++]=k--;
    else
        while(l<=r)
            ret[r--]=k--;
            
    for(int i=1;i<=n;i++)
        cout<<ret[i]<<" ";
    return 0;
}
