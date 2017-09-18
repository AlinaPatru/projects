using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Proxy
{
    public class SafeAccountProxy : IAccount
    {
        private AccountProtected account=null;
        private string password = "1234";

        public bool Deposit(double deposit)
        {
            if (!Authenticate())
            {
                return false;
            }
            CreateAccount();

            return account.Deposit(deposit);
        }

        public bool DisplayBalance()
        {
            if (!Authenticate())
            {
                return false;
            }
            CreateAccount();

            return account.DisplayBalance();
        }

        public bool Withdraw(double withdraw)
        {
            if (!Authenticate())
            {
                return false;
            }
            CreateAccount();

            return account.Withdraw(withdraw);
        }

        public void CreateAccount()
        {
            if (account == null)
            {
                account = new AccountProtected();
            }

        }
        public bool Authenticate()
        {
            Console.WriteLine("Enter password: ");
            string passwordA = Console.ReadLine();
            bool check = passwordA.Equals(password);
            if (! check)
            {
                Console.WriteLine("The password doesn't match! Enter the password again");
            }
            return check;
        }

    }
}
