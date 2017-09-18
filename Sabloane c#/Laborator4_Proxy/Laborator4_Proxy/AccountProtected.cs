using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Proxy
{
    public class AccountProtected : IAccount
    {
        protected double Balance { get; set; }
        public bool Deposit(double deposit)
        {
            if (deposit > 0)
            {
                Console.WriteLine("Deposit successful");
                Balance += deposit;
                return true;
            }
            Console.WriteLine("Deposit failed! Enter a valid deposit");
            return false;
        }

        public bool DisplayBalance()
        {
            Console.WriteLine("You have "+Balance+" in your account");
            return true;
        }

        public bool Withdraw(double withdraw)
        {
            if (Balance >= withdraw)
            {
                Console.WriteLine("Withdraw successful!");
                Balance -= withdraw;
                return true;
            }

            Console.WriteLine("Withdraw failed.You don't have enough money!");
            return false;
        }
    }
}
