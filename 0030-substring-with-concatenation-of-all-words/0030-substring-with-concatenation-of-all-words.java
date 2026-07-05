class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>ans=new ArrayList<>();
        Map<String,Integer>wmap=new HashMap<>();
        for(String word:words) { 
            wmap.put(word,wmap.getOrDefault(word,0)+1);
        }
        int wordlen=words[0].length();
        int totallen=words.length;

        for(int offset=0;offset<wordlen;offset++) { 
            int left=offset;
            int count=0;
            Map<String,Integer>seen=new HashMap<>();
            for(int right=offset;right+wordlen<=s.length();right+=wordlen){ 
                String curr=s.substring(right,right+wordlen);
                if(!wmap.containsKey(curr)){ 
                    seen.clear();
                    count=0;
                    left=right+wordlen;
                    continue;
                }
                seen.put(curr,seen.getOrDefault(curr,0)+1);
                count++;
                while(seen.get(curr)>wmap.get(curr)){ 
                    String lw=s.substring(left,left+wordlen);
                    seen.put(lw,seen.get(lw)-1);

                    left+=wordlen;
                    count--;
                }
                if(count==totallen){ 
                    ans.add(left);
                    String lw=s.substring(left,left+wordlen);
                    seen.put(lw,seen.get(lw)-1);
                    left+=wordlen;
                    count--;
                }
            }
        }
        
        return ans;
    }
}