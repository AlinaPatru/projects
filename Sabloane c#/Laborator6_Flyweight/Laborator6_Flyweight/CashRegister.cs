using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public abstract class CashRegister
    {
        private Dictionary<double, Money> sharedMoneyMap = new Dictionary<double, Money>();
        private Money unsharedMoney; 

        public CashRegister()
        {
            unsharedMoney =CreateNewMoney();
        }

        public Money Lookup(double cash)
        {
            if(sharedMoneyMap.ContainsKey(cash)==false)
            {
                sharedMoneyMap[cash] = CreateNewMoney();
            }
            return sharedMoneyMap[cash];

        }
        public  void CacheIn(double cash)
        {
            if (IsSharedValue(cash))
            {
                Lookup(cash).TotalCacheValue += cash;
            }
            else
                unsharedMoney.TotalCacheValue += cash;
        }
        public  void CacheOut(double cash)
        {
            if (IsSharedValue(cash))
            {
                Lookup(cash).TotalCacheValue -= cash;
            }
            else
                unsharedMoney.TotalCacheValue -= cash;
        }
        public double GetTotalCache()
        {
            double sum=0;

            foreach( var item in sharedMoneyMap)
            {
                sum += item.Value.TotalCacheValue;
            }

            sum += unsharedMoney.TotalCacheValue;

            return sum;
        }

        public abstract Money CreateNewMoney();
        public abstract bool IsSharedValue(double sum);

    }
}
