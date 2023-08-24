import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int bridge_len;
	
	public class Truck {
		int pos = 0;
		int weight;
		int escapeTime;
		
		Truck(int weight, int enterTime) {
			this.weight = weight;
			this.escapeTime = enterTime + bridge_len;
		};
	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue <Truck> bridge = new LinkedList<> ();
        
        // 전역 설정.
        bridge_len = bridge_length;
        
        int time = 0;
        int WeightOnBridge = 0;
        
        // 탈 수 있으면 탄다 (내리지 않고)
        // 내릴 수 있으면 내리고 탄다. 
        
        int idx = 0;
        
       	while (idx < truck_weights.length || WeightOnBridge != 0)
        {
            time ++;
            // 먼저 큐를 돌며 다리 위 트럭을 모두 이동시킨다. 
            
            if (!bridge.isEmpty() && time >= bridge.peek().escapeTime)
            	WeightOnBridge -= bridge.poll().weight;
            
            // 트럭이 남아있고, 다리 위에 더 올라갈 수 있으면 올린다. 
            if (idx < truck_weights.length && WeightOnBridge + truck_weights[idx] <= weight)
            {
                bridge.add(new Truck(truck_weights[idx], time));
                WeightOnBridge += truck_weights[idx];

                idx ++;
            }
        }
        
        return time;
    }
}