using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_State
{
    abstract class State
    {
        public VendingMachine Machine;

        public State(VendingMachine vm)
        {
            this.Machine = vm;
        }


        public State()
        {

        }

        public abstract bool InsertCoin();
        public abstract bool EjectCoin();
        public abstract bool BuyProduct();
        public abstract bool Dispense();

    }
}
