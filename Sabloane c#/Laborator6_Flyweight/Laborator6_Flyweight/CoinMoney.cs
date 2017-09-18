using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class CoinMoney : Money
    {
        public override EMoneyType GetMoneyType()
        {
            return EMoneyType.Coin;
        }

        public static bool IsSharedValue(double sum)
        {
            List<double> money = new List<double>() { 0.01, 0.05, 0.10, 0.50 };
            return money.Contains(sum);
        }
    }
}
