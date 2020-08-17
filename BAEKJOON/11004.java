import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int[] A;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		ans = QuickSelectionSort(1,N,K);
		System.out.println(ans);
		
	}
	private static int QuickSelectionSort(int left, int right, int ks) {
		
		if(left == right)
			return A[left];
		
		int l = left-1;
		int r = right +1;
		int pivot = A[(l+r)/2];
		int tempA;
		
		while(true){
			
			while(A[++l]<pivot);
			while(A[--r]>pivot);
			
			if(l>=r)
				break;
			
			tempA = A[l];
			A[l] = A[r];
			A[r] = tempA;
			
		}
		
		if(l == r && l == ks){
			return pivot;
		}else if(ks<l){
			return QuickSelectionSort(left,l-1,ks);
		}else{
			return QuickSelectionSort(r+1, right,ks);
		}
		
	}

}
