package com.cc.infiniteunitcircle;

/**
 * Created by Chad on 11/13/2014.
 */
public class UnitCircle {
    private static final int[] degrees = {0,30,45,60,90,120,135,150,180,210,225,240,270,300,315,330};
    private static final int[] radNumerator={0,1,1,1,1,2,3,5,1,7,5,4,3,5,7,11};
    private static final int[] radDenominator={0,6,4,3,2,3,4,6,1,6,4,3,2,3,4,6};
    private static final int[] xCoordNumerator={1,3,2,1,0,-1,-2,-3,-1,-3,-2,-1,0,1,2,3};
    private static final int[] xCoordDenominator={1,2,2,2,0,2,2,2,1,2,2,2,0,2,2,2};
    private static final int[] yCoordNumerator={0,1,2,3,1,3,2,1,0,-1,-2,-3,-1,-3,-2,-1};
    private static final int[] yCoordDenominator={0,2,2,2,1,2,2,2,0,2,2,2,1,2,2,2};
    private static final int[] tanNumerator={0,3,1,3,99,-3,-1,-3,0,3,1,3,99,-3,-1,-3};
    private static final int[] tanDenominator={0,3,1,1,99,1,1,3,0,3,1,1,99,1,1,3};
    private static final int[] cscNumerator={99,2,2,23,1,23,2,2,99,-2,-2,-23,-1,-23,-2,-2};
    private static final int[] cscDenominator={99,1,1,3,1,3,1,1,99,1,1,3,1,3,1,1,99};
    private static final int[] secNumerator={1,23,2,2,99,-2,-2,-23,-1,-23,-2,-2,99,2,2,23};
    private static final int[] secDenominator={1,3,1,1,99,1,1,3,1,3,1,1,99,1,1,3};
    private static final int[] cotNumerator={99,3,1,3,0,-3,-1,-3,99,3,1,3,0,-3,-1,-3};
    private static final int[] cotDenominator={99,1,1,3,1,3,1,1,99,1,1,3,1,3,1,1};
    static String build = "rbSam2XCPzDRt2ftKFkllbsZEqvwtvT8FCMSFr9FH9r5jsR49SiY4054r2sFg/QhnKejisd0M8gHKdxVBWnTWLw+jCPwVQhmkQtNqjm6k7TToJ0KOvttp";

    public static String radTop(int position, int revolutions){
        int rad;
        if(revolutions<1 && MyActivity.getParts()<0 && MyActivity.getParts()%16 !=0){
            if (radDenominator[position] != 0) {
                rad = 2 * (revolutions-1) * radDenominator[position] + radNumerator[position];
            } else rad = 2 * (revolutions-1);
        }
        else{
            if (radDenominator[position] != 0) {
                rad = 2 * revolutions * radDenominator[position] + radNumerator[position];
            } else rad = 2 * revolutions;
        }
        if(rad==0)return "0";
        else return rad+"\u03c0";
    }

    public static String radBot(int position){
        if(radDenominator[position]==0||radDenominator[position]==1)return "";
        else return "/"+radDenominator[position];
    }

    public static String degrees(int position, int revolutions){
        int deg;
        if(revolutions<1 && MyActivity.getParts()<0 && MyActivity.getParts()%16 !=0)deg = 360*(revolutions-1) + degrees[position];
        else deg = 360*revolutions + degrees[position];
        return deg+"\u00b0";
    }

    public static String xCoordTop(int position){
        if(xCoordNumerator[position]>1)return "\u221a"+xCoordNumerator[position];
        else if(xCoordNumerator[position]<-1)return "-\u221a"+Math.abs(xCoordNumerator[position]);
        else return xCoordNumerator[position]+"";
    }

    public static String xCoordBot(int position){
        if(xCoordDenominator[position]==0||xCoordDenominator[position]==1)return "";
        else return "/"+xCoordDenominator[position];
    }

    public static String yCoordTop(int position){
        if(yCoordNumerator[position]>1)return "\u221a"+yCoordNumerator[position];
        else if(yCoordNumerator[position]<-1)return "-\u221a"+Math.abs(yCoordNumerator[position]);
        else return yCoordNumerator[position]+"";
    }

    public static String yCoordBot(int position){
        if(yCoordDenominator[position]==0||yCoordDenominator[position]==1)return "";
        else return "/"+yCoordDenominator[position];
    }

    public static String tanTop(int position){
        if(tanNumerator[position]==99)return "undef";
        else if(tanNumerator[position]>1)return "\u221a"+tanNumerator[position];
        else if(tanNumerator[position]<-1)return "-\u221a"+Math.abs(tanNumerator[position]);
        else return tanNumerator[position]+"";
    }

    public static String tanBot(int position){
        if(tanDenominator[position]==0||tanDenominator[position]==1||tanDenominator[position]==99)return "";
        else return "/"+tanDenominator[position];
    }

    public static String cscTop(int position){
        if(cscNumerator[position]==99)return "undef";
        else if(Math.abs(cscNumerator[position])==2 && position %2==1)return cscNumerator[position]+"";
        else if(cscNumerator[position]==2 && position %2==0)return "\u221a"+cscNumerator[position];
        else if(cscNumerator[position]==-2 && position %2==0)return "-\u221a"+Math.abs(cscNumerator[position]);
        else if(cscNumerator[position]==23)return "2\u221a3";
        else if(cscNumerator[position]==-23)return "-2\u221a3";
        else return cscNumerator[position]+"";
    }

    public static String cscBot(int position){
        if(cscDenominator[position]==0||cscDenominator[position]==1||cscDenominator[position]==99)return "";
        else return "/"+cscDenominator[position];
    }

    public static String secTop(int position){
        if(secNumerator[position]==99)return "undef";
        else if(Math.abs(secNumerator[position])==2 && position %2==1)return secNumerator[position]+"";
        else if(secNumerator[position]==2 && position %2==0)return "\u221a"+secNumerator[position];
        else if(secNumerator[position]==-2 && position %2==0)return "-\u221a"+Math.abs(secNumerator[position]);
        else if(secNumerator[position]==23)return "2\u221a3";
        else if(secNumerator[position]==-23)return "-2\u221a3";
        else return secNumerator[position]+"";
    }

    public static String secBot(int position){
        if(secDenominator[position]==0||secDenominator[position]==1||secDenominator[position]==99)return "";
        else return "/"+secDenominator[position];
    }

    public static String cotTop(int position){
        if(cotNumerator[position]==99)return "undef";
        else if(cotNumerator[position]==3)return "\u221a3";
        else if(cotNumerator[position]==-3)return "-\u221a3";
        else return cotNumerator[position]+"";
    }

    public static String cotBot(int position){
        if(cotDenominator[position]==0||cotDenominator[position]==1||cotDenominator[position]==99)return "";
        else return "/"+cotDenominator[position];
    }
}
