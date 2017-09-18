using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Proxy
{
    public interface IAccount
    {
        bool Deposit(double deposit);
        bool Withdraw(double withdraw);
        bool DisplayBalance();
    }
}
