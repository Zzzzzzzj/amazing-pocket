import java.util.Scanner;

public class test2 {
    private static int[] items;

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


        int count=ways(40,n);

        System.out.println(count);
    }

    private static int ways(int m,int n){
        if (m==0)
            return 1;
        else if (m<0)
            return 0;
        else
            return ways(m,n-1)+ways(m-items[n-1],n-1);
    }


}
