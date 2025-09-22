import java.util.*;
import java.io.*;

class Employee implements Serializable //(Marker interface it dosent contain any methods)
{
    public int EmpId;
    public String EmpName;
    public int EmpAge;
    public String EmpAddress;
    public int EmpSalary;

    // This is the Counter to not allow duplicate values of EmpId.
    private static int Counter;

    static
    {
        Counter = 1;
    }

    public Employee(
                        String B, 
                        int C, 
                        String D, 
                        int E
                    )
    {
        this.EmpId = Counter++;
        this.EmpName = B;
        this.EmpAge = C;
        this.EmpAddress = D;
        this.EmpSalary = E;
    }

    public void DisplayInformation()
    {
        System.out.println("Id : "+this.EmpId+
                           " Name : "+this.EmpName+
                           " Age : "+this.EmpAge+
                           " Address : "+EmpAddress+
                           " Salary : "+this.EmpSalary);
    }

    public String toString()
    {
        return "Id : "+this.EmpId+
               " Name : "+this.EmpName+
               " Age : "+this.EmpAge+
               " Address : "+EmpAddress+
               " Salary : "+this.EmpSalary;
    }
}


class MarvellousDBMS implements Serializable
{
    private LinkedList<Employee> Table;

    public MarvellousDBMS()
    {
        System.out.println("MarvellousDBMS Started Succefully...");
        Table = new LinkedList<> ();
    }

    //insert into employee values(1,'Amit',23,'Pune',21000);
    public void InsertIntoTable(
                                    String name, 
                                    int age, 
                                    String address, 
                                    int Salary
                                )
    {
        Employee eobj = new Employee(name,age,address,Salary);

        Table.add(eobj);

        System.out.println("Marvellous DBMS : > New record inserted successfully\n");
    }

    //Select * from employee;
    public void SelectStarFrom()
    {
        System.out.println("------------------------------------------------------------------");
        System.out.println("---------------Data from the employee table-----------------------");
        System.out.println("------------------------------------------------------------------");

        for(Employee eref : Table)
        {
            System.out.println(eref);
        }

        System.out.println("------------------------------------------------------------------");
    }

    public void TakeBackup()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("MarvellousDBMS.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured...");
        }
    }

    public static MarvellousDBMS RestoreBackup(String path)
    {
        try
        {
            MarvellousDBMS ret = null; 

            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ret = (MarvellousDBMS) ois.readObject();
            
            return ret;
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured...");
            return null;
        }
    }

    //Select * from employee where EmpId = 11;
    public void SelectSpecificID(
                                    int id
                                )
    {
        boolean found = false;

        for(Employee eref : Table)
        {
            if(eref.EmpId == id)
            {
                found = true;
                System.out.println(eref);
                break;
            }
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
    }

    //Select * from employee where EmpName = 'amit';
    public void SelectSpecificName(
                                        String name
                                    )
    {
        boolean found = false;

        for(Employee eref : Table)
        {
            if(name.equals(eref.EmpName))
            {
                found = true;
                System.out.println(eref);
            }
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
    }

    //Delete from employee where EmpId = 11;
    public void DeleteSpecificId(   
                                    int id
                                )
    {
        boolean found = false;
        int index = 0;

        for(Employee eref : Table)
        {
            if(eref.EmpId == id)
            {
                found = true;
                break;
            }

            index++;
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record succesfully deleted");
        }
    }

    //Select * from employee where EmpAddress = 'Pune';
    public void SelectSpecificAddress(
                                            String address
                                        )   
    {
        boolean found = false;

        for(Employee eref : Table)
        {
            if(address.equals(eref.EmpAddress))
            {
                found = true;
                System.out.println(eref);
            }
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
    }

    //Select * from employee where EmpAge = 22;
    public void SelectSpecificAge(
                                    int age
                                )
    {
        boolean found = false;

        for(Employee eref : Table)
        {
            if(eref.EmpAge == age)
            {
                found = true;
                System.out.println(eref);
                break;
            }
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
    }

    //Select * from employee where EmpSalary = 22000;
    public void SelectSpecificSalary(
                                        int Salary
                                    )
    {
        boolean found = false;

        for(Employee eref : Table)
        {
            if(eref.EmpSalary == Salary)
            {
                found = true;
                System.out.println(eref);
                break;
            }
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
    }

    //Delete from employee where EmpAge = 21;
    public void DeleteSpecificAge(   
                                    int age
                                )
    {
        boolean found = false;
        int index = 0;

        for(Employee eref : Table)
        {
            if(eref.EmpAge == age)
            {
                found = true;
                break;
            }

            index++;
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record succesfully deleted");
        }
    }

    //Delete from employee where EmpSalary = 21000;
    public void DeleteSpecificSalary(   
                                        int salary
                                    )
    {
        boolean found = false;
        int index = 0;

        for(Employee eref : Table)
        {
            if(eref.EmpSalary == salary)
            {
                found = true;
                break;
            }

            index++;
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record succesfully deleted");
        }
    }

    //Delete from employee where EmpName = 'amit';
    public void DeleteSpecificName(   
                                        String name
                                    )
    {
        boolean found = false;
        int index = 0;

        for(Employee eref : Table)
        {
            if(name.equals(eref.EmpName))
            {
                found = true;
                break;
            }

            index++;
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record succesfully deleted");
        }
    }

    //Delete from employee where EmpAddress = 'pune';
    public void DeleteSpecificAddress(   
                                        String address
                                    )
    {
        boolean found = false;
        int index = 0;

        for(Employee eref : Table)
        {
            if(address.equals(eref.EmpAddress))
            {
                found = true;
                break;
            }

            index++;
        }

        if(found == false)
        {
            System.out.println("There is no such record");
        }
        else
        {
            Table.remove(index);
            System.out.println("Record succesfully deleted");
        }
    }

    //Select max(salary) from student;
    public int SelectMaxSalary() 
    {
        if (Table.isEmpty()) 
        {
            System.out.println("Employee table is empty.");
            return -1;
        }

        int iMax = Integer.MIN_VALUE;

        for (Employee eref : Table) 
        {
            if (eref.EmpSalary > iMax) 
            {
                iMax = eref.EmpSalary;
            }
        }

        return iMax;
    }

    //Select min(salary) from student;
    public int SelectMinSalary() 
    {
        if (Table.isEmpty()) 
        {
            System.out.println("Employee table is empty.");
            return -1;
        }

        int iMin = Integer.MAX_VALUE;

        for (Employee eref : Table) 
        {
            if (eref.EmpSalary < iMin) 
            {
                iMin = eref.EmpSalary;
            }
        }

        return iMin;
    }

    public int SelectCountEmployee()
    {
        return Table.size();
    }

    //Select sum(salary) from student;
    public int SelectSumSalary() 
    {
        if (Table.isEmpty()) 
        {
            System.out.println("Employee table is empty.");
            return -1;
        }

        int iSum = 0;

        for (Employee eref : Table) 
        {
            iSum = iSum + eref.EmpSalary;
        }

        return iSum;
    }

    //Select avg(salary) from student;
    public double SelectAvgSalary() 
    {
        if (Table.isEmpty()) 
        {
            System.out.println("Employee table is empty.");
            return 0.0;
        }

        int iSum = 0;
        double iAvg = 0.0;

        for (Employee eref : Table) 
        {
            iSum = iSum + eref.EmpSalary;
        }

        iAvg = (double) iSum / Table.size();

        return iAvg;
    }

    public void UpdateSalaryById(int id, int Newsalary) 
    {
        boolean found = false;

        for (Employee eref : Table) 
        {
            if (eref.EmpId == id) 
            {
                eref.EmpSalary = Newsalary;
                found = true;
                System.out.println("Salary updated successfully for EmpId: " + id);
                break;
            }
        }

        if (found == false) 
        {
            System.out.println("Employee with ID " + id + " not found.");
        }
}


}//End of Marvellous DBMS

class Customized_Database_Management_System
{
    public static void main(String A[]) throws Exception
    {
        MarvellousDBMS mobj = MarvellousDBMS.RestoreBackup("MarvellousDBMS.ser");


        if(mobj == null)
        {
            System.out.println("Unable to restore the backup");

            mobj = new MarvellousDBMS();
        }

        Scanner sobj = new Scanner(System.in);

        int iOption = 0, salary = 0, age = 0, id = 0, iRet = 0, Newsalary = 0;
        double iRet1 = 0.0;
        String name = "", address = "";

        System.out.println("------------------------------------------------------------------");
        System.out.println("----------------------Marvellous DBMS-----------------------------");
        System.out.println("------------------------------------------------------------------");

        while(iOption != 20)
        {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1 : Insert into employee ");
            System.out.println("2 : Select * from employee ");
            System.out.println("3 : Take a Backup of inserted table ");
            System.out.println("4 : Select * from employee where EmpId =  ");
            System.out.println("5 : Select * from employee where EmpName =  ");
            System.out.println("6 : Delete from employee where EmpId =  ");
            System.out.println("7 : Select * from employee where EmpAddress =  ");
            System.out.println("8 : Select * from employee where EmpAge =  ");
            System.out.println("9 : Select * from employee where EmpSalary =  ");
            System.out.println("10 : Delete from employee where EmpAge =  ");
            System.out.println("11 : Delete from employee where EmpSalary =  ");
            System.out.println("12 : Delete from employee where EmpName =  ");
            System.out.println("13 : Delete from employee where EmpAddress =  ");
            System.out.println("14 : Select max(salary) from employee ");
            System.out.println("15 : Select min(salary) from employee ");
            System.out.println("16 : Select count(*) from employee ");
            System.out.println("17 : Select sum(salary) from employee ");
            System.out.println("18 : Select avg(salary) from employee ");
            System.out.println("19 : Update employee set Salary = __ where id = __ ");
            System.out.println("20 : Terminate the DBMS ");
            System.out.println("------------------------------------------------------------------");

            System.out.println("Please Select the desired operation on the database");
            iOption = sobj.nextInt();

            if(iOption == 1)
            {
                System.out.println("Please enter the data that you want to insert : ");

                sobj.nextLine();
                System.out.println("Enter the name of employee : ");
                name = sobj.nextLine();

                System.out.println("Enter the Age of employee : ");
                age = sobj.nextInt();

                sobj.nextLine();
                System.out.println("Enter the Address of employee : ");
                address = sobj.nextLine();

                System.out.println("Enter the Salary of employee : ");
                salary = sobj.nextInt();

                mobj.InsertIntoTable(name,age,address,salary);
            }
            else if(iOption == 2)
            {
                mobj.SelectStarFrom();
            }
            else if(iOption == 3)
            {
                mobj.TakeBackup();

                System.out.println("Database gets succesfully stored into secondary storage");
            }
            else if(iOption == 4)
            {
                System.out.println("Enter the employee id : ");
                id = sobj.nextInt();

                mobj.SelectSpecificID(id);
            }
            else if(iOption == 5)
            {
                sobj.nextLine();
                System.out.println("Enter the employee name : ");
                name = sobj.nextLine();

                mobj.SelectSpecificName(name);
            }
            else if(iOption == 6)
            {
                System.out.println("Enter the employee id : ");
                id = sobj.nextInt();

                mobj.DeleteSpecificId(id);
            }
            else if(iOption == 7)
            {
                sobj.nextLine();
                System.out.println("Enter the employee address : ");
                address = sobj.nextLine();

                mobj.SelectSpecificAddress(address);
            }
            else if(iOption == 8)
            {
                System.out.println("Enter the employee age : ");
                age = sobj.nextInt();

                mobj.SelectSpecificAge(age);
            }
            else if(iOption == 9)
            {
                System.out.println("Enter the employee Salary : ");
                salary = sobj.nextInt();

                mobj.SelectSpecificSalary(salary);
            }
            else if(iOption == 10)
            {
                System.out.println("Enter the employee Age : ");
                age = sobj.nextInt();

                mobj.DeleteSpecificAge(age);
            }
            else if(iOption == 11)
            {
                System.out.println("Enter the employee Salary : ");
                salary = sobj.nextInt();

                mobj.DeleteSpecificSalary(salary);
            }
            else if(iOption == 12)
            {
                sobj.nextLine();
                System.out.println("Enter the employee name : ");
                name = sobj.nextLine();

                mobj.DeleteSpecificName(name);
            }
            else if(iOption == 13)
            {
                sobj.nextLine();
                System.out.println("Enter the employee address : ");
                address = sobj.nextLine();

                mobj.DeleteSpecificAddress(address);
            }
            else if(iOption == 14)
            {
                iRet = mobj.SelectMaxSalary();
                System.out.println("The Maximum Salary from the Employee table is : "+iRet);
            }
            else if(iOption == 15)
            {
                iRet = mobj.SelectMinSalary();
                System.out.println("The Minimum Salary from the Employee table is : "+iRet);
            }
            else if(iOption == 16)
            {
                iRet = mobj.SelectCountEmployee();
                System.out.println("The Count of employees from the Employee table is : "+iRet);
            }
            else if(iOption == 17)
            {
                iRet = mobj.SelectSumSalary();
                System.out.println("The Sum of all employees Salary from the Employee table is : "+iRet);
            }
            else if(iOption == 18)
            {
                iRet1 = mobj.SelectAvgSalary();
                System.out.println("The average of all employees Salary from the Employee table is : "+iRet1);
            }
            else if(iOption == 19)
            {
                System.out.println("Enter the employees id whos salary you want to update : ");
                id = sobj.nextInt();

                System.out.println("Enter the employee New Salary : ");
                Newsalary = sobj.nextInt();

                mobj.UpdateSalaryById(id,Newsalary);
            }
            else if(iOption == 20)
            {
                System.out.println("Thank you for using the Application");
                mobj = null;
                System.gc();
                break;
            }
        }//End of While

    }//End of main method

}//End of main class