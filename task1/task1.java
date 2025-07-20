public class task1 {
    public static void main(String[] args){
        if (args.length !=2){
            System.err.println("Можно токо дать 2 параметра.");
        }
        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i + 1;
            }        

            System.out.println("n = "+n+", m = " + m);

            int CurrentIndex = 0;
            System.out.print("Полученный путь: ");
            do {
                System.out.print(array[CurrentIndex]);
                CurrentIndex = ( CurrentIndex + m - 1) % n;
            } while( CurrentIndex != 0);

        } catch (NumberFormatException e) {
            System.out.println("Параметры могут быть токо целыми числами");
        }
    }
}