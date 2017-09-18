using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class HasCoinState:State
    {
        public HasCoinState(VendingMachine vm):base(vm)
        {

        }

        public override bool InsertCoin()
        {
            Console.WriteLine("The coin was already inserted.");

            return false;
        }


        public override bool EjectCoin()
        {
            Console.WriteLine("Coin ejected.");

            NoCoinState noCoin = new NoCoinState(Machine);
            Machine.SetMachineState(noCoin);

            return true;
        }


        public override bool BuyProduct()
        {

            Console.WriteLine("Product bought.");

            SoldState sold = new SoldState(Machine);
            Machine.SetMachineState(sold);

            return true;
        }


        public override bool Dispense()
        {

            Console.WriteLine("Cannot dispense.");

            return false;
        }
    }
}
