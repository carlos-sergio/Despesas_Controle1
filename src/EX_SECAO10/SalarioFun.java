package EX_SECAO10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SalarioFun {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<SalarioFunCod> list = new ArrayList<>();


        System.out.println("How many employees will be registred? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.println("Id:");
            Integer id = sc.nextInt();
            //usa o while para contornar hasId e verificar se o id é repetido
            while (hasId(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            double salary = sc.nextDouble();

            SalarioFunCod salariof = new SalarioFunCod(id, name, salary);

            list.add(salariof);
        }
        System.out.println();
        System.out.println("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        SalarioFunCod salariof = list.stream().filter(x -> x.getId() == idSalary)
                .findFirst().orElse(null);

/// p3
        if (salariof == null) {
            System.out.println(" This id does not exist");
        } else {
            System.out.println("enter the percentage");
            double percentage = sc.nextDouble();
            salariof.AcressSalary(percentage);
        }
        System.out.println();
        System.out.println("list off employees");
        for (SalarioFunCod emp : list) {
            System.out.println(emp);
        }

        System.out.println();


        sc.close();


    }

    public static Integer position(List<SalarioFunCod> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<SalarioFunCod> list, int id) {
        SalarioFunCod salariof = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return salariof != null;
    }
}