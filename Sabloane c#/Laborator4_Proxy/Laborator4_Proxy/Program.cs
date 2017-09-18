using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Proxy
{
    class Program
    {
        static void Main(string[] args)
        {
            SafeAccountProxy proxy = new SafeAccountProxy();
            proxy.DisplayBalance();
            proxy.Deposit(356);
            proxy.Withdraw(200);
            proxy.DisplayBalance();

            Console.ReadKey(true);
        }
    }
}
