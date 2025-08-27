import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
		for (String str : participant)
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		for (String str : completion) {
			hm.put(str, hm.get(str) - 1);
			if (hm.get(str) == 0)
				hm.remove(str);
		}
		String answer = "";
		for (String str : hm.keySet())
			answer = str;
		return answer;
    }
}