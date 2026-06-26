class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        Map<Character,Integer>pmap=new HashMap<>();
        Map<Character,Integer>smap=new HashMap<>();

        if(s.length()<p.length()){ 
            return ans;
        }
        for(char ch:p.toCharArray()){ 
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }
        int left=0;
        int count=p.length();

        for(int right=0;right<s.length();right++){ 
            char r=s.charAt(right);
            smap.put(r,smap.getOrDefault(r,0)+1);

            if(pmap.containsKey(r) && smap.get(r)<=pmap.get(r)){ 
                count--;
            }
            if(right-left+1>p.length() ){ 
                char l=s.charAt(left);

                if(pmap.containsKey(l) && smap.get(l)<=pmap.get(l)){ 
                    count++;
                }
                smap.put(l,smap.getOrDefault(l,0)-1);
                left++;

               
            }
            if(count==0){ 
                ans.add(left);
            }
        }
        return ans;

    }
}