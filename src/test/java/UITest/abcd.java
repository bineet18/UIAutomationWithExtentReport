package UITest;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestClass {
    public static boolean validate(List<String> orderLines) {
        // TODO -- write your code here, and remember to return the 
        // correct boolean value
        List<Boolean> result = new ArrayList<Boolean>();

        for(int i=1;i<orderLines.size();i++)
        {
            List<String> temp = Arrays.asList(orderLines.get(i).split(",",0));

            System.out.println(temp);



            //int requiredSum = Integer.parseInt(temp[1]);
            //int actualSum = Integer.parseInt(temp[5])+Integer.parseInt(temp[7]);
    
          /*  if(requiredSum==actualSum)
            {
                result.add(true);
                System.out.println(true);
            }
            else
            {
                result.add(false);
                System.out.println(false);
            }*/
        }
    /*
        if(result.contains(false))
        {return false;}
        else
        {return true;}
    */
        return true;
    }

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        List<String> orderLines = new ArrayList<String>();
        String l;
        while(input.hasNextLine()) {
            l = input.nextLine();
            if(l.equals("")) {
                System.out.println(validate(orderLines));
                orderLines = new ArrayList<String>();
            } else {
                orderLines.add(l);
            }
        }
        if(orderLines.size()>0) {
            System.out.println(validate(orderLines));            
        }
    }
}
