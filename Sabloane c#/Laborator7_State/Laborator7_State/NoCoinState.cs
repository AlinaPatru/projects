using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    class NoCoinState:State
    {
        public NoCoinState(VendingMachine vm):base(vm)
        {

        }

        public override bool InsertCoin()
        {
            Console.WriteLine("Coin inserted");

            HasCoinState hasCoin = new HasCoinState(Machine);
            Machine.SetMachineState(hasCoin);

            return true;
        }

        public override bool EjectCoin()
        {
            Console.WriteLine("No coin in the machine.Can't eject.");
            return false;
        }

        public override bool BuyProduct()
        {
            Console.WriteLine("No coin in the machine.Can't buy.");
            return false;
        }

        public override bool Dispense()
        {
            Console.WriteLine("No coin in the machine.Can't dispense.");
            return false;
        }
    }
}
