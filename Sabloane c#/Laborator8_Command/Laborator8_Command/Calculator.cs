using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Command
{
    public class Calculator
    {
        private double _currentValue = 0;

        public void DoOperation(char arithmOperator,double operand)
        {
            Console.Write("{0}{1}{2}", _currentValue, arithmOperator,operand);

            switch (arithmOperator)
            {
                case '+': { _currentValue += operand; break; }
                case '-': { _currentValue -= operand; break; }
                case '*': { _currentValue *= operand; break; }
                case '/': { _currentValue /= operand; break; }
            }

            Console.WriteLine("=" + _currentValue);
        }
    }
}
