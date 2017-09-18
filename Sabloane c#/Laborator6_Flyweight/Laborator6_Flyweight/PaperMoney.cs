using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class PaperMoney : Money
    {
        public override EMoneyType GetMoneyType()
        {
            return EMoneyType.Paper;
        }

        public static bool IsSharedValue(double sum)
        {
            List<double> money = new List<double>() { 1, 5, 10, 50, 100, 200, 500 };
            return money.Contains(sum);
        }
    }
}
