import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一
 些物品，这些物品的总体积必须是40。
  John现在有n（1≤n ≤ 20）个想要得到的物品，每个物品
 的体积分别是a1，a2……an。John可以从这些物品中选择一
 些，如果选出的物体的总体积是40，那么利用这个神奇的口
 袋，John就可以得到这些物品。现在的问题是，John有多少
 种不同的选择物品的方式。
 */


/**
 * 物品可以选择  选或者不选
 * 所以复杂度为  2^n
 * 用1代表选 0代表不选
 * 二进制来表示
 * 例如 100  转为十进制为4
 * 表示之选第一个物品 是否能到达40空间的要求
 */
public class test1 {

    private static int[] items;

    private static List<Integer> complele=new ArrayList<>();

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if (n<1||n>20){
            System.out.println("输入错误");
            return;
        }
        items=new int[n];

        for (int i=0;i<n;i++){
            Scanner item=new Scanner(System.in);

            int itemVolume=item.nextInt();
            if (itemVolume>40||itemVolume<0){
                System.out.println("输入错误");
                return;
            }
            items[n-1-i]=itemVolume;
        }

        for (int i=0;i<Math.pow(2,n);i++){
            String str= binaryToDecimal(i);
            int length=str.length();
            if (str.equals("")){
                continue;
            }
            int y=0;
            int all=0;
            for (y=0;y<n;y++) {
                if (length-1-y>=0) {
                    String sub = str.substring(length - 1 - y, length - y);
                    if (sub.equals("1")) {
                        all+=items[n-y-1];
                    }
                }
                else {
                    break;
                }
            }
            if (all==40){
                complele.add(i);
            }

        }


        System.out.println(complele.size());


    }

    private static void ways(int m,int n){


    }


    public static void binaryToDecimal(int n,int max){
              for(int i = max;i >= 0; i--)
                      System.out.print(n >>> i & 1);
         }

    public static String binaryToDecimal(int n){
              String str = "";
              while(n!=0){
                      str = n%2+str;
                      n = n/2;
                  }
            return str;
        }
}
