class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer>mpp=new HashMap<>();
        for(char ch:s.toCharArray()) { 
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        List<Character>li=new ArrayList<>(mpp.keySet());
        Collections.sort(li,(a,b)->mpp.get(b)-mpp.get(a));
        StringBuilder sb=new StringBuilder();
        for(char ch : li){ 
            int freq=mpp.get(ch);
            while(freq>0){ 
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
}