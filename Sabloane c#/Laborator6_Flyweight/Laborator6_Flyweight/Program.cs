using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    class Program
    {
        static void Main(string[] args)
        {
            Cashier cashier = new Cashier();
            cashier.CashIn(3000, EMoneyType.Paper);
            cashier.CashIn(1, EMoneyType.Coin);

            cashier.CashOut(300,EMoneyType.Paper);

            Console.WriteLine(cashier.GetTotalCache());

            Console.Read();
        }
    }
}
