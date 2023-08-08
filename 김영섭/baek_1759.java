import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주석까지 다 달았는데 날아가서 두번째로 씁니다 ... 
// 정리 + 기록을 위해서 올립니다. 근데 문제가 어렵습니다.
// 저도 다시 풀라고 하면 한참 걸릴 것 같아요. 그러니까 너무 무리해서 이해하려 하지 않으셔도 좋을 것 같습니다.
// 문제는 문자들을 받아서 해당 문자로 만들 수 있는 어떤 길이의 모든 암호 조합을 출력하는 내용입니다.
// 단, 조건이 있는데 각 암호는 알파벳 순으로 정렬된 상태여야 하고
// 모음이 최소 한개, 자음이 최소 두개 이상 있어야 합니다.
// 이런 경우에, 문제에서 테스트케이스로 주어지는 암호의 길이가 몇인지 알 수 없으므로
// 내가 반복문을 몇 겹으로 중첩해야할 지 알 수 없고,
// 재귀를 통해서 완전 탐색을 진행해야 합니다.

public class Main {
    public static void main (String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st = new StringTokenizer(br.readLine()); 
           
           int len = Integer.parseInt(st.nextToken());
           int K = Integer.parseInt(st.nextToken());
           String str = "";
           
           char[] alpha = new char[K];
           
		// 답을 만들 재귀함수에 매개변수로 (내가 선택해온 문자들) (내가 앞으로 선택할 수 있는 문자들) (내가 원하는 길이)
		// 를 넣어야 합니다. 내가 원하는 길이가 되었을 때, 조건을 만족하면 출력하고, 그렇지 못하면 아무것도 출력하지 않고 종료하면 됩니다.
		// 이때 내가 선택해온 문자들, 선택할 수 있는 문자들을 전달하는 방법으로는 배열이 있을 수 있습니다. 
		// 하지만, 내가 선택하고 남은 (내가 선택할 수 있는 문자열) 을 전달하기 위해 이를 새로 만드는 과정에서
		// 베열을 이용하여 전달하는 것은 직관적이지 못하고, 몹시 불편합니다.
		// 배열을 이용한다면, 반복문을 사용해서 내가 선택한 것을 찾아서 제외해야하고 나머지를 새로운 배열에 하나하나 넣어주어야하는데
		// 이 과정에서 idx를 하나 더 사용해야하기도 하고, 아무튼 복잡합니다. 

		// 대신 문자열의 substring 기능을 이용하면, 아주 간편하게 할 수 있습니다.
		// 만약 i 번째 문자열을 선택했다면, substring(i+1) 을 전달하면 됩니다.
			// 아래 while문에서 굳이 배열문을 만든건 제가 처음에 배열문으로 풀려 했기 때문입니다.
			// 때문에 빈 str이라는 문자열에 굳이 돌면서 문자를 하나씩 append 해주는 과정이 중복되었습니다.
			// 다시 생각해보니까 sort를 사용하기 위함인 것 같기도 합니다.

           st = new StringTokenizer(br.readLine()); 
           
           while(--K >= 0)
               alpha[K] = st.nextToken().charAt(0); 
           
			// 여기서 sorting이 필요한데, 
			// 암호 내 알파벳순으로 정렬되어있어야 하므로
			// 받은 input을 먼저 알파벳으로 정렬하고 가면 보다 쉽습니다.
			// 다음에 전달해줄 문자열을 훨씬 많이 줄일 수 있어서 탐색할 경우의 수가 줄어듭니다.
			// 말로 설명이 어렵네여. 반대로 순서 따라서 다른 취급하는 순열이라면 정렬 안해도 되는 것 같아요.

          	Arrays.sort(alpha);

           	for (int i = 0; i < alpha.length; i++)
               str += alpha[i];
           
           	String res = "";
           
		   	// str : 내가 앞으로 선택할 수 있는 문자들, res : 내가 선택해온 문자들, len : 내가 원하는 암호의 길이. 
		   	// len에 도달했을 때, 종료 조건을 설정해서 터트려주면 됩니다.

           	printPW(str, res, len); 
    }

    // 이름처럼, 모음인지 여부를 boolean 반환
    static boolean isVowel(char c) 
    {
        if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o')
            return true;
        return false;
    }
    
	// 재귀입니다.
    static void printPW(String str, String res, int len)
    {
    	int cntC = 0; 
    	int cntV = 0;

		// 내가 지나쳐온 문자의 자음과 모음 개수를 세줍니다. 
		// 사실 res의 길이가 len - 1 일때만 세면 되는데 
		// 풀다가 머리가 너무 아파서 그냥 셌어요
		// 원래는 cntC와 cntV도 매개변수로 전달해서 계산 수를 줄이려 했는데
		// 재귀에 매개변수 많으면 너무 어지러워
    	for (int i = 0; i < res.length(); i++)
    	{
    		if (isVowel(res.charAt(i)))
    			cntV++;
    		else
    			cntC++;
    	}
    	
		// 암호의 최소 길이가 3인데, 내가 선택한 + 선택할 암호의 길이가 3보다 작으면 답이 없으니 종료합니다.
    	if (res.length() + str.length() < 3)
    		return ;
    	
		// 만약 지금까지 내가 선택해온 암호의 개수가 완성 직전(len -1)이라면, 이번에 잘 더하면 함수를 종료할 수도 있습니다.
		// 근데 주어진 조건 (자음 두 개 이상, 모음 하나 이상) 을 이미 만족했다면?
		// 남은 문자들에서 아무거나 하나 선택해서 출력하면 됩니다. 그리고 종료합니다.
        if (res.length() == len-1 && cntV > 0 && cntC > 1) // if all condition fulfilled -> print every combs
    	{
        	//System.out.println("cntV " + cntV + " cntC " + cntC + " res " + res);
        	for (int i = 0; i < str.length(); i++)
        		System.out.println(res + str.charAt(i));
        	return ;
    	}
        
		// 만약 여기까지 왔는데 내가 선택해온 암호의 개수가 (len -1)이라면
		// 그건 앞에서 조건을 만족하지 못했기 때문입니다.
		// 만약 이번 암호 한 글자를 더 받았는데
		// 조건을 만족할 수 있다면 출력하고, 아니라면 넘깁니다. 그리고 종료.
        if (res.length() == len-1) // condition not fulfilled, but now can be fulfilled
    	{
    		for (int i = 0; i < str.length(); i++)
    		{
    			if (res.length() == len-1 && cntV == 0 && isVowel(str.charAt(i))) // no vowel found, but now got one
    				System.out.println(res + str.charAt(i)); 
    			if (res.length() == len-1 && cntC == 1 && (!isVowel(str.charAt(i)))) // not enough consonant found, but now got one
    				System.out.println(res + str.charAt(i)); 
    		}
    		return ;
    	}
        
		// 만약 여기까지 왔다면 ... 
		// len - 1에 도달하지도 못했다는 얘기입니다.
		// 그럼 다시 선택해주면 됩니다.
		// 아무거나 골라서, 지금까지 선택한 문자열에 더해서 넘겨주고, 선택할 문자열에서는 빼서 넘겨줍니다.
        for (int i = 0; i < str.length(); i++)
        {
	        printPW(str.substring(i+1), res + str.charAt(i), len);
        }
    }
    
}