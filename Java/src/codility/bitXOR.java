package codility;

/**
 * Created by IQBAL-MEBELKART on 8/20/2016.
 */
public class bitXOR {

    public static void main(String args[]){
        System.out.println(getXor(5));
    }

    public static int getXor(int num){
        if(num==8){
            int res=num^num-1;
            System.out.println(num+"^"+(num-1)+"="+res);
            return res;
        }
        int res1=num ^ getXor(num+1);
        System.out.println(num+"^"+(num+1)+"="+res1);
        return res1;
    }
}