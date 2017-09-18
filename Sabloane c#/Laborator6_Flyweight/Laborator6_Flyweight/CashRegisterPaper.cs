using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class CashRegisterPaper : CashRegister
    {
        public override Money CreateNewMoney()
        {
            return new PaperMoney();
        }

        public override bool IsSharedValue(double sum)
        {
            return PaperMoney.IsSharedValue(sum);
        }
    }
}
