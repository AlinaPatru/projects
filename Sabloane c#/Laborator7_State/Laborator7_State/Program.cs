using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class Program
    {
        static void Main(string[] args)
        {
            VendingMachine vendingMachine = new VendingMachine();
            int option;

            do
            {
                Console.WriteLine("\nMenu");
                Console.WriteLine("1. Insert Coin");
                Console.WriteLine("2. Eject coin");
                Console.WriteLine("3. Buy product");
                Console.WriteLine("4. Fill machine");
                Console.WriteLine("5. Inspect machine");
                Console.WriteLine("6. Exit \n");

                option = Convert.ToInt32(Console.ReadLine());

                switch (option)
                {
                    case 1:
                        vendingMachine.UpdateState(EUserOption.InsertCoin);
                        break;
                    case 2:
                        vendingMachine.UpdateState(EUserOption.EjectCoin);
                        break;
                    case 3:
                        vendingMachine.UpdateState(EUserOption.BuyProduct);
                        break;
                    case 4:
                        vendingMachine.UpdateState(EUserOption.FillMachine);
                        break;
                    case 5:
                        vendingMachine.UpdateState(EUserOption.InspectMachine);
                        break;
               
                }
           

            } while (option < 6 && option >0);

        }
    }
}
