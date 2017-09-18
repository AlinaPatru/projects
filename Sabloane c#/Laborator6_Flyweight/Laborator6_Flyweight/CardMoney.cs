using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class CardMoney : Money
    {
        public override EMoneyType GetMoneyType()
        {
            return EMoneyType.Card;
        }


    }
}
