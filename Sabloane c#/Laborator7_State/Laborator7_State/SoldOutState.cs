using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class SoldOutState:State
    {
        public SoldOutState(VendingMachine vm): base(vm)
        {

        }

        public override bool InsertCoin()
        {
            Console.WriteLine("All products were sold");

            return false;
        }

        public override bool EjectCoin()
        {
            Console.WriteLine("All products were sold");

            return false;
        }

        public override bool BuyProduct()
        {
            Console.WriteLine("All products were sold");

            return false;
        }

        public override bool Dispense()
        {
            Console.WriteLine("All products were sold");

            return false;
        }
    }
}
