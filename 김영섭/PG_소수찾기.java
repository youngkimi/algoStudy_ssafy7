import java.util.HashSet;
import java.util.Iterator;

// Guide를 살짝 보았습니다.
// 처음에는 조합이라고 생각했는데 순서가 있으니까 순열이더라고요. (123 / 321을 다르게 취급)
// 그래서 해당 부분 재귀를 짤 때 좀 걸렸습니다.
// 순열 (선택하는 순서에 따라 달라지는 경우), 제가 선택한 문자열을 빼고 남은 문자열을 고스란히 다시 넣어줘야합니다.
// 내가 지금 선택하지 않고 지나왔지만, 이후에 다시 선택할 수 있기 때문입니다.
// 만약 배열을 쓴다면 내가 선택한 문자열의 idx를 값에 저장하고, 하나 작은 사이즈의 배열을 만들고, 반복문을 돌면서 idx와 대조 비교하면서
// idx인 경우는 건너뛰고... 그럼 idx가 하나 더 필요하고... 암튼 복잡합니다.
// 하지만 만약 아래처럼 String의 Substring을 쓰면 아주 편합니다.
// subtstring(0, i) + substring(i) 로 바로 만들 수 있습니다. (마지막 index는 포함 안함)

// 근데 프로그래머스 재귀 짜기 좀 복잡한 것 같아요.

class Solution { 
    HashSet <Integer> combs = new HashSet<>(); // HashSet은 중복을 허용하지 않는 DataSet입니다.

    void Combs(String select, String other) // 내가 선택한 문자들과 내가 선택하지 않은 (앞으로 선택할 수 있는) 문자들
    {
 	   if (other.length() == 0) // 더 선택할게 없다면
 		   combs.add(Integer.parseInt(select)); // HashSet에 넣으려 시도
 	   

		// 이 함수가 처음 호출되었다면, 아무것도 선택하지 않은 상태로는 의미가 없으니
		// 문자열을 돌면서 아무거나 하나 잡아 조합에 넣고, 남은 문자열도 넣어줍니다.
 	   if (select.length() == 0)
 	   {
 		  for (int j = 0; j < other.length(); j++)
 		   {
 			  combs.add(Integer.parseInt(select + other.charAt(j)));
 			  Combs(select + other.charAt(j), other.substring(0, j) + other.substring(j+1));
 		   }
 	   }

	   // 
 	   
	   for (int j = 0; j < other.length(); j++)
	   {
		   for (int i = 0; i < select.length(); i++)
	 	   {
	 		   String element = select.substring(0,i) + other.charAt(j) + select.substring(i);
	 		   combs.add(Integer.parseInt(element));
	 		   Combs(element, other.substring(0, j) + other.substring(j+1));
	  	   }
	   }
    }
    
    boolean isPrime(int num) // integer parse로 변환한 조합을 매개변수로 받아서, 소수가 맞는지 확인
    {
    	if (num < 2)
    		return false;
    	for (int i = 2; i <= num/i; i++) // 소수 찾기 할 때 num까지 돌 필요는 없습니다. 에라토스테네스의 체 라고 부르던데, 생각해보면 직관적으로 아실것 같아요.
    	{
    		if (num % i == 0)
    			return false;
    	}
    	return true; // 암튼 소수가 맞으면 true. 중간에 나눠떨어지면 false가 되겠습니다.
    }
    
    public int solution(String numbers) {

            int cnt = 0;
            Combs("", numbers); 
			// hashSet의 경우 순서가 없습니다. (같은 요소가 없는 복주머니처럼) 그래서 iterator를 받아서 
			// 요소를 출력해줘야 한다고 하더라고요... 
			// 사실 저도 잘 모르지만 그냥 HashSet 돌면서, 내부에 있는 요소를 출력하는 과정이라고 이해하시면 될 것 같습니다.
            Iterator<Integer> iter = combs.iterator(); 
        	while(iter.hasNext())
        	{
    		    if (isPrime((int) (iter.next())))
    		    	cnt++;
    		}
        	return cnt;
    
    }
}