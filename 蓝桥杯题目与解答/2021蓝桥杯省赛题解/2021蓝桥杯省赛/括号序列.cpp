#include<bits/stdc++.h>
using namespace std;
const int N = 5e3+100;
int len,lim[N],f[N][N];
char s[N]; 
typedef long long ll;
const int mod = 1e9+7;
int get(){
	int top=0,R=0,cnt=0;
	for(int i = 1; i <= len; i++){
		if(s[i]=='(') top++;
		else{
			++cnt;
			++R;
			if(top) top--,R--;
			lim[cnt]=R;
		}
	}
	//if(!cnt) return 1;
	//printf("cnt=%d R=%d\n",cnt,R);
	memset(f,0,sizeof(f));
	f[0][0]=1;
	for(int i = 1; i <= cnt; i++){
		for(int j = 0; j <= lim[i]; j++) 
			f[i][lim[i]]=(f[i][lim[i]]+f[i-1][j])%mod;
		for(int j = lim[i]+1; j <= len; j++) 
			f[i][j]=(f[i-1][j]+f[i][j-1])%mod;
	}
	//printf("%d\n",f[cnt][R]);
	return f[cnt][R];
}
int main(){
	scanf("%s",s+1);
	len=strlen(s+1);
	int ans1=get();
	reverse(s+1,s+1+len);
	for(int i = 1; i <= len; i++){
		if(s[i]=='(') s[i]=')';
		else s[i]='(';
	}
	int ans2=get();
	printf("%d",1ll*ans1*ans2%mod); 
	return 0;
} 