using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Command
{
    class Program
    {
        static void Main(string[] args)
        {
            CalculatorInvoker invoker = new CalculatorInvoker();

            invoker.Compute('+', 5);
            invoker.Compute('-', 10);

            Console.Read();

        }
    }
}
