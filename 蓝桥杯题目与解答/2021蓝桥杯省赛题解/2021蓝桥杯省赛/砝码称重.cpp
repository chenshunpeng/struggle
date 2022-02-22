#include <iostream>
#include <bitset> 
using namespace std;
const int N = 15, M = 1e5 + 10; 
int w[N];
bitset<M> b;
int main(){
	int n;
	cin >> n;
	for(int i = 0; i < n; ++i)
		cin >> w[i];
	b[0] = 1;
	//bitset数据整体左移
	for(int i = 0; i < n; ++i)
		b |= b << w[i];
	//bitset数据整体右移
	for(int i = 0; i < n; ++i) 
		b |= b >> w[i];
	//把0刨去
	cout << b.count() - 1 << endl;
	return 0;
}
