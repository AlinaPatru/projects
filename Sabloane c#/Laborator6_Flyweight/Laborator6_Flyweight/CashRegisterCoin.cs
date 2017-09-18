using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class CashRegisterCoin : CashRegister
    {

        public override Money CreateNewMoney()
        {
            return new CoinMoney();
        }


        public override bool IsSharedValue(double sum)
        {
            return CoinMoney.IsSharedValue(sum);
        }
    }
}
