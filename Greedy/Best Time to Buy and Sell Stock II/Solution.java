class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;       
        int res = 0;
        
        boolean isGoingUp = false;
        int buyPrice = -1;
        
        for(int i=0; i<prices.length-1; i++){
            if(isGoingUp && (prices[i]>prices[i+1])){
                isGoingUp = false;
                res+=(prices[i]-buyPrice);
                buyPrice = -1;
                continue;
            }            
            if((!isGoingUp) && (prices[i]<prices[i+1])){
                isGoingUp = true;
                buyPrice = prices[i];
                continue;
            }
        }
        
        if(isGoingUp){
            res+=(prices[prices.length-1]-buyPrice);
        }
        
        return res;
    }
}