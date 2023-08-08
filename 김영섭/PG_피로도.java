class Solution {
	public int solution(int k, int[][] dungeons)
	{
		int answer = sol(k, 0, 0, dungeons); // 처음 피로도, 처음 방문 수(0), 처음 미룬 수(0), 던전
		return answer;
	}
	
	public int sol(int k, int visited, int procrasted, int[][] dungeons)
	{
		int idx = -1;
		int avail = 0;
		
        // 한번 슥 보면서 내가 갈 수 있는 던전이 몇 개인지 봅니다.
        // 갈 수 있는 던전이 없다면 종료 조건으로 사용해도 되지만,
        // 해당 부분을 구현한 이유는 (내가 던전을 입장하지 않고 미뤘던 횟수)와 비교해서
        // 만약 미뤘던 횟수와 갈 수 있는 던전의 개수가 같다면
        // 하나도 방문 안하고 미루기만 했다는 의미이므로
        // 이후에 무조건 하나 방문시켜야 재귀가 무한으로 돌지 않습니다.
		for (int i = 0; i < dungeons.length; i++)
			if (k >= dungeons[i][0]) 
				avail ++;
		
        // 내가 갈 수 있는 던전 중 첫 인덱스를 확인합니다.
        // 위 반복문이랑 중복해서 써도 괜찮을 것 같은데
        // 조금씩 고치다 보니 코드가 중구난방이네요 
		for (int i = 0; i < dungeons.length; i++)
		{
			if (k >= dungeons[i][0])  
			{
				idx = i;
				break;
			}
		}
		
        // 만약 던전이 하나밖에 남지 않았다면
        // 갈 수 있으면 하나 더 방문한 값을 return하고
        // 못가면 그냥 방문했던 값 return
		if (dungeons.length == 1)
		{
			if (k >= dungeons[0][0])
				return visited + 1;
			else
				return visited;
		}
		
        // idx 가 갱신되지 않았다는 건
        // 방문할 수 있는 던전이 없다는 거니까
        // 바로 방문했던 수 return
		if (idx == -1)
			return visited;
		
        // idx가 마지막 던전이라는건
        // 방문할 수 있는 던전이 그거밖에 없다는 의미니까
        // 방문했던 수 + 1 return
		if (idx == dungeons.length-1)
			return visited + 1; 
		
        // 만약 방문할 예정이라면 다음 재귀함수에는 내가 방문할 던전을 뺀 던전의 배열을, 
        // 방문하지 않고 나중에 다시 올 예정이라면 해당 던전을 맨 뒤로 미루면 됩니다. 
		int[][] dungeons_visitnow = new int[dungeons.length - 1][2];
		int[][] dungeons_notnow = new int[dungeons.length][2];
		
		int idx_nd = 0;
		for (int i = 0; i < dungeons.length; i++)
		{
			if (i == idx)
				continue;
			dungeons_visitnow[idx_nd] = dungeons[i];
			dungeons_notnow[idx_nd++] = dungeons[i];
		}
		
        // 나중에 다시 올 던전을 맨 마지막에 넣어줍니다. 
		dungeons_notnow[dungeons.length - 1] = dungeons[idx];
		
        // 그런데 내가 지금까지 미뤄온 횟수가 내가 방문할 수 있는 던전의 횟수와 같다면
        // 그만 미루라고 일단 갈 수 있는 던전에 무조건 집어 넣어줍니다.
		if (avail == procrasted)
			return sol(k - dungeons[idx][1], visited +1, 0, dungeons_visitnow);

        // 그게 아니라면 내가 지금 방문하는 경우 vs 방문하지 않는 경우 중 큰 값을 return
        // 방문하는 경우 visited + 1 하고 방문한 던전을 제외한 새로운 던전 리스트를 매개변수로 전달하고
        // 방문하지 않고 미루는 경우 procrast + 1 하고 지금의 던전을 맨 뒤로 넣은 던전 리스트를 전달합니다.  
		return Math.max(sol(k, visited, procrasted + 1, dungeons_notnow), sol(k - dungeons[idx][1], visited +1, 0, dungeons_visitnow));
	}
    
	
}