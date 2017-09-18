using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Command
{
    public class CalculatorCommand:ICommand
    {
        private Calculator _calculator;
        public char ArithmOperator { get; set; }

        public double Operand { get; set; }

        public CalculatorCommand()
        {
            _calculator = new Calculator();
        }

        public void Execute()
        {
            _calculator.DoOperation(ArithmOperator, Operand); 
        }
    }
}
