using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class SoldState:State
    {
        public SoldState(VendingMachine vm): base(vm)
        {

        }

        public override bool InsertCoin()
        {
            Console.WriteLine("Coin was inserted.");
            HasCoinState hasCoin = new HasCoinState(Machine);
            Machine.SetMachineState(hasCoin);

            return true;
        }


        public override bool EjectCoin()
        {
            Console.WriteLine("Coin can't be ejected.");
            return false;
        }


        public override bool BuyProduct()
        {
            Console.WriteLine("Can't buy a product.Insert a coin");
            return false;
        }


        public override bool Dispense()
        {

            Console.WriteLine("Dispense succes");

            NoCoinState noCoin = new NoCoinState(Machine);
            Machine.SetMachineState(noCoin);

            return true;
        }
    }
}
