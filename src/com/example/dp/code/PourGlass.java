package com.example.dp.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class PourGlass {

    static class Glass{
        double quantity;
        double extra;
    }

    private void helper(int poured,int currLevel,List<List<Glass>> tower){
        if(poured==0){
            boolean isExtraPresent = isExtraPresentOnPrevLevel(tower,currLevel-1);
            if(currLevel>=tower.size() && isExtraPresent){
                tower.add(new ArrayList<>());
                List<Glass>  row = tower.get(currLevel);
                for(int i=0;i<currLevel;i++){
                    row.add(new Glass());
                }
            }
            if(isExtraPresent){
                processCurrLevel(tower,currLevel);
            }
        }
    }

    private void processCurrLevel(List<List<Glass>> tower, int currLevel) {
        if(currLevel>=tower.size()){
            tower.add(new ArrayList<>());
            List<Glass>  row = tower.get(currLevel);
            for(int i=0;i<currLevel;i++){
                row.add(new Glass());
            }
        }

        List<Glass>  row = tower.get(currLevel);
        List<Glass>  prevRow = tower.get(currLevel-1);
        for(int i=0;i<row.size();i++){
            if(i==0){
                Glass prevGlass = prevRow.get(0);
                Glass currGlass = row.get(0);
                if(currGlass.quantity!=1){
                    currGlass.quantity=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }else {
                    currGlass.extra=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }
            }else if(i==row.size()-1){
                Glass prevGlass = prevRow.get(prevRow.size()-1);
                Glass currGlass = row.get(row.size()-1);
                if(currGlass.quantity!=1){
                    currGlass.quantity=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }else {
                    currGlass.extra=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }
            }else{
                Glass prevGlass = prevRow.get(prevRow.size()-1);
                Glass currGlass = row.get(row.size()-1);
                if(currGlass.quantity!=1){
                    currGlass.quantity=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }else {
                    currGlass.extra=prevGlass.extra/2;
                    prevGlass.extra= prevGlass.extra/2;
                }
            }
        }

    }

    private boolean isExtraPresentOnPrevLevel(List<List<Glass>> tower, int level) {
        List<Glass> row = tower.get(level);
        for(int i=0;i<row.size();i++){
            if(row.get(i).quantity==1 && row.get(i).extra>0){
                return true;
            }
        }
        return false;
    }

    public static double champagneTowerOld(int poured, int query_row, int query_glass) {
        List<List<Glass>> tower =new ArrayList<>();
        int index =0;
        while(poured>0){
            if(index>=tower.size()){
                tower.add(new ArrayList<>());
            }
            List<Glass>  row = tower.get(index);
            if(row.isEmpty()){
                for(int i=0;i<=index;i++){
                    row.add(new Glass());
                }
            }
            if(index==0){
                Glass glass = row.get(0);
                if(glass.quantity==0){
                    glass.quantity=1;
                    poured--;
                    continue;
                }else if (glass.extra==0){
                    glass.extra=1;
                    continue;
                }else{
                    index++;
                    continue;
                }
            }else if(index>=1){
                for(int i=0;i<row.size();i++){
                    Glass currGlass = row.get(i);
                    if(i==0){
                        Glass upperGlass = tower.get(index-1).get(0);
                        if(currGlass.quantity<=0){
                            currGlass.quantity = upperGlass.extra/2;
                            upperGlass.extra = upperGlass.extra/2;
                        }else{
                            currGlass.extra = upperGlass.extra/2;
                            upperGlass.extra = upperGlass.extra/2;
                        }
                    }else if(i==row.size()-1){
                        Glass upperGlass = tower.get(index-1).get(index-1);
                        if(currGlass.quantity<=0){
                            currGlass.quantity = upperGlass.extra;
                            upperGlass.extra = 0;
                        }else{
                            currGlass.extra = upperGlass.extra;
                            upperGlass.extra = 0;
                        }
                    }else{
                        Glass upperGlass1 = tower.get(index-1).get(i-1);
                        Glass upperGlass2 = tower.get(index-1).get(i);
                        if(currGlass.quantity<=0){
                            currGlass.quantity = upperGlass1.extra + upperGlass2.extra/2;
                            upperGlass1.extra = 0;
                            upperGlass2.extra = upperGlass2.extra/2;
                        }else{
                            currGlass.extra = upperGlass1.extra + upperGlass2.extra/2;
                            upperGlass1.extra = 0;
                            upperGlass2.extra = upperGlass2.extra/2;
                        }
                    }
                }
            }
            boolean isFilled =true;
            for(int i=0;i<row.size();i++){
                if(row.get(i).quantity==1 && row.get(i).extra==1) {
                    continue;
                }else{
                    isFilled=false;
                    break;
                }
            }
            if(isFilled){
                index++;
            }
            poured--;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(champagneTower(3,1,1));
        System.out.println(champagneTower(100000009,33,17));
        double spare = 3d/2;
        System.out.println(spare);
    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0.0;

        double[][] dp =new double[query_row+2][query_glass+2];
        dp[0][0]=poured;
        for(int i=0;i<dp.length-1;i++){
            for(int j=0;j<dp[i].length-1;j++){
                if(dp[i][j]>1.0){
                    double spare = dp[i][j]-1;
                    dp[i][j] =1;
                    spare =spare/2;
                    dp[i+1][j]+=spare;
                    dp[i+1][j+1]+=spare;
                }
            }
        }
        double result= dp[query_row][query_glass];
        return Math.min(result, 1.0);


    }

}
