import java.util.Scanner;

public class Testtrix {
    private boolean is_running;
    private String[] menu_items;
    private Matrix A;
    private Matrix B;

    public Testtrix() {
        double[][] valsA = { { 1., 2., 3 }, { 4., 5., 6. }, { 7., 8., 9. } };
        this.A = new Matrix(valsA);
        this.B = new Matrix(3, 1, 1.);
        is_running = true;
        menu_items = new String[] { "Print", "Print Submatrix", "Multiply", "transpose", "exit" };
    }

    public static void main(String[] args) {

        Testtrix t = new Testtrix();
        t.run();

    }

    public void run() {
        while (is_running) {
            menu_show(this.menu_items);
            menu_user_input();
        }
    }

    public void menu_show(String[] menu_items) {
        int i = 1;

        for (String item : menu_items) {
            System.out.println(i + ") " + item);
            i++;
        }
    }

    public void menu_user_input() {

        Scanner user_input = new Scanner(System.in);
        String next = user_input.next();
        String[] options = { "A", "B" };
        if (next.equals("1")) {
            System.out.println("Choose an array to print \n");
            menu_show(options);
            user_input = new Scanner(System.in);
            next = user_input.next();
            if (next.equals("1")) {
                A.print(9, 1);
            } else {
                B.print(9, 1);
            }
        } else if (next.equals("2")) {
            System.out.println("Enter initial row index \n");
            user_input = new Scanner(System.in);
            int i0 = Integer.parseInt(user_input.next());
            System.out.println("Enter final row index \n");
            user_input = new Scanner(System.in);
            int i1 = Integer.parseInt(user_input.next());
            System.out.println("Enter initial column index \n");
            user_input = new Scanner(System.in);
            int j0 = Integer.parseInt(user_input.next());
            System.out.println("Enter final column index \n");
            user_input = new Scanner(System.in);
            int j1 = Integer.parseInt(user_input.next());
            System.out.println("Choose an array to print from \n");
            menu_show(options);
            user_input = new Scanner(System.in);
            next = user_input.next();
            if (next.equals("1")) {
                A.getMatrix(i0, i1, j0, j1).print(9, 1);
            } else {
                B.getMatrix(i0, i1, j0, j1).print(9, 1);
            }
        } else if (next.equals("3")) {
            System.out.println("Matrix A multiplied by Matrix B is equal to:");
            Matrix c = this.A.times(this.B);
            c.print(9, 1);
        } else if (next.equals("4")) {
            System.out.println("Choose an array to transpose \n");
            menu_show(options);
            user_input = new Scanner(System.in);
            next = user_input.next();
            if (next.equals("1")) {
                A.transpose().print(9, 1);
            } else {
                B.transpose().print(9, 1);
            }
        } else if (next.equals("5")) {
            System.out.println("program ended");
            is_running = false;
        }

    }

}
