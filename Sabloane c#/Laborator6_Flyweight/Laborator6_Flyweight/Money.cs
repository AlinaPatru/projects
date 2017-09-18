using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public abstract class Money
    {
        public double TotalCacheValue { get; set; }

        public abstract EMoneyType GetMoneyType();
    }
}
