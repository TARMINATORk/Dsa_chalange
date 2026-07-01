class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        String ans="";
        Map<Character,Integer>tmap=new HashMap<>();
        for(char ch:t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
           
        HashMap<Character,Integer>smap=new HashMap<>();

        int left=0;
        int count=t.length();
        int maxlen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch)&& smap.get(ch)<=tmap.get(ch)){
                count--;
            }
            while(count==0){
                if(right-left+1<maxlen){
                    maxlen=right-left+1;
                    ans=s.substring(left,right+1);
                }
                char l=s.charAt(left);
                smap.put(l,smap.getOrDefault(l,0)-1);
                if(tmap.containsKey(l) && smap.get(l)<tmap.get(l)){
                    count++;
                }
                left++;
            }
        }
        return ans;
    }
}