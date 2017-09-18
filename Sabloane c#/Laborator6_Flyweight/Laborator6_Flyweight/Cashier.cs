using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Flyweight
{
    public class Cashier
    {
        private CashRegister coinRegister = new CashRegisterCoin();
        private CashRegister paperRegister = new CashRegisterPaper();
        private CashRegister cardRegister = new CashRegisterCard();

        public void CashIn(double cash,EMoneyType type)
        {
            switch(type)
            {
                case EMoneyType.Coin:
                    {
                        coinRegister.CacheIn(cash);
                        break;
                    }
                case EMoneyType.Paper:
                    {
                        paperRegister.CacheIn(cash);
                        break;
                    }
                case EMoneyType.Card:
                    {
                        cardRegister.CacheIn(cash);
                        break;
                    }
            }
        }

        public void CashOut(double cash, EMoneyType type)
        {
            switch (type)
            {
                case EMoneyType.Coin:
                    {
                        coinRegister.CacheOut(cash);
                        break;
                    }
                case EMoneyType.Paper:
                    {
                        paperRegister.CacheOut(cash);
                        break;
                    }
                case EMoneyType.Card:
                    {
                        cardRegister.CacheOut(cash);
                        break;
                    }
            }
        }

        public double GetTotalCache()
        {
            return cardRegister.GetTotalCache() + paperRegister.GetTotalCache() + coinRegister.GetTotalCache();
        }
    }
}
